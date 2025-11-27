package attlanchonete.attmenulanchonete.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.PrePersist;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class AttPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", nullable = false)
    private AttClienteModel cliente;
    
    @OneToMany(mappedBy = "pedido")
    private List<AttProdutoModel> produtos;
    
    @Column()
    private LocalDateTime data_do_pedido;

    @Column()
    private int total;

    @ManyToOne 
    @JoinColumn(name = "id_funcionario", nullable = false) 
    private AttfuncionarioModel funcionario;

    @PrePersist
    protected void onCreate() {
      data_do_pedido = LocalDateTime.now();
        
    }

   
}
