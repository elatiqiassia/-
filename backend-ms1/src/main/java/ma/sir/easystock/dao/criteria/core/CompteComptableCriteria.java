package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CompteComptableCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;

    private SousClassComptableCriteria sousClassComptable ;
    private List<SousClassComptableCriteria> sousClassComptables ;


    public CompteComptableCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


    public SousClassComptableCriteria getSousClassComptable(){
        return this.sousClassComptable;
    }

    public void setSousClassComptable(SousClassComptableCriteria sousClassComptable){
        this.sousClassComptable = sousClassComptable;
    }
    public List<SousClassComptableCriteria> getSousClassComptables(){
        return this.sousClassComptables;
    }

    public void setSousClassComptables(List<SousClassComptableCriteria> sousClassComptables){
        this.sousClassComptables = sousClassComptables;
    }
}
