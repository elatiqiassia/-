package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "unite_mesure")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="unite_mesure_seq",sequenceName="unite_mesure_seq",allocationSize=1, initialValue = 1)
public class UniteMesureHistory extends HistBusinessObject  {


    public UniteMesureHistory() {
    super();
    }

    public UniteMesureHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="unite_mesure_seq")
    public Long getId() {
    return id;
    }
}

