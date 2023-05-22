package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "paiement_commande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_commande_seq",sequenceName="paiement_commande_seq",allocationSize=1, initialValue = 1)
public class PaiementCommandeHistory extends HistBusinessObject  {


    public PaiementCommandeHistory() {
    super();
    }

    public PaiementCommandeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_commande_seq")
    public Long getId() {
    return id;
    }
}

