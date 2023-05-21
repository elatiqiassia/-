package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.DevisItemFournisseur;
import ma.sir.easystock.bean.history.DevisItemFournisseurHistory;
import ma.sir.easystock.dao.criteria.core.DevisItemFournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.DevisItemFournisseurHistoryCriteria;
import ma.sir.easystock.service.facade.admin.DevisItemFournisseurAdminService;
import ma.sir.easystock.ws.converter.DevisItemFournisseurConverter;
import ma.sir.easystock.ws.dto.DevisItemFournisseurDto;
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

@Api("Manages devisItemFournisseur services")
@RestController
@RequestMapping("/api/admin/devisItemFournisseur/")
public class DevisItemFournisseurRestAdmin  extends AbstractController<DevisItemFournisseur, DevisItemFournisseurDto, DevisItemFournisseurHistory, DevisItemFournisseurCriteria, DevisItemFournisseurHistoryCriteria, DevisItemFournisseurAdminService, DevisItemFournisseurConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DevisItemFournisseurDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one devisItemFournisseur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple devisItemFournisseurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all devisItemFournisseurs")
    @GetMapping("")
    public ResponseEntity<List<DevisItemFournisseurDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a devisItemFournisseur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DevisItemFournisseurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  devisItemFournisseur")
    @PostMapping("")
    public ResponseEntity<DevisItemFournisseurDto> save(@RequestBody DevisItemFournisseurDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  devisItemFournisseur")
    @PutMapping("")
    public ResponseEntity<DevisItemFournisseurDto> update(@RequestBody DevisItemFournisseurDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of devisItemFournisseur")
    @PostMapping("multiple")
    public ResponseEntity<List<DevisItemFournisseurDto>> delete(@RequestBody List<DevisItemFournisseurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified devisItemFournisseur")
    @DeleteMapping("")
    public ResponseEntity<DevisItemFournisseurDto> delete(@RequestBody DevisItemFournisseurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified devisItemFournisseur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple devisItemFournisseurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<DevisItemFournisseur> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("find by devisFournisseur id")
    @GetMapping("devisFournisseur/id/{id}")
    public List<DevisItemFournisseur> findByDevisFournisseurId(@PathVariable Long id){
        return service.findByDevisFournisseurId(id);
    }
    @ApiOperation("delete by devisFournisseur id")
    @DeleteMapping("devisFournisseur/id/{id}")
    public int deleteByDevisFournisseurId(@PathVariable Long id){
        return service.deleteByDevisFournisseurId(id);
    }
    @ApiOperation("Finds devisItemFournisseurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DevisItemFournisseurDto>> findByCriteria(@RequestBody DevisItemFournisseurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated devisItemFournisseurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DevisItemFournisseurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports devisItemFournisseurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DevisItemFournisseurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets devisItemFournisseur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DevisItemFournisseurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets devisItemFournisseur history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets devisItemFournisseur paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DevisItemFournisseurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports devisItemFournisseur history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DevisItemFournisseurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets devisItemFournisseur history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DevisItemFournisseurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DevisItemFournisseurRestAdmin (DevisItemFournisseurAdminService service, DevisItemFournisseurConverter converter) {
        super(service, converter);
    }


}