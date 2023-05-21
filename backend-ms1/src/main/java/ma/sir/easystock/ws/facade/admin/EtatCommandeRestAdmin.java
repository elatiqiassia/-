package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.EtatCommande;
import ma.sir.easystock.bean.history.EtatCommandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatCommandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.EtatCommandeAdminService;
import ma.sir.easystock.ws.converter.EtatCommandeConverter;
import ma.sir.easystock.ws.dto.EtatCommandeDto;
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

@Api("Manages etatCommande services")
@RestController
@RequestMapping("/api/admin/etatCommande/")
public class EtatCommandeRestAdmin  extends AbstractController<EtatCommande, EtatCommandeDto, EtatCommandeHistory, EtatCommandeCriteria, EtatCommandeHistoryCriteria, EtatCommandeAdminService, EtatCommandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatCommandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatCommande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatCommandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatCommandes")
    @GetMapping("")
    public ResponseEntity<List<EtatCommandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatCommandes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatCommandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatCommande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatCommandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatCommande")
    @PostMapping("")
    public ResponseEntity<EtatCommandeDto> save(@RequestBody EtatCommandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatCommande")
    @PutMapping("")
    public ResponseEntity<EtatCommandeDto> update(@RequestBody EtatCommandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatCommande")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatCommandeDto>> delete(@RequestBody List<EtatCommandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatCommande")
    @DeleteMapping("")
    public ResponseEntity<EtatCommandeDto> delete(@RequestBody EtatCommandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatCommande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatCommandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatCommandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatCommandeDto>> findByCriteria(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatCommandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatCommandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatCommande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatCommande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatCommande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatCommandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatCommande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatCommandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatCommande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatCommandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatCommandeRestAdmin (EtatCommandeAdminService service, EtatCommandeConverter converter) {
        super(service, converter);
    }


}