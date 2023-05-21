package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.FournisseurHistory;
import ma.sir.easystock.bean.core.Fournisseur;
import ma.sir.easystock.ws.dto.FournisseurDto;

@Component
public class FournisseurConverter extends AbstractConverter<Fournisseur, FournisseurDto, FournisseurHistory> {


    public  FournisseurConverter(){
        super(Fournisseur.class, FournisseurDto.class, FournisseurHistory.class);
    }

    @Override
    public Fournisseur toItem(FournisseurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Fournisseur item = new Fournisseur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getTel()))
                item.setTel(dto.getTel());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getCreance()))
                item.setCreance(dto.getCreance());


        return item;
        }
    }

    @Override
    public FournisseurDto toDto(Fournisseur item) {
        if (item == null) {
            return null;
        } else {
            FournisseurDto dto = new FournisseurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getTel()))
                dto.setTel(item.getTel());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getCreance()))
                dto.setCreance(item.getCreance());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
