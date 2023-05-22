package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "devis_fournisseur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="devis_fournisseur_seq",sequenceName="devis_fournisseur_seq",allocationSize=1, initialValue = 1)
public class DevisFournisseurHistory extends HistBusinessObject  {


    public DevisFournisseurHistory() {
    super();
    }

    public DevisFournisseurHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="devis_fournisseur_seq")
    public Long getId() {
    return id;
    }
}

