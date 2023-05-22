package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "bilan")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bilan_seq",sequenceName="bilan_seq",allocationSize=1, initialValue = 1)
public class BilanHistory extends HistBusinessObject  {


    public BilanHistory() {
    super();
    }

    public BilanHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bilan_seq")
    public Long getId() {
    return id;
    }
}

