package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Livraison;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.LivraisonItemHistory;
import ma.sir.easystock.bean.core.LivraisonItem;
import ma.sir.easystock.ws.dto.LivraisonItemDto;

@Component
public class LivraisonItemConverter extends AbstractConverter<LivraisonItem, LivraisonItemDto, LivraisonItemHistory> {

    @Autowired
    private LivraisonConverter livraisonConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private MagasinConverter magasinConverter ;
    private boolean produit;
    private boolean magasin;
    private boolean livraison;

    public  LivraisonItemConverter(){
        super(LivraisonItem.class, LivraisonItemDto.class, LivraisonItemHistory.class);
    }

    @Override
    public LivraisonItem toItem(LivraisonItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        LivraisonItem item = new LivraisonItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(this.magasin && dto.getMagasin()!=null)
                item.setMagasin(magasinConverter.toItem(dto.getMagasin())) ;

            if(dto.getLivraison() != null && dto.getLivraison().getId() != null){
                item.setLivraison(new Livraison());
                item.getLivraison().setId(dto.getLivraison().getId());
            }



        return item;
        }
    }

    @Override
    public LivraisonItemDto toDto(LivraisonItem item) {
        if (item == null) {
            return null;
        } else {
            LivraisonItemDto dto = new LivraisonItemDto();
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
        if(this.livraison && item.getLivraison()!=null) {
            dto.setLivraison(livraisonConverter.toDto(item.getLivraison())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.magasin = value;
        this.livraison = value;
    }


    public LivraisonConverter getLivraisonConverter(){
        return this.livraisonConverter;
    }
    public void setLivraisonConverter(LivraisonConverter livraisonConverter ){
        this.livraisonConverter = livraisonConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
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
    public boolean  isLivraison(){
        return this.livraison;
    }
    public void  setLivraison(boolean livraison){
        this.livraison = livraison;
    }
}
