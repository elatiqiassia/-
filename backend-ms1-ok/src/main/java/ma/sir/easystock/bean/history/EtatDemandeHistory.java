package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_demande_seq",sequenceName="etat_demande_seq",allocationSize=1, initialValue = 1)
public class EtatDemandeHistory extends HistBusinessObject  {


    public EtatDemandeHistory() {
    super();
    }

    public EtatDemandeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_demande_seq")
    public Long getId() {
    return id;
    }
}

