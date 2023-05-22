package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Commande;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.PaiementCommandeHistory;
import ma.sir.easystock.bean.core.PaiementCommande;
import ma.sir.easystock.ws.dto.PaiementCommandeDto;

@Component
public class PaiementCommandeConverter extends AbstractConverter<PaiementCommande, PaiementCommandeDto, PaiementCommandeHistory> {

    @Autowired
    private EtatPaiementCommandeConverter etatPaiementCommandeConverter ;
    @Autowired
    private CommandeConverter commandeConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    private boolean commande;
    private boolean modePaiement;
    private boolean etatPaiementCommande;

    public  PaiementCommandeConverter(){
        super(PaiementCommande.class, PaiementCommandeDto.class, PaiementCommandeHistory.class);
    }

    @Override
    public PaiementCommande toItem(PaiementCommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementCommande item = new PaiementCommande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getChequeVire() != null)
                item.setChequeVire(dto.getChequeVire());
            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(this.etatPaiementCommande && dto.getEtatPaiementCommande()!=null)
                item.setEtatPaiementCommande(etatPaiementCommandeConverter.toItem(dto.getEtatPaiementCommande())) ;



        return item;
        }
    }

    @Override
    public PaiementCommandeDto toDto(PaiementCommande item) {
        if (item == null) {
            return null;
        } else {
            PaiementCommandeDto dto = new PaiementCommandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
                dto.setChequeVire(item.getChequeVire());
        if(this.commande && item.getCommande()!=null) {
            dto.setCommande(commandeConverter.toDto(item.getCommande())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.etatPaiementCommande && item.getEtatPaiementCommande()!=null) {
            dto.setEtatPaiementCommande(etatPaiementCommandeConverter.toDto(item.getEtatPaiementCommande())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.commande = value;
        this.modePaiement = value;
        this.etatPaiementCommande = value;
    }


    public EtatPaiementCommandeConverter getEtatPaiementCommandeConverter(){
        return this.etatPaiementCommandeConverter;
    }
    public void setEtatPaiementCommandeConverter(EtatPaiementCommandeConverter etatPaiementCommandeConverter ){
        this.etatPaiementCommandeConverter = etatPaiementCommandeConverter;
    }
    public CommandeConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeConverter(CommandeConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
    }
    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
    public boolean  isModePaiement(){
        return this.modePaiement;
    }
    public void  setModePaiement(boolean modePaiement){
        this.modePaiement = modePaiement;
    }
    public boolean  isEtatPaiementCommande(){
        return this.etatPaiementCommande;
    }
    public void  setEtatPaiementCommande(boolean etatPaiementCommande){
        this.etatPaiementCommande = etatPaiementCommande;
    }
}
