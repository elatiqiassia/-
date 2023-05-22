package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Bilan;
import ma.sir.easystock.bean.history.BilanHistory;
import ma.sir.easystock.dao.criteria.core.BilanCriteria;
import ma.sir.easystock.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.easystock.service.facade.admin.BilanAdminService;
import ma.sir.easystock.ws.converter.BilanConverter;
import ma.sir.easystock.ws.dto.BilanDto;
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

@Api("Manages bilan services")
@RestController
@RequestMapping("/api/admin/bilan/")
public class BilanRestAdmin  extends AbstractController<Bilan, BilanDto, BilanHistory, BilanCriteria, BilanHistoryCriteria, BilanAdminService, BilanConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody BilanDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one bilan")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple bilans")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all bilans")
    @GetMapping("")
    public ResponseEntity<List<BilanDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all bilans")
    @GetMapping("optimized")
    public ResponseEntity<List<BilanDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a bilan by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BilanDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  bilan")
    @PostMapping("")
    public ResponseEntity<BilanDto> save(@RequestBody BilanDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  bilan")
    @PutMapping("")
    public ResponseEntity<BilanDto> update(@RequestBody BilanDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of bilan")
    @PostMapping("multiple")
    public ResponseEntity<List<BilanDto>> delete(@RequestBody List<BilanDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified bilan")
    @DeleteMapping("")
    public ResponseEntity<BilanDto> delete(@RequestBody BilanDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified bilan")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple bilans by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by societe id")
    @GetMapping("societe/id/{id}")
    public List<Bilan> findBySocieteId(@PathVariable Long id){
        return service.findBySocieteId(id);
    }
    @ApiOperation("delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @ApiOperation("Finds bilans by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BilanDto>> findByCriteria(@RequestBody BilanCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated bilans by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BilanCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports bilans by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BilanCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets bilan data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BilanCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets bilan history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets bilan paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BilanHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports bilan history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BilanHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets bilan history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BilanHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BilanRestAdmin (BilanAdminService service, BilanConverter converter) {
        super(service, converter);
    }


}