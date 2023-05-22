package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.OperationComptableCriteria;
import ma.sir.easystock.bean.core.OperationComptable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OperationComptableSpecification extends  AbstractSpecification<OperationComptableCriteria, OperationComptable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateOperationComptable", criteria.getDateOperationComptable(), criteria.getDateOperationComptableFrom(), criteria.getDateOperationComptableTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("societe","id", criteria.getSociete()==null?null:criteria.getSociete().getId());
        addPredicateFk("societe","id", criteria.getSocietes());
        addPredicateFk("societe","ice", criteria.getSociete()==null?null:criteria.getSociete().getIce());
        addPredicateFk("compteComptable","id", criteria.getCompteComptable()==null?null:criteria.getCompteComptable().getId());
        addPredicateFk("compteComptable","id", criteria.getCompteComptables());
    }

    public OperationComptableSpecification(OperationComptableCriteria criteria) {
        super(criteria);
    }

    public OperationComptableSpecification(OperationComptableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
