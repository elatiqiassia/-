import {Component, OnInit} from '@angular/core';
import {PaiementCommandeService} from 'src/app/controller/service/PaiementCommande.service';
import {PaiementCommandeDto} from 'src/app/controller/model/PaiementCommande.model';
import {PaiementCommandeCriteria} from 'src/app/controller/criteria/PaiementCommandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CommandeService } from 'src/app/controller/service/Commande.service';
import { ModePaiementService } from 'src/app/controller/service/ModePaiement.service';
import { EtatPaiementCommandeService } from 'src/app/controller/service/EtatPaiementCommande.service';

import {EtatPaiementCommandeDto} from 'src/app/controller/model/EtatPaiementCommande.model';
import {CommandeDto} from 'src/app/controller/model/Commande.model';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';


@Component({
  selector: 'app-paiement-commande-list-admin',
  templateUrl: './paiement-commande-list-admin.component.html'
})
export class PaiementCommandeListAdminComponent extends AbstractListController<PaiementCommandeDto, PaiementCommandeCriteria, PaiementCommandeService>  implements OnInit {

    fileName = 'PaiementCommande';

     yesOrNoChequeVire :any[] =[];
    commandes :Array<CommandeDto>;
    modePaiements :Array<ModePaiementDto>;
    etatPaiementCommandes :Array<EtatPaiementCommandeDto>;
  
    constructor(paiementCommandeService: PaiementCommandeService, private commandeService: CommandeService, private modePaiementService: ModePaiementService, private etatPaiementCommandeService: EtatPaiementCommandeService) {
        super(paiementCommandeService);
        this.pdfName='PaiementCommande.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCommande();
      this.loadModePaiement();
      this.loadEtatPaiementCommande();
    this.yesOrNoChequeVire =  [{label: 'ChequeVire', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadPaiementCommandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementCommande', 'list');
        isPermistted ? this.service.findAll().subscribe(paiementCommandes => this.items = paiementCommandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'commande?.reference', header: 'Commande'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
            {field: 'chequeVire', header: 'Cheque vire'},
            {field: 'etatPaiementCommande?.libelle', header: 'Etat paiement commande'},
        ];
    }


    public async loadCommande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementCommande', 'list');
        isPermistted ? this.commandeService.findAllOptimized().subscribe(commandes => this.commandes = commandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadModePaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementCommande', 'list');
        isPermistted ? this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatPaiementCommande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementCommande', 'list');
        isPermistted ? this.etatPaiementCommandeService.findAllOptimized().subscribe(etatPaiementCommandes => this.etatPaiementCommandes = etatPaiementCommandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaiementCommandeDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Commande': e.commande?.reference ,
                'Mode paiement': e.modePaiement?.libelle ,
                 'Description': e.description ,
                'Cheque vire': e.chequeVire? 'Vrai' : 'Faux' ,
                'Etat paiement commande': e.etatPaiementCommande?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Commande': this.criteria.commande?.reference ? this.criteria.commande?.reference : environment.emptyForExport ,
        //'Mode paiement': this.criteria.modePaiement?.libelle ? this.criteria.modePaiement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Cheque vire': this.criteria.chequeVire ? (this.criteria.chequeVire ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        //'Etat paiement commande': this.criteria.etatPaiementCommande?.libelle ? this.criteria.etatPaiementCommande?.libelle : environment.emptyForExport ,
        }];
      }
}
