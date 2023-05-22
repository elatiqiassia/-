package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.StockProduitHistory;
import ma.sir.easystock.bean.core.StockProduit;
import ma.sir.easystock.ws.dto.StockProduitDto;

@Component
public class StockProduitConverter extends AbstractConverter<StockProduit, StockProduitDto, StockProduitHistory> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean magasin;
    private boolean produit;

    public  StockProduitConverter(){
        super(StockProduit.class, StockProduitDto.class, StockProduitHistory.class);
    }

    @Override
    public StockProduit toItem(StockProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        StockProduit item = new StockProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getQuantiteDeffecteuse()))
                item.setQuantiteDeffecteuse(dto.getQuantiteDeffecteuse());
            if(this.magasin && dto.getMagasin()!=null)
                item.setMagasin(magasinConverter.toItem(dto.getMagasin())) ;

            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;



        return item;
        }
    }

    @Override
    public StockProduitDto toDto(StockProduit item) {
        if (item == null) {
            return null;
        } else {
            StockProduitDto dto = new StockProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getQuantiteDeffecteuse()))
                dto.setQuantiteDeffecteuse(item.getQuantiteDeffecteuse());
        if(this.magasin && item.getMagasin()!=null) {
            dto.setMagasin(magasinConverter.toDto(item.getMagasin())) ;
        }
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.magasin = value;
        this.produit = value;
    }


    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isMagasin(){
        return this.magasin;
    }
    public void  setMagasin(boolean magasin){
        this.magasin = magasin;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
}
