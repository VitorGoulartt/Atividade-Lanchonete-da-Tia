package attlanchonete.attmenulanchonete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lanchonete")
public class AttLanchoneteModel {
    
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int categoria;
    private Boolean Disponivel;
    private double tempo;

}
