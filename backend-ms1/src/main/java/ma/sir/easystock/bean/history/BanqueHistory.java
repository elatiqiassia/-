package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "banque")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="banque_seq",sequenceName="banque_seq",allocationSize=1, initialValue = 1)
public class BanqueHistory extends HistBusinessObject  {


    public BanqueHistory() {
    super();
    }

    public BanqueHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="banque_seq")
    public Long getId() {
    return id;
    }
}

