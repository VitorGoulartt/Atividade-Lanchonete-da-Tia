package attlanchonete.attmenulanchonete.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attlanchonete.attmenulanchonete.model.AttProdutoModel;



@Repository
public interface AttProdutoRepository extends JpaRepository<AttProdutoModel, Integer> {

}
