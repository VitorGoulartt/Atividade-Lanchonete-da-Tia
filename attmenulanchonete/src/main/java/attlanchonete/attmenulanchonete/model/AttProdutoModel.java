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
@Table(name = "Produto")
public class AttProdutoModel {

    @Column()
    private String nome;

    @Column()
    private double preco;

    @Column()
    private String categoria;

}
