package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.AvoirVente;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.AvoirVenteItemHistory;
import ma.sir.easystock.bean.core.AvoirVenteItem;
import ma.sir.easystock.ws.dto.AvoirVenteItemDto;

@Component
public class AvoirVenteItemConverter extends AbstractConverter<AvoirVenteItem, AvoirVenteItemDto, AvoirVenteItemHistory> {

    @Autowired
    private AvoirVenteConverter avoirVenteConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean avoirVente;

    public  AvoirVenteItemConverter(){
        super(AvoirVenteItem.class, AvoirVenteItemDto.class, AvoirVenteItemHistory.class);
    }

    @Override
    public AvoirVenteItem toItem(AvoirVenteItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirVenteItem item = new AvoirVenteItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMontantAvoir()))
                item.setMontantAvoir(dto.getMontantAvoir());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getAvoirVente() != null && dto.getAvoirVente().getId() != null){
                item.setAvoirVente(new AvoirVente());
                item.getAvoirVente().setId(dto.getAvoirVente().getId());
            }



        return item;
        }
    }

    @Override
    public AvoirVenteItemDto toDto(AvoirVenteItem item) {
        if (item == null) {
            return null;
        } else {
            AvoirVenteItemDto dto = new AvoirVenteItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMontantAvoir()))
                dto.setMontantAvoir(item.getMontantAvoir());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.avoirVente && item.getAvoirVente()!=null) {
            dto.setAvoirVente(avoirVenteConverter.toDto(item.getAvoirVente())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.avoirVente = value;
    }


    public AvoirVenteConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteConverter(AvoirVenteConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isAvoirVente(){
        return this.avoirVente;
    }
    public void  setAvoirVente(boolean avoirVente){
        this.avoirVente = avoirVente;
    }
}
