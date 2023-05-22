package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.StockProduit;
import ma.sir.easystock.dao.criteria.core.StockProduitCriteria;
import ma.sir.easystock.dao.criteria.history.StockProduitHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.StockProduitDto;
import org.springframework.http.HttpEntity;

public interface StockProduitAdminService extends  IService<StockProduit,StockProduitCriteria, StockProduitHistoryCriteria>  {

    List<StockProduit> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<StockProduit> findByProduitId(Long id);
    int deleteByProduitId(Long id);

    HttpEntity<byte[]> createPdf(StockProduitDto dto) throws Exception;


}
