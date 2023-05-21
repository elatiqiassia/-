package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProprietaireChequeBanqueCriteria extends  BaseCriteria  {


    private ProprietaireChequeCriteria proprietaireCheque ;
    private List<ProprietaireChequeCriteria> proprietaireCheques ;
    private BanqueCriteria banque ;
    private List<BanqueCriteria> banques ;


    public ProprietaireChequeBanqueCriteria(){}


    public ProprietaireChequeCriteria getProprietaireCheque(){
        return this.proprietaireCheque;
    }

    public void setProprietaireCheque(ProprietaireChequeCriteria proprietaireCheque){
        this.proprietaireCheque = proprietaireCheque;
    }
    public List<ProprietaireChequeCriteria> getProprietaireCheques(){
        return this.proprietaireCheques;
    }

    public void setProprietaireCheques(List<ProprietaireChequeCriteria> proprietaireCheques){
        this.proprietaireCheques = proprietaireCheques;
    }
    public BanqueCriteria getBanque(){
        return this.banque;
    }

    public void setBanque(BanqueCriteria banque){
        this.banque = banque;
    }
    public List<BanqueCriteria> getBanques(){
        return this.banques;
    }

    public void setBanques(List<BanqueCriteria> banques){
        this.banques = banques;
    }
}
