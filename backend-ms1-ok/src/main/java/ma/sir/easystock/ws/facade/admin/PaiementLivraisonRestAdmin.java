package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.PaiementLivraison;
import ma.sir.easystock.bean.history.PaiementLivraisonHistory;
import ma.sir.easystock.dao.criteria.core.PaiementLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementLivraisonHistoryCriteria;
import ma.sir.easystock.service.facade.admin.PaiementLivraisonAdminService;
import ma.sir.easystock.ws.converter.PaiementLivraisonConverter;
import ma.sir.easystock.ws.dto.PaiementLivraisonDto;
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

@Api("Manages paiementLivraison services")
@RestController
@RequestMapping("/api/admin/paiementLivraison/")
public class PaiementLivraisonRestAdmin  extends AbstractController<PaiementLivraison, PaiementLivraisonDto, PaiementLivraisonHistory, PaiementLivraisonCriteria, PaiementLivraisonHistoryCriteria, PaiementLivraisonAdminService, PaiementLivraisonConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementLivraisonDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paiementLivraison")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paiementLivraisons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paiementLivraisons")
    @GetMapping("")
    public ResponseEntity<List<PaiementLivraisonDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paiementLivraisons")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementLivraisonDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paiementLivraison by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementLivraisonDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paiementLivraison")
    @PostMapping("")
    public ResponseEntity<PaiementLivraisonDto> save(@RequestBody PaiementLivraisonDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paiementLivraison")
    @PutMapping("")
    public ResponseEntity<PaiementLivraisonDto> update(@RequestBody PaiementLivraisonDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paiementLivraison")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementLivraisonDto>> delete(@RequestBody List<PaiementLivraisonDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paiementLivraison")
    @DeleteMapping("")
    public ResponseEntity<PaiementLivraisonDto> delete(@RequestBody PaiementLivraisonDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paiementLivraison")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paiementLivraisons by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by livraison id")
    @GetMapping("livraison/id/{id}")
    public List<PaiementLivraison> findByLivraisonId(@PathVariable Long id){
        return service.findByLivraisonId(id);
    }
    @ApiOperation("delete by livraison id")
    @DeleteMapping("livraison/id/{id}")
    public int deleteByLivraisonId(@PathVariable Long id){
        return service.deleteByLivraisonId(id);
    }
    @ApiOperation("find by vente id")
    @GetMapping("vente/id/{id}")
    public List<PaiementLivraison> findByVenteId(@PathVariable Long id){
        return service.findByVenteId(id);
    }
    @ApiOperation("delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @ApiOperation("find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementLivraison> findByModePaiementId(@PathVariable Long id){
        return service.findByModePaiementId(id);
    }
    @ApiOperation("delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @ApiOperation("find by etatPaiementLivraison id")
    @GetMapping("etatPaiementLivraison/id/{id}")
    public List<PaiementLivraison> findByEtatPaiementLivraisonId(@PathVariable Long id){
        return service.findByEtatPaiementLivraisonId(id);
    }
    @ApiOperation("delete by etatPaiementLivraison id")
    @DeleteMapping("etatPaiementLivraison/id/{id}")
    public int deleteByEtatPaiementLivraisonId(@PathVariable Long id){
        return service.deleteByEtatPaiementLivraisonId(id);
    }
    @ApiOperation("Finds paiementLivraisons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementLivraisonDto>> findByCriteria(@RequestBody PaiementLivraisonCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paiementLivraisons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementLivraisonCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementLivraisons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementLivraisonCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paiementLivraison data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementLivraisonCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paiementLivraison history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paiementLivraison paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaiementLivraisonHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementLivraison history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaiementLivraisonHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paiementLivraison history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaiementLivraisonHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaiementLivraisonRestAdmin (PaiementLivraisonAdminService service, PaiementLivraisonConverter converter) {
        super(service, converter);
    }


}