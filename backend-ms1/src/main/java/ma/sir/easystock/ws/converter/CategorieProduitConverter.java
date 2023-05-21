package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.CategorieProduitHistory;
import ma.sir.easystock.bean.core.CategorieProduit;
import ma.sir.easystock.ws.dto.CategorieProduitDto;

@Component
public class CategorieProduitConverter extends AbstractConverter<CategorieProduit, CategorieProduitDto, CategorieProduitHistory> {


    public  CategorieProduitConverter(){
        super(CategorieProduit.class, CategorieProduitDto.class, CategorieProduitHistory.class);
    }

    @Override
    public CategorieProduit toItem(CategorieProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieProduit item = new CategorieProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public CategorieProduitDto toDto(CategorieProduit item) {
        if (item == null) {
            return null;
        } else {
            CategorieProduitDto dto = new CategorieProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
