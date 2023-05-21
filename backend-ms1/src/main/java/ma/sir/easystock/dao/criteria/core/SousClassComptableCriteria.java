package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SousClassComptableCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;

    private ClassComptableCriteria classComptable ;
    private List<ClassComptableCriteria> classComptables ;


    public SousClassComptableCriteria(){}

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


    public ClassComptableCriteria getClassComptable(){
        return this.classComptable;
    }

    public void setClassComptable(ClassComptableCriteria classComptable){
        this.classComptable = classComptable;
    }
    public List<ClassComptableCriteria> getClassComptables(){
        return this.classComptables;
    }

    public void setClassComptables(List<ClassComptableCriteria> classComptables){
        this.classComptables = classComptables;
    }
}
