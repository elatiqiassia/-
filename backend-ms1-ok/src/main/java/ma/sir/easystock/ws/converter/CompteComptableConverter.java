package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.CompteComptableHistory;
import ma.sir.easystock.bean.core.CompteComptable;
import ma.sir.easystock.ws.dto.CompteComptableDto;

@Component
public class CompteComptableConverter extends AbstractConverter<CompteComptable, CompteComptableDto, CompteComptableHistory> {

    @Autowired
    private SousClassComptableConverter sousClassComptableConverter ;
    private boolean sousClassComptable;

    public  CompteComptableConverter(){
        super(CompteComptable.class, CompteComptableDto.class, CompteComptableHistory.class);
    }

    @Override
    public CompteComptable toItem(CompteComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        CompteComptable item = new CompteComptable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.sousClassComptable && dto.getSousClassComptable()!=null)
                item.setSousClassComptable(sousClassComptableConverter.toItem(dto.getSousClassComptable())) ;



        return item;
        }
    }

    @Override
    public CompteComptableDto toDto(CompteComptable item) {
        if (item == null) {
            return null;
        } else {
            CompteComptableDto dto = new CompteComptableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.sousClassComptable && item.getSousClassComptable()!=null) {
            dto.setSousClassComptable(sousClassComptableConverter.toDto(item.getSousClassComptable())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.sousClassComptable = value;
    }


    public SousClassComptableConverter getSousClassComptableConverter(){
        return this.sousClassComptableConverter;
    }
    public void setSousClassComptableConverter(SousClassComptableConverter sousClassComptableConverter ){
        this.sousClassComptableConverter = sousClassComptableConverter;
    }
    public boolean  isSousClassComptable(){
        return this.sousClassComptable;
    }
    public void  setSousClassComptable(boolean sousClassComptable){
        this.sousClassComptable = sousClassComptable;
    }
}
