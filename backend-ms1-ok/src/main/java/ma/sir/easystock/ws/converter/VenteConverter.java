package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.VenteHistory;
import ma.sir.easystock.bean.core.Vente;
import ma.sir.easystock.ws.dto.VenteDto;

@Component
public class VenteConverter extends AbstractConverter<Vente, VenteDto, VenteHistory> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private VenteItemConverter venteItemConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private EtatVenteConverter etatVenteConverter ;
    private boolean store;
    private boolean client;
    private boolean etatVente;
    private boolean venteItems;

    public  VenteConverter(){
        super(Vente.class, VenteDto.class, VenteHistory.class);
        init(true);
    }

    @Override
    public Vente toItem(VenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        Vente item = new Vente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateVente()))
                item.setDateVente(DateUtil.stringEnToDate(dto.getDateVente()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaye()))
                item.setTotalPaye(dto.getTotalPaye());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;

            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.etatVente && dto.getEtatVente()!=null)
                item.setEtatVente(etatVenteConverter.toItem(dto.getEtatVente())) ;


            if(this.venteItems && ListUtil.isNotEmpty(dto.getVenteItems()))
                item.setVenteItems(venteItemConverter.toItem(dto.getVenteItems()));

        return item;
        }
    }

    @Override
    public VenteDto toDto(Vente item) {
        if (item == null) {
            return null;
        } else {
            VenteDto dto = new VenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateVente()!=null)
                dto.setDateVente(DateUtil.dateTimeToString(item.getDateVente()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaye()))
                dto.setTotalPaye(item.getTotalPaye());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.etatVente && item.getEtatVente()!=null) {
            dto.setEtatVente(etatVenteConverter.toDto(item.getEtatVente())) ;
        }
        if(this.venteItems && ListUtil.isNotEmpty(item.getVenteItems())){
            venteItemConverter.init(true);
            venteItemConverter.setVente(false);
            dto.setVenteItems(venteItemConverter.toDto(item.getVenteItems()));
            venteItemConverter.setVente(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.venteItems = value;
    }

    public void initObject(boolean value) {
        this.store = value;
        this.client = value;
        this.etatVente = value;
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
    public VenteItemConverter getVenteItemConverter(){
        return this.venteItemConverter;
    }
    public void setVenteItemConverter(VenteItemConverter venteItemConverter ){
        this.venteItemConverter = venteItemConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public EtatVenteConverter getEtatVenteConverter(){
        return this.etatVenteConverter;
    }
    public void setEtatVenteConverter(EtatVenteConverter etatVenteConverter ){
        this.etatVenteConverter = etatVenteConverter;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isEtatVente(){
        return this.etatVente;
    }
    public void  setEtatVente(boolean etatVente){
        this.etatVente = etatVente;
    }
    public boolean  isVenteItems(){
        return this.venteItems ;
    }
    public void  setVenteItems(boolean venteItems ){
        this.venteItems  = venteItems ;
    }
}
