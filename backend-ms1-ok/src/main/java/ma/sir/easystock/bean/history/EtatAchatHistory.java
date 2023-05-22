package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_achat_seq",sequenceName="etat_achat_seq",allocationSize=1, initialValue = 1)
public class EtatAchatHistory extends HistBusinessObject  {


    public EtatAchatHistory() {
    super();
    }

    public EtatAchatHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_achat_seq")
    public Long getId() {
    return id;
    }
}

