package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_avoir_vente_seq",sequenceName="etat_avoir_vente_seq",allocationSize=1, initialValue = 1)
public class EtatAvoirVenteHistory extends HistBusinessObject  {


    public EtatAvoirVenteHistory() {
    super();
    }

    public EtatAvoirVenteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_avoir_vente_seq")
    public Long getId() {
    return id;
    }
}

