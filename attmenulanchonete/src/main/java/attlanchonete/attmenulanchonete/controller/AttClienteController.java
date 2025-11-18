package attlanchonete.attmenulanchonete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import attlanchonete.attmenulanchonete.model.AttClienteModel;
import attlanchonete.attmenulanchonete.service.AttClienteService;
import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/api/cliente")
public class AttClienteController {

    @Autowired
    private AttClienteService attClienteService;

    @GetMapping
    public ResponseEntity<List<AttClienteModel>> listartodos(){
        List<AttClienteModel> cliente = attClienteService.listartodos();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttClienteModel> buscarClienteId(@PathVariable int id ){
        AttClienteModel cliente = attClienteService.buscarClienteId(id);
        if( cliente == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{email}")
    public ResponseEntity<AttClienteModel> buscarClienteEmail(@PathVariable String email){
        AttClienteModel cliente = attClienteService.buscarClienteEmail(email);

        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
        
    }
    @PostMapping
    public ResponseEntity<AttClienteModel> adicionarCliente(@RequestBody AttClienteModel cliente  ){
        AttClienteModel clienteNovo = attClienteService.adicionarCliente(cliente);
        if(clienteNovo != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<AttClienteModel> atualizarCliente(@PathVariable int id, @RequestBody AttClienteModel cliente){
        AttClienteController clientes = attClienteService.atualizarCliente(id, cliente);
        if()

    }


}
