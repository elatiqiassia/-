import {Component, OnInit} from '@angular/core';
import {EtatVenteService} from 'src/app/controller/service/EtatVente.service';
import {EtatVenteDto} from 'src/app/controller/model/EtatVente.model';
import {EtatVenteCriteria} from 'src/app/controller/criteria/EtatVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-vente-list-admin',
  templateUrl: './etat-vente-list-admin.component.html'
})
export class EtatVenteListAdminComponent extends AbstractListController<EtatVenteDto, EtatVenteCriteria, EtatVenteService>  implements OnInit {

    fileName = 'EtatVente';

  
    constructor(etatVenteService: EtatVenteService) {
        super(etatVenteService);
        this.pdfName='EtatVente.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatVentes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatVente', 'list');
        isPermistted ? this.service.findAll().subscribe(etatVentes => this.items = etatVentes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatVenteDto) {
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
