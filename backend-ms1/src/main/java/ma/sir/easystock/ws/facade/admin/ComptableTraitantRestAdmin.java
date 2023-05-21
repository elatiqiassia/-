package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.ComptableTraitant;
import ma.sir.easystock.bean.history.ComptableTraitantHistory;
import ma.sir.easystock.dao.criteria.core.ComptableTraitantCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableTraitantHistoryCriteria;
import ma.sir.easystock.service.facade.admin.ComptableTraitantAdminService;
import ma.sir.easystock.ws.converter.ComptableTraitantConverter;
import ma.sir.easystock.ws.dto.ComptableTraitantDto;
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

@Api("Manages comptableTraitant services")
@RestController
@RequestMapping("/api/admin/comptableTraitant/")
public class ComptableTraitantRestAdmin  extends AbstractController<ComptableTraitant, ComptableTraitantDto, ComptableTraitantHistory, ComptableTraitantCriteria, ComptableTraitantHistoryCriteria, ComptableTraitantAdminService, ComptableTraitantConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ComptableTraitantDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one comptableTraitant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple comptableTraitants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all comptableTraitants")
    @GetMapping("")
    public ResponseEntity<List<ComptableTraitantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all comptableTraitants")
    @GetMapping("optimized")
    public ResponseEntity<List<ComptableTraitantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a comptableTraitant by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ComptableTraitantDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  comptableTraitant")
    @PostMapping("")
    public ResponseEntity<ComptableTraitantDto> save(@RequestBody ComptableTraitantDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  comptableTraitant")
    @PutMapping("")
    public ResponseEntity<ComptableTraitantDto> update(@RequestBody ComptableTraitantDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of comptableTraitant")
    @PostMapping("multiple")
    public ResponseEntity<List<ComptableTraitantDto>> delete(@RequestBody List<ComptableTraitantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified comptableTraitant")
    @DeleteMapping("")
    public ResponseEntity<ComptableTraitantDto> delete(@RequestBody ComptableTraitantDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified comptableTraitant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple comptableTraitants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds comptableTraitants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ComptableTraitantDto>> findByCriteria(@RequestBody ComptableTraitantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated comptableTraitants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ComptableTraitantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports comptableTraitants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ComptableTraitantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets comptableTraitant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ComptableTraitantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets comptableTraitant history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets comptableTraitant paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ComptableTraitantHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports comptableTraitant history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ComptableTraitantHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets comptableTraitant history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ComptableTraitantHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ComptableTraitantRestAdmin (ComptableTraitantAdminService service, ComptableTraitantConverter converter) {
        super(service, converter);
    }


}