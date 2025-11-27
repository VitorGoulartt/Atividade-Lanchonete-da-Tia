package attlanchonete.attmenulanchonete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import attlanchonete.attmenulanchonete.model.AttClienteModel;
import attlanchonete.attmenulanchonete.model.AttPedidoModel;
import attlanchonete.attmenulanchonete.model.AttProdutoModel;
import attlanchonete.attmenulanchonete.model.AttfuncionarioModel;
import attlanchonete.attmenulanchonete.repository.AttFuncionarioRepository;
import attlanchonete.attmenulanchonete.repository.AttPedidoRepository;
import attlanchonete.attmenulanchonete.repository.AttProdutoRepository;

public class AttFuncionarioService {
    @Autowired
    private AttFuncionarioRepository attFuncionarioRepository;

    @Autowired
    private AttPedidoRepository attPedidoRepository;

    @Autowired
    private AttProdutoRepository  attProdutoRepository;


    public AttfuncionarioModel adicionarFuncionario(AttfuncionarioModel funcionario){
       
        return attFuncionarioRepository.save(funcionario);
    }

    public AttProdutoModel adicionarProduto(AttProdutoModel Produto){
       
        return attProdutoRepository.save(Produto);
    }

    public AttPedidoModel fazerPedido(AttPedidoModel Pedido, AttClienteModel cliente){
       Pedido.setCliente(cliente);
        return attPedidoRepository.save(Pedido);
      
    }

    public List<AttProdutoModel> listarProdutos(){
        List<AttProdutoModel> Produtos = attProdutoRepository.findAll();
        return Produtos;
        
        
    }

    public List<AttPedidoModel> listarPedidos(){
        List<AttPedidoModel> Pedidos = attPedidoRepository.findAll();
        return Pedidos;

    }

    public AttPedidoModel buscarPedidoId(int id){
     Optional<AttPedidoModel> pedido = attPedidoRepository.findById(id);
     
        return pedido.orElse(null);
    
  
    }

    






}
