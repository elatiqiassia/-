package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.SousClassComptableHistory;
import ma.sir.easystock.bean.core.SousClassComptable;
import ma.sir.easystock.ws.dto.SousClassComptableDto;

@Component
public class SousClassComptableConverter extends AbstractConverter<SousClassComptable, SousClassComptableDto, SousClassComptableHistory> {

    @Autowired
    private ClassComptableConverter classComptableConverter ;
    private boolean classComptable;

    public  SousClassComptableConverter(){
        super(SousClassComptable.class, SousClassComptableDto.class, SousClassComptableHistory.class);
    }

    @Override
    public SousClassComptable toItem(SousClassComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        SousClassComptable item = new SousClassComptable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.classComptable && dto.getClassComptable()!=null)
                item.setClassComptable(classComptableConverter.toItem(dto.getClassComptable())) ;



        return item;
        }
    }

    @Override
    public SousClassComptableDto toDto(SousClassComptable item) {
        if (item == null) {
            return null;
        } else {
            SousClassComptableDto dto = new SousClassComptableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.classComptable && item.getClassComptable()!=null) {
            dto.setClassComptable(classComptableConverter.toDto(item.getClassComptable())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.classComptable = value;
    }


    public ClassComptableConverter getClassComptableConverter(){
        return this.classComptableConverter;
    }
    public void setClassComptableConverter(ClassComptableConverter classComptableConverter ){
        this.classComptableConverter = classComptableConverter;
    }
    public boolean  isClassComptable(){
        return this.classComptable;
    }
    public void  setClassComptable(boolean classComptable){
        this.classComptable = classComptable;
    }
}
