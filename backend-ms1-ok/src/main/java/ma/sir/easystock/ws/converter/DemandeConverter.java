package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.DemandeHistory;
import ma.sir.easystock.bean.core.Demande;
import ma.sir.easystock.ws.dto.DemandeDto;

@Component
public class DemandeConverter extends AbstractConverter<Demande, DemandeDto, DemandeHistory> {

    @Autowired
    private DemandeItemConverter demandeItemConverter ;
    @Autowired
    private EtatDemandeConverter etatDemandeConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean client;
    private boolean etatDemande;
    private boolean demandeItems;

    public  DemandeConverter(){
        super(Demande.class, DemandeDto.class, DemandeHistory.class);
        init(true);
    }

    @Override
    public Demande toItem(DemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Demande item = new Demande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateCommande()))
                item.setDateCommande(DateUtil.stringEnToDate(dto.getDateCommande()));
            if(StringUtil.isNotEmpty(dto.getTotalCheque()))
                item.setTotalCheque(dto.getTotalCheque());
            if(StringUtil.isNotEmpty(dto.getTotalEspece()))
                item.setTotalEspece(dto.getTotalEspece());
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalePaye()))
                item.setTotalePaye(dto.getTotalePaye());
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.etatDemande && dto.getEtatDemande()!=null)
                item.setEtatDemande(etatDemandeConverter.toItem(dto.getEtatDemande())) ;


            if(this.demandeItems && ListUtil.isNotEmpty(dto.getDemandeItems()))
                item.setDemandeItems(demandeItemConverter.toItem(dto.getDemandeItems()));

        return item;
        }
    }

    @Override
    public DemandeDto toDto(Demande item) {
        if (item == null) {
            return null;
        } else {
            DemandeDto dto = new DemandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateCommande()!=null)
                dto.setDateCommande(DateUtil.dateTimeToString(item.getDateCommande()));
            if(StringUtil.isNotEmpty(item.getTotalCheque()))
                dto.setTotalCheque(item.getTotalCheque());
            if(StringUtil.isNotEmpty(item.getTotalEspece()))
                dto.setTotalEspece(item.getTotalEspece());
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalePaye()))
                dto.setTotalePaye(item.getTotalePaye());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.etatDemande && item.getEtatDemande()!=null) {
            dto.setEtatDemande(etatDemandeConverter.toDto(item.getEtatDemande())) ;
        }
        if(this.demandeItems && ListUtil.isNotEmpty(item.getDemandeItems())){
            demandeItemConverter.init(true);
            demandeItemConverter.setDemande(false);
            dto.setDemandeItems(demandeItemConverter.toDto(item.getDemandeItems()));
            demandeItemConverter.setDemande(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.demandeItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.etatDemande = value;
    }


    public DemandeItemConverter getDemandeItemConverter(){
        return this.demandeItemConverter;
    }
    public void setDemandeItemConverter(DemandeItemConverter demandeItemConverter ){
        this.demandeItemConverter = demandeItemConverter;
    }
    public EtatDemandeConverter getEtatDemandeConverter(){
        return this.etatDemandeConverter;
    }
    public void setEtatDemandeConverter(EtatDemandeConverter etatDemandeConverter ){
        this.etatDemandeConverter = etatDemandeConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isEtatDemande(){
        return this.etatDemande;
    }
    public void  setEtatDemande(boolean etatDemande){
        this.etatDemande = etatDemande;
    }
    public boolean  isDemandeItems(){
        return this.demandeItems ;
    }
    public void  setDemandeItems(boolean demandeItems ){
        this.demandeItems  = demandeItems ;
    }
}
