package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "categorie_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="categorie_produit_seq",sequenceName="categorie_produit_seq",allocationSize=1, initialValue = 1)
public class CategorieProduitHistory extends HistBusinessObject  {


    public CategorieProduitHistory() {
    super();
    }

    public CategorieProduitHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_produit_seq")
    public Long getId() {
    return id;
    }
}

