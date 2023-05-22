package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_vente_seq",sequenceName="avoir_vente_seq",allocationSize=1, initialValue = 1)
public class AvoirVenteHistory extends HistBusinessObject  {


    public AvoirVenteHistory() {
    super();
    }

    public AvoirVenteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="avoir_vente_seq")
    public Long getId() {
    return id;
    }
}

