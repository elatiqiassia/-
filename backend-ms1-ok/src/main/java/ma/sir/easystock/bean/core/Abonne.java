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




@Entity
@Table(name = "abonne")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="abonne_seq",sequenceName="abonne_seq",allocationSize=1, initialValue = 1)
public class Abonne   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String adresse;
    @Column(columnDefinition = "boolean default false")
    private Boolean bloqued = false;
    private LocalDateTime dateCreation ;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String tel;
    @Column(length = 500)
    private String logo;
    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    @Column(length = 500)
    private String nomSociete;
    @Column(length = 500)
    private String pathBackUp;
    @Column(length = 500)
    private String patente;
    @Column(length = 500)
    private String rc;
    @Column(length = 500)
    private String cnss;
    @Column(length = 500)
    private String ifisc;
    @Column(length = 500)
    private String ice;


    private List<Societe> societes ;

    public Abonne(){
        super();
    }

    public Abonne(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="abonne_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public Boolean  getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }
    public LocalDateTime getDateCreation(){
        return this.dateCreation;
    }
    public void setDateCreation(LocalDateTime dateCreation){
        this.dateCreation = dateCreation;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getTel(){
        return this.tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public String getLogo(){
        return this.logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getNomSociete(){
        return this.nomSociete;
    }
    public void setNomSociete(String nomSociete){
        this.nomSociete = nomSociete;
    }
    public String getPathBackUp(){
        return this.pathBackUp;
    }
    public void setPathBackUp(String pathBackUp){
        this.pathBackUp = pathBackUp;
    }
    public String getPatente(){
        return this.patente;
    }
    public void setPatente(String patente){
        this.patente = patente;
    }
    public String getRc(){
        return this.rc;
    }
    public void setRc(String rc){
        this.rc = rc;
    }
    public String getCnss(){
        return this.cnss;
    }
    public void setCnss(String cnss){
        this.cnss = cnss;
    }
    public String getIfisc(){
        return this.ifisc;
    }
    public void setIfisc(String ifisc){
        this.ifisc = ifisc;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    @OneToMany(mappedBy = "abonne")
    public List<Societe> getSocietes(){
        return this.societes;
    }
    public void setSocietes(List<Societe> societes){
        this.societes = societes;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonne abonne = (Abonne) o;
        return id != null && id.equals(abonne.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

