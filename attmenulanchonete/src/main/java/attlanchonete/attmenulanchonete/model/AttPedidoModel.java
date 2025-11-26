package attlanchonete.attmenulanchonete.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedido")
public class AttPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private AttClienteModel cliente;
    
    @OneToMany(mappedBy = "Pedido")
    private List<AttProdutoModel> Produto;
    
    @Column()
    private LocalDateTime data_do_pedido;

    @Column()
    private int total;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private AttfuncionarioModel funcionario;

}
