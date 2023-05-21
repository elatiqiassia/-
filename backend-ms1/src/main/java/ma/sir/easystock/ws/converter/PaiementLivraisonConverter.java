package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Livraison;
import ma.sir.easystock.bean.core.Vente;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.PaiementLivraisonHistory;
import ma.sir.easystock.bean.core.PaiementLivraison;
import ma.sir.easystock.ws.dto.PaiementLivraisonDto;

@Component
public class PaiementLivraisonConverter extends AbstractConverter<PaiementLivraison, PaiementLivraisonDto, PaiementLivraisonHistory> {

    @Autowired
    private EtatPaiementLivraisonConverter etatPaiementLivraisonConverter ;
    @Autowired
    private LivraisonConverter livraisonConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    @Autowired
    private VenteConverter venteConverter ;
    private boolean livraison;
    private boolean vente;
    private boolean modePaiement;
    private boolean etatPaiementLivraison;

    public  PaiementLivraisonConverter(){
        super(PaiementLivraison.class, PaiementLivraisonDto.class, PaiementLivraisonHistory.class);
    }

    @Override
    public PaiementLivraison toItem(PaiementLivraisonDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementLivraison item = new PaiementLivraison();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateLivraison()))
                item.setDateLivraison(DateUtil.stringEnToDate(dto.getDateLivraison()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getLivraison() != null && dto.getLivraison().getId() != null){
                item.setLivraison(new Livraison());
                item.getLivraison().setId(dto.getLivraison().getId());
            }

            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(this.etatPaiementLivraison && dto.getEtatPaiementLivraison()!=null)
                item.setEtatPaiementLivraison(etatPaiementLivraisonConverter.toItem(dto.getEtatPaiementLivraison())) ;



        return item;
        }
    }

    @Override
    public PaiementLivraisonDto toDto(PaiementLivraison item) {
        if (item == null) {
            return null;
        } else {
            PaiementLivraisonDto dto = new PaiementLivraisonDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateLivraison()!=null)
                dto.setDateLivraison(DateUtil.dateTimeToString(item.getDateLivraison()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.livraison && item.getLivraison()!=null) {
            dto.setLivraison(livraisonConverter.toDto(item.getLivraison())) ;
        }
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.etatPaiementLivraison && item.getEtatPaiementLivraison()!=null) {
            dto.setEtatPaiementLivraison(etatPaiementLivraisonConverter.toDto(item.getEtatPaiementLivraison())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.livraison = value;
        this.vente = value;
        this.modePaiement = value;
        this.etatPaiementLivraison = value;
    }


    public EtatPaiementLivraisonConverter getEtatPaiementLivraisonConverter(){
        return this.etatPaiementLivraisonConverter;
    }
    public void setEtatPaiementLivraisonConverter(EtatPaiementLivraisonConverter etatPaiementLivraisonConverter ){
        this.etatPaiementLivraisonConverter = etatPaiementLivraisonConverter;
    }
    public LivraisonConverter getLivraisonConverter(){
        return this.livraisonConverter;
    }
    public void setLivraisonConverter(LivraisonConverter livraisonConverter ){
        this.livraisonConverter = livraisonConverter;
    }
    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public boolean  isLivraison(){
        return this.livraison;
    }
    public void  setLivraison(boolean livraison){
        this.livraison = livraison;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isModePaiement(){
        return this.modePaiement;
    }
    public void  setModePaiement(boolean modePaiement){
        this.modePaiement = modePaiement;
    }
    public boolean  isEtatPaiementLivraison(){
        return this.etatPaiementLivraison;
    }
    public void  setEtatPaiementLivraison(boolean etatPaiementLivraison){
        this.etatPaiementLivraison = etatPaiementLivraison;
    }
}
