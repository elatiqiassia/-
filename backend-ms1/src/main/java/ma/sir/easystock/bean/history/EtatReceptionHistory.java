package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_reception")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_reception_seq",sequenceName="etat_reception_seq",allocationSize=1, initialValue = 1)
public class EtatReceptionHistory extends HistBusinessObject  {


    public EtatReceptionHistory() {
    super();
    }

    public EtatReceptionHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_reception_seq")
    public Long getId() {
    return id;
    }
}

