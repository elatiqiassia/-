package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "reception_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="reception_item_seq",sequenceName="reception_item_seq",allocationSize=1, initialValue = 1)
public class ReceptionItemHistory extends HistBusinessObject  {


    public ReceptionItemHistory() {
    super();
    }

    public ReceptionItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="reception_item_seq")
    public Long getId() {
    return id;
    }
}

