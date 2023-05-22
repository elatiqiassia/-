package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.CommandeItem;
import ma.sir.easystock.bean.history.CommandeItemHistory;
import ma.sir.easystock.dao.criteria.core.CommandeItemCriteria;
import ma.sir.easystock.dao.criteria.history.CommandeItemHistoryCriteria;
import ma.sir.easystock.service.facade.admin.CommandeItemAdminService;
import ma.sir.easystock.ws.converter.CommandeItemConverter;
import ma.sir.easystock.ws.dto.CommandeItemDto;
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

@Api("Manages commandeItem services")
@RestController
@RequestMapping("/api/admin/commandeItem/")
public class CommandeItemRestAdmin  extends AbstractController<CommandeItem, CommandeItemDto, CommandeItemHistory, CommandeItemCriteria, CommandeItemHistoryCriteria, CommandeItemAdminService, CommandeItemConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CommandeItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one commandeItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple commandeItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all commandeItems")
    @GetMapping("")
    public ResponseEntity<List<CommandeItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a commandeItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommandeItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  commandeItem")
    @PostMapping("")
    public ResponseEntity<CommandeItemDto> save(@RequestBody CommandeItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  commandeItem")
    @PutMapping("")
    public ResponseEntity<CommandeItemDto> update(@RequestBody CommandeItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of commandeItem")
    @PostMapping("multiple")
    public ResponseEntity<List<CommandeItemDto>> delete(@RequestBody List<CommandeItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified commandeItem")
    @DeleteMapping("")
    public ResponseEntity<CommandeItemDto> delete(@RequestBody CommandeItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified commandeItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple commandeItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<CommandeItem> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("find by commande id")
    @GetMapping("commande/id/{id}")
    public List<CommandeItem> findByCommandeId(@PathVariable Long id){
        return service.findByCommandeId(id);
    }
    @ApiOperation("delete by commande id")
    @DeleteMapping("commande/id/{id}")
    public int deleteByCommandeId(@PathVariable Long id){
        return service.deleteByCommandeId(id);
    }
    @ApiOperation("Finds commandeItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CommandeItemDto>> findByCriteria(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated commandeItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports commandeItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets commandeItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets commandeItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets commandeItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CommandeItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports commandeItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CommandeItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets commandeItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CommandeItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CommandeItemRestAdmin (CommandeItemAdminService service, CommandeItemConverter converter) {
        super(service, converter);
    }


}