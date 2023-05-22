package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Demande;
import ma.sir.easystock.bean.history.DemandeHistory;
import ma.sir.easystock.dao.criteria.core.DemandeCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.DemandeAdminService;
import ma.sir.easystock.ws.converter.DemandeConverter;
import ma.sir.easystock.ws.dto.DemandeDto;
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

@Api("Manages demande services")
@RestController
@RequestMapping("/api/admin/demande/")
public class DemandeRestAdmin  extends AbstractController<Demande, DemandeDto, DemandeHistory, DemandeCriteria, DemandeHistoryCriteria, DemandeAdminService, DemandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DemandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one demande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple demandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all demandes")
    @GetMapping("")
    public ResponseEntity<List<DemandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all demandes")
    @GetMapping("optimized")
    public ResponseEntity<List<DemandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a demande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  demande")
    @PostMapping("")
    public ResponseEntity<DemandeDto> save(@RequestBody DemandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  demande")
    @PutMapping("")
    public ResponseEntity<DemandeDto> update(@RequestBody DemandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of demande")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandeDto>> delete(@RequestBody List<DemandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified demande")
    @DeleteMapping("")
    public ResponseEntity<DemandeDto> delete(@RequestBody DemandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified demande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple demandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Demande> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by etatDemande id")
    @GetMapping("etatDemande/id/{id}")
    public List<Demande> findByEtatDemandeId(@PathVariable Long id){
        return service.findByEtatDemandeId(id);
    }
    @ApiOperation("delete by etatDemande id")
    @DeleteMapping("etatDemande/id/{id}")
    public int deleteByEtatDemandeId(@PathVariable Long id){
        return service.deleteByEtatDemandeId(id);
    }
    @ApiOperation("Finds a demande and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<DemandeDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds demandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandeDto>> findByCriteria(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated demandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets demande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets demande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets demande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DemandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DemandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets demande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DemandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DemandeRestAdmin (DemandeAdminService service, DemandeConverter converter) {
        super(service, converter);
    }


}