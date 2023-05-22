package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.DevisFournisseurCriteria;
import ma.sir.easystock.bean.core.DevisFournisseur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DevisFournisseurSpecification extends  AbstractSpecification<DevisFournisseurCriteria, DevisFournisseur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateDevis", criteria.getDateDevis(), criteria.getDateDevisFrom(), criteria.getDateDevisTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","ice", criteria.getFournisseur()==null?null:criteria.getFournisseur().getIce());
    }

    public DevisFournisseurSpecification(DevisFournisseurCriteria criteria) {
        super(criteria);
    }

    public DevisFournisseurSpecification(DevisFournisseurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
