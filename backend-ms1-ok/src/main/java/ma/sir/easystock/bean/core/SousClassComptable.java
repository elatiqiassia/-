package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "sous_class_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sous_class_comptable_seq",sequenceName="sous_class_comptable_seq",allocationSize=1, initialValue = 1)
public class SousClassComptable   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;

    private ClassComptable classComptable ;
    


    public SousClassComptable(){
        super();
    }

    public SousClassComptable(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sous_class_comptable_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ClassComptable getClassComptable(){
        return this.classComptable;
    }
    public void setClassComptable(ClassComptable classComptable){
        this.classComptable = classComptable;
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
        SousClassComptable sousClassComptable = (SousClassComptable) o;
        return id != null && id.equals(sousClassComptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

