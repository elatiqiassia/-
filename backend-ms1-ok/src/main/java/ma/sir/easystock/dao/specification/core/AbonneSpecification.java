package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.AbonneCriteria;
import ma.sir.easystock.bean.core.Abonne;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AbonneSpecification extends  AbstractSpecification<AbonneCriteria, Abonne>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
        addPredicateBool("bloqued", criteria.getBloqued());
        addPredicate("dateCreation", criteria.getDateCreation(), criteria.getDateCreationFrom(), criteria.getDateCreationTo());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("tel", criteria.getTel(),criteria.getTelLike());
        addPredicate("logo", criteria.getLogo(),criteria.getLogoLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("nomSociete", criteria.getNomSociete(),criteria.getNomSocieteLike());
        addPredicate("pathBackUp", criteria.getPathBackUp(),criteria.getPathBackUpLike());
        addPredicate("patente", criteria.getPatente(),criteria.getPatenteLike());
        addPredicate("rc", criteria.getRc(),criteria.getRcLike());
        addPredicate("cnss", criteria.getCnss(),criteria.getCnssLike());
        addPredicate("ifisc", criteria.getIfisc(),criteria.getIfiscLike());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
    }

    public AbonneSpecification(AbonneCriteria criteria) {
        super(criteria);
    }

    public AbonneSpecification(AbonneCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
