package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Reception;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ReceptionItemHistory;
import ma.sir.easystock.bean.core.ReceptionItem;
import ma.sir.easystock.ws.dto.ReceptionItemDto;

@Component
public class ReceptionItemConverter extends AbstractConverter<ReceptionItem, ReceptionItemDto, ReceptionItemHistory> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private ReceptionConverter receptionConverter ;
    @Autowired
    private MagasinConverter magasinConverter ;
    private boolean produit;
    private boolean magasin;
    private boolean reception;

    public  ReceptionItemConverter(){
        super(ReceptionItem.class, ReceptionItemDto.class, ReceptionItemHistory.class);
    }

    @Override
    public ReceptionItem toItem(ReceptionItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReceptionItem item = new ReceptionItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(this.magasin && dto.getMagasin()!=null)
                item.setMagasin(magasinConverter.toItem(dto.getMagasin())) ;

            if(dto.getReception() != null && dto.getReception().getId() != null){
                item.setReception(new Reception());
                item.getReception().setId(dto.getReception().getId());
            }



        return item;
        }
    }

    @Override
    public ReceptionItemDto toDto(ReceptionItem item) {
        if (item == null) {
            return null;
        } else {
            ReceptionItemDto dto = new ReceptionItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.magasin && item.getMagasin()!=null) {
            dto.setMagasin(magasinConverter.toDto(item.getMagasin())) ;
        }
        if(this.reception && item.getReception()!=null) {
            dto.setReception(receptionConverter.toDto(item.getReception())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.magasin = value;
        this.reception = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public ReceptionConverter getReceptionConverter(){
        return this.receptionConverter;
    }
    public void setReceptionConverter(ReceptionConverter receptionConverter ){
        this.receptionConverter = receptionConverter;
    }
    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isMagasin(){
        return this.magasin;
    }
    public void  setMagasin(boolean magasin){
        this.magasin = magasin;
    }
    public boolean  isReception(){
        return this.reception;
    }
    public void  setReception(boolean reception){
        this.reception = reception;
    }
}
