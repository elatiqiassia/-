package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatPaiementLivraison;
import ma.sir.easystock.bean.history.EtatPaiementLivraisonHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementLivraisonHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatPaiementLivraisonAdminService;
import ma.sir.easystock.ws.converter.EtatPaiementLivraisonConverter;
import ma.sir.easystock.ws.dto.EtatPaiementLivraisonDto;
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

@Api("Manages etatPaiementLivraison services")
@RestController
@RequestMapping("/api/admin/etatPaiementLivraison/")
public class EtatPaiementLivraisonRestAdmin  extends AbstractController<EtatPaiementLivraison, EtatPaiementLivraisonDto, EtatPaiementLivraisonHistory, EtatPaiementLivraisonCriteria, EtatPaiementLivraisonHistoryCriteria, EtatPaiementLivraisonAdminService, EtatPaiementLivraisonConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatPaiementLivraisonDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatPaiementLivraison")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatPaiementLivraisons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatPaiementLivraisons")
    @GetMapping("")
    public ResponseEntity<List<EtatPaiementLivraisonDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatPaiementLivraisons")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatPaiementLivraisonDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatPaiementLivraison by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatPaiementLivraisonDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatPaiementLivraison")
    @PostMapping("")
    public ResponseEntity<EtatPaiementLivraisonDto> save(@RequestBody EtatPaiementLivraisonDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatPaiementLivraison")
    @PutMapping("")
    public ResponseEntity<EtatPaiementLivraisonDto> update(@RequestBody EtatPaiementLivraisonDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatPaiementLivraison")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatPaiementLivraisonDto>> delete(@RequestBody List<EtatPaiementLivraisonDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatPaiementLivraison")
    @DeleteMapping("")
    public ResponseEntity<EtatPaiementLivraisonDto> delete(@RequestBody EtatPaiementLivraisonDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatPaiementLivraison")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatPaiementLivraisons by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatPaiementLivraisons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatPaiementLivraisonDto>> findByCriteria(@RequestBody EtatPaiementLivraisonCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatPaiementLivraisons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatPaiementLivraisonCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementLivraisons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatPaiementLivraisonCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatPaiementLivraison data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatPaiementLivraisonCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatPaiementLivraison history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatPaiementLivraison paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatPaiementLivraisonHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementLivraison history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatPaiementLivraisonHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatPaiementLivraison history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatPaiementLivraisonHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatPaiementLivraisonRestAdmin (EtatPaiementLivraisonAdminService service, EtatPaiementLivraisonConverter converter) {
        super(service, converter);
    }


}