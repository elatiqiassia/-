package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.AbonneHistory;
import ma.sir.easystock.bean.core.Abonne;
import ma.sir.easystock.ws.dto.AbonneDto;

@Component
public class AbonneConverter extends AbstractConverter<Abonne, AbonneDto, AbonneHistory> {

    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    private boolean societes;

    public  AbonneConverter(){
        super(Abonne.class, AbonneDto.class, AbonneHistory.class);
        init(true);
    }

    @Override
    public Abonne toItem(AbonneDto dto) {
        if (dto == null) {
            return null;
        } else {
        Abonne item = new Abonne();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());
            if(dto.getBloqued() != null)
                item.setBloqued(dto.getBloqued());
            if(StringUtil.isNotEmpty(dto.getDateCreation()))
                item.setDateCreation(DateUtil.stringEnToDate(dto.getDateCreation()));
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getTel()))
                item.setTel(dto.getTel());
            if(StringUtil.isNotEmpty(dto.getLogo()))
                item.setLogo(dto.getLogo());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getNomSociete()))
                item.setNomSociete(dto.getNomSociete());
            if(StringUtil.isNotEmpty(dto.getPathBackUp()))
                item.setPathBackUp(dto.getPathBackUp());
            if(StringUtil.isNotEmpty(dto.getPatente()))
                item.setPatente(dto.getPatente());
            if(StringUtil.isNotEmpty(dto.getRc()))
                item.setRc(dto.getRc());
            if(StringUtil.isNotEmpty(dto.getCnss()))
                item.setCnss(dto.getCnss());
            if(StringUtil.isNotEmpty(dto.getIfisc()))
                item.setIfisc(dto.getIfisc());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());

            if(this.societes && ListUtil.isNotEmpty(dto.getSocietes()))
                item.setSocietes(societeConverter.toItem(dto.getSocietes()));

        return item;
        }
    }

    @Override
    public AbonneDto toDto(Abonne item) {
        if (item == null) {
            return null;
        } else {
            AbonneDto dto = new AbonneDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());
                dto.setBloqued(item.getBloqued());
            if(item.getDateCreation()!=null)
                dto.setDateCreation(DateUtil.dateTimeToString(item.getDateCreation()));
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getTel()))
                dto.setTel(item.getTel());
            if(StringUtil.isNotEmpty(item.getLogo()))
                dto.setLogo(item.getLogo());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(StringUtil.isNotEmpty(item.getNomSociete()))
                dto.setNomSociete(item.getNomSociete());
            if(StringUtil.isNotEmpty(item.getPathBackUp()))
                dto.setPathBackUp(item.getPathBackUp());
            if(StringUtil.isNotEmpty(item.getPatente()))
                dto.setPatente(item.getPatente());
            if(StringUtil.isNotEmpty(item.getRc()))
                dto.setRc(item.getRc());
            if(StringUtil.isNotEmpty(item.getCnss()))
                dto.setCnss(item.getCnss());
            if(StringUtil.isNotEmpty(item.getIfisc()))
                dto.setIfisc(item.getIfisc());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
        if(this.societes && ListUtil.isNotEmpty(item.getSocietes())){
            societeConverter.init(true);
            societeConverter.setAbonne(false);
            dto.setSocietes(societeConverter.toDto(item.getSocietes()));
            societeConverter.setAbonne(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.societes = value;
    }

    public void initObject(boolean value) {
    }


    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public boolean  isSocietes(){
        return this.societes ;
    }
    public void  setSocietes(boolean societes ){
        this.societes  = societes ;
    }
}
