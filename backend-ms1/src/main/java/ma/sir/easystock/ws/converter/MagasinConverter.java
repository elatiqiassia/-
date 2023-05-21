package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.MagasinHistory;
import ma.sir.easystock.bean.core.Magasin;
import ma.sir.easystock.ws.dto.MagasinDto;

@Component
public class MagasinConverter extends AbstractConverter<Magasin, MagasinDto, MagasinHistory> {

    @Autowired
    private StoreConverter storeConverter ;
    private boolean store;

    public  MagasinConverter(){
        super(Magasin.class, MagasinDto.class, MagasinHistory.class);
    }

    @Override
    public Magasin toItem(MagasinDto dto) {
        if (dto == null) {
            return null;
        } else {
        Magasin item = new Magasin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());
            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;



        return item;
        }
    }

    @Override
    public MagasinDto toDto(Magasin item) {
        if (item == null) {
            return null;
        } else {
            MagasinDto dto = new MagasinDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.store = value;
    }


    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
}
