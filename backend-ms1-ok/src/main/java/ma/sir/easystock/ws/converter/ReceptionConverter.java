package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Commande;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ReceptionHistory;
import ma.sir.easystock.bean.core.Reception;
import ma.sir.easystock.ws.dto.ReceptionDto;

@Component
public class ReceptionConverter extends AbstractConverter<Reception, ReceptionDto, ReceptionHistory> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private ReceptionItemConverter receptionItemConverter ;
    @Autowired
    private CommandeConverter commandeConverter ;
    @Autowired
    private EtatReceptionConverter etatReceptionConverter ;
    private boolean commande;
    private boolean etatReception;
    private boolean receptionItems;

    public  ReceptionConverter(){
        super(Reception.class, ReceptionDto.class, ReceptionHistory.class);
        init(true);
    }

    @Override
    public Reception toItem(ReceptionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Reception item = new Reception();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateReception()))
                item.setDateReception(DateUtil.stringEnToDate(dto.getDateReception()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
            }

            if(this.etatReception && dto.getEtatReception()!=null)
                item.setEtatReception(etatReceptionConverter.toItem(dto.getEtatReception())) ;


            if(this.receptionItems && ListUtil.isNotEmpty(dto.getReceptionItems()))
                item.setReceptionItems(receptionItemConverter.toItem(dto.getReceptionItems()));

        return item;
        }
    }

    @Override
    public ReceptionDto toDto(Reception item) {
        if (item == null) {
            return null;
        } else {
            ReceptionDto dto = new ReceptionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateReception()!=null)
                dto.setDateReception(DateUtil.dateTimeToString(item.getDateReception()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.commande && item.getCommande()!=null) {
            dto.setCommande(commandeConverter.toDto(item.getCommande())) ;
        }
        if(this.etatReception && item.getEtatReception()!=null) {
            dto.setEtatReception(etatReceptionConverter.toDto(item.getEtatReception())) ;
        }
        if(this.receptionItems && ListUtil.isNotEmpty(item.getReceptionItems())){
            receptionItemConverter.init(true);
            receptionItemConverter.setReception(false);
            dto.setReceptionItems(receptionItemConverter.toDto(item.getReceptionItems()));
            receptionItemConverter.setReception(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.receptionItems = value;
    }

    public void initObject(boolean value) {
        this.commande = value;
        this.etatReception = value;
    }


    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public ReceptionItemConverter getReceptionItemConverter(){
        return this.receptionItemConverter;
    }
    public void setReceptionItemConverter(ReceptionItemConverter receptionItemConverter ){
        this.receptionItemConverter = receptionItemConverter;
    }
    public CommandeConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeConverter(CommandeConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
    }
    public EtatReceptionConverter getEtatReceptionConverter(){
        return this.etatReceptionConverter;
    }
    public void setEtatReceptionConverter(EtatReceptionConverter etatReceptionConverter ){
        this.etatReceptionConverter = etatReceptionConverter;
    }
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
    public boolean  isEtatReception(){
        return this.etatReception;
    }
    public void  setEtatReception(boolean etatReception){
        this.etatReception = etatReception;
    }
    public boolean  isReceptionItems(){
        return this.receptionItems ;
    }
    public void  setReceptionItems(boolean receptionItems ){
        this.receptionItems  = receptionItems ;
    }
}
