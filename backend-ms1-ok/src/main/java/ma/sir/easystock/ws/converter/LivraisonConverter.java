package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Demande;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.LivraisonHistory;
import ma.sir.easystock.bean.core.Livraison;
import ma.sir.easystock.ws.dto.LivraisonDto;

@Component
public class LivraisonConverter extends AbstractConverter<Livraison, LivraisonDto, LivraisonHistory> {

    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private DemandeConverter demandeConverter ;
    @Autowired
    private LivraisonItemConverter livraisonItemConverter ;
    @Autowired
    private EtatLivraisonConverter etatLivraisonConverter ;
    private boolean demande;
    private boolean etatLivraison;
    private boolean client;
    private boolean livraisonItems;

    public  LivraisonConverter(){
        super(Livraison.class, LivraisonDto.class, LivraisonHistory.class);
        init(true);
    }

    @Override
    public Livraison toItem(LivraisonDto dto) {
        if (dto == null) {
            return null;
        } else {
        Livraison item = new Livraison();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateLivraison()))
                item.setDateLivraison(DateUtil.stringEnToDate(dto.getDateLivraison()));
            if(dto.getDemande() != null && dto.getDemande().getId() != null){
                item.setDemande(new Demande());
                item.getDemande().setId(dto.getDemande().getId());
            }

            if(this.etatLivraison && dto.getEtatLivraison()!=null)
                item.setEtatLivraison(etatLivraisonConverter.toItem(dto.getEtatLivraison())) ;

            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;


            if(this.livraisonItems && ListUtil.isNotEmpty(dto.getLivraisonItems()))
                item.setLivraisonItems(livraisonItemConverter.toItem(dto.getLivraisonItems()));

        return item;
        }
    }

    @Override
    public LivraisonDto toDto(Livraison item) {
        if (item == null) {
            return null;
        } else {
            LivraisonDto dto = new LivraisonDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateLivraison()!=null)
                dto.setDateLivraison(DateUtil.dateTimeToString(item.getDateLivraison()));
        if(this.demande && item.getDemande()!=null) {
            dto.setDemande(demandeConverter.toDto(item.getDemande())) ;
        }
        if(this.etatLivraison && item.getEtatLivraison()!=null) {
            dto.setEtatLivraison(etatLivraisonConverter.toDto(item.getEtatLivraison())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.livraisonItems && ListUtil.isNotEmpty(item.getLivraisonItems())){
            livraisonItemConverter.init(true);
            livraisonItemConverter.setLivraison(false);
            dto.setLivraisonItems(livraisonItemConverter.toDto(item.getLivraisonItems()));
            livraisonItemConverter.setLivraison(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.livraisonItems = value;
    }

    public void initObject(boolean value) {
        this.demande = value;
        this.etatLivraison = value;
        this.client = value;
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
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public DemandeConverter getDemandeConverter(){
        return this.demandeConverter;
    }
    public void setDemandeConverter(DemandeConverter demandeConverter ){
        this.demandeConverter = demandeConverter;
    }
    public LivraisonItemConverter getLivraisonItemConverter(){
        return this.livraisonItemConverter;
    }
    public void setLivraisonItemConverter(LivraisonItemConverter livraisonItemConverter ){
        this.livraisonItemConverter = livraisonItemConverter;
    }
    public EtatLivraisonConverter getEtatLivraisonConverter(){
        return this.etatLivraisonConverter;
    }
    public void setEtatLivraisonConverter(EtatLivraisonConverter etatLivraisonConverter ){
        this.etatLivraisonConverter = etatLivraisonConverter;
    }
    public boolean  isDemande(){
        return this.demande;
    }
    public void  setDemande(boolean demande){
        this.demande = demande;
    }
    public boolean  isEtatLivraison(){
        return this.etatLivraison;
    }
    public void  setEtatLivraison(boolean etatLivraison){
        this.etatLivraison = etatLivraison;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isLivraisonItems(){
        return this.livraisonItems ;
    }
    public void  setLivraisonItems(boolean livraisonItems ){
        this.livraisonItems  = livraisonItems ;
    }
}
