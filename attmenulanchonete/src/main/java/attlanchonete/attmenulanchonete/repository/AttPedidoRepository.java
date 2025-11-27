package attlanchonete.attmenulanchonete.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attlanchonete.attmenulanchonete.model.AttPedidoModel;


@Repository
public interface AttPedidoRepository extends JpaRepository<AttPedidoModel, Integer> {

}
