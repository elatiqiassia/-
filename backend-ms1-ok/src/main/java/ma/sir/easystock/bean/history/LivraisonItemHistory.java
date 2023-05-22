package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "livraison_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="livraison_item_seq",sequenceName="livraison_item_seq",allocationSize=1, initialValue = 1)
public class LivraisonItemHistory extends HistBusinessObject  {


    public LivraisonItemHistory() {
    super();
    }

    public LivraisonItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="livraison_item_seq")
    public Long getId() {
    return id;
    }
}

