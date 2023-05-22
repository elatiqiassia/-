package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Marque;
import ma.sir.easystock.bean.history.MarqueHistory;
import ma.sir.easystock.dao.criteria.core.MarqueCriteria;
import ma.sir.easystock.dao.criteria.history.MarqueHistoryCriteria;
import ma.sir.easystock.service.facade.admin.MarqueAdminService;
import ma.sir.easystock.ws.converter.MarqueConverter;
import ma.sir.easystock.ws.dto.MarqueDto;
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

@Api("Manages marque services")
@RestController
@RequestMapping("/api/admin/marque/")
public class MarqueRestAdmin  extends AbstractController<Marque, MarqueDto, MarqueHistory, MarqueCriteria, MarqueHistoryCriteria, MarqueAdminService, MarqueConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody MarqueDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one marque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple marques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all marques")
    @GetMapping("")
    public ResponseEntity<List<MarqueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all marques")
    @GetMapping("optimized")
    public ResponseEntity<List<MarqueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a marque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MarqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  marque")
    @PostMapping("")
    public ResponseEntity<MarqueDto> save(@RequestBody MarqueDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  marque")
    @PutMapping("")
    public ResponseEntity<MarqueDto> update(@RequestBody MarqueDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of marque")
    @PostMapping("multiple")
    public ResponseEntity<List<MarqueDto>> delete(@RequestBody List<MarqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified marque")
    @DeleteMapping("")
    public ResponseEntity<MarqueDto> delete(@RequestBody MarqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified marque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple marques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds marques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MarqueDto>> findByCriteria(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated marques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports marques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets marque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets marque history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets marque paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody MarqueHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports marque history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody MarqueHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets marque history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody MarqueHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public MarqueRestAdmin (MarqueAdminService service, MarqueConverter converter) {
        super(service, converter);
    }


}