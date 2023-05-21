package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.DeclarationIs;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.DeclarationIs;
import java.util.List;


@Repository
public interface DeclarationIsDao extends AbstractRepository<DeclarationIs,Long>  {
    DeclarationIs findByReference(String reference);
    int deleteByReference(String reference);

    List<DeclarationIs> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationIs> findByTauxIsId(Long id);
    int deleteByTauxIsId(Long id);
    List<DeclarationIs> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    List<DeclarationIs> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);

    @Query("SELECT NEW DeclarationIs(item.id,item.reference) FROM DeclarationIs item")
    List<DeclarationIs> findAllOptimized();
}
