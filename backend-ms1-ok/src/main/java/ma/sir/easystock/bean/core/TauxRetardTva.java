package ma.sir.easystock.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "taux_retard_tva")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="taux_retard_tva_seq",sequenceName="taux_retard_tva_seq",allocationSize=1, initialValue = 1)
public class TauxRetardTva   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateApplicationMin ;
    private LocalDateTime dateApplicationMax ;
    private BigDecimal montant = BigDecimal.ZERO;



    public TauxRetardTva(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="taux_retard_tva_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateApplicationMin(){
        return this.dateApplicationMin;
    }
    public void setDateApplicationMin(LocalDateTime dateApplicationMin){
        this.dateApplicationMin = dateApplicationMin;
    }
    public LocalDateTime getDateApplicationMax(){
        return this.dateApplicationMax;
    }
    public void setDateApplicationMax(LocalDateTime dateApplicationMax){
        this.dateApplicationMax = dateApplicationMax;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TauxRetardTva tauxRetardTva = (TauxRetardTva) o;
        return id != null && id.equals(tauxRetardTva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

