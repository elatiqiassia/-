package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Banque;
import ma.sir.easystock.bean.history.BanqueHistory;
import ma.sir.easystock.dao.criteria.core.BanqueCriteria;
import ma.sir.easystock.dao.criteria.history.BanqueHistoryCriteria;
import ma.sir.easystock.service.facade.admin.BanqueAdminService;
import ma.sir.easystock.ws.converter.BanqueConverter;
import ma.sir.easystock.ws.dto.BanqueDto;
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

@Api("Manages banque services")
@RestController
@RequestMapping("/api/admin/banque/")
public class BanqueRestAdmin  extends AbstractController<Banque, BanqueDto, BanqueHistory, BanqueCriteria, BanqueHistoryCriteria, BanqueAdminService, BanqueConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody BanqueDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one banque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple banques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all banques")
    @GetMapping("")
    public ResponseEntity<List<BanqueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all banques")
    @GetMapping("optimized")
    public ResponseEntity<List<BanqueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a banque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BanqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  banque")
    @PostMapping("")
    public ResponseEntity<BanqueDto> save(@RequestBody BanqueDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  banque")
    @PutMapping("")
    public ResponseEntity<BanqueDto> update(@RequestBody BanqueDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of banque")
    @PostMapping("multiple")
    public ResponseEntity<List<BanqueDto>> delete(@RequestBody List<BanqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified banque")
    @DeleteMapping("")
    public ResponseEntity<BanqueDto> delete(@RequestBody BanqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified banque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple banques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds banques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BanqueDto>> findByCriteria(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated banques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports banques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets banque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets banque history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets banque paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BanqueHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports banque history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BanqueHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets banque history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BanqueHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BanqueRestAdmin (BanqueAdminService service, BanqueConverter converter) {
        super(service, converter);
    }


}