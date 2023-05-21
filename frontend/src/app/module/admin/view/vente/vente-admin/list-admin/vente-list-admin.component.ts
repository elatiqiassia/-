import {Component, OnInit} from '@angular/core';
import {VenteService} from 'src/app/controller/service/Vente.service';
import {VenteDto} from 'src/app/controller/model/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/VenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StoreService } from 'src/app/controller/service/Store.service';
import { ClientService } from 'src/app/controller/service/Client.service';
import { EtatVenteService } from 'src/app/controller/service/EtatVente.service';

import {VenteItemDto} from 'src/app/controller/model/VenteItem.model';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {EtatVenteDto} from 'src/app/controller/model/EtatVente.model';
import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-vente-list-admin',
  templateUrl: './vente-list-admin.component.html'
})
export class VenteListAdminComponent extends AbstractListController<VenteDto, VenteCriteria, VenteService>  implements OnInit {

    fileName = 'Vente';

    stores :Array<StoreDto>;
    clients :Array<ClientDto>;
    etatVentes :Array<EtatVenteDto>;
  
    constructor(venteService: VenteService, private storeService: StoreService, private clientService: ClientService, private etatVenteService: EtatVenteService) {
        super(venteService);
        this.pdfName='Vente.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStore();
      this.loadClient();
      this.loadEtatVente();
    }

    public async loadVentes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Vente', 'list');
        isPermistted ? this.service.findAll().subscribe(ventes => this.items = ventes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateVente', header: 'Date vente'},
            {field: 'total', header: 'Total'},
            {field: 'totalPaye', header: 'Total paye'},
            {field: 'store?.libelle', header: 'Store'},
            {field: 'client?.nom', header: 'Client'},
            {field: 'etatVente?.libelle', header: 'Etat vente'},
        ];
    }


    public async loadStore(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Vente', 'list');
        isPermistted ? this.storeService.findAllOptimized().subscribe(stores => this.stores = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Vente', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatVente(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Vente', 'list');
        isPermistted ? this.etatVenteService.findAllOptimized().subscribe(etatVentes => this.etatVentes = etatVentes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: VenteDto) {
        if (res.venteItems != null) {
             res.venteItems.forEach(d => { d.vente = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date vente': this.datePipe.transform(e.dateVente , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Total paye': e.totalPaye ,
                 'Description': e.description ,
                'Store': e.store?.libelle ,
                'Client': e.client?.nom ,
                'Etat vente': e.etatVente?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date vente Min': this.criteria.dateVenteFrom ? this.datePipe.transform(this.criteria.dateVenteFrom , this.dateFormat) : environment.emptyForExport ,
            'Date vente Max': this.criteria.dateVenteTo ? this.datePipe.transform(this.criteria.dateVenteTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Total paye Min': this.criteria.totalPayeMin ? this.criteria.totalPayeMin : environment.emptyForExport ,
            'Total paye Max': this.criteria.totalPayeMax ? this.criteria.totalPayeMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Store': this.criteria.store?.libelle ? this.criteria.store?.libelle : environment.emptyForExport ,
        //'Client': this.criteria.client?.nom ? this.criteria.client?.nom : environment.emptyForExport ,
        //'Etat vente': this.criteria.etatVente?.libelle ? this.criteria.etatVente?.libelle : environment.emptyForExport ,
        }];
      }
}
