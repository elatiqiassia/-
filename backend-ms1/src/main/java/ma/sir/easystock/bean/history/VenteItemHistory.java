package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "vente_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vente_item_seq",sequenceName="vente_item_seq",allocationSize=1, initialValue = 1)
public class VenteItemHistory extends HistBusinessObject  {


    public VenteItemHistory() {
    super();
    }

    public VenteItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vente_item_seq")
    public Long getId() {
    return id;
    }
}

