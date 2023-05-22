package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ProprietaireChequeBanqueHistory;
import ma.sir.easystock.bean.core.ProprietaireChequeBanque;
import ma.sir.easystock.ws.dto.ProprietaireChequeBanqueDto;

@Component
public class ProprietaireChequeBanqueConverter extends AbstractConverter<ProprietaireChequeBanque, ProprietaireChequeBanqueDto, ProprietaireChequeBanqueHistory> {

    @Autowired
    private ProprietaireChequeConverter proprietaireChequeConverter ;
    @Autowired
    private BanqueConverter banqueConverter ;
    private boolean proprietaireCheque;
    private boolean banque;

    public  ProprietaireChequeBanqueConverter(){
        super(ProprietaireChequeBanque.class, ProprietaireChequeBanqueDto.class, ProprietaireChequeBanqueHistory.class);
    }

    @Override
    public ProprietaireChequeBanque toItem(ProprietaireChequeBanqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProprietaireChequeBanque item = new ProprietaireChequeBanque();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(this.proprietaireCheque && dto.getProprietaireCheque()!=null)
                item.setProprietaireCheque(proprietaireChequeConverter.toItem(dto.getProprietaireCheque())) ;

            if(this.banque && dto.getBanque()!=null)
                item.setBanque(banqueConverter.toItem(dto.getBanque())) ;



        return item;
        }
    }

    @Override
    public ProprietaireChequeBanqueDto toDto(ProprietaireChequeBanque item) {
        if (item == null) {
            return null;
        } else {
            ProprietaireChequeBanqueDto dto = new ProprietaireChequeBanqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.proprietaireCheque && item.getProprietaireCheque()!=null) {
            dto.setProprietaireCheque(proprietaireChequeConverter.toDto(item.getProprietaireCheque())) ;
        }
        if(this.banque && item.getBanque()!=null) {
            dto.setBanque(banqueConverter.toDto(item.getBanque())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.proprietaireCheque = value;
        this.banque = value;
    }


    public ProprietaireChequeConverter getProprietaireChequeConverter(){
        return this.proprietaireChequeConverter;
    }
    public void setProprietaireChequeConverter(ProprietaireChequeConverter proprietaireChequeConverter ){
        this.proprietaireChequeConverter = proprietaireChequeConverter;
    }
    public BanqueConverter getBanqueConverter(){
        return this.banqueConverter;
    }
    public void setBanqueConverter(BanqueConverter banqueConverter ){
        this.banqueConverter = banqueConverter;
    }
    public boolean  isProprietaireCheque(){
        return this.proprietaireCheque;
    }
    public void  setProprietaireCheque(boolean proprietaireCheque){
        this.proprietaireCheque = proprietaireCheque;
    }
    public boolean  isBanque(){
        return this.banque;
    }
    public void  setBanque(boolean banque){
        this.banque = banque;
    }
}
