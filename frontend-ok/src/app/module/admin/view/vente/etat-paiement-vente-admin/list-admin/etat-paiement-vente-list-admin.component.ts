import {Component, OnInit} from '@angular/core';
import {EtatPaiementVenteService} from 'src/app/controller/service/EtatPaiementVente.service';
import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {EtatPaiementVenteCriteria} from 'src/app/controller/criteria/EtatPaiementVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-paiement-vente-list-admin',
  templateUrl: './etat-paiement-vente-list-admin.component.html'
})
export class EtatPaiementVenteListAdminComponent extends AbstractListController<EtatPaiementVenteDto, EtatPaiementVenteCriteria, EtatPaiementVenteService>  implements OnInit {

    fileName = 'EtatPaiementVente';

  
    constructor(etatPaiementVenteService: EtatPaiementVenteService) {
        super(etatPaiementVenteService);
        this.pdfName='EtatPaiementVente.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatPaiementVentes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatPaiementVente', 'list');
        isPermistted ? this.service.findAll().subscribe(etatPaiementVentes => this.items = etatPaiementVentes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatPaiementVenteDto) {
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
