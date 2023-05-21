package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatPaiementLivraisonHistory;
import ma.sir.easystock.bean.core.EtatPaiementLivraison;
import ma.sir.easystock.ws.dto.EtatPaiementLivraisonDto;

@Component
public class EtatPaiementLivraisonConverter extends AbstractConverter<EtatPaiementLivraison, EtatPaiementLivraisonDto, EtatPaiementLivraisonHistory> {


    public  EtatPaiementLivraisonConverter(){
        super(EtatPaiementLivraison.class, EtatPaiementLivraisonDto.class, EtatPaiementLivraisonHistory.class);
    }

    @Override
    public EtatPaiementLivraison toItem(EtatPaiementLivraisonDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatPaiementLivraison item = new EtatPaiementLivraison();
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
    public EtatPaiementLivraisonDto toDto(EtatPaiementLivraison item) {
        if (item == null) {
            return null;
        } else {
            EtatPaiementLivraisonDto dto = new EtatPaiementLivraisonDto();
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
