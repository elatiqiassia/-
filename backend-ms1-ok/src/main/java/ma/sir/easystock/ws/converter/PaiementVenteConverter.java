package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Vente;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.PaiementVenteHistory;
import ma.sir.easystock.bean.core.PaiementVente;
import ma.sir.easystock.ws.dto.PaiementVenteDto;

@Component
public class PaiementVenteConverter extends AbstractConverter<PaiementVente, PaiementVenteDto, PaiementVenteHistory> {

    @Autowired
    private EtatPaiementVenteConverter etatPaiementVenteConverter ;
    @Autowired
    private VenteConverter venteConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    private boolean vente;
    private boolean modePaiement;
    private boolean etatPaiementVente;

    public  PaiementVenteConverter(){
        super(PaiementVente.class, PaiementVenteDto.class, PaiementVenteHistory.class);
    }

    @Override
    public PaiementVente toItem(PaiementVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementVente item = new PaiementVente();
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
            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(this.etatPaiementVente && dto.getEtatPaiementVente()!=null)
                item.setEtatPaiementVente(etatPaiementVenteConverter.toItem(dto.getEtatPaiementVente())) ;



        return item;
        }
    }

    @Override
    public PaiementVenteDto toDto(PaiementVente item) {
        if (item == null) {
            return null;
        } else {
            PaiementVenteDto dto = new PaiementVenteDto();
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
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.etatPaiementVente && item.getEtatPaiementVente()!=null) {
            dto.setEtatPaiementVente(etatPaiementVenteConverter.toDto(item.getEtatPaiementVente())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.vente = value;
        this.modePaiement = value;
        this.etatPaiementVente = value;
    }


    public EtatPaiementVenteConverter getEtatPaiementVenteConverter(){
        return this.etatPaiementVenteConverter;
    }
    public void setEtatPaiementVenteConverter(EtatPaiementVenteConverter etatPaiementVenteConverter ){
        this.etatPaiementVenteConverter = etatPaiementVenteConverter;
    }
    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
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
    public boolean  isEtatPaiementVente(){
        return this.etatPaiementVente;
    }
    public void  setEtatPaiementVente(boolean etatPaiementVente){
        this.etatPaiementVente = etatPaiementVente;
    }
}
