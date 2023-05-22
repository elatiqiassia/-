package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatAvoirAchatHistory;
import ma.sir.easystock.bean.core.EtatAvoirAchat;
import ma.sir.easystock.ws.dto.EtatAvoirAchatDto;

@Component
public class EtatAvoirAchatConverter extends AbstractConverter<EtatAvoirAchat, EtatAvoirAchatDto, EtatAvoirAchatHistory> {


    public  EtatAvoirAchatConverter(){
        super(EtatAvoirAchat.class, EtatAvoirAchatDto.class, EtatAvoirAchatHistory.class);
    }

    @Override
    public EtatAvoirAchat toItem(EtatAvoirAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatAvoirAchat item = new EtatAvoirAchat();
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
    public EtatAvoirAchatDto toDto(EtatAvoirAchat item) {
        if (item == null) {
            return null;
        } else {
            EtatAvoirAchatDto dto = new EtatAvoirAchatDto();
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
