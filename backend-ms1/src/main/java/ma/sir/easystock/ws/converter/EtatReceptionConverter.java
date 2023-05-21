package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatReceptionHistory;
import ma.sir.easystock.bean.core.EtatReception;
import ma.sir.easystock.ws.dto.EtatReceptionDto;

@Component
public class EtatReceptionConverter extends AbstractConverter<EtatReception, EtatReceptionDto, EtatReceptionHistory> {


    public  EtatReceptionConverter(){
        super(EtatReception.class, EtatReceptionDto.class, EtatReceptionHistory.class);
    }

    @Override
    public EtatReception toItem(EtatReceptionDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatReception item = new EtatReception();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getStyle()))
                item.setStyle(dto.getStyle());


        return item;
        }
    }

    @Override
    public EtatReceptionDto toDto(EtatReception item) {
        if (item == null) {
            return null;
        } else {
            EtatReceptionDto dto = new EtatReceptionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getStyle()))
                dto.setStyle(item.getStyle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
