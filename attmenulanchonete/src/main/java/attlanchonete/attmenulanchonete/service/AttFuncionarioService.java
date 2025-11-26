package attlanchonete.attmenulanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;

import attlanchonete.attmenulanchonete.model.AttfuncionarioModel;
import attlanchonete.attmenulanchonete.repository.AttFuncionarioRepository;

public class AttFuncionarioService {
    @Autowired
    private AttFuncionarioRepository attFuncionarioRepository;

    public AttfuncionarioModel adicionarFuncionario(AttfuncionarioModel funcionario){
       
        return attFuncionarioRepository.save(funcionario);
    }

}
