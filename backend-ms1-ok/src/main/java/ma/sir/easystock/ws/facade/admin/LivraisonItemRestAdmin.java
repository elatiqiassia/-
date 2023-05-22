package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.LivraisonItem;
import ma.sir.easystock.bean.history.LivraisonItemHistory;
import ma.sir.easystock.dao.criteria.core.LivraisonItemCriteria;
import ma.sir.easystock.dao.criteria.history.LivraisonItemHistoryCriteria;
import ma.sir.easystock.service.facade.admin.LivraisonItemAdminService;
import ma.sir.easystock.ws.converter.LivraisonItemConverter;
import ma.sir.easystock.ws.dto.LivraisonItemDto;
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

@Api("Manages livraisonItem services")
@RestController
@RequestMapping("/api/admin/livraisonItem/")
public class LivraisonItemRestAdmin  extends AbstractController<LivraisonItem, LivraisonItemDto, LivraisonItemHistory, LivraisonItemCriteria, LivraisonItemHistoryCriteria, LivraisonItemAdminService, LivraisonItemConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody LivraisonItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one livraisonItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple livraisonItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all livraisonItems")
    @GetMapping("")
    public ResponseEntity<List<LivraisonItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a livraisonItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LivraisonItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  livraisonItem")
    @PostMapping("")
    public ResponseEntity<LivraisonItemDto> save(@RequestBody LivraisonItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  livraisonItem")
    @PutMapping("")
    public ResponseEntity<LivraisonItemDto> update(@RequestBody LivraisonItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of livraisonItem")
    @PostMapping("multiple")
    public ResponseEntity<List<LivraisonItemDto>> delete(@RequestBody List<LivraisonItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified livraisonItem")
    @DeleteMapping("")
    public ResponseEntity<LivraisonItemDto> delete(@RequestBody LivraisonItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified livraisonItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple livraisonItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<LivraisonItem> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("find by magasin id")
    @GetMapping("magasin/id/{id}")
    public List<LivraisonItem> findByMagasinId(@PathVariable Long id){
        return service.findByMagasinId(id);
    }
    @ApiOperation("delete by magasin id")
    @DeleteMapping("magasin/id/{id}")
    public int deleteByMagasinId(@PathVariable Long id){
        return service.deleteByMagasinId(id);
    }
    @ApiOperation("find by livraison id")
    @GetMapping("livraison/id/{id}")
    public List<LivraisonItem> findByLivraisonId(@PathVariable Long id){
        return service.findByLivraisonId(id);
    }
    @ApiOperation("delete by livraison id")
    @DeleteMapping("livraison/id/{id}")
    public int deleteByLivraisonId(@PathVariable Long id){
        return service.deleteByLivraisonId(id);
    }
    @ApiOperation("Finds livraisonItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LivraisonItemDto>> findByCriteria(@RequestBody LivraisonItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated livraisonItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LivraisonItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports livraisonItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LivraisonItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets livraisonItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LivraisonItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets livraisonItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets livraisonItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody LivraisonItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports livraisonItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody LivraisonItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets livraisonItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody LivraisonItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public LivraisonItemRestAdmin (LivraisonItemAdminService service, LivraisonItemConverter converter) {
        super(service, converter);
    }


}