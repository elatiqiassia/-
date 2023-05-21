package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "operation_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="operation_comptable_seq",sequenceName="operation_comptable_seq",allocationSize=1, initialValue = 1)
public class OperationComptableHistory extends HistBusinessObject  {


    public OperationComptableHistory() {
    super();
    }

    public OperationComptableHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="operation_comptable_seq")
    public Long getId() {
    return id;
    }
}

