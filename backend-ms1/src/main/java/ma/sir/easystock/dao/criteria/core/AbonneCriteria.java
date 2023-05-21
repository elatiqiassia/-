package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AbonneCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String adresse;
    private String adresseLike;
    private Boolean bloqued;
    private LocalDateTime dateCreation;
    private LocalDateTime dateCreationFrom;
    private LocalDateTime dateCreationTo;
    private String email;
    private String emailLike;
    private String tel;
    private String telLike;
    private String logo;
    private String logoLike;
    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String nomSociete;
    private String nomSocieteLike;
    private String pathBackUp;
    private String pathBackUpLike;
    private String patente;
    private String patenteLike;
    private String rc;
    private String rcLike;
    private String cnss;
    private String cnssLike;
    private String ifisc;
    private String ifiscLike;
    private String ice;
    private String iceLike;



    public AbonneCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public String getAdresseLike(){
        return this.adresseLike;
    }
    public void setAdresseLike(String adresseLike){
        this.adresseLike = adresseLike;
    }

    public Boolean getBloqued(){
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
    public LocalDateTime getDateCreationFrom(){
        return this.dateCreationFrom;
    }
    public void setDateCreationFrom(LocalDateTime dateCreationFrom){
        this.dateCreationFrom = dateCreationFrom;
    }
    public LocalDateTime getDateCreationTo(){
        return this.dateCreationTo;
    }
    public void setDateCreationTo(LocalDateTime dateCreationTo){
        this.dateCreationTo = dateCreationTo;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getTel(){
        return this.tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public String getTelLike(){
        return this.telLike;
    }
    public void setTelLike(String telLike){
        this.telLike = telLike;
    }

    public String getLogo(){
        return this.logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public String getLogoLike(){
        return this.logoLike;
    }
    public void setLogoLike(String logoLike){
        this.logoLike = logoLike;
    }

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }

    public String getNomSociete(){
        return this.nomSociete;
    }
    public void setNomSociete(String nomSociete){
        this.nomSociete = nomSociete;
    }
    public String getNomSocieteLike(){
        return this.nomSocieteLike;
    }
    public void setNomSocieteLike(String nomSocieteLike){
        this.nomSocieteLike = nomSocieteLike;
    }

    public String getPathBackUp(){
        return this.pathBackUp;
    }
    public void setPathBackUp(String pathBackUp){
        this.pathBackUp = pathBackUp;
    }
    public String getPathBackUpLike(){
        return this.pathBackUpLike;
    }
    public void setPathBackUpLike(String pathBackUpLike){
        this.pathBackUpLike = pathBackUpLike;
    }

    public String getPatente(){
        return this.patente;
    }
    public void setPatente(String patente){
        this.patente = patente;
    }
    public String getPatenteLike(){
        return this.patenteLike;
    }
    public void setPatenteLike(String patenteLike){
        this.patenteLike = patenteLike;
    }

    public String getRc(){
        return this.rc;
    }
    public void setRc(String rc){
        this.rc = rc;
    }
    public String getRcLike(){
        return this.rcLike;
    }
    public void setRcLike(String rcLike){
        this.rcLike = rcLike;
    }

    public String getCnss(){
        return this.cnss;
    }
    public void setCnss(String cnss){
        this.cnss = cnss;
    }
    public String getCnssLike(){
        return this.cnssLike;
    }
    public void setCnssLike(String cnssLike){
        this.cnssLike = cnssLike;
    }

    public String getIfisc(){
        return this.ifisc;
    }
    public void setIfisc(String ifisc){
        this.ifisc = ifisc;
    }
    public String getIfiscLike(){
        return this.ifiscLike;
    }
    public void setIfiscLike(String ifiscLike){
        this.ifiscLike = ifiscLike;
    }

    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }


}
