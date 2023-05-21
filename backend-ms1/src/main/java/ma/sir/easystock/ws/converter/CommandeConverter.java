package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.CommandeHistory;
import ma.sir.easystock.bean.core.Commande;
import ma.sir.easystock.ws.dto.CommandeDto;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeDto, CommandeHistory> {

    @Autowired
    private CommandeItemConverter commandeItemConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private EtatCommandeConverter etatCommandeConverter ;
    private boolean client;
    private boolean etatCommande;
    private boolean commandeItems;

    public  CommandeConverter(){
        super(Commande.class, CommandeDto.class, CommandeHistory.class);
        init(true);
    }

    @Override
    public Commande toItem(CommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Commande item = new Commande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateCommande()))
                item.setDateCommande(DateUtil.stringEnToDate(dto.getDateCommande()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalePaye()))
                item.setTotalePaye(dto.getTotalePaye());
            if(StringUtil.isNotEmpty(dto.getTotalPayeCheque()))
                item.setTotalPayeCheque(dto.getTotalPayeCheque());
            if(StringUtil.isNotEmpty(dto.getTotalPayeEspece()))
                item.setTotalPayeEspece(dto.getTotalPayeEspece());
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.etatCommande && dto.getEtatCommande()!=null)
                item.setEtatCommande(etatCommandeConverter.toItem(dto.getEtatCommande())) ;


            if(this.commandeItems && ListUtil.isNotEmpty(dto.getCommandeItems()))
                item.setCommandeItems(commandeItemConverter.toItem(dto.getCommandeItems()));

        return item;
        }
    }

    @Override
    public CommandeDto toDto(Commande item) {
        if (item == null) {
            return null;
        } else {
            CommandeDto dto = new CommandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateCommande()!=null)
                dto.setDateCommande(DateUtil.dateTimeToString(item.getDateCommande()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalePaye()))
                dto.setTotalePaye(item.getTotalePaye());
            if(StringUtil.isNotEmpty(item.getTotalPayeCheque()))
                dto.setTotalPayeCheque(item.getTotalPayeCheque());
            if(StringUtil.isNotEmpty(item.getTotalPayeEspece()))
                dto.setTotalPayeEspece(item.getTotalPayeEspece());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.etatCommande && item.getEtatCommande()!=null) {
            dto.setEtatCommande(etatCommandeConverter.toDto(item.getEtatCommande())) ;
        }
        if(this.commandeItems && ListUtil.isNotEmpty(item.getCommandeItems())){
            commandeItemConverter.init(true);
            commandeItemConverter.setCommande(false);
            dto.setCommandeItems(commandeItemConverter.toDto(item.getCommandeItems()));
            commandeItemConverter.setCommande(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.commandeItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.etatCommande = value;
    }


    public CommandeItemConverter getCommandeItemConverter(){
        return this.commandeItemConverter;
    }
    public void setCommandeItemConverter(CommandeItemConverter commandeItemConverter ){
        this.commandeItemConverter = commandeItemConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public EtatCommandeConverter getEtatCommandeConverter(){
        return this.etatCommandeConverter;
    }
    public void setEtatCommandeConverter(EtatCommandeConverter etatCommandeConverter ){
        this.etatCommandeConverter = etatCommandeConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isEtatCommande(){
        return this.etatCommande;
    }
    public void  setEtatCommande(boolean etatCommande){
        this.etatCommande = etatCommande;
    }
    public boolean  isCommandeItems(){
        return this.commandeItems ;
    }
    public void  setCommandeItems(boolean commandeItems ){
        this.commandeItems  = commandeItems ;
    }
}
