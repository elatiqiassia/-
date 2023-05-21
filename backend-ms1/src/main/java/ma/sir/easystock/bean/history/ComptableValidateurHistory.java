package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "comptable_validateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="comptable_validateur_seq",sequenceName="comptable_validateur_seq",allocationSize=1, initialValue = 1)
public class ComptableValidateurHistory extends HistBusinessObject  {


    public ComptableValidateurHistory() {
    super();
    }

    public ComptableValidateurHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="comptable_validateur_seq")
    public Long getId() {
    return id;
    }
}

