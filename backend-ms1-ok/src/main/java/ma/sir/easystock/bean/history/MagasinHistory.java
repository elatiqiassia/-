package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "magasin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="magasin_seq",sequenceName="magasin_seq",allocationSize=1, initialValue = 1)
public class MagasinHistory extends HistBusinessObject  {


    public MagasinHistory() {
    super();
    }

    public MagasinHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="magasin_seq")
    public Long getId() {
    return id;
    }
}

