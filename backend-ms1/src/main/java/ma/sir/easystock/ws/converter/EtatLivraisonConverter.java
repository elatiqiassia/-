package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatLivraisonHistory;
import ma.sir.easystock.bean.core.EtatLivraison;
import ma.sir.easystock.ws.dto.EtatLivraisonDto;

@Component
public class EtatLivraisonConverter extends AbstractConverter<EtatLivraison, EtatLivraisonDto, EtatLivraisonHistory> {


    public  EtatLivraisonConverter(){
        super(EtatLivraison.class, EtatLivraisonDto.class, EtatLivraisonHistory.class);
    }

    @Override
    public EtatLivraison toItem(EtatLivraisonDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatLivraison item = new EtatLivraison();
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
    public EtatLivraisonDto toDto(EtatLivraison item) {
        if (item == null) {
            return null;
        } else {
            EtatLivraisonDto dto = new EtatLivraisonDto();
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
