package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.PaiementCommande;
import ma.sir.easystock.bean.history.PaiementCommandeHistory;
import ma.sir.easystock.dao.criteria.core.PaiementCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementCommandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.PaiementCommandeAdminService;
import ma.sir.easystock.ws.converter.PaiementCommandeConverter;
import ma.sir.easystock.ws.dto.PaiementCommandeDto;
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

@Api("Manages paiementCommande services")
@RestController
@RequestMapping("/api/admin/paiementCommande/")
public class PaiementCommandeRestAdmin  extends AbstractController<PaiementCommande, PaiementCommandeDto, PaiementCommandeHistory, PaiementCommandeCriteria, PaiementCommandeHistoryCriteria, PaiementCommandeAdminService, PaiementCommandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementCommandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paiementCommande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paiementCommandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paiementCommandes")
    @GetMapping("")
    public ResponseEntity<List<PaiementCommandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paiementCommandes")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementCommandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paiementCommande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementCommandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paiementCommande")
    @PostMapping("")
    public ResponseEntity<PaiementCommandeDto> save(@RequestBody PaiementCommandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paiementCommande")
    @PutMapping("")
    public ResponseEntity<PaiementCommandeDto> update(@RequestBody PaiementCommandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paiementCommande")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementCommandeDto>> delete(@RequestBody List<PaiementCommandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paiementCommande")
    @DeleteMapping("")
    public ResponseEntity<PaiementCommandeDto> delete(@RequestBody PaiementCommandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paiementCommande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paiementCommandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by commande id")
    @GetMapping("commande/id/{id}")
    public List<PaiementCommande> findByCommandeId(@PathVariable Long id){
        return service.findByCommandeId(id);
    }
    @ApiOperation("delete by commande id")
    @DeleteMapping("commande/id/{id}")
    public int deleteByCommandeId(@PathVariable Long id){
        return service.deleteByCommandeId(id);
    }
    @ApiOperation("find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementCommande> findByModePaiementId(@PathVariable Long id){
        return service.findByModePaiementId(id);
    }
    @ApiOperation("delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @ApiOperation("find by etatPaiementCommande id")
    @GetMapping("etatPaiementCommande/id/{id}")
    public List<PaiementCommande> findByEtatPaiementCommandeId(@PathVariable Long id){
        return service.findByEtatPaiementCommandeId(id);
    }
    @ApiOperation("delete by etatPaiementCommande id")
    @DeleteMapping("etatPaiementCommande/id/{id}")
    public int deleteByEtatPaiementCommandeId(@PathVariable Long id){
        return service.deleteByEtatPaiementCommandeId(id);
    }
    @ApiOperation("Finds paiementCommandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementCommandeDto>> findByCriteria(@RequestBody PaiementCommandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paiementCommandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementCommandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementCommandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementCommandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paiementCommande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementCommandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paiementCommande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paiementCommande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaiementCommandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementCommande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaiementCommandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paiementCommande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaiementCommandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaiementCommandeRestAdmin (PaiementCommandeAdminService service, PaiementCommandeConverter converter) {
        super(service, converter);
    }


}