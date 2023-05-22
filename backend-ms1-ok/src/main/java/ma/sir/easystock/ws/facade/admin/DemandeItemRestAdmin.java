package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.DemandeItem;
import ma.sir.easystock.bean.history.DemandeItemHistory;
import ma.sir.easystock.dao.criteria.core.DemandeItemCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeItemHistoryCriteria;
import ma.sir.easystock.service.facade.admin.DemandeItemAdminService;
import ma.sir.easystock.ws.converter.DemandeItemConverter;
import ma.sir.easystock.ws.dto.DemandeItemDto;
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

@Api("Manages demandeItem services")
@RestController
@RequestMapping("/api/admin/demandeItem/")
public class DemandeItemRestAdmin  extends AbstractController<DemandeItem, DemandeItemDto, DemandeItemHistory, DemandeItemCriteria, DemandeItemHistoryCriteria, DemandeItemAdminService, DemandeItemConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DemandeItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one demandeItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple demandeItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all demandeItems")
    @GetMapping("")
    public ResponseEntity<List<DemandeItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a demandeItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandeItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  demandeItem")
    @PostMapping("")
    public ResponseEntity<DemandeItemDto> save(@RequestBody DemandeItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  demandeItem")
    @PutMapping("")
    public ResponseEntity<DemandeItemDto> update(@RequestBody DemandeItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of demandeItem")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandeItemDto>> delete(@RequestBody List<DemandeItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified demandeItem")
    @DeleteMapping("")
    public ResponseEntity<DemandeItemDto> delete(@RequestBody DemandeItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified demandeItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple demandeItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<DemandeItem> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("find by demande id")
    @GetMapping("demande/id/{id}")
    public List<DemandeItem> findByDemandeId(@PathVariable Long id){
        return service.findByDemandeId(id);
    }
    @ApiOperation("delete by demande id")
    @DeleteMapping("demande/id/{id}")
    public int deleteByDemandeId(@PathVariable Long id){
        return service.deleteByDemandeId(id);
    }
    @ApiOperation("Finds demandeItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandeItemDto>> findByCriteria(@RequestBody DemandeItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated demandeItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandeItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demandeItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DemandeItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets demandeItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandeItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets demandeItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets demandeItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DemandeItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports demandeItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DemandeItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets demandeItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DemandeItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DemandeItemRestAdmin (DemandeItemAdminService service, DemandeItemConverter converter) {
        super(service, converter);
    }


}