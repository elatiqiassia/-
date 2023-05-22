package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeCriteria;
import ma.sir.easystock.bean.core.ProprietaireCheque;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProprietaireChequeSpecification extends  AbstractSpecification<ProprietaireChequeCriteria, ProprietaireCheque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ProprietaireChequeSpecification(ProprietaireChequeCriteria criteria) {
        super(criteria);
    }

    public ProprietaireChequeSpecification(ProprietaireChequeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
