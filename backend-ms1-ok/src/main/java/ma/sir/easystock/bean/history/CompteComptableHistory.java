package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "compte_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="compte_comptable_seq",sequenceName="compte_comptable_seq",allocationSize=1, initialValue = 1)
public class CompteComptableHistory extends HistBusinessObject  {


    public CompteComptableHistory() {
    super();
    }

    public CompteComptableHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="compte_comptable_seq")
    public Long getId() {
    return id;
    }
}

