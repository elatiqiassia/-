package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.TauxRetardTva;
import ma.sir.easystock.bean.history.TauxRetardTvaHistory;
import ma.sir.easystock.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.easystock.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.easystock.service.facade.admin.TauxRetardTvaAdminService;
import ma.sir.easystock.ws.converter.TauxRetardTvaConverter;
import ma.sir.easystock.ws.dto.TauxRetardTvaDto;
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

@Api("Manages tauxRetardTva services")
@RestController
@RequestMapping("/api/admin/tauxRetardTva/")
public class TauxRetardTvaRestAdmin  extends AbstractController<TauxRetardTva, TauxRetardTvaDto, TauxRetardTvaHistory, TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria, TauxRetardTvaAdminService, TauxRetardTvaConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody TauxRetardTvaDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one tauxRetardTva")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple tauxRetardTvas")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all tauxRetardTvas")
    @GetMapping("")
    public ResponseEntity<List<TauxRetardTvaDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a tauxRetardTva by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TauxRetardTvaDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  tauxRetardTva")
    @PostMapping("")
    public ResponseEntity<TauxRetardTvaDto> save(@RequestBody TauxRetardTvaDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  tauxRetardTva")
    @PutMapping("")
    public ResponseEntity<TauxRetardTvaDto> update(@RequestBody TauxRetardTvaDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of tauxRetardTva")
    @PostMapping("multiple")
    public ResponseEntity<List<TauxRetardTvaDto>> delete(@RequestBody List<TauxRetardTvaDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified tauxRetardTva")
    @DeleteMapping("")
    public ResponseEntity<TauxRetardTvaDto> delete(@RequestBody TauxRetardTvaDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified tauxRetardTva")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple tauxRetardTvas by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds tauxRetardTvas by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TauxRetardTvaDto>> findByCriteria(@RequestBody TauxRetardTvaCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated tauxRetardTvas by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TauxRetardTvaCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports tauxRetardTvas by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TauxRetardTvaCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets tauxRetardTva data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TauxRetardTvaCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets tauxRetardTva history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets tauxRetardTva paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TauxRetardTvaHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports tauxRetardTva history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TauxRetardTvaHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets tauxRetardTva history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TauxRetardTvaHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TauxRetardTvaRestAdmin (TauxRetardTvaAdminService service, TauxRetardTvaConverter converter) {
        super(service, converter);
    }


}