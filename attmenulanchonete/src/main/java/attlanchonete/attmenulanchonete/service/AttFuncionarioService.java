package attlanchonete.attmenulanchonete.service;

import java.util.List;
import java.util.Optional;



import attlanchonete.attmenulanchonete.model.AttClienteModel;
import attlanchonete.attmenulanchonete.model.AttPedidoModel;
import attlanchonete.attmenulanchonete.model.AttProdutoModel;
import attlanchonete.attmenulanchonete.model.AttfuncionarioModel;
import attlanchonete.attmenulanchonete.repository.AttFuncionarioRepository;
import attlanchonete.attmenulanchonete.repository.AttPedidoRepository;
import attlanchonete.attmenulanchonete.repository.AttProdutoRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttFuncionarioService {
    @Autowired
    private AttFuncionarioRepository attFuncionarioRepository;

    @Autowired
    private AttPedidoRepository attPedidoRepository;

    @Autowired
    private AttProdutoRepository  attProdutoRepository;


   @Transactional
    public AttfuncionarioModel adicionarFuncionario(AttfuncionarioModel funcionario) {
        if (funcionario != null) {
            // >>>>> Adicione este bloco de código para corrigir o erro: <<<<<
            // Percorre todos os pedidos que vieram no objeto 'funcionario' do JSON
            if (funcionario.getPedidos() != null) {
                for (AttPedidoModel pedido : funcionario.getPedidos()) {
                    // Define o funcionário principal (que estamos salvando) como 
                    // o funcionário responsável por CADA pedido.
                    // Isso preenche o campo 'id_funcionario' no SQL gerado.
                    pedido.setFuncionario(funcionario); 
                }
            }
            // >>>>> Fim do bloco de correção <<<<<

            // Agora o Hibernate tem todas as informações necessárias para salvar corretamente
            return attFuncionarioRepository.save(funcionario);
        }
        
        return null;
    }
    public AttProdutoModel adicionarProduto(AttProdutoModel Produto){
       
        if(Produto != null){

         return attProdutoRepository.save(Produto);
        }
         return null;
       
    }

    public AttPedidoModel fazerPedido(AttPedidoModel Pedido, AttClienteModel cliente, AttfuncionarioModel funcionario){
       Pedido.setCliente(cliente);
        Pedido.setFuncionario(funcionario); 

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
