package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatAvoirVenteHistory;
import ma.sir.easystock.bean.core.EtatAvoirVente;
import ma.sir.easystock.ws.dto.EtatAvoirVenteDto;

@Component
public class EtatAvoirVenteConverter extends AbstractConverter<EtatAvoirVente, EtatAvoirVenteDto, EtatAvoirVenteHistory> {


    public  EtatAvoirVenteConverter(){
        super(EtatAvoirVente.class, EtatAvoirVenteDto.class, EtatAvoirVenteHistory.class);
    }

    @Override
    public EtatAvoirVente toItem(EtatAvoirVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatAvoirVente item = new EtatAvoirVente();
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
    public EtatAvoirVenteDto toDto(EtatAvoirVente item) {
        if (item == null) {
            return null;
        } else {
            EtatAvoirVenteDto dto = new EtatAvoirVenteDto();
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
