package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.PaiementVente;
import ma.sir.easystock.bean.history.PaiementVenteHistory;
import ma.sir.easystock.dao.criteria.core.PaiementVenteCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementVenteHistoryCriteria;
import ma.sir.easystock.service.facade.admin.PaiementVenteAdminService;
import ma.sir.easystock.ws.converter.PaiementVenteConverter;
import ma.sir.easystock.ws.dto.PaiementVenteDto;
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

@Api("Manages paiementVente services")
@RestController
@RequestMapping("/api/admin/paiementVente/")
public class PaiementVenteRestAdmin  extends AbstractController<PaiementVente, PaiementVenteDto, PaiementVenteHistory, PaiementVenteCriteria, PaiementVenteHistoryCriteria, PaiementVenteAdminService, PaiementVenteConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one paiementVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple paiementVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all paiementVentes")
    @GetMapping("")
    public ResponseEntity<List<PaiementVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all paiementVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a paiementVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  paiementVente")
    @PostMapping("")
    public ResponseEntity<PaiementVenteDto> save(@RequestBody PaiementVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  paiementVente")
    @PutMapping("")
    public ResponseEntity<PaiementVenteDto> update(@RequestBody PaiementVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of paiementVente")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementVenteDto>> delete(@RequestBody List<PaiementVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified paiementVente")
    @DeleteMapping("")
    public ResponseEntity<PaiementVenteDto> delete(@RequestBody PaiementVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified paiementVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple paiementVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by vente id")
    @GetMapping("vente/id/{id}")
    public List<PaiementVente> findByVenteId(@PathVariable Long id){
        return service.findByVenteId(id);
    }
    @ApiOperation("delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @ApiOperation("find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementVente> findByModePaiementId(@PathVariable Long id){
        return service.findByModePaiementId(id);
    }
    @ApiOperation("delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @ApiOperation("find by etatPaiementVente id")
    @GetMapping("etatPaiementVente/id/{id}")
    public List<PaiementVente> findByEtatPaiementVenteId(@PathVariable Long id){
        return service.findByEtatPaiementVenteId(id);
    }
    @ApiOperation("delete by etatPaiementVente id")
    @DeleteMapping("etatPaiementVente/id/{id}")
    public int deleteByEtatPaiementVenteId(@PathVariable Long id){
        return service.deleteByEtatPaiementVenteId(id);
    }
    @ApiOperation("Finds paiementVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementVenteDto>> findByCriteria(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated paiementVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets paiementVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets paiementVente history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets paiementVente paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaiementVenteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports paiementVente history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaiementVenteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets paiementVente history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaiementVenteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaiementVenteRestAdmin (PaiementVenteAdminService service, PaiementVenteConverter converter) {
        super(service, converter);
    }


}