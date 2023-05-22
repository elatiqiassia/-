package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "comptable_traitant")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="comptable_traitant_seq",sequenceName="comptable_traitant_seq",allocationSize=1, initialValue = 1)
public class ComptableTraitantHistory extends HistBusinessObject  {


    public ComptableTraitantHistory() {
    super();
    }

    public ComptableTraitantHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="comptable_traitant_seq")
    public Long getId() {
    return id;
    }
}

