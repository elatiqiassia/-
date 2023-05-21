import {Component, OnInit} from '@angular/core';
import {StoreService} from 'src/app/controller/service/Store.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreCriteria} from 'src/app/controller/criteria/StoreCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SocieteService } from 'src/app/controller/service/Societe.service';

import {SocieteDto} from 'src/app/controller/model/Societe.model';


@Component({
  selector: 'app-store-list-admin',
  templateUrl: './store-list-admin.component.html'
})
export class StoreListAdminComponent extends AbstractListController<StoreDto, StoreCriteria, StoreService>  implements OnInit {

    fileName = 'Store';

    societes :Array<SocieteDto>;
  
    constructor(storeService: StoreService, private societeService: SocieteService) {
        super(storeService);
        this.pdfName='Store.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSociete();
    }

    public async loadStores(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Store', 'list');
        isPermistted ? this.service.findAll().subscribe(stores => this.items = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'reference', header: 'Reference'},
            {field: 'societe?.ice', header: 'Societe'},
        ];
    }


    public async loadSociete(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Store', 'list');
        isPermistted ? this.societeService.findAllOptimized().subscribe(societes => this.societes = societes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: StoreDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Reference': e.reference ,
                'Societe': e.societe?.ice ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
        //'Societe': this.criteria.societe?.ice ? this.criteria.societe?.ice : environment.emptyForExport ,
        }];
      }
}
