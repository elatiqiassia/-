package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.CompteComptable;
import ma.sir.easystock.bean.history.CompteComptableHistory;
import ma.sir.easystock.dao.criteria.core.CompteComptableCriteria;
import ma.sir.easystock.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.easystock.service.facade.admin.CompteComptableAdminService;
import ma.sir.easystock.ws.converter.CompteComptableConverter;
import ma.sir.easystock.ws.dto.CompteComptableDto;
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

@Api("Manages compteComptable services")
@RestController
@RequestMapping("/api/admin/compteComptable/")
public class CompteComptableRestAdmin  extends AbstractController<CompteComptable, CompteComptableDto, CompteComptableHistory, CompteComptableCriteria, CompteComptableHistoryCriteria, CompteComptableAdminService, CompteComptableConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CompteComptableDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one compteComptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple compteComptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all compteComptables")
    @GetMapping("")
    public ResponseEntity<List<CompteComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all compteComptables")
    @GetMapping("optimized")
    public ResponseEntity<List<CompteComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a compteComptable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CompteComptableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  compteComptable")
    @PostMapping("")
    public ResponseEntity<CompteComptableDto> save(@RequestBody CompteComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  compteComptable")
    @PutMapping("")
    public ResponseEntity<CompteComptableDto> update(@RequestBody CompteComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of compteComptable")
    @PostMapping("multiple")
    public ResponseEntity<List<CompteComptableDto>> delete(@RequestBody List<CompteComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified compteComptable")
    @DeleteMapping("")
    public ResponseEntity<CompteComptableDto> delete(@RequestBody CompteComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified compteComptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple compteComptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by sousClassComptable id")
    @GetMapping("sousClassComptable/id/{id}")
    public List<CompteComptable> findBySousClassComptableId(@PathVariable Long id){
        return service.findBySousClassComptableId(id);
    }
    @ApiOperation("delete by sousClassComptable id")
    @DeleteMapping("sousClassComptable/id/{id}")
    public int deleteBySousClassComptableId(@PathVariable Long id){
        return service.deleteBySousClassComptableId(id);
    }
    @ApiOperation("Finds compteComptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CompteComptableDto>> findByCriteria(@RequestBody CompteComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated compteComptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CompteComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports compteComptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CompteComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets compteComptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CompteComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets compteComptable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets compteComptable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CompteComptableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports compteComptable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CompteComptableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets compteComptable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CompteComptableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CompteComptableRestAdmin (CompteComptableAdminService service, CompteComptableConverter converter) {
        super(service, converter);
    }


}