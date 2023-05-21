package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class SousClassComptableDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;

    private ClassComptableDto classComptable ;



    public SousClassComptableDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }


    public ClassComptableDto getClassComptable(){
        return this.classComptable;
    }

    public void setClassComptable(ClassComptableDto classComptable){
        this.classComptable = classComptable;
    }




}
