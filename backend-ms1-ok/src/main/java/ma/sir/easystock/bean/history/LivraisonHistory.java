package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "livraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="livraison_seq",sequenceName="livraison_seq",allocationSize=1, initialValue = 1)
public class LivraisonHistory extends HistBusinessObject  {


    public LivraisonHistory() {
    super();
    }

    public LivraisonHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="livraison_seq")
    public Long getId() {
    return id;
    }
}

