package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.SousClassComptable;
import ma.sir.easystock.bean.history.SousClassComptableHistory;
import ma.sir.easystock.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.easystock.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.easystock.service.facade.admin.SousClassComptableAdminService;
import ma.sir.easystock.ws.converter.SousClassComptableConverter;
import ma.sir.easystock.ws.dto.SousClassComptableDto;
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

@Api("Manages sousClassComptable services")
@RestController
@RequestMapping("/api/admin/sousClassComptable/")
public class SousClassComptableRestAdmin  extends AbstractController<SousClassComptable, SousClassComptableDto, SousClassComptableHistory, SousClassComptableCriteria, SousClassComptableHistoryCriteria, SousClassComptableAdminService, SousClassComptableConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SousClassComptableDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one sousClassComptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple sousClassComptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all sousClassComptables")
    @GetMapping("")
    public ResponseEntity<List<SousClassComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all sousClassComptables")
    @GetMapping("optimized")
    public ResponseEntity<List<SousClassComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a sousClassComptable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SousClassComptableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  sousClassComptable")
    @PostMapping("")
    public ResponseEntity<SousClassComptableDto> save(@RequestBody SousClassComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  sousClassComptable")
    @PutMapping("")
    public ResponseEntity<SousClassComptableDto> update(@RequestBody SousClassComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of sousClassComptable")
    @PostMapping("multiple")
    public ResponseEntity<List<SousClassComptableDto>> delete(@RequestBody List<SousClassComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified sousClassComptable")
    @DeleteMapping("")
    public ResponseEntity<SousClassComptableDto> delete(@RequestBody SousClassComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified sousClassComptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple sousClassComptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by classComptable id")
    @GetMapping("classComptable/id/{id}")
    public List<SousClassComptable> findByClassComptableId(@PathVariable Long id){
        return service.findByClassComptableId(id);
    }
    @ApiOperation("delete by classComptable id")
    @DeleteMapping("classComptable/id/{id}")
    public int deleteByClassComptableId(@PathVariable Long id){
        return service.deleteByClassComptableId(id);
    }
    @ApiOperation("Finds sousClassComptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SousClassComptableDto>> findByCriteria(@RequestBody SousClassComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated sousClassComptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SousClassComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports sousClassComptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SousClassComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets sousClassComptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SousClassComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets sousClassComptable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets sousClassComptable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SousClassComptableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports sousClassComptable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SousClassComptableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets sousClassComptable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SousClassComptableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SousClassComptableRestAdmin (SousClassComptableAdminService service, SousClassComptableConverter converter) {
        super(service, converter);
    }


}