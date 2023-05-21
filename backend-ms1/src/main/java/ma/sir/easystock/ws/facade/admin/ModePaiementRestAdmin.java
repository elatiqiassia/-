package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.ModePaiement;
import ma.sir.easystock.bean.history.ModePaiementHistory;
import ma.sir.easystock.dao.criteria.core.ModePaiementCriteria;
import ma.sir.easystock.dao.criteria.history.ModePaiementHistoryCriteria;
import ma.sir.easystock.service.facade.admin.ModePaiementAdminService;
import ma.sir.easystock.ws.converter.ModePaiementConverter;
import ma.sir.easystock.ws.dto.ModePaiementDto;
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

@Api("Manages modePaiement services")
@RestController
@RequestMapping("/api/admin/modePaiement/")
public class ModePaiementRestAdmin  extends AbstractController<ModePaiement, ModePaiementDto, ModePaiementHistory, ModePaiementCriteria, ModePaiementHistoryCriteria, ModePaiementAdminService, ModePaiementConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ModePaiementDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one modePaiement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple modePaiements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all modePaiements")
    @GetMapping("")
    public ResponseEntity<List<ModePaiementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all modePaiements")
    @GetMapping("optimized")
    public ResponseEntity<List<ModePaiementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a modePaiement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ModePaiementDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  modePaiement")
    @PostMapping("")
    public ResponseEntity<ModePaiementDto> save(@RequestBody ModePaiementDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  modePaiement")
    @PutMapping("")
    public ResponseEntity<ModePaiementDto> update(@RequestBody ModePaiementDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of modePaiement")
    @PostMapping("multiple")
    public ResponseEntity<List<ModePaiementDto>> delete(@RequestBody List<ModePaiementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified modePaiement")
    @DeleteMapping("")
    public ResponseEntity<ModePaiementDto> delete(@RequestBody ModePaiementDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified modePaiement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple modePaiements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds modePaiements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ModePaiementDto>> findByCriteria(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated modePaiements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports modePaiements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets modePaiement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ModePaiementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets modePaiement history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets modePaiement paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ModePaiementHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports modePaiement history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ModePaiementHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets modePaiement history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ModePaiementHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ModePaiementRestAdmin (ModePaiementAdminService service, ModePaiementConverter converter) {
        super(service, converter);
    }


}