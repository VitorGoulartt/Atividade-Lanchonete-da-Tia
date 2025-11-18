package attlanchonete.attmenulanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import attlanchonete.attmenulanchonete.model.AttLanchoneteModel;
import attlanchonete.attmenulanchonete.repository.AttLanchoneteRepository;

@Service
public class AttLanchoneteService {

    @Autowired
    private AttLanchoneteRepository attLanchoneteRepository;

  

    public List<AttLanchoneteModel> listartodos(){
        List<AttLanchoneteModel> lanches = attLanchoneteRepository.findAll();
        List<AttLanchoneteModel> disponivellanches = new ArrayList<>();
        for (AttLanchoneteModel a : lanches ) {
         if(a.getDisponivel() == true){
              disponivellanches.add(a);
            }
         
        }
        return disponivellanches;
       
        

    }

    public AttLanchoneteModel buscarIdLanche(int id){
        Optional<AttLanchoneteModel> lanche = attLanchoneteRepository.findById(id);
            return lanche.orElse(null);
        
    }

    public List<AttLanchoneteModel> buscarCategoria(int categoria){
        List<AttLanchoneteModel> categorias = attLanchoneteRepository.findByCategoria(categoria);
        if(categorias != null){
           return categorias;
        }
        return null;
        

    }
    
    public AttLanchoneteModel adicionarLanche(AttLanchoneteModel lanche){
        lanche.setDisponivel(true);
        switch(lanche.getCategoria()){
            case 1: 
            lanche.setTempo("(10-15 min)");
            break;
            case 2:
            lanche.setTempo("(2-5 min)");
            break;
            case 3:
            lanche.setTempo("(8-10 min)");
            break;
            case 4:
            lanche.setTempo("(5 min)");
            break;
        }
        if(lanche.getPreco() > 0 ){
            return attLanchoneteRepository.save(lanche);

        }else if(lanche.getPreco() <= 0){
            lanche.setDisponivel(false);
             return attLanchoneteRepository.save(lanche);

        }
           
        return null;
        
    }

    public AttLanchoneteModel atualizarLanches(int id, AttLanchoneteModel lancheNovo ){
        Optional<AttLanchoneteModel> lancheatual = attLanchoneteRepository.findById(id);
        if(lancheatual.isPresent()){
            AttLanchoneteModel lanche = lancheatual.get();
            lanche.setNome(lancheNovo.getNome());
            lanche.setPreco(lancheNovo.getPreco());
            return attLanchoneteRepository.save(lanche);

        }
        return null;
    }

    public void apagarLanche(int id){
       attLanchoneteRepository.deleteById(id);

    }



}
