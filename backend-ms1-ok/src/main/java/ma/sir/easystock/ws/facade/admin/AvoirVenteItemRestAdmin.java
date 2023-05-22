package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.AvoirVenteItem;
import ma.sir.easystock.bean.history.AvoirVenteItemHistory;
import ma.sir.easystock.dao.criteria.core.AvoirVenteItemCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirVenteItemHistoryCriteria;
import ma.sir.easystock.service.facade.admin.AvoirVenteItemAdminService;
import ma.sir.easystock.ws.converter.AvoirVenteItemConverter;
import ma.sir.easystock.ws.dto.AvoirVenteItemDto;
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

@Api("Manages avoirVenteItem services")
@RestController
@RequestMapping("/api/admin/avoirVenteItem/")
public class AvoirVenteItemRestAdmin  extends AbstractController<AvoirVenteItem, AvoirVenteItemDto, AvoirVenteItemHistory, AvoirVenteItemCriteria, AvoirVenteItemHistoryCriteria, AvoirVenteItemAdminService, AvoirVenteItemConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AvoirVenteItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one avoirVenteItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple avoirVenteItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all avoirVenteItems")
    @GetMapping("")
    public ResponseEntity<List<AvoirVenteItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a avoirVenteItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirVenteItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  avoirVenteItem")
    @PostMapping("")
    public ResponseEntity<AvoirVenteItemDto> save(@RequestBody AvoirVenteItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  avoirVenteItem")
    @PutMapping("")
    public ResponseEntity<AvoirVenteItemDto> update(@RequestBody AvoirVenteItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of avoirVenteItem")
    @PostMapping("multiple")
    public ResponseEntity<List<AvoirVenteItemDto>> delete(@RequestBody List<AvoirVenteItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified avoirVenteItem")
    @DeleteMapping("")
    public ResponseEntity<AvoirVenteItemDto> delete(@RequestBody AvoirVenteItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified avoirVenteItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple avoirVenteItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<AvoirVenteItem> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("find by avoirVente id")
    @GetMapping("avoirVente/id/{id}")
    public List<AvoirVenteItem> findByAvoirVenteId(@PathVariable Long id){
        return service.findByAvoirVenteId(id);
    }
    @ApiOperation("delete by avoirVente id")
    @DeleteMapping("avoirVente/id/{id}")
    public int deleteByAvoirVenteId(@PathVariable Long id){
        return service.deleteByAvoirVenteId(id);
    }
    @ApiOperation("Finds avoirVenteItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvoirVenteItemDto>> findByCriteria(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated avoirVenteItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports avoirVenteItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets avoirVenteItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets avoirVenteItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets avoirVenteItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AvoirVenteItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports avoirVenteItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AvoirVenteItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets avoirVenteItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AvoirVenteItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AvoirVenteItemRestAdmin (AvoirVenteItemAdminService service, AvoirVenteItemConverter converter) {
        super(service, converter);
    }


}