package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatPaiementCommande;
import ma.sir.easystock.bean.history.EtatPaiementCommandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementCommandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatPaiementCommandeAdminService;
import ma.sir.easystock.ws.converter.EtatPaiementCommandeConverter;
import ma.sir.easystock.ws.dto.EtatPaiementCommandeDto;
import ma.sir.easystock.zynerator.controller.AbstractController;
import ma.sir.easystock.zynerator.dto.AuditEntityDto;
import ma.sir.easystock.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.easystock.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.easystock.zynerator.dto.FileTempDto;

@Api("Manages etatPaiementCommande services")
@RestController
@RequestMapping("/api/admin/etatPaiementCommande/")
public class EtatPaiementCommandeRestAdmin  extends AbstractController<EtatPaiementCommande, EtatPaiementCommandeDto, EtatPaiementCommandeHistory, EtatPaiementCommandeCriteria, EtatPaiementCommandeHistoryCriteria, EtatPaiementCommandeAdminService, EtatPaiementCommandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatPaiementCommandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatPaiementCommande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatPaiementCommandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatPaiementCommandes")
    @GetMapping("")
    public ResponseEntity<List<EtatPaiementCommandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatPaiementCommandes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatPaiementCommandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatPaiementCommande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatPaiementCommandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatPaiementCommande")
    @PostMapping("")
    public ResponseEntity<EtatPaiementCommandeDto> save(@RequestBody EtatPaiementCommandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatPaiementCommande")
    @PutMapping("")
    public ResponseEntity<EtatPaiementCommandeDto> update(@RequestBody EtatPaiementCommandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatPaiementCommande")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatPaiementCommandeDto>> delete(@RequestBody List<EtatPaiementCommandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatPaiementCommande")
    @DeleteMapping("")
    public ResponseEntity<EtatPaiementCommandeDto> delete(@RequestBody EtatPaiementCommandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatPaiementCommande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatPaiementCommandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatPaiementCommandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatPaiementCommandeDto>> findByCriteria(@RequestBody EtatPaiementCommandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatPaiementCommandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatPaiementCommandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementCommandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatPaiementCommandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatPaiementCommande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatPaiementCommandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatPaiementCommande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatPaiementCommande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatPaiementCommandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementCommande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatPaiementCommandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatPaiementCommande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatPaiementCommandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatPaiementCommandeRestAdmin (EtatPaiementCommandeAdminService service, EtatPaiementCommandeConverter converter) {
        super(service, converter);
    }


}