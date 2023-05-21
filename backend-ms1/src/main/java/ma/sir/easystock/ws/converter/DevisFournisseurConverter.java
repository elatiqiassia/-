package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.DevisFournisseurHistory;
import ma.sir.easystock.bean.core.DevisFournisseur;
import ma.sir.easystock.ws.dto.DevisFournisseurDto;

@Component
public class DevisFournisseurConverter extends AbstractConverter<DevisFournisseur, DevisFournisseurDto, DevisFournisseurHistory> {

    @Autowired
    private DevisItemFournisseurConverter devisItemFournisseurConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    private boolean fournisseur;
    private boolean devisItemFournisseurs;

    public  DevisFournisseurConverter(){
        super(DevisFournisseur.class, DevisFournisseurDto.class, DevisFournisseurHistory.class);
        init(true);
    }

    @Override
    public DevisFournisseur toItem(DevisFournisseurDto dto) {
        if (dto == null) {
            return null;
        } else {
        DevisFournisseur item = new DevisFournisseur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateDevis()))
                item.setDateDevis(DateUtil.stringEnToDate(dto.getDateDevis()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.fournisseur && dto.getFournisseur()!=null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;


            if(this.devisItemFournisseurs && ListUtil.isNotEmpty(dto.getDevisItemFournisseurs()))
                item.setDevisItemFournisseurs(devisItemFournisseurConverter.toItem(dto.getDevisItemFournisseurs()));

        return item;
        }
    }

    @Override
    public DevisFournisseurDto toDto(DevisFournisseur item) {
        if (item == null) {
            return null;
        } else {
            DevisFournisseurDto dto = new DevisFournisseurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateDevis()!=null)
                dto.setDateDevis(DateUtil.dateTimeToString(item.getDateDevis()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.devisItemFournisseurs && ListUtil.isNotEmpty(item.getDevisItemFournisseurs())){
            devisItemFournisseurConverter.init(true);
            devisItemFournisseurConverter.setDevisFournisseur(false);
            dto.setDevisItemFournisseurs(devisItemFournisseurConverter.toDto(item.getDevisItemFournisseurs()));
            devisItemFournisseurConverter.setDevisFournisseur(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.devisItemFournisseurs = value;
    }

    public void initObject(boolean value) {
        this.fournisseur = value;
    }


    public DevisItemFournisseurConverter getDevisItemFournisseurConverter(){
        return this.devisItemFournisseurConverter;
    }
    public void setDevisItemFournisseurConverter(DevisItemFournisseurConverter devisItemFournisseurConverter ){
        this.devisItemFournisseurConverter = devisItemFournisseurConverter;
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
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isDevisItemFournisseurs(){
        return this.devisItemFournisseurs ;
    }
    public void  setDevisItemFournisseurs(boolean devisItemFournisseurs ){
        this.devisItemFournisseurs  = devisItemFournisseurs ;
    }
}
