package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.ComptableValidateur;
import ma.sir.easystock.bean.history.ComptableValidateurHistory;
import ma.sir.easystock.dao.criteria.core.ComptableValidateurCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableValidateurHistoryCriteria;
import ma.sir.easystock.service.facade.admin.ComptableValidateurAdminService;
import ma.sir.easystock.ws.converter.ComptableValidateurConverter;
import ma.sir.easystock.ws.dto.ComptableValidateurDto;
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

@Api("Manages comptableValidateur services")
@RestController
@RequestMapping("/api/admin/comptableValidateur/")
public class ComptableValidateurRestAdmin  extends AbstractController<ComptableValidateur, ComptableValidateurDto, ComptableValidateurHistory, ComptableValidateurCriteria, ComptableValidateurHistoryCriteria, ComptableValidateurAdminService, ComptableValidateurConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ComptableValidateurDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one comptableValidateur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple comptableValidateurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all comptableValidateurs")
    @GetMapping("")
    public ResponseEntity<List<ComptableValidateurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all comptableValidateurs")
    @GetMapping("optimized")
    public ResponseEntity<List<ComptableValidateurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a comptableValidateur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ComptableValidateurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  comptableValidateur")
    @PostMapping("")
    public ResponseEntity<ComptableValidateurDto> save(@RequestBody ComptableValidateurDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  comptableValidateur")
    @PutMapping("")
    public ResponseEntity<ComptableValidateurDto> update(@RequestBody ComptableValidateurDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of comptableValidateur")
    @PostMapping("multiple")
    public ResponseEntity<List<ComptableValidateurDto>> delete(@RequestBody List<ComptableValidateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified comptableValidateur")
    @DeleteMapping("")
    public ResponseEntity<ComptableValidateurDto> delete(@RequestBody ComptableValidateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified comptableValidateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple comptableValidateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds comptableValidateurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ComptableValidateurDto>> findByCriteria(@RequestBody ComptableValidateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated comptableValidateurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ComptableValidateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports comptableValidateurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ComptableValidateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets comptableValidateur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ComptableValidateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets comptableValidateur history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets comptableValidateur paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ComptableValidateurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports comptableValidateur history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ComptableValidateurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets comptableValidateur history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ComptableValidateurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ComptableValidateurRestAdmin (ComptableValidateurAdminService service, ComptableValidateurConverter converter) {
        super(service, converter);
    }


}