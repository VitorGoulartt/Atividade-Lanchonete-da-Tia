package attlanchonete.attmenulanchonete.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedido")
public class AttPedidoModel {

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private AttClienteModel cliente;
    
    
    private AttProdutoModel Produto;
    @Column()
    private LocalDateTime data_do_pedido;

    @Column()
    private int total;

}
