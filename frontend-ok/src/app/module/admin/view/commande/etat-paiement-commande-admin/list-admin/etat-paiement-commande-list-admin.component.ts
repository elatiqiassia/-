import {Component, OnInit} from '@angular/core';
import {EtatPaiementCommandeService} from 'src/app/controller/service/EtatPaiementCommande.service';
import {EtatPaiementCommandeDto} from 'src/app/controller/model/EtatPaiementCommande.model';
import {EtatPaiementCommandeCriteria} from 'src/app/controller/criteria/EtatPaiementCommandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-paiement-commande-list-admin',
  templateUrl: './etat-paiement-commande-list-admin.component.html'
})
export class EtatPaiementCommandeListAdminComponent extends AbstractListController<EtatPaiementCommandeDto, EtatPaiementCommandeCriteria, EtatPaiementCommandeService>  implements OnInit {

    fileName = 'EtatPaiementCommande';

  
    constructor(etatPaiementCommandeService: EtatPaiementCommandeService) {
        super(etatPaiementCommandeService);
        this.pdfName='EtatPaiementCommande.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatPaiementCommandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatPaiementCommande', 'list');
        isPermistted ? this.service.findAll().subscribe(etatPaiementCommandes => this.items = etatPaiementCommandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatPaiementCommandeDto) {
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
