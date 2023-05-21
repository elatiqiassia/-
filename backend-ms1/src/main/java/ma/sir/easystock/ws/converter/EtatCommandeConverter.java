package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatCommandeHistory;
import ma.sir.easystock.bean.core.EtatCommande;
import ma.sir.easystock.ws.dto.EtatCommandeDto;

@Component
public class EtatCommandeConverter extends AbstractConverter<EtatCommande, EtatCommandeDto, EtatCommandeHistory> {


    public  EtatCommandeConverter(){
        super(EtatCommande.class, EtatCommandeDto.class, EtatCommandeHistory.class);
    }

    @Override
    public EtatCommande toItem(EtatCommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatCommande item = new EtatCommande();
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
    public EtatCommandeDto toDto(EtatCommande item) {
        if (item == null) {
            return null;
        } else {
            EtatCommandeDto dto = new EtatCommandeDto();
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
