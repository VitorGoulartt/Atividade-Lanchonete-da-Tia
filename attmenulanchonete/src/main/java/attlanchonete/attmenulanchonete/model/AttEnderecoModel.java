package attlanchonete.attmenulanchonete.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;


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
@Table(name = "endereco")
public class AttEnderecoModel {

   

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String complemento;
    
    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String numero;


}
