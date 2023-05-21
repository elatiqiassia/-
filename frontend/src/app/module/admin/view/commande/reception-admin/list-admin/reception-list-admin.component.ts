import {Component, OnInit} from '@angular/core';
import {ReceptionService} from 'src/app/controller/service/Reception.service';
import {ReceptionDto} from 'src/app/controller/model/Reception.model';
import {ReceptionCriteria} from 'src/app/controller/criteria/ReceptionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CommandeService } from 'src/app/controller/service/Commande.service';
import { EtatReceptionService } from 'src/app/controller/service/EtatReception.service';

import {CommandeDto} from 'src/app/controller/model/Commande.model';
import {ReceptionItemDto} from 'src/app/controller/model/ReceptionItem.model';
import {EtatReceptionDto} from 'src/app/controller/model/EtatReception.model';


@Component({
  selector: 'app-reception-list-admin',
  templateUrl: './reception-list-admin.component.html'
})
export class ReceptionListAdminComponent extends AbstractListController<ReceptionDto, ReceptionCriteria, ReceptionService>  implements OnInit {

    fileName = 'Reception';

    commandes :Array<CommandeDto>;
    etatReceptions :Array<EtatReceptionDto>;
  
    constructor(receptionService: ReceptionService, private commandeService: CommandeService, private etatReceptionService: EtatReceptionService) {
        super(receptionService);
        this.pdfName='Reception.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCommande();
      this.loadEtatReception();
    }

    public async loadReceptions(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Reception', 'list');
        isPermistted ? this.service.findAll().subscribe(receptions => this.items = receptions,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'commande?.reference', header: 'Commande'},
            {field: 'reference', header: 'Reference'},
            {field: 'dateReception', header: 'Date reception'},
            {field: 'etatReception?.libelle', header: 'Etat reception'},
        ];
    }


    public async loadCommande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Reception', 'list');
        isPermistted ? this.commandeService.findAllOptimized().subscribe(commandes => this.commandes = commandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatReception(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Reception', 'list');
        isPermistted ? this.etatReceptionService.findAllOptimized().subscribe(etatReceptions => this.etatReceptions = etatReceptions,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ReceptionDto) {
        if (res.receptionItems != null) {
             res.receptionItems.forEach(d => { d.reception = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Commande': e.commande?.reference ,
                 'Reference': e.reference ,
                'Date reception': this.datePipe.transform(e.dateReception , 'dd/MM/yyyy hh:mm'),
                 'Description': e.description ,
                'Etat reception': e.etatReception?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Commande': this.criteria.commande?.reference ? this.criteria.commande?.reference : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date reception Min': this.criteria.dateReceptionFrom ? this.datePipe.transform(this.criteria.dateReceptionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date reception Max': this.criteria.dateReceptionTo ? this.datePipe.transform(this.criteria.dateReceptionTo , this.dateFormat) : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Etat reception': this.criteria.etatReception?.libelle ? this.criteria.etatReception?.libelle : environment.emptyForExport ,
        }];
      }
}
