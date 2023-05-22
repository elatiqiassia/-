package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "categorie_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_produit_seq",sequenceName="categorie_produit_seq",allocationSize=1, initialValue = 1)
public class CategorieProduit   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;



    public CategorieProduit(){
        super();
    }

    public CategorieProduit(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_produit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieProduit categorieProduit = (CategorieProduit) o;
        return id != null && id.equals(categorieProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

