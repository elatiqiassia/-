package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.TauxIs;
import ma.sir.easystock.bean.history.TauxIsHistory;
import ma.sir.easystock.dao.criteria.core.TauxIsCriteria;
import ma.sir.easystock.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.easystock.service.facade.admin.TauxIsAdminService;
import ma.sir.easystock.ws.converter.TauxIsConverter;
import ma.sir.easystock.ws.dto.TauxIsDto;
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

@Api("Manages tauxIs services")
@RestController
@RequestMapping("/api/admin/tauxIs/")
public class TauxIsRestAdmin  extends AbstractController<TauxIs, TauxIsDto, TauxIsHistory, TauxIsCriteria, TauxIsHistoryCriteria, TauxIsAdminService, TauxIsConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody TauxIsDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one tauxIs")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple tauxIss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all tauxIss")
    @GetMapping("")
    public ResponseEntity<List<TauxIsDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a tauxIs by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TauxIsDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  tauxIs")
    @PostMapping("")
    public ResponseEntity<TauxIsDto> save(@RequestBody TauxIsDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  tauxIs")
    @PutMapping("")
    public ResponseEntity<TauxIsDto> update(@RequestBody TauxIsDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of tauxIs")
    @PostMapping("multiple")
    public ResponseEntity<List<TauxIsDto>> delete(@RequestBody List<TauxIsDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified tauxIs")
    @DeleteMapping("")
    public ResponseEntity<TauxIsDto> delete(@RequestBody TauxIsDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified tauxIs")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple tauxIss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds tauxIss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TauxIsDto>> findByCriteria(@RequestBody TauxIsCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated tauxIss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TauxIsCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports tauxIss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TauxIsCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets tauxIs data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TauxIsCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets tauxIs history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets tauxIs paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TauxIsHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports tauxIs history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TauxIsHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets tauxIs history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TauxIsHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TauxIsRestAdmin (TauxIsAdminService service, TauxIsConverter converter) {
        super(service, converter);
    }


}