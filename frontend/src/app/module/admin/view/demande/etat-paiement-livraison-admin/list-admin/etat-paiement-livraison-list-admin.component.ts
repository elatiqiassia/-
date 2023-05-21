import {Component, OnInit} from '@angular/core';
import {EtatPaiementLivraisonService} from 'src/app/controller/service/EtatPaiementLivraison.service';
import {EtatPaiementLivraisonDto} from 'src/app/controller/model/EtatPaiementLivraison.model';
import {EtatPaiementLivraisonCriteria} from 'src/app/controller/criteria/EtatPaiementLivraisonCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-paiement-livraison-list-admin',
  templateUrl: './etat-paiement-livraison-list-admin.component.html'
})
export class EtatPaiementLivraisonListAdminComponent extends AbstractListController<EtatPaiementLivraisonDto, EtatPaiementLivraisonCriteria, EtatPaiementLivraisonService>  implements OnInit {

    fileName = 'EtatPaiementLivraison';

  
    constructor(etatPaiementLivraisonService: EtatPaiementLivraisonService) {
        super(etatPaiementLivraisonService);
        this.pdfName='EtatPaiementLivraison.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatPaiementLivraisons(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatPaiementLivraison', 'list');
        isPermistted ? this.service.findAll().subscribe(etatPaiementLivraisons => this.items = etatPaiementLivraisons,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatPaiementLivraisonDto) {
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
