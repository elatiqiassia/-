package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ProduitHistory;
import ma.sir.easystock.bean.core.Produit;
import ma.sir.easystock.ws.dto.ProduitDto;

@Component
public class ProduitConverter extends AbstractConverter<Produit, ProduitDto, ProduitHistory> {

    @Autowired
    private UniteMesureConverter uniteMesureConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private CategorieProduitConverter categorieProduitConverter ;
    @Autowired
    private MarqueConverter marqueConverter ;
    private boolean categorieProduit;
    private boolean uniteMesure;
    private boolean marque;
    private boolean store;

    public  ProduitConverter(){
        super(Produit.class, ProduitDto.class, ProduitHistory.class);
    }

    @Override
    public Produit toItem(ProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        Produit item = new Produit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getBarcode()))
                item.setBarcode(dto.getBarcode());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getPrixAchatMoyen()))
                item.setPrixAchatMoyen(dto.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getSeuilAlert()))
                item.setSeuilAlert(dto.getSeuilAlert());
            if(StringUtil.isNotEmpty(dto.getPhotoProduits()))
                item.setPhotoProduits(dto.getPhotoProduits());
            if(this.categorieProduit && dto.getCategorieProduit()!=null)
                item.setCategorieProduit(categorieProduitConverter.toItem(dto.getCategorieProduit())) ;

            if(this.uniteMesure && dto.getUniteMesure()!=null)
                item.setUniteMesure(uniteMesureConverter.toItem(dto.getUniteMesure())) ;

            if(this.marque && dto.getMarque()!=null)
                item.setMarque(marqueConverter.toItem(dto.getMarque())) ;

            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;



        return item;
        }
    }

    @Override
    public ProduitDto toDto(Produit item) {
        if (item == null) {
            return null;
        } else {
            ProduitDto dto = new ProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getBarcode()))
                dto.setBarcode(item.getBarcode());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getPrixAchatMoyen()))
                dto.setPrixAchatMoyen(item.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getSeuilAlert()))
                dto.setSeuilAlert(item.getSeuilAlert());
            if(StringUtil.isNotEmpty(item.getPhotoProduits()))
                dto.setPhotoProduits(item.getPhotoProduits());
        if(this.categorieProduit && item.getCategorieProduit()!=null) {
            dto.setCategorieProduit(categorieProduitConverter.toDto(item.getCategorieProduit())) ;
        }
        if(this.uniteMesure && item.getUniteMesure()!=null) {
            dto.setUniteMesure(uniteMesureConverter.toDto(item.getUniteMesure())) ;
        }
        if(this.marque && item.getMarque()!=null) {
            dto.setMarque(marqueConverter.toDto(item.getMarque())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.categorieProduit = value;
        this.uniteMesure = value;
        this.marque = value;
        this.store = value;
    }


    public UniteMesureConverter getUniteMesureConverter(){
        return this.uniteMesureConverter;
    }
    public void setUniteMesureConverter(UniteMesureConverter uniteMesureConverter ){
        this.uniteMesureConverter = uniteMesureConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public CategorieProduitConverter getCategorieProduitConverter(){
        return this.categorieProduitConverter;
    }
    public void setCategorieProduitConverter(CategorieProduitConverter categorieProduitConverter ){
        this.categorieProduitConverter = categorieProduitConverter;
    }
    public MarqueConverter getMarqueConverter(){
        return this.marqueConverter;
    }
    public void setMarqueConverter(MarqueConverter marqueConverter ){
        this.marqueConverter = marqueConverter;
    }
    public boolean  isCategorieProduit(){
        return this.categorieProduit;
    }
    public void  setCategorieProduit(boolean categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public boolean  isUniteMesure(){
        return this.uniteMesure;
    }
    public void  setUniteMesure(boolean uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    public boolean  isMarque(){
        return this.marque;
    }
    public void  setMarque(boolean marque){
        this.marque = marque;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
}
