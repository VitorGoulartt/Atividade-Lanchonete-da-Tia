package attlanchonete.attmenulanchonete.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attlanchonete.attmenulanchonete.model.AttfuncionarioModel;

@Repository
public interface AttFuncionarioRepository extends JpaRepository<AttfuncionarioModel, Integer>  {

}
