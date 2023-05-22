package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.AchatItem;
import ma.sir.easystock.bean.history.AchatItemHistory;
import ma.sir.easystock.dao.criteria.core.AchatItemCriteria;
import ma.sir.easystock.dao.criteria.history.AchatItemHistoryCriteria;
import ma.sir.easystock.service.facade.admin.AchatItemAdminService;
import ma.sir.easystock.ws.converter.AchatItemConverter;
import ma.sir.easystock.ws.dto.AchatItemDto;
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

@Api("Manages achatItem services")
@RestController
@RequestMapping("/api/admin/achatItem/")
public class AchatItemRestAdmin  extends AbstractController<AchatItem, AchatItemDto, AchatItemHistory, AchatItemCriteria, AchatItemHistoryCriteria, AchatItemAdminService, AchatItemConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AchatItemDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one achatItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple achatItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all achatItems")
    @GetMapping("")
    public ResponseEntity<List<AchatItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a achatItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AchatItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  achatItem")
    @PostMapping("")
    public ResponseEntity<AchatItemDto> save(@RequestBody AchatItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  achatItem")
    @PutMapping("")
    public ResponseEntity<AchatItemDto> update(@RequestBody AchatItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of achatItem")
    @PostMapping("multiple")
    public ResponseEntity<List<AchatItemDto>> delete(@RequestBody List<AchatItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified achatItem")
    @DeleteMapping("")
    public ResponseEntity<AchatItemDto> delete(@RequestBody AchatItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified achatItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple achatItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by produit id")
    @GetMapping("produit/id/{id}")
    public List<AchatItem> findByProduitId(@PathVariable Long id){
        return service.findByProduitId(id);
    }
    @ApiOperation("delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @ApiOperation("find by achat id")
    @GetMapping("achat/id/{id}")
    public List<AchatItem> findByAchatId(@PathVariable Long id){
        return service.findByAchatId(id);
    }
    @ApiOperation("delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @ApiOperation("Finds achatItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AchatItemDto>> findByCriteria(@RequestBody AchatItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated achatItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AchatItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports achatItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AchatItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets achatItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AchatItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets achatItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets achatItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AchatItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports achatItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AchatItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets achatItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AchatItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AchatItemRestAdmin (AchatItemAdminService service, AchatItemConverter converter) {
        super(service, converter);
    }


}