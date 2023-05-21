package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_paiement_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_paiement_vente_seq",sequenceName="etat_paiement_vente_seq",allocationSize=1, initialValue = 1)
public class EtatPaiementVenteHistory extends HistBusinessObject  {


    public EtatPaiementVenteHistory() {
    super();
    }

    public EtatPaiementVenteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_paiement_vente_seq")
    public Long getId() {
    return id;
    }
}

