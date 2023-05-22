package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatVente;
import ma.sir.easystock.bean.history.EtatVenteHistory;
import ma.sir.easystock.dao.criteria.core.EtatVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatVenteHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatVenteAdminService;
import ma.sir.easystock.ws.converter.EtatVenteConverter;
import ma.sir.easystock.ws.dto.EtatVenteDto;
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

@Api("Manages etatVente services")
@RestController
@RequestMapping("/api/admin/etatVente/")
public class EtatVenteRestAdmin  extends AbstractController<EtatVente, EtatVenteDto, EtatVenteHistory, EtatVenteCriteria, EtatVenteHistoryCriteria, EtatVenteAdminService, EtatVenteConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatVentes")
    @GetMapping("")
    public ResponseEntity<List<EtatVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatVente")
    @PostMapping("")
    public ResponseEntity<EtatVenteDto> save(@RequestBody EtatVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatVente")
    @PutMapping("")
    public ResponseEntity<EtatVenteDto> update(@RequestBody EtatVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatVente")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatVenteDto>> delete(@RequestBody List<EtatVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatVente")
    @DeleteMapping("")
    public ResponseEntity<EtatVenteDto> delete(@RequestBody EtatVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatVenteDto>> findByCriteria(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatVente history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatVente paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatVenteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatVente history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatVenteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatVente history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatVenteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatVenteRestAdmin (EtatVenteAdminService service, EtatVenteConverter converter) {
        super(service, converter);
    }


}