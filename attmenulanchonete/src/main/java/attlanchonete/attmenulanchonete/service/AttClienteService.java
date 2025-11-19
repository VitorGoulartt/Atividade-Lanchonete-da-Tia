package attlanchonete.attmenulanchonete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.Calendar;

import attlanchonete.attmenulanchonete.model.AttClienteModel;

import attlanchonete.attmenulanchonete.repository.AttClienteRepository;

@Service
public class AttClienteService {
    @Autowired
    private AttClienteRepository attClienteRepository;

    public List<AttClienteModel> listartodos(){
        List<AttClienteModel> clienteAtivo = attClienteRepository.findAllByAtivo(true);
        return clienteAtivo;

    }

    public AttClienteModel buscarClienteId(int id){
        Optional<AttClienteModel> cliente = attClienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public  AttClienteModel buscarClienteEmail(String email){
        Optional<AttClienteModel> cliente = attClienteRepository.findByEmail(email);
        return cliente.orElse(null);
    }

    public AttClienteModel adicionarCliente(AttClienteModel cliente){

        cliente.setAtivo(true);
        cliente.setDataCadastro(Calendar.getInstance().getTime());
        cliente.setPedidos(null);
        return attClienteRepository.save(cliente);

    }

    public AttClienteModel atualizarCliente(int id, AttClienteModel cliente){
        Optional<AttClienteModel> clienteNovo = attClienteRepository.findById(id);
        if(clienteNovo.isPresent()){
            AttClienteModel clientes = clienteNovo.get();
            clientes.setNomeCompleto(cliente.getNomeCompleto());
            clientes.setEndereco(cliente.getEndereco());
            clientes.setTelefone(cliente.getTelefone());
            clientes.setPreferencias(cliente.getPreferencias());
            return attClienteRepository.save(cliente);

        }
        return null;
    }

}
