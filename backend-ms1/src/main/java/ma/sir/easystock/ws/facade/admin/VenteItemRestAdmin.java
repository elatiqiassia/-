package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.VenteItem;
import ma.sir.easystock.bean.history.VenteItemHistory;
import ma.sir.easystock.dao.criteria.core.VenteItemCriteria;
import ma.sir.easystock.dao.criteria.history.VenteItemHistoryCriteria;
import ma.sir.easystock.service.facade.admin.VenteItemAdminService;
import ma.sir.easystock.ws.converter.VenteItemConverter;
import ma.sir.easystock.ws.dto.VenteItemDto;
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

@Api("Manages venteItem services")
@RestController
@RequestMapping("/api/admin/venteItem/")
public class VenteItemRestAdmin  extends AbstractController<VenteItem, VenteItemDto, VenteItemHistory, VenteItemCriteria, VenteItemHistoryCriteria, VenteItemAdminService, VenteItemConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody VenteItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one venteItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple venteItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all venteItems")
    @GetMapping("")
    public ResponseEntity<List<VenteItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a venteItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VenteItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  venteItem")
    @PostMapping("")
    public ResponseEntity<VenteItemDto> save(@RequestBody VenteItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  venteItem")
    @PutMapping("")
    public ResponseEntity<VenteItemDto> update(@RequestBody VenteItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of venteItem")
    @PostMapping("multiple")
    public ResponseEntity<List<VenteItemDto>> delete(@RequestBody List<VenteItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified venteItem")
    @DeleteMapping("")
    public ResponseEntity<VenteItemDto> delete(@RequestBody VenteItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified venteItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple venteItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<VenteItem> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("find by vente id")
    @GetMapping("vente/id/{id}")
    public List<VenteItem> findByVenteId(@PathVariable Long id){
        return service.findByVenteId(id);
    }
    @ApiOperation("delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @ApiOperation("Finds venteItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VenteItemDto>> findByCriteria(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated venteItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports venteItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets venteItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets venteItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets venteItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody VenteItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports venteItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody VenteItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets venteItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody VenteItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public VenteItemRestAdmin (VenteItemAdminService service, VenteItemConverter converter) {
        super(service, converter);
    }


}