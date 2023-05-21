package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Demande;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.DemandeItemHistory;
import ma.sir.easystock.bean.core.DemandeItem;
import ma.sir.easystock.ws.dto.DemandeItemDto;

@Component
public class DemandeItemConverter extends AbstractConverter<DemandeItem, DemandeItemDto, DemandeItemHistory> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private DemandeConverter demandeConverter ;
    private boolean produit;
    private boolean demande;

    public  DemandeItemConverter(){
        super(DemandeItem.class, DemandeItemDto.class, DemandeItemHistory.class);
    }

    @Override
    public DemandeItem toItem(DemandeItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandeItem item = new DemandeItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getQuantiteLivre()))
                item.setQuantiteLivre(dto.getQuantiteLivre());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getDemande() != null && dto.getDemande().getId() != null){
                item.setDemande(new Demande());
                item.getDemande().setId(dto.getDemande().getId());
            }



        return item;
        }
    }

    @Override
    public DemandeItemDto toDto(DemandeItem item) {
        if (item == null) {
            return null;
        } else {
            DemandeItemDto dto = new DemandeItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getQuantiteLivre()))
                dto.setQuantiteLivre(item.getQuantiteLivre());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.demande && item.getDemande()!=null) {
            dto.setDemande(demandeConverter.toDto(item.getDemande())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.demande = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public DemandeConverter getDemandeConverter(){
        return this.demandeConverter;
    }
    public void setDemandeConverter(DemandeConverter demandeConverter ){
        this.demandeConverter = demandeConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isDemande(){
        return this.demande;
    }
    public void  setDemande(boolean demande){
        this.demande = demande;
    }
}
