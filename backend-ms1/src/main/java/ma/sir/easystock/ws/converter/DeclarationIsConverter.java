package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Societe;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.DeclarationIsHistory;
import ma.sir.easystock.bean.core.DeclarationIs;
import ma.sir.easystock.ws.dto.DeclarationIsDto;

@Component
public class DeclarationIsConverter extends AbstractConverter<DeclarationIs, DeclarationIsDto, DeclarationIsHistory> {

    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private TauxIsConverter tauxIsConverter ;
    @Autowired
    private ComptableTraitantConverter comptableTraitantConverter ;
    @Autowired
    private ComptableValidateurConverter comptableValidateurConverter ;
    private boolean societe;
    private boolean tauxIs;
    private boolean comptableTraitant;
    private boolean comptableValidateur;

    public  DeclarationIsConverter(){
        super(DeclarationIs.class, DeclarationIsDto.class, DeclarationIsHistory.class);
    }

    @Override
    public DeclarationIs toItem(DeclarationIsDto dto) {
        if (dto == null) {
            return null;
        } else {
        DeclarationIs item = new DeclarationIs();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateDeclaration()))
                item.setDateDeclaration(DateUtil.stringEnToDate(dto.getDateDeclaration()));
            if(StringUtil.isNotEmpty(dto.getTrimistre()))
                item.setTrimistre(dto.getTrimistre());
            if(StringUtil.isNotEmpty(dto.getAnnee()))
                item.setAnnee(dto.getAnnee());
            if(StringUtil.isNotEmpty(dto.getTotalCharge()))
                item.setTotalCharge(dto.getTotalCharge());
            if(StringUtil.isNotEmpty(dto.getTotalProduit()))
                item.setTotalProduit(dto.getTotalProduit());
            if(StringUtil.isNotEmpty(dto.getResultatAvantImpot()))
                item.setResultatAvantImpot(dto.getResultatAvantImpot());
            if(StringUtil.isNotEmpty(dto.getMontantImpot()))
                item.setMontantImpot(dto.getMontantImpot());
            if(StringUtil.isNotEmpty(dto.getResultatApresImpot()))
                item.setResultatApresImpot(dto.getResultatApresImpot());
            if(dto.getSociete() != null && dto.getSociete().getId() != null){
                item.setSociete(new Societe());
                item.getSociete().setId(dto.getSociete().getId());
            }

            if(this.tauxIs && dto.getTauxIs()!=null)
                item.setTauxIs(tauxIsConverter.toItem(dto.getTauxIs())) ;

            if(this.comptableTraitant && dto.getComptableTraitant()!=null)
                item.setComptableTraitant(comptableTraitantConverter.toItem(dto.getComptableTraitant())) ;

            if(this.comptableValidateur && dto.getComptableValidateur()!=null)
                item.setComptableValidateur(comptableValidateurConverter.toItem(dto.getComptableValidateur())) ;



        return item;
        }
    }

    @Override
    public DeclarationIsDto toDto(DeclarationIs item) {
        if (item == null) {
            return null;
        } else {
            DeclarationIsDto dto = new DeclarationIsDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateDeclaration()!=null)
                dto.setDateDeclaration(DateUtil.dateTimeToString(item.getDateDeclaration()));
            if(StringUtil.isNotEmpty(item.getTrimistre()))
                dto.setTrimistre(item.getTrimistre());
            if(StringUtil.isNotEmpty(item.getAnnee()))
                dto.setAnnee(item.getAnnee());
            if(StringUtil.isNotEmpty(item.getTotalCharge()))
                dto.setTotalCharge(item.getTotalCharge());
            if(StringUtil.isNotEmpty(item.getTotalProduit()))
                dto.setTotalProduit(item.getTotalProduit());
            if(StringUtil.isNotEmpty(item.getResultatAvantImpot()))
                dto.setResultatAvantImpot(item.getResultatAvantImpot());
            if(StringUtil.isNotEmpty(item.getMontantImpot()))
                dto.setMontantImpot(item.getMontantImpot());
            if(StringUtil.isNotEmpty(item.getResultatApresImpot()))
                dto.setResultatApresImpot(item.getResultatApresImpot());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.tauxIs && item.getTauxIs()!=null) {
            dto.setTauxIs(tauxIsConverter.toDto(item.getTauxIs())) ;
        }
        if(this.comptableTraitant && item.getComptableTraitant()!=null) {
            dto.setComptableTraitant(comptableTraitantConverter.toDto(item.getComptableTraitant())) ;
        }
        if(this.comptableValidateur && item.getComptableValidateur()!=null) {
            dto.setComptableValidateur(comptableValidateurConverter.toDto(item.getComptableValidateur())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.societe = value;
        this.tauxIs = value;
        this.comptableTraitant = value;
        this.comptableValidateur = value;
    }


    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public TauxIsConverter getTauxIsConverter(){
        return this.tauxIsConverter;
    }
    public void setTauxIsConverter(TauxIsConverter tauxIsConverter ){
        this.tauxIsConverter = tauxIsConverter;
    }
    public ComptableTraitantConverter getComptableTraitantConverter(){
        return this.comptableTraitantConverter;
    }
    public void setComptableTraitantConverter(ComptableTraitantConverter comptableTraitantConverter ){
        this.comptableTraitantConverter = comptableTraitantConverter;
    }
    public ComptableValidateurConverter getComptableValidateurConverter(){
        return this.comptableValidateurConverter;
    }
    public void setComptableValidateurConverter(ComptableValidateurConverter comptableValidateurConverter ){
        this.comptableValidateurConverter = comptableValidateurConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
    public boolean  isTauxIs(){
        return this.tauxIs;
    }
    public void  setTauxIs(boolean tauxIs){
        this.tauxIs = tauxIs;
    }
    public boolean  isComptableTraitant(){
        return this.comptableTraitant;
    }
    public void  setComptableTraitant(boolean comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
    public boolean  isComptableValidateur(){
        return this.comptableValidateur;
    }
    public void  setComptableValidateur(boolean comptableValidateur){
        this.comptableValidateur = comptableValidateur;
    }
}
