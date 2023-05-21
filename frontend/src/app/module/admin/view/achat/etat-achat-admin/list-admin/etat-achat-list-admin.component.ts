import {Component, OnInit} from '@angular/core';
import {EtatAchatService} from 'src/app/controller/service/EtatAchat.service';
import {EtatAchatDto} from 'src/app/controller/model/EtatAchat.model';
import {EtatAchatCriteria} from 'src/app/controller/criteria/EtatAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-achat-list-admin',
  templateUrl: './etat-achat-list-admin.component.html'
})
export class EtatAchatListAdminComponent extends AbstractListController<EtatAchatDto, EtatAchatCriteria, EtatAchatService>  implements OnInit {

    fileName = 'EtatAchat';

  
    constructor(etatAchatService: EtatAchatService) {
        super(etatAchatService);
        this.pdfName='EtatAchat.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatAchats(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatAchat', 'list');
        isPermistted ? this.service.findAll().subscribe(etatAchats => this.items = etatAchats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatAchatDto) {
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
