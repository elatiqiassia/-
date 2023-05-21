package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatDemandeHistory;
import ma.sir.easystock.bean.core.EtatDemande;
import ma.sir.easystock.ws.dto.EtatDemandeDto;

@Component
public class EtatDemandeConverter extends AbstractConverter<EtatDemande, EtatDemandeDto, EtatDemandeHistory> {


    public  EtatDemandeConverter(){
        super(EtatDemande.class, EtatDemandeDto.class, EtatDemandeHistory.class);
    }

    @Override
    public EtatDemande toItem(EtatDemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatDemande item = new EtatDemande();
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
    public EtatDemandeDto toDto(EtatDemande item) {
        if (item == null) {
            return null;
        } else {
            EtatDemandeDto dto = new EtatDemandeDto();
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
