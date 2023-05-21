import {Component, OnInit} from '@angular/core';
import {PaiementDemandeService} from 'src/app/controller/service/PaiementDemande.service';
import {PaiementDemandeDto} from 'src/app/controller/model/PaiementDemande.model';
import {PaiementDemandeCriteria} from 'src/app/controller/criteria/PaiementDemandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { DemandeService } from 'src/app/controller/service/Demande.service';
import { ModePaiementService } from 'src/app/controller/service/ModePaiement.service';
import { EtatPaiementDemandeService } from 'src/app/controller/service/EtatPaiementDemande.service';

import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';


@Component({
  selector: 'app-paiement-demande-list-admin',
  templateUrl: './paiement-demande-list-admin.component.html'
})
export class PaiementDemandeListAdminComponent extends AbstractListController<PaiementDemandeDto, PaiementDemandeCriteria, PaiementDemandeService>  implements OnInit {

    fileName = 'PaiementDemande';

     yesOrNoChequeVire :any[] =[];
    demandes :Array<DemandeDto>;
    modePaiements :Array<ModePaiementDto>;
    etatPaiementDemandes :Array<EtatPaiementDemandeDto>;
  
    constructor(paiementDemandeService: PaiementDemandeService, private demandeService: DemandeService, private modePaiementService: ModePaiementService, private etatPaiementDemandeService: EtatPaiementDemandeService) {
        super(paiementDemandeService);
        this.pdfName='PaiementDemande.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadDemande();
      this.loadModePaiement();
      this.loadEtatPaiementDemande();
    this.yesOrNoChequeVire =  [{label: 'ChequeVire', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadPaiementDemandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.service.findAll().subscribe(paiementDemandes => this.items = paiementDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'demande?.reference', header: 'Demande'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
            {field: 'chequeVire', header: 'Cheque vire'},
            {field: 'etatPaiementDemande?.libelle', header: 'Etat paiement demande'},
        ];
    }


    public async loadDemande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.demandeService.findAllOptimized().subscribe(demandes => this.demandes = demandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadModePaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatPaiementDemande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.etatPaiementDemandeService.findAllOptimized().subscribe(etatPaiementDemandes => this.etatPaiementDemandes = etatPaiementDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaiementDemandeDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Demande': e.demande?.reference ,
                'Mode paiement': e.modePaiement?.libelle ,
                 'Description': e.description ,
                'Cheque vire': e.chequeVire? 'Vrai' : 'Faux' ,
                'Etat paiement demande': e.etatPaiementDemande?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Demande': this.criteria.demande?.reference ? this.criteria.demande?.reference : environment.emptyForExport ,
        //'Mode paiement': this.criteria.modePaiement?.libelle ? this.criteria.modePaiement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Cheque vire': this.criteria.chequeVire ? (this.criteria.chequeVire ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        //'Etat paiement demande': this.criteria.etatPaiementDemande?.libelle ? this.criteria.etatPaiementDemande?.libelle : environment.emptyForExport ,
        }];
      }
}
