package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.CategorieProduit;
import ma.sir.easystock.bean.history.CategorieProduitHistory;
import ma.sir.easystock.dao.criteria.core.CategorieProduitCriteria;
import ma.sir.easystock.dao.criteria.history.CategorieProduitHistoryCriteria;
import ma.sir.easystock.service.facade.admin.CategorieProduitAdminService;
import ma.sir.easystock.ws.converter.CategorieProduitConverter;
import ma.sir.easystock.ws.dto.CategorieProduitDto;
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

@Api("Manages categorieProduit services")
@RestController
@RequestMapping("/api/admin/categorieProduit/")
public class CategorieProduitRestAdmin  extends AbstractController<CategorieProduit, CategorieProduitDto, CategorieProduitHistory, CategorieProduitCriteria, CategorieProduitHistoryCriteria, CategorieProduitAdminService, CategorieProduitConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CategorieProduitDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one categorieProduit")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple categorieProduits")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all categorieProduits")
    @GetMapping("")
    public ResponseEntity<List<CategorieProduitDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all categorieProduits")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieProduitDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a categorieProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  categorieProduit")
    @PostMapping("")
    public ResponseEntity<CategorieProduitDto> save(@RequestBody CategorieProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  categorieProduit")
    @PutMapping("")
    public ResponseEntity<CategorieProduitDto> update(@RequestBody CategorieProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of categorieProduit")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieProduitDto>> delete(@RequestBody List<CategorieProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified categorieProduit")
    @DeleteMapping("")
    public ResponseEntity<CategorieProduitDto> delete(@RequestBody CategorieProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified categorieProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple categorieProduits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds categorieProduits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieProduitDto>> findByCriteria(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated categorieProduits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports categorieProduits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets categorieProduit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets categorieProduit history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets categorieProduit paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CategorieProduitHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports categorieProduit history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CategorieProduitHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets categorieProduit history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CategorieProduitHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CategorieProduitRestAdmin (CategorieProduitAdminService service, CategorieProduitConverter converter) {
        super(service, converter);
    }


}