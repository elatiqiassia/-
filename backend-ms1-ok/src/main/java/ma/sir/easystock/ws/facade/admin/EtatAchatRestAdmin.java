package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatAchat;
import ma.sir.easystock.bean.history.EtatAchatHistory;
import ma.sir.easystock.dao.criteria.core.EtatAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAchatHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatAchatAdminService;
import ma.sir.easystock.ws.converter.EtatAchatConverter;
import ma.sir.easystock.ws.dto.EtatAchatDto;
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

@Api("Manages etatAchat services")
@RestController
@RequestMapping("/api/admin/etatAchat/")
public class EtatAchatRestAdmin  extends AbstractController<EtatAchat, EtatAchatDto, EtatAchatHistory, EtatAchatCriteria, EtatAchatHistoryCriteria, EtatAchatAdminService, EtatAchatConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatAchats")
    @GetMapping("")
    public ResponseEntity<List<EtatAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatAchat")
    @PostMapping("")
    public ResponseEntity<EtatAchatDto> save(@RequestBody EtatAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatAchat")
    @PutMapping("")
    public ResponseEntity<EtatAchatDto> update(@RequestBody EtatAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatAchatDto>> delete(@RequestBody List<EtatAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatAchat")
    @DeleteMapping("")
    public ResponseEntity<EtatAchatDto> delete(@RequestBody EtatAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatAchatDto>> findByCriteria(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatAchat history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatAchat paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatAchatHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatAchat history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatAchatHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatAchat history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatAchatHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatAchatRestAdmin (EtatAchatAdminService service, EtatAchatConverter converter) {
        super(service, converter);
    }


}