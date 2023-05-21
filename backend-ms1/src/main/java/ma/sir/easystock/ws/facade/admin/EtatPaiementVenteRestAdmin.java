package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatPaiementVente;
import ma.sir.easystock.bean.history.EtatPaiementVenteHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementVenteHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatPaiementVenteAdminService;
import ma.sir.easystock.ws.converter.EtatPaiementVenteConverter;
import ma.sir.easystock.ws.dto.EtatPaiementVenteDto;
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

@Api("Manages etatPaiementVente services")
@RestController
@RequestMapping("/api/admin/etatPaiementVente/")
public class EtatPaiementVenteRestAdmin  extends AbstractController<EtatPaiementVente, EtatPaiementVenteDto, EtatPaiementVenteHistory, EtatPaiementVenteCriteria, EtatPaiementVenteHistoryCriteria, EtatPaiementVenteAdminService, EtatPaiementVenteConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatPaiementVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatPaiementVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatPaiementVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatPaiementVentes")
    @GetMapping("")
    public ResponseEntity<List<EtatPaiementVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatPaiementVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatPaiementVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatPaiementVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatPaiementVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatPaiementVente")
    @PostMapping("")
    public ResponseEntity<EtatPaiementVenteDto> save(@RequestBody EtatPaiementVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatPaiementVente")
    @PutMapping("")
    public ResponseEntity<EtatPaiementVenteDto> update(@RequestBody EtatPaiementVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatPaiementVente")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatPaiementVenteDto>> delete(@RequestBody List<EtatPaiementVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatPaiementVente")
    @DeleteMapping("")
    public ResponseEntity<EtatPaiementVenteDto> delete(@RequestBody EtatPaiementVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatPaiementVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatPaiementVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatPaiementVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatPaiementVenteDto>> findByCriteria(@RequestBody EtatPaiementVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatPaiementVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatPaiementVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatPaiementVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatPaiementVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatPaiementVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatPaiementVente history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatPaiementVente paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatPaiementVenteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatPaiementVente history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatPaiementVenteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatPaiementVente history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatPaiementVenteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatPaiementVenteRestAdmin (EtatPaiementVenteAdminService service, EtatPaiementVenteConverter converter) {
        super(service, converter);
    }


}