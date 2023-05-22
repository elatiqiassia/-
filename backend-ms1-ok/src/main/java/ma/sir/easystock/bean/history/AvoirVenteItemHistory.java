package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "avoir_vente_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_vente_item_seq",sequenceName="avoir_vente_item_seq",allocationSize=1, initialValue = 1)
public class AvoirVenteItemHistory extends HistBusinessObject  {


    public AvoirVenteItemHistory() {
    super();
    }

    public AvoirVenteItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="avoir_vente_item_seq")
    public Long getId() {
    return id;
    }
}

