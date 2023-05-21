package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.StockProduit;
import ma.sir.easystock.bean.history.StockProduitHistory;
import ma.sir.easystock.dao.criteria.core.StockProduitCriteria;
import ma.sir.easystock.dao.criteria.history.StockProduitHistoryCriteria;
import ma.sir.easystock.service.facade.admin.StockProduitAdminService;
import ma.sir.easystock.ws.converter.StockProduitConverter;
import ma.sir.easystock.ws.dto.StockProduitDto;
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

@Api("Manages stockProduit services")
@RestController
@RequestMapping("/api/admin/stockProduit/")
public class StockProduitRestAdmin  extends AbstractController<StockProduit, StockProduitDto, StockProduitHistory, StockProduitCriteria, StockProduitHistoryCriteria, StockProduitAdminService, StockProduitConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody StockProduitDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one stockProduit")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple stockProduits")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all stockProduits")
    @GetMapping("")
    public ResponseEntity<List<StockProduitDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a stockProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StockProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  stockProduit")
    @PostMapping("")
    public ResponseEntity<StockProduitDto> save(@RequestBody StockProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  stockProduit")
    @PutMapping("")
    public ResponseEntity<StockProduitDto> update(@RequestBody StockProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of stockProduit")
    @PostMapping("multiple")
    public ResponseEntity<List<StockProduitDto>> delete(@RequestBody List<StockProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified stockProduit")
    @DeleteMapping("")
    public ResponseEntity<StockProduitDto> delete(@RequestBody StockProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified stockProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple stockProduits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by magasin id")
    @GetMapping("magasin/id/{id}")
    public List<StockProduit> findByMagasinId(@PathVariable Long id){
        return service.findByMagasinId(id);
    }
    @ApiOperation("delete by magasin id")
    @DeleteMapping("magasin/id/{id}")
    public int deleteByMagasinId(@PathVariable Long id){
        return service.deleteByMagasinId(id);
    }
    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<StockProduit> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("Finds stockProduits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StockProduitDto>> findByCriteria(@RequestBody StockProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated stockProduits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StockProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports stockProduits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StockProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets stockProduit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StockProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets stockProduit history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets stockProduit paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StockProduitHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports stockProduit history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StockProduitHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets stockProduit history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StockProduitHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public StockProduitRestAdmin (StockProduitAdminService service, StockProduitConverter converter) {
        super(service, converter);
    }


}