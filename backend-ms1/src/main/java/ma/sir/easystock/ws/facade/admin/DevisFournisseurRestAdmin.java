package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.DevisFournisseur;
import ma.sir.easystock.bean.history.DevisFournisseurHistory;
import ma.sir.easystock.dao.criteria.core.DevisFournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.DevisFournisseurHistoryCriteria;
import ma.sir.easystock.service.facade.admin.DevisFournisseurAdminService;
import ma.sir.easystock.ws.converter.DevisFournisseurConverter;
import ma.sir.easystock.ws.dto.DevisFournisseurDto;
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

@Api("Manages devisFournisseur services")
@RestController
@RequestMapping("/api/admin/devisFournisseur/")
public class DevisFournisseurRestAdmin  extends AbstractController<DevisFournisseur, DevisFournisseurDto, DevisFournisseurHistory, DevisFournisseurCriteria, DevisFournisseurHistoryCriteria, DevisFournisseurAdminService, DevisFournisseurConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DevisFournisseurDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one devisFournisseur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple devisFournisseurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all devisFournisseurs")
    @GetMapping("")
    public ResponseEntity<List<DevisFournisseurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all devisFournisseurs")
    @GetMapping("optimized")
    public ResponseEntity<List<DevisFournisseurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a devisFournisseur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DevisFournisseurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  devisFournisseur")
    @PostMapping("")
    public ResponseEntity<DevisFournisseurDto> save(@RequestBody DevisFournisseurDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  devisFournisseur")
    @PutMapping("")
    public ResponseEntity<DevisFournisseurDto> update(@RequestBody DevisFournisseurDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of devisFournisseur")
    @PostMapping("multiple")
    public ResponseEntity<List<DevisFournisseurDto>> delete(@RequestBody List<DevisFournisseurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified devisFournisseur")
    @DeleteMapping("")
    public ResponseEntity<DevisFournisseurDto> delete(@RequestBody DevisFournisseurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified devisFournisseur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple devisFournisseurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public List<DevisFournisseur> findByFournisseurId(@PathVariable Long id){
        return service.findByFournisseurId(id);
    }
    @ApiOperation("delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public int deleteByFournisseurId(@PathVariable Long id){
        return service.deleteByFournisseurId(id);
    }
    @ApiOperation("Finds a devisFournisseur and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<DevisFournisseurDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds devisFournisseurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DevisFournisseurDto>> findByCriteria(@RequestBody DevisFournisseurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated devisFournisseurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DevisFournisseurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports devisFournisseurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DevisFournisseurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets devisFournisseur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DevisFournisseurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets devisFournisseur history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets devisFournisseur paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DevisFournisseurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports devisFournisseur history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DevisFournisseurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets devisFournisseur history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DevisFournisseurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DevisFournisseurRestAdmin (DevisFournisseurAdminService service, DevisFournisseurConverter converter) {
        super(service, converter);
    }


}