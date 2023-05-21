package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Societe;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.DeclarationTvaHistory;
import ma.sir.easystock.bean.core.DeclarationTva;
import ma.sir.easystock.ws.dto.DeclarationTvaDto;

@Component
public class DeclarationTvaConverter extends AbstractConverter<DeclarationTva, DeclarationTvaDto, DeclarationTvaHistory> {

    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private ComptableTraitantConverter comptableTraitantConverter ;
    @Autowired
    private TauxRetardTvaConverter tauxRetardTvaConverter ;
    @Autowired
    private ComptableValidateurConverter comptableValidateurConverter ;
    private boolean societe;
    private boolean tauxRetardTva;
    private boolean comptableTraitant;
    private boolean comptableValidateur;

    public  DeclarationTvaConverter(){
        super(DeclarationTva.class, DeclarationTvaDto.class, DeclarationTvaHistory.class);
    }

    @Override
    public DeclarationTva toItem(DeclarationTvaDto dto) {
        if (dto == null) {
            return null;
        } else {
        DeclarationTva item = new DeclarationTva();
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
            if(StringUtil.isNotEmpty(dto.getTotalTvaCollecte()))
                item.setTotalTvaCollecte(dto.getTotalTvaCollecte());
            if(StringUtil.isNotEmpty(dto.getTotalTvaDue()))
                item.setTotalTvaDue(dto.getTotalTvaDue());
            if(StringUtil.isNotEmpty(dto.getDifferenceTva()))
                item.setDifferenceTva(dto.getDifferenceTva());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(dto.getSociete() != null && dto.getSociete().getId() != null){
                item.setSociete(new Societe());
                item.getSociete().setId(dto.getSociete().getId());
            }

            if(this.tauxRetardTva && dto.getTauxRetardTva()!=null)
                item.setTauxRetardTva(tauxRetardTvaConverter.toItem(dto.getTauxRetardTva())) ;

            if(this.comptableTraitant && dto.getComptableTraitant()!=null)
                item.setComptableTraitant(comptableTraitantConverter.toItem(dto.getComptableTraitant())) ;

            if(this.comptableValidateur && dto.getComptableValidateur()!=null)
                item.setComptableValidateur(comptableValidateurConverter.toItem(dto.getComptableValidateur())) ;



        return item;
        }
    }

    @Override
    public DeclarationTvaDto toDto(DeclarationTva item) {
        if (item == null) {
            return null;
        } else {
            DeclarationTvaDto dto = new DeclarationTvaDto();
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
            if(StringUtil.isNotEmpty(item.getTotalTvaCollecte()))
                dto.setTotalTvaCollecte(item.getTotalTvaCollecte());
            if(StringUtil.isNotEmpty(item.getTotalTvaDue()))
                dto.setTotalTvaDue(item.getTotalTvaDue());
            if(StringUtil.isNotEmpty(item.getDifferenceTva()))
                dto.setDifferenceTva(item.getDifferenceTva());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.tauxRetardTva && item.getTauxRetardTva()!=null) {
            dto.setTauxRetardTva(tauxRetardTvaConverter.toDto(item.getTauxRetardTva())) ;
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
        this.tauxRetardTva = value;
        this.comptableTraitant = value;
        this.comptableValidateur = value;
    }


    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public ComptableTraitantConverter getComptableTraitantConverter(){
        return this.comptableTraitantConverter;
    }
    public void setComptableTraitantConverter(ComptableTraitantConverter comptableTraitantConverter ){
        this.comptableTraitantConverter = comptableTraitantConverter;
    }
    public TauxRetardTvaConverter getTauxRetardTvaConverter(){
        return this.tauxRetardTvaConverter;
    }
    public void setTauxRetardTvaConverter(TauxRetardTvaConverter tauxRetardTvaConverter ){
        this.tauxRetardTvaConverter = tauxRetardTvaConverter;
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
    public boolean  isTauxRetardTva(){
        return this.tauxRetardTva;
    }
    public void  setTauxRetardTva(boolean tauxRetardTva){
        this.tauxRetardTva = tauxRetardTva;
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
