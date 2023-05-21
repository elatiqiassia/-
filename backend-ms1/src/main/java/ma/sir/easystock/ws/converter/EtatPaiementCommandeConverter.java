package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatPaiementCommandeHistory;
import ma.sir.easystock.bean.core.EtatPaiementCommande;
import ma.sir.easystock.ws.dto.EtatPaiementCommandeDto;

@Component
public class EtatPaiementCommandeConverter extends AbstractConverter<EtatPaiementCommande, EtatPaiementCommandeDto, EtatPaiementCommandeHistory> {


    public  EtatPaiementCommandeConverter(){
        super(EtatPaiementCommande.class, EtatPaiementCommandeDto.class, EtatPaiementCommandeHistory.class);
    }

    @Override
    public EtatPaiementCommande toItem(EtatPaiementCommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatPaiementCommande item = new EtatPaiementCommande();
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
    public EtatPaiementCommandeDto toDto(EtatPaiementCommande item) {
        if (item == null) {
            return null;
        } else {
            EtatPaiementCommandeDto dto = new EtatPaiementCommandeDto();
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
