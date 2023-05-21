import {Component, OnInit} from '@angular/core';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementCriteria} from 'src/app/controller/criteria/ModePaiementCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-mode-paiement-list-admin',
  templateUrl: './mode-paiement-list-admin.component.html'
})
export class ModePaiementListAdminComponent extends AbstractListController<ModePaiementDto, ModePaiementCriteria, ModePaiementService>  implements OnInit {

    fileName = 'ModePaiement';

  
    constructor(modePaiementService: ModePaiementService) {
        super(modePaiementService);
        this.pdfName='ModePaiement.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadModePaiements(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ModePaiement', 'list');
        isPermistted ? this.service.findAll().subscribe(modePaiements => this.items = modePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: ModePaiementDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                 'Style': e.style ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Style': this.criteria.style ? this.criteria.style : environment.emptyForExport ,
        }];
      }
}
