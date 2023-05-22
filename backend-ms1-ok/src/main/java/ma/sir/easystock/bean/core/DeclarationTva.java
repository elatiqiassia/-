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
@Table(name = "declaration_tva")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="declaration_tva_seq",sequenceName="declaration_tva_seq",allocationSize=1, initialValue = 1)
public class DeclarationTva   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateDeclaration ;
    private Integer trimistre = 0;
    private Integer annee = 0;
    private BigDecimal totalTvaCollecte = BigDecimal.ZERO;
    private BigDecimal totalTvaDue = BigDecimal.ZERO;
    private BigDecimal differenceTva = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;

    private Societe societe ;
    
    private TauxRetardTva tauxRetardTva ;
    
    private ComptableTraitant comptableTraitant ;
    
    private ComptableValidateur comptableValidateur ;
    


    public DeclarationTva(){
        super();
    }

    public DeclarationTva(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="declaration_tva_seq")
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
    public LocalDateTime getDateDeclaration(){
        return this.dateDeclaration;
    }
    public void setDateDeclaration(LocalDateTime dateDeclaration){
        this.dateDeclaration = dateDeclaration;
    }
    public Integer getTrimistre(){
        return this.trimistre;
    }
    public void setTrimistre(Integer trimistre){
        this.trimistre = trimistre;
    }
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Societe getSociete(){
        return this.societe;
    }
    public void setSociete(Societe societe){
        this.societe = societe;
    }
    public BigDecimal getTotalTvaCollecte(){
        return this.totalTvaCollecte;
    }
    public void setTotalTvaCollecte(BigDecimal totalTvaCollecte){
        this.totalTvaCollecte = totalTvaCollecte;
    }
    public BigDecimal getTotalTvaDue(){
        return this.totalTvaDue;
    }
    public void setTotalTvaDue(BigDecimal totalTvaDue){
        this.totalTvaDue = totalTvaDue;
    }
    public BigDecimal getDifferenceTva(){
        return this.differenceTva;
    }
    public void setDifferenceTva(BigDecimal differenceTva){
        this.differenceTva = differenceTva;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TauxRetardTva getTauxRetardTva(){
        return this.tauxRetardTva;
    }
    public void setTauxRetardTva(TauxRetardTva tauxRetardTva){
        this.tauxRetardTva = tauxRetardTva;
    }
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ComptableTraitant getComptableTraitant(){
        return this.comptableTraitant;
    }
    public void setComptableTraitant(ComptableTraitant comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ComptableValidateur getComptableValidateur(){
        return this.comptableValidateur;
    }
    public void setComptableValidateur(ComptableValidateur comptableValidateur){
        this.comptableValidateur = comptableValidateur;
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
        DeclarationTva declarationTva = (DeclarationTva) o;
        return id != null && id.equals(declarationTva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

