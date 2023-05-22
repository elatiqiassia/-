package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatAvoirAchat;
import ma.sir.easystock.bean.history.EtatAvoirAchatHistory;
import ma.sir.easystock.dao.criteria.core.EtatAvoirAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAvoirAchatHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatAvoirAchatAdminService;
import ma.sir.easystock.ws.converter.EtatAvoirAchatConverter;
import ma.sir.easystock.ws.dto.EtatAvoirAchatDto;
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

@Api("Manages etatAvoirAchat services")
@RestController
@RequestMapping("/api/admin/etatAvoirAchat/")
public class EtatAvoirAchatRestAdmin  extends AbstractController<EtatAvoirAchat, EtatAvoirAchatDto, EtatAvoirAchatHistory, EtatAvoirAchatCriteria, EtatAvoirAchatHistoryCriteria, EtatAvoirAchatAdminService, EtatAvoirAchatConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatAvoirAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatAvoirAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatAvoirAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatAvoirAchats")
    @GetMapping("")
    public ResponseEntity<List<EtatAvoirAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatAvoirAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatAvoirAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatAvoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAvoirAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatAvoirAchat")
    @PostMapping("")
    public ResponseEntity<EtatAvoirAchatDto> save(@RequestBody EtatAvoirAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatAvoirAchat")
    @PutMapping("")
    public ResponseEntity<EtatAvoirAchatDto> update(@RequestBody EtatAvoirAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatAvoirAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatAvoirAchatDto>> delete(@RequestBody List<EtatAvoirAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatAvoirAchat")
    @DeleteMapping("")
    public ResponseEntity<EtatAvoirAchatDto> delete(@RequestBody EtatAvoirAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatAvoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatAvoirAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatAvoirAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatAvoirAchatDto>> findByCriteria(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatAvoirAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatAvoirAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatAvoirAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatAvoirAchat history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatAvoirAchat paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatAvoirAchatHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatAvoirAchat history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatAvoirAchatHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatAvoirAchat history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatAvoirAchatHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatAvoirAchatRestAdmin (EtatAvoirAchatAdminService service, EtatAvoirAchatConverter converter) {
        super(service, converter);
    }


}