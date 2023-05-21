package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatDemande;
import ma.sir.easystock.bean.history.EtatDemandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatDemandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatDemandeAdminService;
import ma.sir.easystock.ws.converter.EtatDemandeConverter;
import ma.sir.easystock.ws.dto.EtatDemandeDto;
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

@Api("Manages etatDemande services")
@RestController
@RequestMapping("/api/admin/etatDemande/")
public class EtatDemandeRestAdmin  extends AbstractController<EtatDemande, EtatDemandeDto, EtatDemandeHistory, EtatDemandeCriteria, EtatDemandeHistoryCriteria, EtatDemandeAdminService, EtatDemandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatDemandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatDemande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatDemandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatDemandes")
    @GetMapping("")
    public ResponseEntity<List<EtatDemandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatDemandes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatDemandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatDemande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatDemandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatDemande")
    @PostMapping("")
    public ResponseEntity<EtatDemandeDto> save(@RequestBody EtatDemandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatDemande")
    @PutMapping("")
    public ResponseEntity<EtatDemandeDto> update(@RequestBody EtatDemandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatDemande")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatDemandeDto>> delete(@RequestBody List<EtatDemandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatDemande")
    @DeleteMapping("")
    public ResponseEntity<EtatDemandeDto> delete(@RequestBody EtatDemandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatDemande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatDemandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatDemandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatDemandeDto>> findByCriteria(@RequestBody EtatDemandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatDemandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatDemandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatDemandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatDemandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatDemande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatDemandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatDemande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatDemande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatDemandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatDemande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatDemandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatDemande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatDemandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatDemandeRestAdmin (EtatDemandeAdminService service, EtatDemandeConverter converter) {
        super(service, converter);
    }


}