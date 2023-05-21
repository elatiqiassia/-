import {Component, OnInit} from '@angular/core';
import {EtatAvoirAchatService} from 'src/app/controller/service/EtatAvoirAchat.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from 'src/app/controller/criteria/EtatAvoirAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-avoir-achat-list-admin',
  templateUrl: './etat-avoir-achat-list-admin.component.html'
})
export class EtatAvoirAchatListAdminComponent extends AbstractListController<EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatService>  implements OnInit {

    fileName = 'EtatAvoirAchat';

  
    constructor(etatAvoirAchatService: EtatAvoirAchatService) {
        super(etatAvoirAchatService);
        this.pdfName='EtatAvoirAchat.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatAvoirAchats(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatAvoirAchat', 'list');
        isPermistted ? this.service.findAll().subscribe(etatAvoirAchats => this.items = etatAvoirAchats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatAvoirAchatDto) {
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
