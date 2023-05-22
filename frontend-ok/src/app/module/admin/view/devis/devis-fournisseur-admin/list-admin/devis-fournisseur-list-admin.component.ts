import {Component, OnInit} from '@angular/core';
import {DevisFournisseurService} from 'src/app/controller/service/DevisFournisseur.service';
import {DevisFournisseurDto} from 'src/app/controller/model/DevisFournisseur.model';
import {DevisFournisseurCriteria} from 'src/app/controller/criteria/DevisFournisseurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { FournisseurService } from 'src/app/controller/service/Fournisseur.service';

import {DevisItemFournisseurDto} from 'src/app/controller/model/DevisItemFournisseur.model';
import {FournisseurDto} from 'src/app/controller/model/Fournisseur.model';


@Component({
  selector: 'app-devis-fournisseur-list-admin',
  templateUrl: './devis-fournisseur-list-admin.component.html'
})
export class DevisFournisseurListAdminComponent extends AbstractListController<DevisFournisseurDto, DevisFournisseurCriteria, DevisFournisseurService>  implements OnInit {

    fileName = 'DevisFournisseur';

    fournisseurs :Array<FournisseurDto>;
  
    constructor(devisFournisseurService: DevisFournisseurService, private fournisseurService: FournisseurService) {
        super(devisFournisseurService);
        this.pdfName='DevisFournisseur.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadFournisseur();
    }

    public async loadDevisFournisseurs(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DevisFournisseur', 'list');
        isPermistted ? this.service.findAll().subscribe(devisFournisseurs => this.items = devisFournisseurs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateDevis', header: 'Date devis'},
            {field: 'total', header: 'Total'},
            {field: 'fournisseur?.nom', header: 'Fournisseur'},
        ];
    }


    public async loadFournisseur(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DevisFournisseur', 'list');
        isPermistted ? this.fournisseurService.findAllOptimized().subscribe(fournisseurs => this.fournisseurs = fournisseurs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DevisFournisseurDto) {
        if (res.devisItemFournisseurs != null) {
             res.devisItemFournisseurs.forEach(d => { d.devisFournisseur = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date devis': this.datePipe.transform(e.dateDevis , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Description': e.description ,
                'Fournisseur': e.fournisseur?.nom ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date devis Min': this.criteria.dateDevisFrom ? this.datePipe.transform(this.criteria.dateDevisFrom , this.dateFormat) : environment.emptyForExport ,
            'Date devis Max': this.criteria.dateDevisTo ? this.datePipe.transform(this.criteria.dateDevisTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Fournisseur': this.criteria.fournisseur?.nom ? this.criteria.fournisseur?.nom : environment.emptyForExport ,
        }];
      }
}
