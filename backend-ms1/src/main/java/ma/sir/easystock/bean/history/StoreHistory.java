package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "store")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="store_seq",sequenceName="store_seq",allocationSize=1, initialValue = 1)
public class StoreHistory extends HistBusinessObject  {


    public StoreHistory() {
    super();
    }

    public StoreHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="store_seq")
    public Long getId() {
    return id;
    }
}

