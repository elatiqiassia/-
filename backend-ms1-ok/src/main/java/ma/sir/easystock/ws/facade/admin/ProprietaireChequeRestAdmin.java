package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.ProprietaireCheque;
import ma.sir.easystock.bean.history.ProprietaireChequeHistory;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeCriteria;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.ProprietaireChequeAdminService;
import ma.sir.easystock.ws.converter.ProprietaireChequeConverter;
import ma.sir.easystock.ws.dto.ProprietaireChequeDto;
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

@Api("Manages proprietaireCheque services")
@RestController
@RequestMapping("/api/admin/proprietaireCheque/")
public class ProprietaireChequeRestAdmin  extends AbstractController<ProprietaireCheque, ProprietaireChequeDto, ProprietaireChequeHistory, ProprietaireChequeCriteria, ProprietaireChequeHistoryCriteria, ProprietaireChequeAdminService, ProprietaireChequeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ProprietaireChequeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one proprietaireCheque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple proprietaireCheques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all proprietaireCheques")
    @GetMapping("")
    public ResponseEntity<List<ProprietaireChequeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all proprietaireCheques")
    @GetMapping("optimized")
    public ResponseEntity<List<ProprietaireChequeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a proprietaireCheque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProprietaireChequeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  proprietaireCheque")
    @PostMapping("")
    public ResponseEntity<ProprietaireChequeDto> save(@RequestBody ProprietaireChequeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  proprietaireCheque")
    @PutMapping("")
    public ResponseEntity<ProprietaireChequeDto> update(@RequestBody ProprietaireChequeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of proprietaireCheque")
    @PostMapping("multiple")
    public ResponseEntity<List<ProprietaireChequeDto>> delete(@RequestBody List<ProprietaireChequeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified proprietaireCheque")
    @DeleteMapping("")
    public ResponseEntity<ProprietaireChequeDto> delete(@RequestBody ProprietaireChequeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified proprietaireCheque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple proprietaireCheques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds proprietaireCheques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProprietaireChequeDto>> findByCriteria(@RequestBody ProprietaireChequeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated proprietaireCheques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProprietaireChequeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports proprietaireCheques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProprietaireChequeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets proprietaireCheque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProprietaireChequeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets proprietaireCheque history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets proprietaireCheque paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ProprietaireChequeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports proprietaireCheque history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ProprietaireChequeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets proprietaireCheque history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ProprietaireChequeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ProprietaireChequeRestAdmin (ProprietaireChequeAdminService service, ProprietaireChequeConverter converter) {
        super(service, converter);
    }


}