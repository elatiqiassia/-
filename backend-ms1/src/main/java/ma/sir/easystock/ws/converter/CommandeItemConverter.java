package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Commande;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.CommandeItemHistory;
import ma.sir.easystock.bean.core.CommandeItem;
import ma.sir.easystock.ws.dto.CommandeItemDto;

@Component
public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemDto, CommandeItemHistory> {

    @Autowired
    private CommandeConverter commandeConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean commande;

    public  CommandeItemConverter(){
        super(CommandeItem.class, CommandeItemDto.class, CommandeItemHistory.class);
    }

    @Override
    public CommandeItem toItem(CommandeItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        CommandeItem item = new CommandeItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getQuantiteReceptionne()))
                item.setQuantiteReceptionne(dto.getQuantiteReceptionne());
            if(this.produit && dto.getProduit()!=null)
                item.setProduit(produitConverter.toItem(dto.getProduit())) ;

            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
            }



        return item;
        }
    }

    @Override
    public CommandeItemDto toDto(CommandeItem item) {
        if (item == null) {
            return null;
        } else {
            CommandeItemDto dto = new CommandeItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getQuantiteReceptionne()))
                dto.setQuantiteReceptionne(item.getQuantiteReceptionne());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.commande && item.getCommande()!=null) {
            dto.setCommande(commandeConverter.toDto(item.getCommande())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.commande = value;
    }


    public CommandeConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeConverter(CommandeConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
}
