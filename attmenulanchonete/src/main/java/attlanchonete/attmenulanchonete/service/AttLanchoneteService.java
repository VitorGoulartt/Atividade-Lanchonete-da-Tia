package attlanchonete.attmenulanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
        
        if(attLanchoneteModel.getDisponivel() == true){

            return attLanchoneteRepository.findAll();
        }
        

    }

    public AttLanchoneteModel buscarIdLanche(int id){
        Optional<AttLanchoneteModel> lanche = attLanchoneteRepository.findById(id);
        if(lanche.getDisponivel() == true){
            return lanche.orElse(null);
        }
        return null;
        
    }

}
