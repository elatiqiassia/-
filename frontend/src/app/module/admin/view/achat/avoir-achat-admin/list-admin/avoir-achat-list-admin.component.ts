import {Component, OnInit} from '@angular/core';
import {AvoirAchatService} from 'src/app/controller/service/AvoirAchat.service';
import {AvoirAchatDto} from 'src/app/controller/model/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/AvoirAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { AchatService } from 'src/app/controller/service/Achat.service';
import { EtatAvoirAchatService } from 'src/app/controller/service/EtatAvoirAchat.service';

import {EtatAvoirAchatDto} from 'src/app/controller/model/EtatAvoirAchat.model';
import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AvoirAchatItemDto} from 'src/app/controller/model/AvoirAchatItem.model';


@Component({
  selector: 'app-avoir-achat-list-admin',
  templateUrl: './avoir-achat-list-admin.component.html'
})
export class AvoirAchatListAdminComponent extends AbstractListController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatService>  implements OnInit {

    fileName = 'AvoirAchat';

    achats :Array<AchatDto>;
    etatAvoirAchats :Array<EtatAvoirAchatDto>;
  
    constructor(avoirAchatService: AvoirAchatService, private achatService: AchatService, private etatAvoirAchatService: EtatAvoirAchatService) {
        super(avoirAchatService);
        this.pdfName='AvoirAchat.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadAchat();
      this.loadEtatAvoirAchat();
    }

    public async loadAvoirAchats(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AvoirAchat', 'list');
        isPermistted ? this.service.findAll().subscribe(avoirAchats => this.items = avoirAchats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'dateAvoir', header: 'Date avoir'},
            {field: 'montant', header: 'Montant'},
            {field: 'achat?.reference', header: 'Achat'},
            {field: 'etatAvoirAchat?.libelle', header: 'Etat avoir achat'},
        ];
    }


    public async loadAchat(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AvoirAchat', 'list');
        isPermistted ? this.achatService.findAllOptimized().subscribe(achats => this.achats = achats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatAvoirAchat(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AvoirAchat', 'list');
        isPermistted ? this.etatAvoirAchatService.findAllOptimized().subscribe(etatAvoirAchats => this.etatAvoirAchats = etatAvoirAchats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: AvoirAchatDto) {
        if (res.avoirAchatItems != null) {
             res.avoirAchatItems.forEach(d => { d.avoirAchat = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Date avoir': this.datePipe.transform(e.dateAvoir , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Achat': e.achat?.reference ,
                'Etat avoir achat': e.etatAvoirAchat?.libelle ,
            }
        });

        this.criteriaData = [{
            'Date avoir Min': this.criteria.dateAvoirFrom ? this.datePipe.transform(this.criteria.dateAvoirFrom , this.dateFormat) : environment.emptyForExport ,
            'Date avoir Max': this.criteria.dateAvoirTo ? this.datePipe.transform(this.criteria.dateAvoirTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Achat': this.criteria.achat?.reference ? this.criteria.achat?.reference : environment.emptyForExport ,
        //'Etat avoir achat': this.criteria.etatAvoirAchat?.libelle ? this.criteria.etatAvoirAchat?.libelle : environment.emptyForExport ,
        }];
      }
}
