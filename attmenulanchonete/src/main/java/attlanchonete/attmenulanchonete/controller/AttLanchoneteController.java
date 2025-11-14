package attlanchonete.attmenulanchonete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import attlanchonete.attmenulanchonete.model.AttLanchoneteModel;
import attlanchonete.attmenulanchonete.service.AttLanchoneteService;

import java.util.List;



@RestController
@RequestMapping("/api/lanchonete")
public class AttLanchoneteController {

    @Autowired
    private AttLanchoneteService attLanchoneteService;

    @GetMapping
    public ResponseEntity<List<AttLanchoneteModel>> listartodos(){
        List<AttLanchoneteModel> lanches = attLanchoneteService.listartodos();

        return ResponseEntity.ok(lanches);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AttLanchoneteModel> buscarIdLanche(@PathVariable int id){
        AttLanchoneteModel lanche = attLanchoneteService.buscarIdLanche(id);
        if(lanche != null){
            return ResponseEntity.ok(lanche);

        }

        return ResponseEntity.notFound().build();
        
    }

    @GetMapping("/{categoria}")
    public ResponseEntity<List<AttLanchoneteModel>> 0(@PathVariable int categoria){

        List<AttLanchoneteModel> categorias = attLanchoneteService.buscarCategoria(categoria);

        if(categorias != null){
            return ResponseEntity.ok(categorias);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<AttLanchoneteModel> adicionarLanche(@RequestBody AttLanchoneteModel lanche){
        AttLanchoneteModel lanchenovo = attlanchoneteService.adicionarLanche(lanche);
        if(lanchenovo != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(lanchenovo);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttLanchoneteModel> atualizarLanches(@PathVariable int id){
        AttLanchoneteModel lanche = attLanchoneteService.atualizarLanches(id);
        if(lanche != null){
            attLanchoneteService.atualizarLanches(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AttLanchoneteModel> apagarLanche(@PathVariable int id){
        AttLanchoneteModel lanche = new attLanchoneteService.apagarLanche(id);
        if(lanche != null){
            attLanchoneteService.apagarLanche(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
