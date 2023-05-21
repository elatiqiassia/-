package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "proprietaire_cheque_banque")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="proprietaire_cheque_banque_seq",sequenceName="proprietaire_cheque_banque_seq",allocationSize=1, initialValue = 1)
public class ProprietaireChequeBanqueHistory extends HistBusinessObject  {


    public ProprietaireChequeBanqueHistory() {
    super();
    }

    public ProprietaireChequeBanqueHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="proprietaire_cheque_banque_seq")
    public Long getId() {
    return id;
    }
}

