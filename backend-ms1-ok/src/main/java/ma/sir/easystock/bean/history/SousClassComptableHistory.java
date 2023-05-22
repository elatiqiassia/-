package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "sous_class_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sous_class_comptable_seq",sequenceName="sous_class_comptable_seq",allocationSize=1, initialValue = 1)
public class SousClassComptableHistory extends HistBusinessObject  {


    public SousClassComptableHistory() {
    super();
    }

    public SousClassComptableHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sous_class_comptable_seq")
    public Long getId() {
    return id;
    }
}

