package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ComptableTraitantHistory;
import ma.sir.easystock.bean.core.ComptableTraitant;
import ma.sir.easystock.ws.dto.ComptableTraitantDto;

@Component
public class ComptableTraitantConverter extends AbstractConverter<ComptableTraitant, ComptableTraitantDto, ComptableTraitantHistory> {


    public  ComptableTraitantConverter(){
        super(ComptableTraitant.class, ComptableTraitantDto.class, ComptableTraitantHistory.class);
    }

    @Override
    public ComptableTraitant toItem(ComptableTraitantDto dto) {
        if (dto == null) {
            return null;
        } else {
        ComptableTraitant item = new ComptableTraitant();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());


        return item;
        }
    }

    @Override
    public ComptableTraitantDto toDto(ComptableTraitant item) {
        if (item == null) {
            return null;
        } else {
            ComptableTraitantDto dto = new ComptableTraitantDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
