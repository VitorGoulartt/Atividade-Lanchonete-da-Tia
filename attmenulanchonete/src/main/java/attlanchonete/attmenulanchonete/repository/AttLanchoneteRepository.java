package attlanchonete.attmenulanchonete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attlanchonete.attmenulanchonete.model.AttLanchoneteModel;

@Repository
public interface AttLanchoneteRepository extends JpaRepository<AttLanchoneteModel, Integer> {

   List<AttLanchoneteModel> findByCategoria(int categoria);
}
