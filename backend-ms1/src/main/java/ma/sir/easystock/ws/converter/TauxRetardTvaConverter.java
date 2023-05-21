package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.TauxRetardTvaHistory;
import ma.sir.easystock.bean.core.TauxRetardTva;
import ma.sir.easystock.ws.dto.TauxRetardTvaDto;

@Component
public class TauxRetardTvaConverter extends AbstractConverter<TauxRetardTva, TauxRetardTvaDto, TauxRetardTvaHistory> {


    public  TauxRetardTvaConverter(){
        super(TauxRetardTva.class, TauxRetardTvaDto.class, TauxRetardTvaHistory.class);
    }

    @Override
    public TauxRetardTva toItem(TauxRetardTvaDto dto) {
        if (dto == null) {
            return null;
        } else {
        TauxRetardTva item = new TauxRetardTva();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateApplicationMin()))
                item.setDateApplicationMin(DateUtil.stringEnToDate(dto.getDateApplicationMin()));
            if(StringUtil.isNotEmpty(dto.getDateApplicationMax()))
                item.setDateApplicationMax(DateUtil.stringEnToDate(dto.getDateApplicationMax()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());


        return item;
        }
    }

    @Override
    public TauxRetardTvaDto toDto(TauxRetardTva item) {
        if (item == null) {
            return null;
        } else {
            TauxRetardTvaDto dto = new TauxRetardTvaDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateApplicationMin()!=null)
                dto.setDateApplicationMin(DateUtil.dateTimeToString(item.getDateApplicationMin()));
            if(item.getDateApplicationMax()!=null)
                dto.setDateApplicationMax(DateUtil.dateTimeToString(item.getDateApplicationMax()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
