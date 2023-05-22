package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.AchatHistory;
import ma.sir.easystock.bean.core.Achat;
import ma.sir.easystock.ws.dto.AchatDto;

@Component
public class AchatConverter extends AbstractConverter<Achat, AchatDto, AchatHistory> {

    @Autowired
    private EtatAchatConverter etatAchatConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private AchatItemConverter achatItemConverter ;
    private boolean fournisseur;
    private boolean store;
    private boolean etatAchat;
    private boolean achatItems;

    public  AchatConverter(){
        super(Achat.class, AchatDto.class, AchatHistory.class);
        init(true);
    }

    @Override
    public Achat toItem(AchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Achat item = new Achat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateAchat()))
                item.setDateAchat(DateUtil.stringEnToDate(dto.getDateAchat()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaye()))
                item.setTotalPaye(dto.getTotalPaye());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.fournisseur && dto.getFournisseur()!=null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;

            if(this.etatAchat && dto.getEtatAchat()!=null)
                item.setEtatAchat(etatAchatConverter.toItem(dto.getEtatAchat())) ;


            if(this.achatItems && ListUtil.isNotEmpty(dto.getAchatItems()))
                item.setAchatItems(achatItemConverter.toItem(dto.getAchatItems()));

        return item;
        }
    }

    @Override
    public AchatDto toDto(Achat item) {
        if (item == null) {
            return null;
        } else {
            AchatDto dto = new AchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateAchat()!=null)
                dto.setDateAchat(DateUtil.dateTimeToString(item.getDateAchat()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaye()))
                dto.setTotalPaye(item.getTotalPaye());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.etatAchat && item.getEtatAchat()!=null) {
            dto.setEtatAchat(etatAchatConverter.toDto(item.getEtatAchat())) ;
        }
        if(this.achatItems && ListUtil.isNotEmpty(item.getAchatItems())){
            achatItemConverter.init(true);
            achatItemConverter.setAchat(false);
            dto.setAchatItems(achatItemConverter.toDto(item.getAchatItems()));
            achatItemConverter.setAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.achatItems = value;
    }

    public void initObject(boolean value) {
        this.fournisseur = value;
        this.store = value;
        this.etatAchat = value;
    }


    public EtatAchatConverter getEtatAchatConverter(){
        return this.etatAchatConverter;
    }
    public void setEtatAchatConverter(EtatAchatConverter etatAchatConverter ){
        this.etatAchatConverter = etatAchatConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public AchatItemConverter getAchatItemConverter(){
        return this.achatItemConverter;
    }
    public void setAchatItemConverter(AchatItemConverter achatItemConverter ){
        this.achatItemConverter = achatItemConverter;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isEtatAchat(){
        return this.etatAchat;
    }
    public void  setEtatAchat(boolean etatAchat){
        this.etatAchat = etatAchat;
    }
    public boolean  isAchatItems(){
        return this.achatItems ;
    }
    public void  setAchatItems(boolean achatItems ){
        this.achatItems  = achatItems ;
    }
}
