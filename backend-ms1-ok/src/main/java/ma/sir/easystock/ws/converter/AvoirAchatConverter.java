package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Achat;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.AvoirAchatHistory;
import ma.sir.easystock.bean.core.AvoirAchat;
import ma.sir.easystock.ws.dto.AvoirAchatDto;

@Component
public class AvoirAchatConverter extends AbstractConverter<AvoirAchat, AvoirAchatDto, AvoirAchatHistory> {

    @Autowired
    private EtatAvoirAchatConverter etatAvoirAchatConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirAchatItemConverter avoirAchatItemConverter ;
    @Autowired
    private AchatConverter achatConverter ;
    private boolean achat;
    private boolean etatAvoirAchat;
    private boolean avoirAchatItems;

    public  AvoirAchatConverter(){
        super(AvoirAchat.class, AvoirAchatDto.class, AvoirAchatHistory.class);
        init(true);
    }

    @Override
    public AvoirAchat toItem(AvoirAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirAchat item = new AvoirAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateAvoir()))
                item.setDateAvoir(DateUtil.stringEnToDate(dto.getDateAvoir()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
            }

            if(this.etatAvoirAchat && dto.getEtatAvoirAchat()!=null)
                item.setEtatAvoirAchat(etatAvoirAchatConverter.toItem(dto.getEtatAvoirAchat())) ;


            if(this.avoirAchatItems && ListUtil.isNotEmpty(dto.getAvoirAchatItems()))
                item.setAvoirAchatItems(avoirAchatItemConverter.toItem(dto.getAvoirAchatItems()));

        return item;
        }
    }

    @Override
    public AvoirAchatDto toDto(AvoirAchat item) {
        if (item == null) {
            return null;
        } else {
            AvoirAchatDto dto = new AvoirAchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateAvoir()!=null)
                dto.setDateAvoir(DateUtil.dateTimeToString(item.getDateAvoir()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }
        if(this.etatAvoirAchat && item.getEtatAvoirAchat()!=null) {
            dto.setEtatAvoirAchat(etatAvoirAchatConverter.toDto(item.getEtatAvoirAchat())) ;
        }
        if(this.avoirAchatItems && ListUtil.isNotEmpty(item.getAvoirAchatItems())){
            avoirAchatItemConverter.init(true);
            avoirAchatItemConverter.setAvoirAchat(false);
            dto.setAvoirAchatItems(avoirAchatItemConverter.toDto(item.getAvoirAchatItems()));
            avoirAchatItemConverter.setAvoirAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.avoirAchatItems = value;
    }

    public void initObject(boolean value) {
        this.achat = value;
        this.etatAvoirAchat = value;
    }


    public EtatAvoirAchatConverter getEtatAvoirAchatConverter(){
        return this.etatAvoirAchatConverter;
    }
    public void setEtatAvoirAchatConverter(EtatAvoirAchatConverter etatAvoirAchatConverter ){
        this.etatAvoirAchatConverter = etatAvoirAchatConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirAchatItemConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemConverter(AvoirAchatItemConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
    }
    public AchatConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatConverter(AchatConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }
    public void  setEtatAvoirAchat(boolean etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }
    public boolean  isAvoirAchatItems(){
        return this.avoirAchatItems ;
    }
    public void  setAvoirAchatItems(boolean avoirAchatItems ){
        this.avoirAchatItems  = avoirAchatItems ;
    }
}
