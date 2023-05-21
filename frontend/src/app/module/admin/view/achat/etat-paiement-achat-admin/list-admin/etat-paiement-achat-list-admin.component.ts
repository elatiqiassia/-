import {Component, OnInit} from '@angular/core';
import {EtatPaiementAchatService} from 'src/app/controller/service/EtatPaiementAchat.service';
import {EtatPaiementAchatDto} from 'src/app/controller/model/EtatPaiementAchat.model';
import {EtatPaiementAchatCriteria} from 'src/app/controller/criteria/EtatPaiementAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-paiement-achat-list-admin',
  templateUrl: './etat-paiement-achat-list-admin.component.html'
})
export class EtatPaiementAchatListAdminComponent extends AbstractListController<EtatPaiementAchatDto, EtatPaiementAchatCriteria, EtatPaiementAchatService>  implements OnInit {

    fileName = 'EtatPaiementAchat';

  
    constructor(etatPaiementAchatService: EtatPaiementAchatService) {
        super(etatPaiementAchatService);
        this.pdfName='EtatPaiementAchat.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatPaiementAchats(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatPaiementAchat', 'list');
        isPermistted ? this.service.findAll().subscribe(etatPaiementAchats => this.items = etatPaiementAchats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatPaiementAchatDto) {
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
