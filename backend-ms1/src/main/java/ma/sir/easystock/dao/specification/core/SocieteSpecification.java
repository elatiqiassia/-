package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.SocieteCriteria;
import ma.sir.easystock.bean.core.Societe;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SocieteSpecification extends  AbstractSpecification<SocieteCriteria, Societe>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicate("siege", criteria.getSiege(),criteria.getSiegeLike());
        addPredicateInt("dernierAnneePayerIs", criteria.getDernierAnneePayerIs(), criteria.getDernierAnneePayerIsMin(), criteria.getDernierAnneePayerIsMax());
        addPredicateInt("dernierTrimestrePayerIs", criteria.getDernierTrimestrePayerIs(), criteria.getDernierTrimestrePayerIsMin(), criteria.getDernierTrimestrePayerIsMax());
        addPredicateInt("dernierAnneePayerTva", criteria.getDernierAnneePayerTva(), criteria.getDernierAnneePayerTvaMin(), criteria.getDernierAnneePayerTvaMax());
        addPredicateInt("dernierTrimestrePayerTva", criteria.getDernierTrimestrePayerTva(), criteria.getDernierTrimestrePayerTvaMin(), criteria.getDernierTrimestrePayerTvaMax());
        addPredicateBool("bloqued", criteria.getBloqued());
        addPredicateFk("abonne","id", criteria.getAbonne()==null?null:criteria.getAbonne().getId());
        addPredicateFk("abonne","id", criteria.getAbonnes());
        addPredicateFk("abonne","code", criteria.getAbonne()==null?null:criteria.getAbonne().getCode());
    }

    public SocieteSpecification(SocieteCriteria criteria) {
        super(criteria);
    }

    public SocieteSpecification(SocieteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
