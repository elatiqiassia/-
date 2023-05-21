package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "magasin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="magasin_seq",sequenceName="magasin_seq",allocationSize=1, initialValue = 1)
public class Magasin   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String adresse;

    private Store store ;
    


    public Magasin(){
        super();
    }

    public Magasin(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="magasin_seq")
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
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore(){
        return this.store;
    }
    public void setStore(Store store){
        this.store = store;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magasin magasin = (Magasin) o;
        return id != null && id.equals(magasin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

