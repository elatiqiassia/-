package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.MarqueHistory;
import ma.sir.easystock.bean.core.Marque;
import ma.sir.easystock.ws.dto.MarqueDto;

@Component
public class MarqueConverter extends AbstractConverter<Marque, MarqueDto, MarqueHistory> {


    public  MarqueConverter(){
        super(Marque.class, MarqueDto.class, MarqueHistory.class);
    }

    @Override
    public Marque toItem(MarqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Marque item = new Marque();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public MarqueDto toDto(Marque item) {
        if (item == null) {
            return null;
        } else {
            MarqueDto dto = new MarqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
