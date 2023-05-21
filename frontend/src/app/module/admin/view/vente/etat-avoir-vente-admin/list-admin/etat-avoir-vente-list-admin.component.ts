import {Component, OnInit} from '@angular/core';
import {EtatAvoirVenteService} from 'src/app/controller/service/EtatAvoirVente.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/EtatAvoirVente.model';
import {EtatAvoirVenteCriteria} from 'src/app/controller/criteria/EtatAvoirVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-avoir-vente-list-admin',
  templateUrl: './etat-avoir-vente-list-admin.component.html'
})
export class EtatAvoirVenteListAdminComponent extends AbstractListController<EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteService>  implements OnInit {

    fileName = 'EtatAvoirVente';

  
    constructor(etatAvoirVenteService: EtatAvoirVenteService) {
        super(etatAvoirVenteService);
        this.pdfName='EtatAvoirVente.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatAvoirVentes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatAvoirVente', 'list');
        isPermistted ? this.service.findAll().subscribe(etatAvoirVentes => this.items = etatAvoirVentes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatAvoirVenteDto) {
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
