package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.PaiementAchat;
import ma.sir.easystock.bean.history.PaiementAchatHistory;
import ma.sir.easystock.dao.criteria.core.PaiementAchatCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementAchatHistoryCriteria;
import ma.sir.easystock.service.facade.admin.PaiementAchatAdminService;
import ma.sir.easystock.ws.converter.PaiementAchatConverter;
import ma.sir.easystock.ws.dto.PaiementAchatDto;
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

@Api("Manages paiementAchat services")
@RestController
@RequestMapping("/api/admin/paiementAchat/")
public class PaiementAchatRestAdmin  extends AbstractController<PaiementAchat, PaiementAchatDto, PaiementAchatHistory, PaiementAchatCriteria, PaiementAchatHistoryCriteria, PaiementAchatAdminService, PaiementAchatConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paiementAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paiementAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paiementAchats")
    @GetMapping("")
    public ResponseEntity<List<PaiementAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paiementAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paiementAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paiementAchat")
    @PostMapping("")
    public ResponseEntity<PaiementAchatDto> save(@RequestBody PaiementAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paiementAchat")
    @PutMapping("")
    public ResponseEntity<PaiementAchatDto> update(@RequestBody PaiementAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paiementAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementAchatDto>> delete(@RequestBody List<PaiementAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paiementAchat")
    @DeleteMapping("")
    public ResponseEntity<PaiementAchatDto> delete(@RequestBody PaiementAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paiementAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paiementAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by achat id")
    @GetMapping("achat/id/{id}")
    public List<PaiementAchat> findByAchatId(@PathVariable Long id){
        return service.findByAchatId(id);
    }
    @ApiOperation("delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @ApiOperation("find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementAchat> findByModePaiementId(@PathVariable Long id){
        return service.findByModePaiementId(id);
    }
    @ApiOperation("delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @ApiOperation("find by etatPaiementAchat id")
    @GetMapping("etatPaiementAchat/id/{id}")
    public List<PaiementAchat> findByEtatPaiementAchatId(@PathVariable Long id){
        return service.findByEtatPaiementAchatId(id);
    }
    @ApiOperation("delete by etatPaiementAchat id")
    @DeleteMapping("etatPaiementAchat/id/{id}")
    public int deleteByEtatPaiementAchatId(@PathVariable Long id){
        return service.deleteByEtatPaiementAchatId(id);
    }
    @ApiOperation("Finds paiementAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementAchatDto>> findByCriteria(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paiementAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paiementAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paiementAchat history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paiementAchat paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaiementAchatHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementAchat history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaiementAchatHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paiementAchat history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaiementAchatHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaiementAchatRestAdmin (PaiementAchatAdminService service, PaiementAchatConverter converter) {
        super(service, converter);
    }


}