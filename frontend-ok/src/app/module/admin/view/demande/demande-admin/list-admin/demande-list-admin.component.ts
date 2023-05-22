import {Component, OnInit} from '@angular/core';
import {DemandeService} from 'src/app/controller/service/Demande.service';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {DemandeCriteria} from 'src/app/controller/criteria/DemandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ClientService } from 'src/app/controller/service/Client.service';
import { EtatDemandeService } from 'src/app/controller/service/EtatDemande.service';

import {EtatDemandeDto} from 'src/app/controller/model/EtatDemande.model';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {DemandeItemDto} from 'src/app/controller/model/DemandeItem.model';


@Component({
  selector: 'app-demande-list-admin',
  templateUrl: './demande-list-admin.component.html'
})
export class DemandeListAdminComponent extends AbstractListController<DemandeDto, DemandeCriteria, DemandeService>  implements OnInit {

    fileName = 'Demande';

    clients :Array<ClientDto>;
    etatDemandes :Array<EtatDemandeDto>;
  
    constructor(demandeService: DemandeService, private clientService: ClientService, private etatDemandeService: EtatDemandeService) {
        super(demandeService);
        this.pdfName='Demande.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadClient();
      this.loadEtatDemande();
    }

    public async loadDemandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.service.findAll().subscribe(demandes => this.items = demandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateCommande', header: 'Date commande'},
            {field: 'totalCheque', header: 'Total cheque'},
            {field: 'totalEspece', header: 'Total espece'},
            {field: 'total', header: 'Total'},
            {field: 'totalePaye', header: 'Totale paye'},
            {field: 'client?.nom', header: 'Client'},
            {field: 'etatDemande?.libelle', header: 'Etat demande'},
        ];
    }


    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatDemande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.etatDemandeService.findAllOptimized().subscribe(etatDemandes => this.etatDemandes = etatDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DemandeDto) {
        if (res.demandeItems != null) {
             res.demandeItems.forEach(d => { d.demande = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date commande': this.datePipe.transform(e.dateCommande , 'dd/MM/yyyy hh:mm'),
                 'Total cheque': e.totalCheque ,
                 'Total espece': e.totalEspece ,
                 'Total': e.total ,
                 'Totale paye': e.totalePaye ,
                'Client': e.client?.nom ,
                'Etat demande': e.etatDemande?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date commande Min': this.criteria.dateCommandeFrom ? this.datePipe.transform(this.criteria.dateCommandeFrom , this.dateFormat) : environment.emptyForExport ,
            'Date commande Max': this.criteria.dateCommandeTo ? this.datePipe.transform(this.criteria.dateCommandeTo , this.dateFormat) : environment.emptyForExport ,
            'Total cheque Min': this.criteria.totalChequeMin ? this.criteria.totalChequeMin : environment.emptyForExport ,
            'Total cheque Max': this.criteria.totalChequeMax ? this.criteria.totalChequeMax : environment.emptyForExport ,
            'Total espece Min': this.criteria.totalEspeceMin ? this.criteria.totalEspeceMin : environment.emptyForExport ,
            'Total espece Max': this.criteria.totalEspeceMax ? this.criteria.totalEspeceMax : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Totale paye Min': this.criteria.totalePayeMin ? this.criteria.totalePayeMin : environment.emptyForExport ,
            'Totale paye Max': this.criteria.totalePayeMax ? this.criteria.totalePayeMax : environment.emptyForExport ,
        //'Client': this.criteria.client?.nom ? this.criteria.client?.nom : environment.emptyForExport ,
        //'Etat demande': this.criteria.etatDemande?.libelle ? this.criteria.etatDemande?.libelle : environment.emptyForExport ,
        }];
      }
}
