package ma.sir.easystock.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vente_seq",sequenceName="vente_seq",allocationSize=1, initialValue = 1)
public class Vente   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateVente ;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal totalPaye = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Store store ;
    
    private Client client ;
    
    private EtatVente etatVente ;
    

    private List<VenteItem> venteItems ;

    public Vente(){
        super();
    }

    public Vente(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vente_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateVente(){
        return this.dateVente;
    }
    public void setDateVente(LocalDateTime dateVente){
        this.dateVente = dateVente;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public BigDecimal getTotalPaye(){
        return this.totalPaye;
    }
    public void setTotalPaye(BigDecimal totalPaye){
        this.totalPaye = totalPaye;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore(){
        return this.store;
    }
    public void setStore(Store store){
        this.store = store;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @OneToMany(mappedBy = "vente")
    public List<VenteItem> getVenteItems(){
        return this.venteItems;
    }
    public void setVenteItems(List<VenteItem> venteItems){
        this.venteItems = venteItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatVente getEtatVente(){
        return this.etatVente;
    }
    public void setEtatVente(EtatVente etatVente){
        this.etatVente = etatVente;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vente vente = (Vente) o;
        return id != null && id.equals(vente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

