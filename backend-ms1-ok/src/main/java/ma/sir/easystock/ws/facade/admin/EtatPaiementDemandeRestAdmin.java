package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatPaiementDemande;
import ma.sir.easystock.bean.history.EtatPaiementDemandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementDemandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatPaiementDemandeAdminService;
import ma.sir.easystock.ws.converter.EtatPaiementDemandeConverter;
import ma.sir.easystock.ws.dto.EtatPaiementDemandeDto;
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

@Api("Manages etatPaiementDemande services")
@RestController
@RequestMapping("/api/admin/etatPaiementDemande/")
public class EtatPaiementDemandeRestAdmin  extends AbstractController<EtatPaiementDemande, EtatPaiementDemandeDto, EtatPaiementDemandeHistory, EtatPaiementDemandeCriteria, EtatPaiementDemandeHistoryCriteria, EtatPaiementDemandeAdminService, EtatPaiementDemandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatPaiementDemandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatPaiementDemande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatPaiementDemandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatPaiementDemandes")
    @GetMapping("")
    public ResponseEntity<List<EtatPaiementDemandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatPaiementDemandes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatPaiementDemandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatPaiementDemande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatPaiementDemandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatPaiementDemande")
    @PostMapping("")
    public ResponseEntity<EtatPaiementDemandeDto> save(@RequestBody EtatPaiementDemandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatPaiementDemande")
    @PutMapping("")
    public ResponseEntity<EtatPaiementDemandeDto> update(@RequestBody EtatPaiementDemandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatPaiementDemande")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatPaiementDemandeDto>> delete(@RequestBody List<EtatPaiementDemandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatPaiementDemande")
    @DeleteMapping("")
    public ResponseEntity<EtatPaiementDemandeDto> delete(@RequestBody EtatPaiementDemandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatPaiementDemande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatPaiementDemandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatPaiementDemandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatPaiementDemandeDto>> findByCriteria(@RequestBody EtatPaiementDemandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatPaiementDemandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatPaiementDemandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementDemandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatPaiementDemandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatPaiementDemande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatPaiementDemandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatPaiementDemande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatPaiementDemande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatPaiementDemandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementDemande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatPaiementDemandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatPaiementDemande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatPaiementDemandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatPaiementDemandeRestAdmin (EtatPaiementDemandeAdminService service, EtatPaiementDemandeConverter converter) {
        super(service, converter);
    }


}