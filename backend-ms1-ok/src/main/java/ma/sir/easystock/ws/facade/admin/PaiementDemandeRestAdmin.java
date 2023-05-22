package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.PaiementDemande;
import ma.sir.easystock.bean.history.PaiementDemandeHistory;
import ma.sir.easystock.dao.criteria.core.PaiementDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementDemandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.PaiementDemandeAdminService;
import ma.sir.easystock.ws.converter.PaiementDemandeConverter;
import ma.sir.easystock.ws.dto.PaiementDemandeDto;
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

@Api("Manages paiementDemande services")
@RestController
@RequestMapping("/api/admin/paiementDemande/")
public class PaiementDemandeRestAdmin  extends AbstractController<PaiementDemande, PaiementDemandeDto, PaiementDemandeHistory, PaiementDemandeCriteria, PaiementDemandeHistoryCriteria, PaiementDemandeAdminService, PaiementDemandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementDemandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paiementDemande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paiementDemandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paiementDemandes")
    @GetMapping("")
    public ResponseEntity<List<PaiementDemandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paiementDemandes")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementDemandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paiementDemande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementDemandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paiementDemande")
    @PostMapping("")
    public ResponseEntity<PaiementDemandeDto> save(@RequestBody PaiementDemandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paiementDemande")
    @PutMapping("")
    public ResponseEntity<PaiementDemandeDto> update(@RequestBody PaiementDemandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paiementDemande")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementDemandeDto>> delete(@RequestBody List<PaiementDemandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paiementDemande")
    @DeleteMapping("")
    public ResponseEntity<PaiementDemandeDto> delete(@RequestBody PaiementDemandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paiementDemande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paiementDemandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by demande id")
    @GetMapping("demande/id/{id}")
    public List<PaiementDemande> findByDemandeId(@PathVariable Long id){
        return service.findByDemandeId(id);
    }
    @ApiOperation("delete by demande id")
    @DeleteMapping("demande/id/{id}")
    public int deleteByDemandeId(@PathVariable Long id){
        return service.deleteByDemandeId(id);
    }
    @ApiOperation("find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementDemande> findByModePaiementId(@PathVariable Long id){
        return service.findByModePaiementId(id);
    }
    @ApiOperation("delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @ApiOperation("find by etatPaiementDemande id")
    @GetMapping("etatPaiementDemande/id/{id}")
    public List<PaiementDemande> findByEtatPaiementDemandeId(@PathVariable Long id){
        return service.findByEtatPaiementDemandeId(id);
    }
    @ApiOperation("delete by etatPaiementDemande id")
    @DeleteMapping("etatPaiementDemande/id/{id}")
    public int deleteByEtatPaiementDemandeId(@PathVariable Long id){
        return service.deleteByEtatPaiementDemandeId(id);
    }
    @ApiOperation("Finds paiementDemandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementDemandeDto>> findByCriteria(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paiementDemandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementDemandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paiementDemande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paiementDemande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paiementDemande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaiementDemandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementDemande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaiementDemandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paiementDemande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaiementDemandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaiementDemandeRestAdmin (PaiementDemandeAdminService service, PaiementDemandeConverter converter) {
        super(service, converter);
    }


}