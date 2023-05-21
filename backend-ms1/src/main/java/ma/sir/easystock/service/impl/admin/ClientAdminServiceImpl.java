package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Client;
import ma.sir.easystock.bean.history.ClientHistory;
import ma.sir.easystock.dao.criteria.core.ClientCriteria;
import ma.sir.easystock.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ClientDao;
import ma.sir.easystock.dao.facade.history.ClientHistoryDao;
import ma.sir.easystock.dao.specification.core.ClientSpecification;
import ma.sir.easystock.service.facade.admin.ClientAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ClientDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {
    public static final String TEMPLATE = "template/client.vm";
    public static final String FILE_NAME = "client.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Client findByReferenceEntity(Client t){
        return  dao.findByCin(t.getCin());
    }




    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}