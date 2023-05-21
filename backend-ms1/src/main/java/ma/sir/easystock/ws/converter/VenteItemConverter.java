package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Vente;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.VenteItemHistory;
import ma.sir.easystock.bean.core.VenteItem;
import ma.sir.easystock.ws.dto.VenteItemDto;

@Component
public class VenteItemConverter extends AbstractConverter<VenteItem, VenteItemDto, VenteItemHistory> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private VenteConverter venteConverter ;
    private boolean produit;
    private boolean vente;

    public  VenteItemConverter(){
        super(VenteItem.class, VenteItemDto.class, VenteItemHistory.class);
    }

    @Override
    public VenteItem toItem(VenteItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        VenteItem item = new VenteItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrixUnitaire()))
                item.setPrixUnitaire(dto.getPrixUnitaire());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getRemise()))
                item.setRemise(dto.getRemise());
            if(StringUtil.isNotEmpty(dto.getQuantiteAvoir()))
                item.setQuantiteAvoir(dto.getQuantiteAvoir());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
            }



        return item;
        }
    }

    @Override
    public VenteItemDto toDto(VenteItem item) {
        if (item == null) {
            return null;
        } else {
            VenteItemDto dto = new VenteItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrixUnitaire()))
                dto.setPrixUnitaire(item.getPrixUnitaire());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getRemise()))
                dto.setRemise(item.getRemise());
            if(StringUtil.isNotEmpty(item.getQuantiteAvoir()))
                dto.setQuantiteAvoir(item.getQuantiteAvoir());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.vente = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
}
