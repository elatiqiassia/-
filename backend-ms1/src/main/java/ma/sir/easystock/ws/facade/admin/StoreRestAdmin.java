package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Store;
import ma.sir.easystock.bean.history.StoreHistory;
import ma.sir.easystock.dao.criteria.core.StoreCriteria;
import ma.sir.easystock.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.easystock.service.facade.admin.StoreAdminService;
import ma.sir.easystock.ws.converter.StoreConverter;
import ma.sir.easystock.ws.dto.StoreDto;
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

@Api("Manages store services")
@RestController
@RequestMapping("/api/admin/store/")
public class StoreRestAdmin  extends AbstractController<Store, StoreDto, StoreHistory, StoreCriteria, StoreHistoryCriteria, StoreAdminService, StoreConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody StoreDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one store")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple stores")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all stores")
    @GetMapping("")
    public ResponseEntity<List<StoreDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all stores")
    @GetMapping("optimized")
    public ResponseEntity<List<StoreDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a store by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StoreDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  store")
    @PostMapping("")
    public ResponseEntity<StoreDto> save(@RequestBody StoreDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  store")
    @PutMapping("")
    public ResponseEntity<StoreDto> update(@RequestBody StoreDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of store")
    @PostMapping("multiple")
    public ResponseEntity<List<StoreDto>> delete(@RequestBody List<StoreDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified store")
    @DeleteMapping("")
    public ResponseEntity<StoreDto> delete(@RequestBody StoreDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified store")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple stores by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by societe id")
    @GetMapping("societe/id/{id}")
    public List<Store> findBySocieteId(@PathVariable Long id){
        return service.findBySocieteId(id);
    }
    @ApiOperation("delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @ApiOperation("Finds stores by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StoreDto>> findByCriteria(@RequestBody StoreCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated stores by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StoreCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports stores by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StoreCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets store data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StoreCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets store history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets store paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StoreHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports store history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StoreHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets store history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StoreHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public StoreRestAdmin (StoreAdminService service, StoreConverter converter) {
        super(service, converter);
    }


}