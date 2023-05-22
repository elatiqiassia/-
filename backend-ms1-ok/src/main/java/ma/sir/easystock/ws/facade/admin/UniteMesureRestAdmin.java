package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.UniteMesure;
import ma.sir.easystock.bean.history.UniteMesureHistory;
import ma.sir.easystock.dao.criteria.core.UniteMesureCriteria;
import ma.sir.easystock.dao.criteria.history.UniteMesureHistoryCriteria;
import ma.sir.easystock.service.facade.admin.UniteMesureAdminService;
import ma.sir.easystock.ws.converter.UniteMesureConverter;
import ma.sir.easystock.ws.dto.UniteMesureDto;
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

@Api("Manages uniteMesure services")
@RestController
@RequestMapping("/api/admin/uniteMesure/")
public class UniteMesureRestAdmin  extends AbstractController<UniteMesure, UniteMesureDto, UniteMesureHistory, UniteMesureCriteria, UniteMesureHistoryCriteria, UniteMesureAdminService, UniteMesureConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody UniteMesureDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one uniteMesure")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple uniteMesures")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all uniteMesures")
    @GetMapping("")
    public ResponseEntity<List<UniteMesureDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all uniteMesures")
    @GetMapping("optimized")
    public ResponseEntity<List<UniteMesureDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a uniteMesure by id")
    @GetMapping("id/{id}")
    public ResponseEntity<UniteMesureDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  uniteMesure")
    @PostMapping("")
    public ResponseEntity<UniteMesureDto> save(@RequestBody UniteMesureDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  uniteMesure")
    @PutMapping("")
    public ResponseEntity<UniteMesureDto> update(@RequestBody UniteMesureDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of uniteMesure")
    @PostMapping("multiple")
    public ResponseEntity<List<UniteMesureDto>> delete(@RequestBody List<UniteMesureDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified uniteMesure")
    @DeleteMapping("")
    public ResponseEntity<UniteMesureDto> delete(@RequestBody UniteMesureDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified uniteMesure")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple uniteMesures by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds uniteMesures by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<UniteMesureDto>> findByCriteria(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated uniteMesures by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports uniteMesures by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets uniteMesure data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets uniteMesure history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets uniteMesure paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody UniteMesureHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports uniteMesure history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody UniteMesureHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets uniteMesure history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody UniteMesureHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public UniteMesureRestAdmin (UniteMesureAdminService service, UniteMesureConverter converter) {
        super(service, converter);
    }


}