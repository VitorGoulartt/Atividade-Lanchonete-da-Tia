package attlanchonete.attmenulanchonete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import attlanchonete.attmenulanchonete.model.AttLanchoneteModel;
import attlanchonete.attmenulanchonete.service.AttLanchoneteService;

import java.util.List;



@RestController
@RequestMapping("/api/produtos")
public class AttLanchoneteController {

    @Autowired
    private AttLanchoneteService attLanchoneteService;

    @GetMapping
    public ResponseEntity<List<AttLanchoneteModel>> listartodos(){
        List<AttLanchoneteModel> lanche = new attLanchoneteService.listartodos();

        return ResponseEntity.ok(lanche);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AttLanchoneteModel> buscarIdLanche(@PathVariable int id){
        AttLanchoneteModel lanche = new attLanchoneteService.buscarIdLanche(id);
        return ResponseEntity
    }


}
