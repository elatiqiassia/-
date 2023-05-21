package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.AvoirVente;
import ma.sir.easystock.bean.history.AvoirVenteHistory;
import ma.sir.easystock.dao.criteria.core.AvoirVenteCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirVenteHistoryCriteria;
import ma.sir.easystock.service.facade.admin.AvoirVenteAdminService;
import ma.sir.easystock.ws.converter.AvoirVenteConverter;
import ma.sir.easystock.ws.dto.AvoirVenteDto;
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

@Api("Manages avoirVente services")
@RestController
@RequestMapping("/api/admin/avoirVente/")
public class AvoirVenteRestAdmin  extends AbstractController<AvoirVente, AvoirVenteDto, AvoirVenteHistory, AvoirVenteCriteria, AvoirVenteHistoryCriteria, AvoirVenteAdminService, AvoirVenteConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AvoirVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one avoirVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple avoirVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all avoirVentes")
    @GetMapping("")
    public ResponseEntity<List<AvoirVenteDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a avoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  avoirVente")
    @PostMapping("")
    public ResponseEntity<AvoirVenteDto> save(@RequestBody AvoirVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  avoirVente")
    @PutMapping("")
    public ResponseEntity<AvoirVenteDto> update(@RequestBody AvoirVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of avoirVente")
    @PostMapping("multiple")
    public ResponseEntity<List<AvoirVenteDto>> delete(@RequestBody List<AvoirVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified avoirVente")
    @DeleteMapping("")
    public ResponseEntity<AvoirVenteDto> delete(@RequestBody AvoirVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified avoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple avoirVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by vente id")
    @GetMapping("vente/id/{id}")
    public List<AvoirVente> findByVenteId(@PathVariable Long id){
        return service.findByVenteId(id);
    }
    @ApiOperation("delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @ApiOperation("find by etatAvoirVente id")
    @GetMapping("etatAvoirVente/id/{id}")
    public List<AvoirVente> findByEtatAvoirVenteId(@PathVariable Long id){
        return service.findByEtatAvoirVenteId(id);
    }
    @ApiOperation("delete by etatAvoirVente id")
    @DeleteMapping("etatAvoirVente/id/{id}")
    public int deleteByEtatAvoirVenteId(@PathVariable Long id){
        return service.deleteByEtatAvoirVenteId(id);
    }
    @ApiOperation("Finds a avoirVente and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<AvoirVenteDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds avoirVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvoirVenteDto>> findByCriteria(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated avoirVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports avoirVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets avoirVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvoirVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets avoirVente history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets avoirVente paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AvoirVenteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports avoirVente history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AvoirVenteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets avoirVente history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AvoirVenteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AvoirVenteRestAdmin (AvoirVenteAdminService service, AvoirVenteConverter converter) {
        super(service, converter);
    }


}