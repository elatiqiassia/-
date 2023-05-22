package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.UniteMesureHistory;
import ma.sir.easystock.bean.core.UniteMesure;
import ma.sir.easystock.ws.dto.UniteMesureDto;

@Component
public class UniteMesureConverter extends AbstractConverter<UniteMesure, UniteMesureDto, UniteMesureHistory> {


    public  UniteMesureConverter(){
        super(UniteMesure.class, UniteMesureDto.class, UniteMesureHistory.class);
    }

    @Override
    public UniteMesure toItem(UniteMesureDto dto) {
        if (dto == null) {
            return null;
        } else {
        UniteMesure item = new UniteMesure();
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
    public UniteMesureDto toDto(UniteMesure item) {
        if (item == null) {
            return null;
        } else {
            UniteMesureDto dto = new UniteMesureDto();
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
