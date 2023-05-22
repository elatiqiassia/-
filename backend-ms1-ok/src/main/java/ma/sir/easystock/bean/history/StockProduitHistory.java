package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "stock_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="stock_produit_seq",sequenceName="stock_produit_seq",allocationSize=1, initialValue = 1)
public class StockProduitHistory extends HistBusinessObject  {


    public StockProduitHistory() {
    super();
    }

    public StockProduitHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="stock_produit_seq")
    public Long getId() {
    return id;
    }
}

