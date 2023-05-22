package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.DeclarationTva;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.DeclarationTva;
import java.util.List;


@Repository
public interface DeclarationTvaDao extends AbstractRepository<DeclarationTva,Long>  {
    DeclarationTva findByReference(String reference);
    int deleteByReference(String reference);

    List<DeclarationTva> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationTva> findByTauxRetardTvaId(Long id);
    int deleteByTauxRetardTvaId(Long id);
    List<DeclarationTva> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    List<DeclarationTva> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);

    @Query("SELECT NEW DeclarationTva(item.id,item.reference) FROM DeclarationTva item")
    List<DeclarationTva> findAllOptimized();
}
