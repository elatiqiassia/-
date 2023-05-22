package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_commande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_commande_seq",sequenceName="etat_commande_seq",allocationSize=1, initialValue = 1)
public class EtatCommandeHistory extends HistBusinessObject  {


    public EtatCommandeHistory() {
    super();
    }

    public EtatCommandeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_commande_seq")
    public Long getId() {
    return id;
    }
}

