package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "paiement_livraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_livraison_seq",sequenceName="paiement_livraison_seq",allocationSize=1, initialValue = 1)
public class PaiementLivraisonHistory extends HistBusinessObject  {


    public PaiementLivraisonHistory() {
    super();
    }

    public PaiementLivraisonHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_livraison_seq")
    public Long getId() {
    return id;
    }
}

