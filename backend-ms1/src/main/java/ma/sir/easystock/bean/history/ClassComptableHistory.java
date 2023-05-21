package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "class_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="class_comptable_seq",sequenceName="class_comptable_seq",allocationSize=1, initialValue = 1)
public class ClassComptableHistory extends HistBusinessObject  {


    public ClassComptableHistory() {
    super();
    }

    public ClassComptableHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="class_comptable_seq")
    public Long getId() {
    return id;
    }
}

