package attlanchonete.attmenulanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private AttLanchoneteModel attLanchoneteModel;

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
        List<AttLanchoneteModel> categorias = attLanchoneteRepository.findBy(categoria);

    }

}
