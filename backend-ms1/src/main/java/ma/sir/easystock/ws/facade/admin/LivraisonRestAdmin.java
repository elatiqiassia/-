package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Livraison;
import ma.sir.easystock.bean.history.LivraisonHistory;
import ma.sir.easystock.dao.criteria.core.LivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.LivraisonHistoryCriteria;
import ma.sir.easystock.service.facade.admin.LivraisonAdminService;
import ma.sir.easystock.ws.converter.LivraisonConverter;
import ma.sir.easystock.ws.dto.LivraisonDto;
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

@Api("Manages livraison services")
@RestController
@RequestMapping("/api/admin/livraison/")
public class LivraisonRestAdmin  extends AbstractController<Livraison, LivraisonDto, LivraisonHistory, LivraisonCriteria, LivraisonHistoryCriteria, LivraisonAdminService, LivraisonConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody LivraisonDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one livraison")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple livraisons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all livraisons")
    @GetMapping("")
    public ResponseEntity<List<LivraisonDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a livraison by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LivraisonDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  livraison")
    @PostMapping("")
    public ResponseEntity<LivraisonDto> save(@RequestBody LivraisonDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  livraison")
    @PutMapping("")
    public ResponseEntity<LivraisonDto> update(@RequestBody LivraisonDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of livraison")
    @PostMapping("multiple")
    public ResponseEntity<List<LivraisonDto>> delete(@RequestBody List<LivraisonDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified livraison")
    @DeleteMapping("")
    public ResponseEntity<LivraisonDto> delete(@RequestBody LivraisonDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified livraison")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple livraisons by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by demande id")
    @GetMapping("demande/id/{id}")
    public List<Livraison> findByDemandeId(@PathVariable Long id){
        return service.findByDemandeId(id);
    }
    @ApiOperation("delete by demande id")
    @DeleteMapping("demande/id/{id}")
    public int deleteByDemandeId(@PathVariable Long id){
        return service.deleteByDemandeId(id);
    }
    @ApiOperation("find by etatLivraison id")
    @GetMapping("etatLivraison/id/{id}")
    public List<Livraison> findByEtatLivraisonId(@PathVariable Long id){
        return service.findByEtatLivraisonId(id);
    }
    @ApiOperation("delete by etatLivraison id")
    @DeleteMapping("etatLivraison/id/{id}")
    public int deleteByEtatLivraisonId(@PathVariable Long id){
        return service.deleteByEtatLivraisonId(id);
    }
    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Livraison> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("Finds a livraison and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<LivraisonDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds livraisons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LivraisonDto>> findByCriteria(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated livraisons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports livraisons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets livraison data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets livraison history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets livraison paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody LivraisonHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports livraison history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody LivraisonHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets livraison history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody LivraisonHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public LivraisonRestAdmin (LivraisonAdminService service, LivraisonConverter converter) {
        super(service, converter);
    }


}