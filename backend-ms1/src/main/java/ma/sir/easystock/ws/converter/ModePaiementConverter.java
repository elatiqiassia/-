package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ModePaiementHistory;
import ma.sir.easystock.bean.core.ModePaiement;
import ma.sir.easystock.ws.dto.ModePaiementDto;

@Component
public class ModePaiementConverter extends AbstractConverter<ModePaiement, ModePaiementDto, ModePaiementHistory> {


    public  ModePaiementConverter(){
        super(ModePaiement.class, ModePaiementDto.class, ModePaiementHistory.class);
    }

    @Override
    public ModePaiement toItem(ModePaiementDto dto) {
        if (dto == null) {
            return null;
        } else {
        ModePaiement item = new ModePaiement();
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
    public ModePaiementDto toDto(ModePaiement item) {
        if (item == null) {
            return null;
        } else {
            ModePaiementDto dto = new ModePaiementDto();
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
