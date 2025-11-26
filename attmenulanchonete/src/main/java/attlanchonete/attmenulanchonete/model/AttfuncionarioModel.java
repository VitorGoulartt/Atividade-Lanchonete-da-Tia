package attlanchonete.attmenulanchonete.model;

import jakarta.persistence.Entity;
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

    private String cargo;

    private double salario;
    

}
