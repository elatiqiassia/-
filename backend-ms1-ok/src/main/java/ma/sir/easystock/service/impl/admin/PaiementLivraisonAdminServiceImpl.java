package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.PaiementLivraison;
import ma.sir.easystock.bean.history.PaiementLivraisonHistory;
import ma.sir.easystock.dao.criteria.core.PaiementLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementLivraisonHistoryCriteria;
import ma.sir.easystock.dao.facade.core.PaiementLivraisonDao;
import ma.sir.easystock.dao.facade.history.PaiementLivraisonHistoryDao;
import ma.sir.easystock.dao.specification.core.PaiementLivraisonSpecification;
import ma.sir.easystock.service.facade.admin.PaiementLivraisonAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.PaiementLivraisonDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.LivraisonAdminService ;
import ma.sir.easystock.service.facade.admin.EtatPaiementLivraisonAdminService ;
import ma.sir.easystock.service.facade.admin.VenteAdminService ;
import ma.sir.easystock.service.facade.admin.ModePaiementAdminService ;


import java.util.List;
@Service
public class PaiementLivraisonAdminServiceImpl extends AbstractServiceImpl<PaiementLivraison,PaiementLivraisonHistory, PaiementLivraisonCriteria, PaiementLivraisonHistoryCriteria, PaiementLivraisonDao,
PaiementLivraisonHistoryDao> implements PaiementLivraisonAdminService {
    public static final String TEMPLATE = "template/paiementLivraison.vm";
    public static final String FILE_NAME = "paiementLivraison.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaiementLivraisonDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaiementLivraison findByReferenceEntity(PaiementLivraison t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementLivraison> findByLivraisonId(Long id){
        return dao.findByLivraisonId(id);
    }
    public int deleteByLivraisonId(Long id){
        return dao.deleteByLivraisonId(id);
    }
    public List<PaiementLivraison> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public List<PaiementLivraison> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public List<PaiementLivraison> findByEtatPaiementLivraisonId(Long id){
        return dao.findByEtatPaiementLivraisonId(id);
    }
    public int deleteByEtatPaiementLivraisonId(Long id){
        return dao.deleteByEtatPaiementLivraisonId(id);
    }



    public void configure() {
        super.configure(PaiementLivraison.class,PaiementLivraisonHistory.class, PaiementLivraisonHistoryCriteria.class, PaiementLivraisonSpecification.class);
    }

    @Autowired
    private LivraisonAdminService livraisonService ;
    @Autowired
    private EtatPaiementLivraisonAdminService etatPaiementLivraisonService ;
    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaiementLivraisonAdminServiceImpl(PaiementLivraisonDao dao, PaiementLivraisonHistoryDao historyDao) {
        super(dao, historyDao);
    }

}