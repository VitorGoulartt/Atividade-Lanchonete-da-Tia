package attlanchonete.attmenulanchonete.model;

import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(nullable = false, length = 100 )
    private String nomeCompleto; //Obrigatório

    @Column(nullable = false, unique = true, length = 120)
    private String email; //Único no sistema,obrigatório, deve ser válido (ADICIONE,MAS NÃO PRECISAVALIDAR )

    @Column(nullable = false, length = 50)
    private int telefone; //Formato válido,opcional (ADICIONE,MAS NÃO PRECISA VALIDAR )

    @Column(nullable =  false, length = 150)
    private String endereço;// (Tipado em uma classe) obrigatório

    @Column(nullable = false, length = 150)
    private Date dataCadastro;//Gerado automaticamente

    @Column(nullable = false, length = 150)
    private boolean ativo; //Booleano, padrão:true

    @Column(nullable = false, length = 150)
    private String preferencias;//Texto opcional

    @Column(nullable = true, length = 150)
    private String historicoCompras;//Inicialmente vazio(ADD COMO STRING NÃO OBRIGATÓRIA)

    @Column(nullable = false, unique = true, length = 150)
    private float cpf;//Obrigatório, único,válido (ADICIONE,MAS NÃO PRECISA VALIDAR )

    @Column(nullable = true, length = 150)
    private String pedidos;//Campo inicialmente vazio (ADD COMO STRING NÃO OBRIGATÓRIA)

    public AttClienteModel(){

    }

    public AttClienteModel(String nomeCompleto, String email, int telefone, String endereço, Date dataCadastro, boolean ativo, String preferencias, String historicoCompras, float cpf, String pedidos){
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.endereço = endereço;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
        this.preferencias = preferencias;
        this.cpf = cpf;
        this.historicoCompras = historicoCompras;
        this.pedidos = pedidos;
    }

   
}
