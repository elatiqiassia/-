package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ProprietaireChequeHistory;
import ma.sir.easystock.bean.core.ProprietaireCheque;
import ma.sir.easystock.ws.dto.ProprietaireChequeDto;

@Component
public class ProprietaireChequeConverter extends AbstractConverter<ProprietaireCheque, ProprietaireChequeDto, ProprietaireChequeHistory> {


    public  ProprietaireChequeConverter(){
        super(ProprietaireCheque.class, ProprietaireChequeDto.class, ProprietaireChequeHistory.class);
    }

    @Override
    public ProprietaireCheque toItem(ProprietaireChequeDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProprietaireCheque item = new ProprietaireCheque();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public ProprietaireChequeDto toDto(ProprietaireCheque item) {
        if (item == null) {
            return null;
        } else {
            ProprietaireChequeDto dto = new ProprietaireChequeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
