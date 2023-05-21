package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Produit;
import ma.sir.easystock.bean.history.ProduitHistory;
import ma.sir.easystock.dao.criteria.core.ProduitCriteria;
import ma.sir.easystock.dao.criteria.history.ProduitHistoryCriteria;
import ma.sir.easystock.service.facade.admin.ProduitAdminService;
import ma.sir.easystock.ws.converter.ProduitConverter;
import ma.sir.easystock.ws.dto.ProduitDto;
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

@Api("Manages produit services")
@RestController
@RequestMapping("/api/admin/produit/")
public class ProduitRestAdmin  extends AbstractController<Produit, ProduitDto, ProduitHistory, ProduitCriteria, ProduitHistoryCriteria, ProduitAdminService, ProduitConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ProduitDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one produit")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple produits")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all produits")
    @GetMapping("")
    public ResponseEntity<List<ProduitDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all produits")
    @GetMapping("optimized")
    public ResponseEntity<List<ProduitDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a produit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  produit")
    @PostMapping("")
    public ResponseEntity<ProduitDto> save(@RequestBody ProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  produit")
    @PutMapping("")
    public ResponseEntity<ProduitDto> update(@RequestBody ProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of produit")
    @PostMapping("multiple")
    public ResponseEntity<List<ProduitDto>> delete(@RequestBody List<ProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified produit")
    @DeleteMapping("")
    public ResponseEntity<ProduitDto> delete(@RequestBody ProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified produit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple produits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by categorieProduit id")
    @GetMapping("categorieProduit/id/{id}")
    public List<Produit> findByCategorieProduitId(@PathVariable Long id){
        return service.findByCategorieProduitId(id);
    }
    @ApiOperation("delete by categorieProduit id")
    @DeleteMapping("categorieProduit/id/{id}")
    public int deleteByCategorieProduitId(@PathVariable Long id){
        return service.deleteByCategorieProduitId(id);
    }
    @ApiOperation("find by uniteMesure id")
    @GetMapping("uniteMesure/id/{id}")
    public List<Produit> findByUniteMesureId(@PathVariable Long id){
        return service.findByUniteMesureId(id);
    }
    @ApiOperation("delete by uniteMesure id")
    @DeleteMapping("uniteMesure/id/{id}")
    public int deleteByUniteMesureId(@PathVariable Long id){
        return service.deleteByUniteMesureId(id);
    }
    @ApiOperation("find by marque id")
    @GetMapping("marque/id/{id}")
    public List<Produit> findByMarqueId(@PathVariable Long id){
        return service.findByMarqueId(id);
    }
    @ApiOperation("delete by marque id")
    @DeleteMapping("marque/id/{id}")
    public int deleteByMarqueId(@PathVariable Long id){
        return service.deleteByMarqueId(id);
    }
    @ApiOperation("find by store id")
    @GetMapping("store/id/{id}")
    public List<Produit> findByStoreId(@PathVariable Long id){
        return service.findByStoreId(id);
    }
    @ApiOperation("delete by store id")
    @DeleteMapping("store/id/{id}")
    public int deleteByStoreId(@PathVariable Long id){
        return service.deleteByStoreId(id);
    }
    @ApiOperation("Finds produits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProduitDto>> findByCriteria(@RequestBody ProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated produits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports produits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets produit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets produit history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets produit paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ProduitHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports produit history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ProduitHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets produit history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ProduitHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ProduitRestAdmin (ProduitAdminService service, ProduitConverter converter) {
        super(service, converter);
    }


}