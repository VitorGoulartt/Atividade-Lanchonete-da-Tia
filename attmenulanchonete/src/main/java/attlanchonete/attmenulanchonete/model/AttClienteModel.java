package attlanchonete.attmenulanchonete.model;

import java.time.LocalDateTime;




import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity 
@Table(name = "cliente")
@Getter
@Setter
public class AttClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//Numérico, gerado pelo sistema

    @Column(nullable = false)
    private String nomeCompleto; //Obrigatório

    @Column(nullable = false, unique = true)
    private String email; //Único no sistema,obrigatório, deve ser válido (ADICIONE,MAS NÃO PRECISAVALIDAR )

   
    @Column
    private String telefone; //Formato válido,opcional (ADICIONE,MAS NÃO PRECISA VALIDAR )

    @Embedded
    private AttEnderecoModel endereco;// (Tipado em uma classe) obrigatório

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;//Gerado automaticamente

    @Column(nullable = false)
    private boolean ativo; //Booleano, padrão:true

    @Column(columnDefinition = "TEXT")
    private String preferencias;//Texto opcional

    @Column(columnDefinition = "TEXT")
    private String historicoCompras;//Inicialmente vazio(ADD COMO STRING NÃO OBRIGATÓRIA)

    @Column(nullable = false, unique = true)
    private String cpf;//Obrigatório, único,válido (ADICIONE,MAS NÃO PRECISA VALIDAR )

    @Column(columnDefinition = "TEXT")
    private String pedidos;//Campo inicialmente vazio (ADD COMO STRING NÃO OBRIGATÓRIA)

    @PrePersist
    protected void onCreate() {
      dataCadastro = LocalDateTime.now();
        ativo = true;
    }

    public AttClienteModel(){

    }

    public AttClienteModel(String nomeCompleto, String email, String telefone, AttEnderecoModel endereco, LocalDateTime dataCadastro, boolean ativo, String preferencias, String historicoCompras, String cpf, String pedidos){
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
        this.preferencias = preferencias;
        this.cpf = cpf;
        this.historicoCompras = historicoCompras;
        this.pedidos = pedidos;
    }

  

   
}
