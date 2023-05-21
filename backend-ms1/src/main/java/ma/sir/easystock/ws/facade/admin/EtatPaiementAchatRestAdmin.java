package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatPaiementAchat;
import ma.sir.easystock.bean.history.EtatPaiementAchatHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementAchatHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatPaiementAchatAdminService;
import ma.sir.easystock.ws.converter.EtatPaiementAchatConverter;
import ma.sir.easystock.ws.dto.EtatPaiementAchatDto;
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

@Api("Manages etatPaiementAchat services")
@RestController
@RequestMapping("/api/admin/etatPaiementAchat/")
public class EtatPaiementAchatRestAdmin  extends AbstractController<EtatPaiementAchat, EtatPaiementAchatDto, EtatPaiementAchatHistory, EtatPaiementAchatCriteria, EtatPaiementAchatHistoryCriteria, EtatPaiementAchatAdminService, EtatPaiementAchatConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatPaiementAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatPaiementAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatPaiementAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatPaiementAchats")
    @GetMapping("")
    public ResponseEntity<List<EtatPaiementAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatPaiementAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatPaiementAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatPaiementAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatPaiementAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatPaiementAchat")
    @PostMapping("")
    public ResponseEntity<EtatPaiementAchatDto> save(@RequestBody EtatPaiementAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatPaiementAchat")
    @PutMapping("")
    public ResponseEntity<EtatPaiementAchatDto> update(@RequestBody EtatPaiementAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatPaiementAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatPaiementAchatDto>> delete(@RequestBody List<EtatPaiementAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatPaiementAchat")
    @DeleteMapping("")
    public ResponseEntity<EtatPaiementAchatDto> delete(@RequestBody EtatPaiementAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatPaiementAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatPaiementAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatPaiementAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatPaiementAchatDto>> findByCriteria(@RequestBody EtatPaiementAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatPaiementAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatPaiementAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatPaiementAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatPaiementAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatPaiementAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatPaiementAchat history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatPaiementAchat paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatPaiementAchatHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementAchat history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatPaiementAchatHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatPaiementAchat history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatPaiementAchatHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatPaiementAchatRestAdmin (EtatPaiementAchatAdminService service, EtatPaiementAchatConverter converter) {
        super(service, converter);
    }


}