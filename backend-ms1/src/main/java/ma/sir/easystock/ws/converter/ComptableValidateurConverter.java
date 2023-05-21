package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ComptableValidateurHistory;
import ma.sir.easystock.bean.core.ComptableValidateur;
import ma.sir.easystock.ws.dto.ComptableValidateurDto;

@Component
public class ComptableValidateurConverter extends AbstractConverter<ComptableValidateur, ComptableValidateurDto, ComptableValidateurHistory> {


    public  ComptableValidateurConverter(){
        super(ComptableValidateur.class, ComptableValidateurDto.class, ComptableValidateurHistory.class);
    }

    @Override
    public ComptableValidateur toItem(ComptableValidateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        ComptableValidateur item = new ComptableValidateur();
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
    public ComptableValidateurDto toDto(ComptableValidateur item) {
        if (item == null) {
            return null;
        } else {
            ComptableValidateurDto dto = new ComptableValidateurDto();
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
