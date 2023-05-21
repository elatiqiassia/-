import {Component, OnInit} from '@angular/core';
import {MagasinService} from 'src/app/controller/service/Magasin.service';
import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinCriteria} from 'src/app/controller/criteria/MagasinCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StoreService } from 'src/app/controller/service/Store.service';

import {StoreDto} from 'src/app/controller/model/Store.model';


@Component({
  selector: 'app-magasin-list-admin',
  templateUrl: './magasin-list-admin.component.html'
})
export class MagasinListAdminComponent extends AbstractListController<MagasinDto, MagasinCriteria, MagasinService>  implements OnInit {

    fileName = 'Magasin';

    stores :Array<StoreDto>;
  
    constructor(magasinService: MagasinService, private storeService: StoreService) {
        super(magasinService);
        this.pdfName='Magasin.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStore();
    }

    public async loadMagasins(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Magasin', 'list');
        isPermistted ? this.service.findAll().subscribe(magasins => this.items = magasins,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'adresse', header: 'Adresse'},
            {field: 'store?.libelle', header: 'Store'},
        ];
    }


    public async loadStore(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Magasin', 'list');
        isPermistted ? this.storeService.findAllOptimized().subscribe(stores => this.stores = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: MagasinDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Adresse': e.adresse ,
                'Store': e.store?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Adresse': this.criteria.adresse ? this.criteria.adresse : environment.emptyForExport ,
        //'Store': this.criteria.store?.libelle ? this.criteria.store?.libelle : environment.emptyForExport ,
        }];
      }
}
