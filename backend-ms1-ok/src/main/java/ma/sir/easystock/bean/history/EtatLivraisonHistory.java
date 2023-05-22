package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_livraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_livraison_seq",sequenceName="etat_livraison_seq",allocationSize=1, initialValue = 1)
public class EtatLivraisonHistory extends HistBusinessObject  {


    public EtatLivraisonHistory() {
    super();
    }

    public EtatLivraisonHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_livraison_seq")
    public Long getId() {
    return id;
    }
}

