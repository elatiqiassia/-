package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.AvoirAchat;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.AvoirAchatItemHistory;
import ma.sir.easystock.bean.core.AvoirAchatItem;
import ma.sir.easystock.ws.dto.AvoirAchatItemDto;

@Component
public class AvoirAchatItemConverter extends AbstractConverter<AvoirAchatItem, AvoirAchatItemDto, AvoirAchatItemHistory> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirAchatConverter avoirAchatConverter ;
    private boolean produit;
    private boolean avoirAchat;

    public  AvoirAchatItemConverter(){
        super(AvoirAchatItem.class, AvoirAchatItemDto.class, AvoirAchatItemHistory.class);
    }

    @Override
    public AvoirAchatItem toItem(AvoirAchatItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirAchatItem item = new AvoirAchatItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getAvoirAchat() != null && dto.getAvoirAchat().getId() != null){
                item.setAvoirAchat(new AvoirAchat());
                item.getAvoirAchat().setId(dto.getAvoirAchat().getId());
            }



        return item;
        }
    }

    @Override
    public AvoirAchatItemDto toDto(AvoirAchatItem item) {
        if (item == null) {
            return null;
        } else {
            AvoirAchatItemDto dto = new AvoirAchatItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.avoirAchat && item.getAvoirAchat()!=null) {
            dto.setAvoirAchat(avoirAchatConverter.toDto(item.getAvoirAchat())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.avoirAchat = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirAchatConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatConverter(AvoirAchatConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isAvoirAchat(){
        return this.avoirAchat;
    }
    public void  setAvoirAchat(boolean avoirAchat){
        this.avoirAchat = avoirAchat;
    }
}
