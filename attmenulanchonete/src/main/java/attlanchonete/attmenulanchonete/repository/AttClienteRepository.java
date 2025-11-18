package attlanchonete.attmenulanchonete.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attlanchonete.attmenulanchonete.model.AttClienteModel;

@Repository
public interface AttClienteRepository extends JpaRepository<AttClienteModel, Integer> {
    List<AttClienteModel> findAllByAtivo(boolean ativo);

    Optional<AttClienteModel> findByEmail(String email);

    

}
