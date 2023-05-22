package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatPaiementDemandeHistory;
import ma.sir.easystock.bean.core.EtatPaiementDemande;
import ma.sir.easystock.ws.dto.EtatPaiementDemandeDto;

@Component
public class EtatPaiementDemandeConverter extends AbstractConverter<EtatPaiementDemande, EtatPaiementDemandeDto, EtatPaiementDemandeHistory> {


    public  EtatPaiementDemandeConverter(){
        super(EtatPaiementDemande.class, EtatPaiementDemandeDto.class, EtatPaiementDemandeHistory.class);
    }

    @Override
    public EtatPaiementDemande toItem(EtatPaiementDemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatPaiementDemande item = new EtatPaiementDemande();
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
    public EtatPaiementDemandeDto toDto(EtatPaiementDemande item) {
        if (item == null) {
            return null;
        } else {
            EtatPaiementDemandeDto dto = new EtatPaiementDemandeDto();
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
