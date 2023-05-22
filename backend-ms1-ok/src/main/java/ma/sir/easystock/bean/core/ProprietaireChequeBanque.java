package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "proprietaire_cheque_banque")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="proprietaire_cheque_banque_seq",sequenceName="proprietaire_cheque_banque_seq",allocationSize=1, initialValue = 1)
public class ProprietaireChequeBanque   extends AuditBusinessObject     {

    private Long id;


    private ProprietaireCheque proprietaireCheque ;
    
    private Banque banque ;
    


    public ProprietaireChequeBanque(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="proprietaire_cheque_banque_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ProprietaireCheque getProprietaireCheque(){
        return this.proprietaireCheque;
    }
    public void setProprietaireCheque(ProprietaireCheque proprietaireCheque){
        this.proprietaireCheque = proprietaireCheque;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Banque getBanque(){
        return this.banque;
    }
    public void setBanque(Banque banque){
        this.banque = banque;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireChequeBanque proprietaireChequeBanque = (ProprietaireChequeBanque) o;
        return id != null && id.equals(proprietaireChequeBanque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

