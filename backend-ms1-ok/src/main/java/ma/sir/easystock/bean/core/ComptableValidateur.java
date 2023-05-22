package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "comptable_validateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="comptable_validateur_seq",sequenceName="comptable_validateur_seq",allocationSize=1, initialValue = 1)
public class ComptableValidateur   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String cin;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;



    public ComptableValidateur(){
        super();
    }

    public ComptableValidateur(Long id,String cin){
        this.id = id;
        this.cin = cin ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="comptable_validateur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Transient
    public String getLabel() {
        label = cin;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComptableValidateur comptableValidateur = (ComptableValidateur) o;
        return id != null && id.equals(comptableValidateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

