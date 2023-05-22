package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbonneDto  extends AuditBaseDto {

    private String code  ;
    private String adresse  ;
    private Boolean bloqued  ;
    private String dateCreation ;
    private String email  ;
    private String tel  ;
    private String logo  ;
    private String nom  ;
    private String prenom  ;
    private String nomSociete  ;
    private String pathBackUp  ;
    private String patente  ;
    private String rc  ;
    private String cnss  ;
    private String ifisc  ;
    private String ice  ;


    private List<SocieteDto> societes ;


    public AbonneDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    @Log
    public Boolean getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateCreation(){
        return this.dateCreation;
    }
    public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public String getTel(){
        return this.tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }

    @Log
    public String getLogo(){
        return this.logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }

    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public String getNomSociete(){
        return this.nomSociete;
    }
    public void setNomSociete(String nomSociete){
        this.nomSociete = nomSociete;
    }

    @Log
    public String getPathBackUp(){
        return this.pathBackUp;
    }
    public void setPathBackUp(String pathBackUp){
        this.pathBackUp = pathBackUp;
    }

    @Log
    public String getPatente(){
        return this.patente;
    }
    public void setPatente(String patente){
        this.patente = patente;
    }

    @Log
    public String getRc(){
        return this.rc;
    }
    public void setRc(String rc){
        this.rc = rc;
    }

    @Log
    public String getCnss(){
        return this.cnss;
    }
    public void setCnss(String cnss){
        this.cnss = cnss;
    }

    @Log
    public String getIfisc(){
        return this.ifisc;
    }
    public void setIfisc(String ifisc){
        this.ifisc = ifisc;
    }

    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }





    public List<SocieteDto> getSocietes(){
        return this.societes;
    }

    public void setSocietes(List<SocieteDto> societes){
        this.societes = societes;
    }

}
