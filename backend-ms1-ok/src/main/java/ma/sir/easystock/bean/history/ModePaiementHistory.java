package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "mode_paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="mode_paiement_seq",sequenceName="mode_paiement_seq",allocationSize=1, initialValue = 1)
public class ModePaiementHistory extends HistBusinessObject  {


    public ModePaiementHistory() {
    super();
    }

    public ModePaiementHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="mode_paiement_seq")
    public Long getId() {
    return id;
    }
}

