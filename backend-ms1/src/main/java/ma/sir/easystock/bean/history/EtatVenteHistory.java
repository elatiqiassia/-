package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_vente_seq",sequenceName="etat_vente_seq",allocationSize=1, initialValue = 1)
public class EtatVenteHistory extends HistBusinessObject  {


    public EtatVenteHistory() {
    super();
    }

    public EtatVenteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_vente_seq")
    public Long getId() {
    return id;
    }
}

