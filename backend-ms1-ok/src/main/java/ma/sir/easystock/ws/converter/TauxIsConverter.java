package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.TauxIsHistory;
import ma.sir.easystock.bean.core.TauxIs;
import ma.sir.easystock.ws.dto.TauxIsDto;

@Component
public class TauxIsConverter extends AbstractConverter<TauxIs, TauxIsDto, TauxIsHistory> {


    public  TauxIsConverter(){
        super(TauxIs.class, TauxIsDto.class, TauxIsHistory.class);
    }

    @Override
    public TauxIs toItem(TauxIsDto dto) {
        if (dto == null) {
            return null;
        } else {
        TauxIs item = new TauxIs();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getResultatMin()))
                item.setResultatMin(dto.getResultatMin());
            if(StringUtil.isNotEmpty(dto.getResultatMax()))
                item.setResultatMax(dto.getResultatMax());
            if(StringUtil.isNotEmpty(dto.getDateApplicationMin()))
                item.setDateApplicationMin(DateUtil.stringEnToDate(dto.getDateApplicationMin()));
            if(StringUtil.isNotEmpty(dto.getDateApplicationMax()))
                item.setDateApplicationMax(DateUtil.stringEnToDate(dto.getDateApplicationMax()));
            if(StringUtil.isNotEmpty(dto.getPourcentage()))
                item.setPourcentage(dto.getPourcentage());


        return item;
        }
    }

    @Override
    public TauxIsDto toDto(TauxIs item) {
        if (item == null) {
            return null;
        } else {
            TauxIsDto dto = new TauxIsDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getResultatMin()))
                dto.setResultatMin(item.getResultatMin());
            if(StringUtil.isNotEmpty(item.getResultatMax()))
                dto.setResultatMax(item.getResultatMax());
            if(item.getDateApplicationMin()!=null)
                dto.setDateApplicationMin(DateUtil.dateTimeToString(item.getDateApplicationMin()));
            if(item.getDateApplicationMax()!=null)
                dto.setDateApplicationMax(DateUtil.dateTimeToString(item.getDateApplicationMax()));
            if(StringUtil.isNotEmpty(item.getPourcentage()))
                dto.setPourcentage(item.getPourcentage());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
