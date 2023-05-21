package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Vente;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.AvoirVenteHistory;
import ma.sir.easystock.bean.core.AvoirVente;
import ma.sir.easystock.ws.dto.AvoirVenteDto;

@Component
public class AvoirVenteConverter extends AbstractConverter<AvoirVente, AvoirVenteDto, AvoirVenteHistory> {

    @Autowired
    private EtatAvoirVenteConverter etatAvoirVenteConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirVenteItemConverter avoirVenteItemConverter ;
    @Autowired
    private VenteConverter venteConverter ;
    private boolean vente;
    private boolean etatAvoirVente;
    private boolean avoirVenteItems;

    public  AvoirVenteConverter(){
        super(AvoirVente.class, AvoirVenteDto.class, AvoirVenteHistory.class);
        init(true);
    }

    @Override
    public AvoirVente toItem(AvoirVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirVente item = new AvoirVente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateAvoir()))
                item.setDateAvoir(DateUtil.stringEnToDate(dto.getDateAvoir()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
            }

            if(this.etatAvoirVente && dto.getEtatAvoirVente()!=null)
                item.setEtatAvoirVente(etatAvoirVenteConverter.toItem(dto.getEtatAvoirVente())) ;


            if(this.avoirVenteItems && ListUtil.isNotEmpty(dto.getAvoirVenteItems()))
                item.setAvoirVenteItems(avoirVenteItemConverter.toItem(dto.getAvoirVenteItems()));

        return item;
        }
    }

    @Override
    public AvoirVenteDto toDto(AvoirVente item) {
        if (item == null) {
            return null;
        } else {
            AvoirVenteDto dto = new AvoirVenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateAvoir()!=null)
                dto.setDateAvoir(DateUtil.dateTimeToString(item.getDateAvoir()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.etatAvoirVente && item.getEtatAvoirVente()!=null) {
            dto.setEtatAvoirVente(etatAvoirVenteConverter.toDto(item.getEtatAvoirVente())) ;
        }
        if(this.avoirVenteItems && ListUtil.isNotEmpty(item.getAvoirVenteItems())){
            avoirVenteItemConverter.init(true);
            avoirVenteItemConverter.setAvoirVente(false);
            dto.setAvoirVenteItems(avoirVenteItemConverter.toDto(item.getAvoirVenteItems()));
            avoirVenteItemConverter.setAvoirVente(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.avoirVenteItems = value;
    }

    public void initObject(boolean value) {
        this.vente = value;
        this.etatAvoirVente = value;
    }


    public EtatAvoirVenteConverter getEtatAvoirVenteConverter(){
        return this.etatAvoirVenteConverter;
    }
    public void setEtatAvoirVenteConverter(EtatAvoirVenteConverter etatAvoirVenteConverter ){
        this.etatAvoirVenteConverter = etatAvoirVenteConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirVenteItemConverter getAvoirVenteItemConverter(){
        return this.avoirVenteItemConverter;
    }
    public void setAvoirVenteItemConverter(AvoirVenteItemConverter avoirVenteItemConverter ){
        this.avoirVenteItemConverter = avoirVenteItemConverter;
    }
    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isEtatAvoirVente(){
        return this.etatAvoirVente;
    }
    public void  setEtatAvoirVente(boolean etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }
    public boolean  isAvoirVenteItems(){
        return this.avoirVenteItems ;
    }
    public void  setAvoirVenteItems(boolean avoirVenteItems ){
        this.avoirVenteItems  = avoirVenteItems ;
    }
}
