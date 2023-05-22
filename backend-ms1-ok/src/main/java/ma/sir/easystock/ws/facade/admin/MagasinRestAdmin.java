package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Magasin;
import ma.sir.easystock.bean.history.MagasinHistory;
import ma.sir.easystock.dao.criteria.core.MagasinCriteria;
import ma.sir.easystock.dao.criteria.history.MagasinHistoryCriteria;
import ma.sir.easystock.service.facade.admin.MagasinAdminService;
import ma.sir.easystock.ws.converter.MagasinConverter;
import ma.sir.easystock.ws.dto.MagasinDto;
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

@Api("Manages magasin services")
@RestController
@RequestMapping("/api/admin/magasin/")
public class MagasinRestAdmin  extends AbstractController<Magasin, MagasinDto, MagasinHistory, MagasinCriteria, MagasinHistoryCriteria, MagasinAdminService, MagasinConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody MagasinDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one magasin")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple magasins")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all magasins")
    @GetMapping("")
    public ResponseEntity<List<MagasinDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all magasins")
    @GetMapping("optimized")
    public ResponseEntity<List<MagasinDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a magasin by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MagasinDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  magasin")
    @PostMapping("")
    public ResponseEntity<MagasinDto> save(@RequestBody MagasinDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  magasin")
    @PutMapping("")
    public ResponseEntity<MagasinDto> update(@RequestBody MagasinDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of magasin")
    @PostMapping("multiple")
    public ResponseEntity<List<MagasinDto>> delete(@RequestBody List<MagasinDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified magasin")
    @DeleteMapping("")
    public ResponseEntity<MagasinDto> delete(@RequestBody MagasinDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified magasin")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple magasins by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by store id")
    @GetMapping("store/id/{id}")
    public List<Magasin> findByStoreId(@PathVariable Long id){
        return service.findByStoreId(id);
    }
    @ApiOperation("delete by store id")
    @DeleteMapping("store/id/{id}")
    public int deleteByStoreId(@PathVariable Long id){
        return service.deleteByStoreId(id);
    }
    @ApiOperation("Finds magasins by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MagasinDto>> findByCriteria(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated magasins by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports magasins by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets magasin data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MagasinCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets magasin history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets magasin paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody MagasinHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports magasin history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody MagasinHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets magasin history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody MagasinHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public MagasinRestAdmin (MagasinAdminService service, MagasinConverter converter) {
        super(service, converter);
    }


}