package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class MagasinDto  extends AuditBaseDto {

    private String reference  ;
    private String adresse  ;

    private StoreDto store ;



    public MagasinDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }


    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }




}
