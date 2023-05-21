package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatAvoirVente;
import ma.sir.easystock.bean.history.EtatAvoirVenteHistory;
import ma.sir.easystock.dao.criteria.core.EtatAvoirVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAvoirVenteHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatAvoirVenteAdminService;
import ma.sir.easystock.ws.converter.EtatAvoirVenteConverter;
import ma.sir.easystock.ws.dto.EtatAvoirVenteDto;
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

@Api("Manages etatAvoirVente services")
@RestController
@RequestMapping("/api/admin/etatAvoirVente/")
public class EtatAvoirVenteRestAdmin  extends AbstractController<EtatAvoirVente, EtatAvoirVenteDto, EtatAvoirVenteHistory, EtatAvoirVenteCriteria, EtatAvoirVenteHistoryCriteria, EtatAvoirVenteAdminService, EtatAvoirVenteConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatAvoirVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatAvoirVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatAvoirVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatAvoirVentes")
    @GetMapping("")
    public ResponseEntity<List<EtatAvoirVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatAvoirVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatAvoirVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatAvoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAvoirVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatAvoirVente")
    @PostMapping("")
    public ResponseEntity<EtatAvoirVenteDto> save(@RequestBody EtatAvoirVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatAvoirVente")
    @PutMapping("")
    public ResponseEntity<EtatAvoirVenteDto> update(@RequestBody EtatAvoirVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatAvoirVente")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatAvoirVenteDto>> delete(@RequestBody List<EtatAvoirVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatAvoirVente")
    @DeleteMapping("")
    public ResponseEntity<EtatAvoirVenteDto> delete(@RequestBody EtatAvoirVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatAvoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatAvoirVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatAvoirVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatAvoirVenteDto>> findByCriteria(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatAvoirVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatAvoirVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatAvoirVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatAvoirVente history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatAvoirVente paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatAvoirVenteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatAvoirVente history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatAvoirVenteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatAvoirVente history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatAvoirVenteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatAvoirVenteRestAdmin (EtatAvoirVenteAdminService service, EtatAvoirVenteConverter converter) {
        super(service, converter);
    }


}