package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Societe;
import ma.sir.easystock.bean.history.SocieteHistory;
import ma.sir.easystock.dao.criteria.core.SocieteCriteria;
import ma.sir.easystock.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.easystock.service.facade.admin.SocieteAdminService;
import ma.sir.easystock.ws.converter.SocieteConverter;
import ma.sir.easystock.ws.dto.SocieteDto;
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

@Api("Manages societe services")
@RestController
@RequestMapping("/api/admin/societe/")
public class SocieteRestAdmin  extends AbstractController<Societe, SocieteDto, SocieteHistory, SocieteCriteria, SocieteHistoryCriteria, SocieteAdminService, SocieteConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SocieteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one societe")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple societes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all societes")
    @GetMapping("")
    public ResponseEntity<List<SocieteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all societes")
    @GetMapping("optimized")
    public ResponseEntity<List<SocieteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a societe by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SocieteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  societe")
    @PostMapping("")
    public ResponseEntity<SocieteDto> save(@RequestBody SocieteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  societe")
    @PutMapping("")
    public ResponseEntity<SocieteDto> update(@RequestBody SocieteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of societe")
    @PostMapping("multiple")
    public ResponseEntity<List<SocieteDto>> delete(@RequestBody List<SocieteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified societe")
    @DeleteMapping("")
    public ResponseEntity<SocieteDto> delete(@RequestBody SocieteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified societe")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple societes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by abonne id")
    @GetMapping("abonne/id/{id}")
    public List<Societe> findByAbonneId(@PathVariable Long id){
        return service.findByAbonneId(id);
    }
    @ApiOperation("delete by abonne id")
    @DeleteMapping("abonne/id/{id}")
    public int deleteByAbonneId(@PathVariable Long id){
        return service.deleteByAbonneId(id);
    }
    @ApiOperation("Finds a societe and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<SocieteDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds societes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SocieteDto>> findByCriteria(@RequestBody SocieteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated societes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SocieteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports societes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SocieteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets societe data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SocieteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets societe history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets societe paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SocieteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports societe history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SocieteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets societe history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SocieteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SocieteRestAdmin (SocieteAdminService service, SocieteConverter converter) {
        super(service, converter);
    }


}