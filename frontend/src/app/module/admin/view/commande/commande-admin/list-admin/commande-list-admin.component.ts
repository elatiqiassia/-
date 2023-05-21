import {Component, OnInit} from '@angular/core';
import {CommandeService} from 'src/app/controller/service/Commande.service';
import {CommandeDto} from 'src/app/controller/model/Commande.model';
import {CommandeCriteria} from 'src/app/controller/criteria/CommandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ClientService } from 'src/app/controller/service/Client.service';
import { EtatCommandeService } from 'src/app/controller/service/EtatCommande.service';

import {EtatCommandeDto} from 'src/app/controller/model/EtatCommande.model';
import {CommandeItemDto} from 'src/app/controller/model/CommandeItem.model';
import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-commande-list-admin',
  templateUrl: './commande-list-admin.component.html'
})
export class CommandeListAdminComponent extends AbstractListController<CommandeDto, CommandeCriteria, CommandeService>  implements OnInit {

    fileName = 'Commande';

    clients :Array<ClientDto>;
    etatCommandes :Array<EtatCommandeDto>;
  
    constructor(commandeService: CommandeService, private clientService: ClientService, private etatCommandeService: EtatCommandeService) {
        super(commandeService);
        this.pdfName='Commande.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadClient();
      this.loadEtatCommande();
    }

    public async loadCommandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Commande', 'list');
        isPermistted ? this.service.findAll().subscribe(commandes => this.items = commandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateCommande', header: 'Date commande'},
            {field: 'total', header: 'Total'},
            {field: 'totalePaye', header: 'Totale paye'},
            {field: 'totalPayeCheque', header: 'Total paye cheque'},
            {field: 'totalPayeEspece', header: 'Total paye espece'},
            {field: 'client?.nom', header: 'Client'},
            {field: 'etatCommande?.libelle', header: 'Etat commande'},
        ];
    }


    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Commande', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatCommande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Commande', 'list');
        isPermistted ? this.etatCommandeService.findAllOptimized().subscribe(etatCommandes => this.etatCommandes = etatCommandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: CommandeDto) {
        if (res.commandeItems != null) {
             res.commandeItems.forEach(d => { d.commande = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date commande': this.datePipe.transform(e.dateCommande , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Totale paye': e.totalePaye ,
                 'Total paye cheque': e.totalPayeCheque ,
                 'Total paye espece': e.totalPayeEspece ,
                'Client': e.client?.nom ,
                'Etat commande': e.etatCommande?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date commande Min': this.criteria.dateCommandeFrom ? this.datePipe.transform(this.criteria.dateCommandeFrom , this.dateFormat) : environment.emptyForExport ,
            'Date commande Max': this.criteria.dateCommandeTo ? this.datePipe.transform(this.criteria.dateCommandeTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Totale paye Min': this.criteria.totalePayeMin ? this.criteria.totalePayeMin : environment.emptyForExport ,
            'Totale paye Max': this.criteria.totalePayeMax ? this.criteria.totalePayeMax : environment.emptyForExport ,
            'Total paye cheque Min': this.criteria.totalPayeChequeMin ? this.criteria.totalPayeChequeMin : environment.emptyForExport ,
            'Total paye cheque Max': this.criteria.totalPayeChequeMax ? this.criteria.totalPayeChequeMax : environment.emptyForExport ,
            'Total paye espece Min': this.criteria.totalPayeEspeceMin ? this.criteria.totalPayeEspeceMin : environment.emptyForExport ,
            'Total paye espece Max': this.criteria.totalPayeEspeceMax ? this.criteria.totalPayeEspeceMax : environment.emptyForExport ,
        //'Client': this.criteria.client?.nom ? this.criteria.client?.nom : environment.emptyForExport ,
        //'Etat commande': this.criteria.etatCommande?.libelle ? this.criteria.etatCommande?.libelle : environment.emptyForExport ,
        }];
      }
}
