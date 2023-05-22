import {Component, OnInit} from '@angular/core';
import {PaiementVenteService} from 'src/app/controller/service/PaiementVente.service';
import {PaiementVenteDto} from 'src/app/controller/model/PaiementVente.model';
import {PaiementVenteCriteria} from 'src/app/controller/criteria/PaiementVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { VenteService } from 'src/app/controller/service/Vente.service';
import { ModePaiementService } from 'src/app/controller/service/ModePaiement.service';
import { EtatPaiementVenteService } from 'src/app/controller/service/EtatPaiementVente.service';

import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {VenteDto} from 'src/app/controller/model/Vente.model';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';


@Component({
  selector: 'app-paiement-vente-list-admin',
  templateUrl: './paiement-vente-list-admin.component.html'
})
export class PaiementVenteListAdminComponent extends AbstractListController<PaiementVenteDto, PaiementVenteCriteria, PaiementVenteService>  implements OnInit {

    fileName = 'PaiementVente';

    ventes :Array<VenteDto>;
    modePaiements :Array<ModePaiementDto>;
    etatPaiementVentes :Array<EtatPaiementVenteDto>;
  
    constructor(paiementVenteService: PaiementVenteService, private venteService: VenteService, private modePaiementService: ModePaiementService, private etatPaiementVenteService: EtatPaiementVenteService) {
        super(paiementVenteService);
        this.pdfName='PaiementVente.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadVente();
      this.loadModePaiement();
      this.loadEtatPaiementVente();
    }

    public async loadPaiementVentes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementVente', 'list');
        isPermistted ? this.service.findAll().subscribe(paiementVentes => this.items = paiementVentes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'vente?.reference', header: 'Vente'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
            {field: 'etatPaiementVente?.libelle', header: 'Etat paiement vente'},
        ];
    }


    public async loadVente(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementVente', 'list');
        isPermistted ? this.venteService.findAllOptimized().subscribe(ventes => this.ventes = ventes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadModePaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementVente', 'list');
        isPermistted ? this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatPaiementVente(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementVente', 'list');
        isPermistted ? this.etatPaiementVenteService.findAllOptimized().subscribe(etatPaiementVentes => this.etatPaiementVentes = etatPaiementVentes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaiementVenteDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Vente': e.vente?.reference ,
                'Mode paiement': e.modePaiement?.libelle ,
                 'Description': e.description ,
                'Etat paiement vente': e.etatPaiementVente?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Vente': this.criteria.vente?.reference ? this.criteria.vente?.reference : environment.emptyForExport ,
        //'Mode paiement': this.criteria.modePaiement?.libelle ? this.criteria.modePaiement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Etat paiement vente': this.criteria.etatPaiementVente?.libelle ? this.criteria.etatPaiementVente?.libelle : environment.emptyForExport ,
        }];
      }
}
