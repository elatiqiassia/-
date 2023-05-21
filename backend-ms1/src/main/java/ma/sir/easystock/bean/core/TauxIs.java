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
@Table(name = "taux_is")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="taux_is_seq",sequenceName="taux_is_seq",allocationSize=1, initialValue = 1)
public class TauxIs   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal resultatMin = BigDecimal.ZERO;
    private BigDecimal resultatMax = BigDecimal.ZERO;
    private LocalDateTime dateApplicationMin ;
    private LocalDateTime dateApplicationMax ;
    private BigDecimal pourcentage = BigDecimal.ZERO;



    public TauxIs(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="taux_is_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getResultatMin(){
        return this.resultatMin;
    }
    public void setResultatMin(BigDecimal resultatMin){
        this.resultatMin = resultatMin;
    }
    public BigDecimal getResultatMax(){
        return this.resultatMax;
    }
    public void setResultatMax(BigDecimal resultatMax){
        this.resultatMax = resultatMax;
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
    public BigDecimal getPourcentage(){
        return this.pourcentage;
    }
    public void setPourcentage(BigDecimal pourcentage){
        this.pourcentage = pourcentage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TauxIs tauxIs = (TauxIs) o;
        return id != null && id.equals(tauxIs.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

