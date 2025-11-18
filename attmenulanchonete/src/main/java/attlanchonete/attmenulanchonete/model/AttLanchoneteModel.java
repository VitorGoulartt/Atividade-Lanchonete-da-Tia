package attlanchonete.attmenulanchonete.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lanchonete")
@Getter
@Setter
public class AttLanchoneteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false, length = 4)
    private int categoria;

    @Column(nullable = false)
    private Boolean disponivel;

    @Column(nullable = false, length = 100)
    private String tempo;

    public AttLanchoneteModel(){

    }

    public AttLanchoneteModel(int id, String nome, String descricao, double preco, int categoria, boolean disponivel, String tempo){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.disponivel = disponivel;
        this.tempo = tempo;
    }

    
}
