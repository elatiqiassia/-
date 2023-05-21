package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Societe;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.OperationComptableHistory;
import ma.sir.easystock.bean.core.OperationComptable;
import ma.sir.easystock.ws.dto.OperationComptableDto;

@Component
public class OperationComptableConverter extends AbstractConverter<OperationComptable, OperationComptableDto, OperationComptableHistory> {

    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private CompteComptableConverter compteComptableConverter ;
    private boolean societe;
    private boolean compteComptable;

    public  OperationComptableConverter(){
        super(OperationComptable.class, OperationComptableDto.class, OperationComptableHistory.class);
    }

    @Override
    public OperationComptable toItem(OperationComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        OperationComptable item = new OperationComptable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateOperationComptable()))
                item.setDateOperationComptable(DateUtil.stringEnToDate(dto.getDateOperationComptable()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(dto.getSociete() != null && dto.getSociete().getId() != null){
                item.setSociete(new Societe());
                item.getSociete().setId(dto.getSociete().getId());
            }

            if(this.compteComptable && dto.getCompteComptable()!=null)
                item.setCompteComptable(compteComptableConverter.toItem(dto.getCompteComptable())) ;



        return item;
        }
    }

    @Override
    public OperationComptableDto toDto(OperationComptable item) {
        if (item == null) {
            return null;
        } else {
            OperationComptableDto dto = new OperationComptableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateOperationComptable()!=null)
                dto.setDateOperationComptable(DateUtil.dateTimeToString(item.getDateOperationComptable()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.compteComptable && item.getCompteComptable()!=null) {
            dto.setCompteComptable(compteComptableConverter.toDto(item.getCompteComptable())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.societe = value;
        this.compteComptable = value;
    }


    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public CompteComptableConverter getCompteComptableConverter(){
        return this.compteComptableConverter;
    }
    public void setCompteComptableConverter(CompteComptableConverter compteComptableConverter ){
        this.compteComptableConverter = compteComptableConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
    public boolean  isCompteComptable(){
        return this.compteComptable;
    }
    public void  setCompteComptable(boolean compteComptable){
        this.compteComptable = compteComptable;
    }
}
