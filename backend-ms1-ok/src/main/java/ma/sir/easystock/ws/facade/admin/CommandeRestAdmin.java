package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Commande;
import ma.sir.easystock.bean.history.CommandeHistory;
import ma.sir.easystock.dao.criteria.core.CommandeCriteria;
import ma.sir.easystock.dao.criteria.history.CommandeHistoryCriteria;
import ma.sir.easystock.service.facade.admin.CommandeAdminService;
import ma.sir.easystock.ws.converter.CommandeConverter;
import ma.sir.easystock.ws.dto.CommandeDto;
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

@Api("Manages commande services")
@RestController
@RequestMapping("/api/admin/commande/")
public class CommandeRestAdmin  extends AbstractController<Commande, CommandeDto, CommandeHistory, CommandeCriteria, CommandeHistoryCriteria, CommandeAdminService, CommandeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody CommandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one commande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple commandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all commandes")
    @GetMapping("")
    public ResponseEntity<List<CommandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all commandes")
    @GetMapping("optimized")
    public ResponseEntity<List<CommandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a commande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  commande")
    @PostMapping("")
    public ResponseEntity<CommandeDto> save(@RequestBody CommandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  commande")
    @PutMapping("")
    public ResponseEntity<CommandeDto> update(@RequestBody CommandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of commande")
    @PostMapping("multiple")
    public ResponseEntity<List<CommandeDto>> delete(@RequestBody List<CommandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified commande")
    @DeleteMapping("")
    public ResponseEntity<CommandeDto> delete(@RequestBody CommandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified commande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple commandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Commande> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by etatCommande id")
    @GetMapping("etatCommande/id/{id}")
    public List<Commande> findByEtatCommandeId(@PathVariable Long id){
        return service.findByEtatCommandeId(id);
    }
    @ApiOperation("delete by etatCommande id")
    @DeleteMapping("etatCommande/id/{id}")
    public int deleteByEtatCommandeId(@PathVariable Long id){
        return service.deleteByEtatCommandeId(id);
    }
    @ApiOperation("Finds a commande and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<CommandeDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds commandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CommandeDto>> findByCriteria(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated commandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports commandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets commande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CommandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets commande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets commande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CommandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports commande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CommandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets commande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CommandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CommandeRestAdmin (CommandeAdminService service, CommandeConverter converter) {
        super(service, converter);
    }


}