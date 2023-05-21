package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "paiement_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_achat_seq",sequenceName="paiement_achat_seq",allocationSize=1, initialValue = 1)
public class PaiementAchatHistory extends HistBusinessObject  {


    public PaiementAchatHistory() {
    super();
    }

    public PaiementAchatHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_achat_seq")
    public Long getId() {
    return id;
    }
}

