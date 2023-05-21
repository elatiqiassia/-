package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "demande_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_item_seq",sequenceName="demande_item_seq",allocationSize=1, initialValue = 1)
public class DemandeItemHistory extends HistBusinessObject  {


    public DemandeItemHistory() {
    super();
    }

    public DemandeItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demande_item_seq")
    public Long getId() {
    return id;
    }
}

