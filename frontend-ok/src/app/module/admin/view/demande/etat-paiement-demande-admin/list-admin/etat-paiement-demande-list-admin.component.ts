import {Component, OnInit} from '@angular/core';
import {EtatPaiementDemandeService} from 'src/app/controller/service/EtatPaiementDemande.service';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';
import {EtatPaiementDemandeCriteria} from 'src/app/controller/criteria/EtatPaiementDemandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-paiement-demande-list-admin',
  templateUrl: './etat-paiement-demande-list-admin.component.html'
})
export class EtatPaiementDemandeListAdminComponent extends AbstractListController<EtatPaiementDemandeDto, EtatPaiementDemandeCriteria, EtatPaiementDemandeService>  implements OnInit {

    fileName = 'EtatPaiementDemande';

  
    constructor(etatPaiementDemandeService: EtatPaiementDemandeService) {
        super(etatPaiementDemandeService);
        this.pdfName='EtatPaiementDemande.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatPaiementDemandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatPaiementDemande', 'list');
        isPermistted ? this.service.findAll().subscribe(etatPaiementDemandes => this.items = etatPaiementDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatPaiementDemandeDto) {
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
