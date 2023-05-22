package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.AvoirAchat;
import ma.sir.easystock.bean.history.AvoirAchatHistory;
import ma.sir.easystock.dao.criteria.core.AvoirAchatCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirAchatHistoryCriteria;
import ma.sir.easystock.service.facade.admin.AvoirAchatAdminService;
import ma.sir.easystock.ws.converter.AvoirAchatConverter;
import ma.sir.easystock.ws.dto.AvoirAchatDto;
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

@Api("Manages avoirAchat services")
@RestController
@RequestMapping("/api/admin/avoirAchat/")
public class AvoirAchatRestAdmin  extends AbstractController<AvoirAchat, AvoirAchatDto, AvoirAchatHistory, AvoirAchatCriteria, AvoirAchatHistoryCriteria, AvoirAchatAdminService, AvoirAchatConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody AvoirAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one avoirAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple avoirAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all avoirAchats")
    @GetMapping("")
    public ResponseEntity<List<AvoirAchatDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a avoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  avoirAchat")
    @PostMapping("")
    public ResponseEntity<AvoirAchatDto> save(@RequestBody AvoirAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  avoirAchat")
    @PutMapping("")
    public ResponseEntity<AvoirAchatDto> update(@RequestBody AvoirAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of avoirAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<AvoirAchatDto>> delete(@RequestBody List<AvoirAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified avoirAchat")
    @DeleteMapping("")
    public ResponseEntity<AvoirAchatDto> delete(@RequestBody AvoirAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified avoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple avoirAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by achat id")
    @GetMapping("achat/id/{id}")
    public List<AvoirAchat> findByAchatId(@PathVariable Long id){
        return service.findByAchatId(id);
    }
    @ApiOperation("delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @ApiOperation("find by etatAvoirAchat id")
    @GetMapping("etatAvoirAchat/id/{id}")
    public List<AvoirAchat> findByEtatAvoirAchatId(@PathVariable Long id){
        return service.findByEtatAvoirAchatId(id);
    }
    @ApiOperation("delete by etatAvoirAchat id")
    @DeleteMapping("etatAvoirAchat/id/{id}")
    public int deleteByEtatAvoirAchatId(@PathVariable Long id){
        return service.deleteByEtatAvoirAchatId(id);
    }
    @ApiOperation("Finds a avoirAchat and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<AvoirAchatDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds avoirAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvoirAchatDto>> findByCriteria(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated avoirAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports avoirAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets avoirAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets avoirAchat history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets avoirAchat paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AvoirAchatHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports avoirAchat history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AvoirAchatHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets avoirAchat history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AvoirAchatHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AvoirAchatRestAdmin (AvoirAchatAdminService service, AvoirAchatConverter converter) {
        super(service, converter);
    }


}