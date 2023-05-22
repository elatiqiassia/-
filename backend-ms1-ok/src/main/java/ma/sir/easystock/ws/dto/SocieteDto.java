package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocieteDto  extends AuditBaseDto {

    private String ice  ;
    private String siege  ;
    private Integer dernierAnneePayerIs  = 0 ;
    private Integer dernierTrimestrePayerIs  = 0 ;
    private Integer dernierAnneePayerTva  = 0 ;
    private Integer dernierTrimestrePayerTva  = 0 ;
    private Boolean bloqued  ;

    private AbonneDto abonne ;

    private List<StoreDto> stores ;


    public SocieteDto(){
        super();
    }



    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }

    @Log
    public String getSiege(){
        return this.siege;
    }
    public void setSiege(String siege){
        this.siege = siege;
    }

    @Log
    public Integer getDernierAnneePayerIs(){
        return this.dernierAnneePayerIs;
    }
    public void setDernierAnneePayerIs(Integer dernierAnneePayerIs){
        this.dernierAnneePayerIs = dernierAnneePayerIs;
    }

    @Log
    public Integer getDernierTrimestrePayerIs(){
        return this.dernierTrimestrePayerIs;
    }
    public void setDernierTrimestrePayerIs(Integer dernierTrimestrePayerIs){
        this.dernierTrimestrePayerIs = dernierTrimestrePayerIs;
    }

    @Log
    public Integer getDernierAnneePayerTva(){
        return this.dernierAnneePayerTva;
    }
    public void setDernierAnneePayerTva(Integer dernierAnneePayerTva){
        this.dernierAnneePayerTva = dernierAnneePayerTva;
    }

    @Log
    public Integer getDernierTrimestrePayerTva(){
        return this.dernierTrimestrePayerTva;
    }
    public void setDernierTrimestrePayerTva(Integer dernierTrimestrePayerTva){
        this.dernierTrimestrePayerTva = dernierTrimestrePayerTva;
    }

    @Log
    public Boolean getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }


    public AbonneDto getAbonne(){
        return this.abonne;
    }

    public void setAbonne(AbonneDto abonne){
        this.abonne = abonne;
    }



    public List<StoreDto> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreDto> stores){
        this.stores = stores;
    }

}
