package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Reception;
import ma.sir.easystock.bean.history.ReceptionHistory;
import ma.sir.easystock.dao.criteria.core.ReceptionCriteria;
import ma.sir.easystock.dao.criteria.history.ReceptionHistoryCriteria;
import ma.sir.easystock.service.facade.admin.ReceptionAdminService;
import ma.sir.easystock.ws.converter.ReceptionConverter;
import ma.sir.easystock.ws.dto.ReceptionDto;
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

@Api("Manages reception services")
@RestController
@RequestMapping("/api/admin/reception/")
public class ReceptionRestAdmin  extends AbstractController<Reception, ReceptionDto, ReceptionHistory, ReceptionCriteria, ReceptionHistoryCriteria, ReceptionAdminService, ReceptionConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReceptionDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one reception")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple receptions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all receptions")
    @GetMapping("")
    public ResponseEntity<List<ReceptionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all receptions")
    @GetMapping("optimized")
    public ResponseEntity<List<ReceptionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a reception by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReceptionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  reception")
    @PostMapping("")
    public ResponseEntity<ReceptionDto> save(@RequestBody ReceptionDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  reception")
    @PutMapping("")
    public ResponseEntity<ReceptionDto> update(@RequestBody ReceptionDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of reception")
    @PostMapping("multiple")
    public ResponseEntity<List<ReceptionDto>> delete(@RequestBody List<ReceptionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified reception")
    @DeleteMapping("")
    public ResponseEntity<ReceptionDto> delete(@RequestBody ReceptionDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified reception")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple receptions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by commande id")
    @GetMapping("commande/id/{id}")
    public List<Reception> findByCommandeId(@PathVariable Long id){
        return service.findByCommandeId(id);
    }
    @ApiOperation("delete by commande id")
    @DeleteMapping("commande/id/{id}")
    public int deleteByCommandeId(@PathVariable Long id){
        return service.deleteByCommandeId(id);
    }
    @ApiOperation("find by etatReception id")
    @GetMapping("etatReception/id/{id}")
    public List<Reception> findByEtatReceptionId(@PathVariable Long id){
        return service.findByEtatReceptionId(id);
    }
    @ApiOperation("delete by etatReception id")
    @DeleteMapping("etatReception/id/{id}")
    public int deleteByEtatReceptionId(@PathVariable Long id){
        return service.deleteByEtatReceptionId(id);
    }
    @ApiOperation("Finds a reception and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ReceptionDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds receptions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReceptionDto>> findByCriteria(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated receptions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports receptions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets reception data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets reception history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets reception paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ReceptionHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports reception history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ReceptionHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets reception history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ReceptionHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ReceptionRestAdmin (ReceptionAdminService service, ReceptionConverter converter) {
        super(service, converter);
    }


}