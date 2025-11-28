package attlanchonete.attmenulanchonete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import attlanchonete.attmenulanchonete.model.AttPedidoModel;
import attlanchonete.attmenulanchonete.model.AttProdutoModel;
import attlanchonete.attmenulanchonete.model.AttfuncionarioModel;
import attlanchonete.attmenulanchonete.service.AttFuncionarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/funcionario")
public class AttfuncionarioController {
    
    @Autowired
    private AttFuncionarioService attFuncionarioService;


    @PostMapping
    public ResponseEntity<AttfuncionarioModel> adicionarFuncionario(@RequestBody AttfuncionarioModel funcionario ){
        AttfuncionarioModel funcionarioNovo = attFuncionarioService.adicionarFuncionario(funcionario);
        if(funcionarioNovo != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioNovo);
        }
         return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();

    }

    @PostMapping("/produto")
    public ResponseEntity<AttProdutoModel> adicionarProduto(@RequestBody AttProdutoModel Produto ){
        AttProdutoModel ProdutoNovo = attFuncionarioService.adicionarProduto(Produto);
        if(ProdutoNovo != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoNovo);
        }
         return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();

    }

    @PostMapping("/Pedido/{clienteId}/{funcionarioId}")
    public ResponseEntity<AttPedidoModel> adicionarPedido(@RequestBody AttPedidoModel Pedido , @PathVariable int clienteId,@PathVariable int funcionarioId ){
        
        AttPedidoModel PedidoNovo = attFuncionarioService.fazerPedido(Pedido , clienteId, funcionarioId);
        if(Pedido != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(PedidoNovo);
        }
         return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();

    }

    @GetMapping("/listaDePedidos")
    public ResponseEntity<List<AttPedidoModel>> listarPedidos(){
        List<AttPedidoModel> pedido = attFuncionarioService.listarPedidos();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/listaDeProdutos")
    public ResponseEntity<List<AttProdutoModel>> listarProdutos(){
        List<AttProdutoModel> produtos = attFuncionarioService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<AttPedidoModel> buscarPedidoId(@PathVariable int id){
        AttPedidoModel pedido = attFuncionarioService.buscarPedidoId(id);
        if(pedido != null){
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.notFound().build();

    }


}
