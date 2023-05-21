package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "proprietaire_cheque")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="proprietaire_cheque_seq",sequenceName="proprietaire_cheque_seq",allocationSize=1, initialValue = 1)
public class ProprietaireCheque   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String code;



    public ProprietaireCheque(){
        super();
    }

    public ProprietaireCheque(Long id,String nom){
        this.id = id;
        this.nom = nom ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="proprietaire_cheque_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Transient
    public String getLabel() {
        label = nom;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireCheque proprietaireCheque = (ProprietaireCheque) o;
        return id != null && id.equals(proprietaireCheque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

