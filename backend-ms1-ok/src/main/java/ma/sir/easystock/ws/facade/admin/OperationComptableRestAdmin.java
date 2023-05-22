package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.OperationComptable;
import ma.sir.easystock.bean.history.OperationComptableHistory;
import ma.sir.easystock.dao.criteria.core.OperationComptableCriteria;
import ma.sir.easystock.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.easystock.service.facade.admin.OperationComptableAdminService;
import ma.sir.easystock.ws.converter.OperationComptableConverter;
import ma.sir.easystock.ws.dto.OperationComptableDto;
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

@Api("Manages operationComptable services")
@RestController
@RequestMapping("/api/admin/operationComptable/")
public class OperationComptableRestAdmin  extends AbstractController<OperationComptable, OperationComptableDto, OperationComptableHistory, OperationComptableCriteria, OperationComptableHistoryCriteria, OperationComptableAdminService, OperationComptableConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody OperationComptableDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one operationComptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple operationComptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all operationComptables")
    @GetMapping("")
    public ResponseEntity<List<OperationComptableDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a operationComptable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OperationComptableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  operationComptable")
    @PostMapping("")
    public ResponseEntity<OperationComptableDto> save(@RequestBody OperationComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  operationComptable")
    @PutMapping("")
    public ResponseEntity<OperationComptableDto> update(@RequestBody OperationComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of operationComptable")
    @PostMapping("multiple")
    public ResponseEntity<List<OperationComptableDto>> delete(@RequestBody List<OperationComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified operationComptable")
    @DeleteMapping("")
    public ResponseEntity<OperationComptableDto> delete(@RequestBody OperationComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified operationComptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple operationComptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by societe id")
    @GetMapping("societe/id/{id}")
    public List<OperationComptable> findBySocieteId(@PathVariable Long id){
        return service.findBySocieteId(id);
    }
    @ApiOperation("delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @ApiOperation("find by compteComptable id")
    @GetMapping("compteComptable/id/{id}")
    public List<OperationComptable> findByCompteComptableId(@PathVariable Long id){
        return service.findByCompteComptableId(id);
    }
    @ApiOperation("delete by compteComptable id")
    @DeleteMapping("compteComptable/id/{id}")
    public int deleteByCompteComptableId(@PathVariable Long id){
        return service.deleteByCompteComptableId(id);
    }
    @ApiOperation("Finds operationComptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OperationComptableDto>> findByCriteria(@RequestBody OperationComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated operationComptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OperationComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports operationComptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OperationComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets operationComptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OperationComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets operationComptable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets operationComptable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody OperationComptableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports operationComptable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody OperationComptableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets operationComptable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody OperationComptableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public OperationComptableRestAdmin (OperationComptableAdminService service, OperationComptableConverter converter) {
        super(service, converter);
    }


}