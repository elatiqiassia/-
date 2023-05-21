package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "paiement_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_vente_seq",sequenceName="paiement_vente_seq",allocationSize=1, initialValue = 1)
public class PaiementVenteHistory extends HistBusinessObject  {


    public PaiementVenteHistory() {
    super();
    }

    public PaiementVenteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_vente_seq")
    public Long getId() {
    return id;
    }
}

