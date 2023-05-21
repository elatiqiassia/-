import {Component, OnInit} from '@angular/core';
import {EtatDemandeService} from 'src/app/controller/service/EtatDemande.service';
import {EtatDemandeDto} from 'src/app/controller/model/EtatDemande.model';
import {EtatDemandeCriteria} from 'src/app/controller/criteria/EtatDemandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-demande-list-admin',
  templateUrl: './etat-demande-list-admin.component.html'
})
export class EtatDemandeListAdminComponent extends AbstractListController<EtatDemandeDto, EtatDemandeCriteria, EtatDemandeService>  implements OnInit {

    fileName = 'EtatDemande';

  
    constructor(etatDemandeService: EtatDemandeService) {
        super(etatDemandeService);
        this.pdfName='EtatDemande.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatDemandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatDemande', 'list');
        isPermistted ? this.service.findAll().subscribe(etatDemandes => this.items = etatDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatDemandeDto) {
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
