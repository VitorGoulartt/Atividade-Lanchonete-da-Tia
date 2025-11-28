package attlanchonete.attmenulanchonete.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Funcionario")
public class AttfuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private String cargo;

    private double salario;

    @OneToMany(mappedBy = "funcionario") // Diz ao Hibernate: "O mapeamento já existe no campo 'funcionario' da outra classe"
    @JsonIgnore // <-- Impede o loop infinito no JSON
    private List<AttPedidoModel> pedidos;
    

}
