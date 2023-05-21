package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.ProprietaireChequeBanque;
import ma.sir.easystock.bean.history.ProprietaireChequeBanqueHistory;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeBanqueCriteria;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeBanqueHistoryCriteria;
import ma.sir.easystock.service.facade.admin.ProprietaireChequeBanqueAdminService;
import ma.sir.easystock.ws.converter.ProprietaireChequeBanqueConverter;
import ma.sir.easystock.ws.dto.ProprietaireChequeBanqueDto;
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

@Api("Manages proprietaireChequeBanque services")
@RestController
@RequestMapping("/api/admin/proprietaireChequeBanque/")
public class ProprietaireChequeBanqueRestAdmin  extends AbstractController<ProprietaireChequeBanque, ProprietaireChequeBanqueDto, ProprietaireChequeBanqueHistory, ProprietaireChequeBanqueCriteria, ProprietaireChequeBanqueHistoryCriteria, ProprietaireChequeBanqueAdminService, ProprietaireChequeBanqueConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ProprietaireChequeBanqueDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one proprietaireChequeBanque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple proprietaireChequeBanques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all proprietaireChequeBanques")
    @GetMapping("")
    public ResponseEntity<List<ProprietaireChequeBanqueDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a proprietaireChequeBanque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProprietaireChequeBanqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  proprietaireChequeBanque")
    @PostMapping("")
    public ResponseEntity<ProprietaireChequeBanqueDto> save(@RequestBody ProprietaireChequeBanqueDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  proprietaireChequeBanque")
    @PutMapping("")
    public ResponseEntity<ProprietaireChequeBanqueDto> update(@RequestBody ProprietaireChequeBanqueDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of proprietaireChequeBanque")
    @PostMapping("multiple")
    public ResponseEntity<List<ProprietaireChequeBanqueDto>> delete(@RequestBody List<ProprietaireChequeBanqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified proprietaireChequeBanque")
    @DeleteMapping("")
    public ResponseEntity<ProprietaireChequeBanqueDto> delete(@RequestBody ProprietaireChequeBanqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified proprietaireChequeBanque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple proprietaireChequeBanques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by proprietaireCheque id")
    @GetMapping("proprietaireCheque/id/{id}")
    public List<ProprietaireChequeBanque> findByProprietaireChequeId(@PathVariable Long id){
        return service.findByProprietaireChequeId(id);
    }
    @ApiOperation("delete by proprietaireCheque id")
    @DeleteMapping("proprietaireCheque/id/{id}")
    public int deleteByProprietaireChequeId(@PathVariable Long id){
        return service.deleteByProprietaireChequeId(id);
    }
    @ApiOperation("find by banque id")
    @GetMapping("banque/id/{id}")
    public List<ProprietaireChequeBanque> findByBanqueId(@PathVariable Long id){
        return service.findByBanqueId(id);
    }
    @ApiOperation("delete by banque id")
    @DeleteMapping("banque/id/{id}")
    public int deleteByBanqueId(@PathVariable Long id){
        return service.deleteByBanqueId(id);
    }
    @ApiOperation("Finds proprietaireChequeBanques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProprietaireChequeBanqueDto>> findByCriteria(@RequestBody ProprietaireChequeBanqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated proprietaireChequeBanques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProprietaireChequeBanqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports proprietaireChequeBanques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProprietaireChequeBanqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets proprietaireChequeBanque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProprietaireChequeBanqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets proprietaireChequeBanque history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets proprietaireChequeBanque paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ProprietaireChequeBanqueHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports proprietaireChequeBanque history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ProprietaireChequeBanqueHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets proprietaireChequeBanque history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ProprietaireChequeBanqueHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ProprietaireChequeBanqueRestAdmin (ProprietaireChequeBanqueAdminService service, ProprietaireChequeBanqueConverter converter) {
        super(service, converter);
    }


}