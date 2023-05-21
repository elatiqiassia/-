import {Component, OnInit} from '@angular/core';
import {BilanService} from 'src/app/controller/service/Bilan.service';
import {BilanDto} from 'src/app/controller/model/Bilan.model';
import {BilanCriteria} from 'src/app/controller/criteria/BilanCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SocieteService } from 'src/app/controller/service/Societe.service';

import {SocieteDto} from 'src/app/controller/model/Societe.model';


@Component({
  selector: 'app-bilan-list-admin',
  templateUrl: './bilan-list-admin.component.html'
})
export class BilanListAdminComponent extends AbstractListController<BilanDto, BilanCriteria, BilanService>  implements OnInit {

    fileName = 'Bilan';

    societes :Array<SocieteDto>;
  
    constructor(bilanService: BilanService, private societeService: SocieteService) {
        super(bilanService);
        this.pdfName='Bilan.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSociete();
    }

    public async loadBilans(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Bilan', 'list');
        isPermistted ? this.service.findAll().subscribe(bilans => this.items = bilans,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'annee', header: 'Annee'},
            {field: 'societe?.ice', header: 'Societe'},
            {field: 'immobilisationsIncorporelles', header: 'Immobilisations incorporelles'},
            {field: 'immobilisationsCorporelles', header: 'Immobilisations corporelles'},
            {field: 'immobilisationsFinancieres', header: 'Immobilisations financieres'},
            {field: 'totalActifImmobolise', header: 'Total actif immobolise'},
            {field: 'stocks', header: 'Stocks'},
            {field: 'creancesClients', header: 'Creances clients'},
            {field: 'totalActifCirculant', header: 'Total actif circulant'},
            {field: 'depotEnBanque', header: 'Depot en banque'},
            {field: 'avoirEnCaisse', header: 'Avoir en caisse'},
            {field: 'totalTresorieActif', header: 'Total tresorie actif'},
            {field: 'totalActif', header: 'Total actif'},
            {field: 'capitalPersonnel', header: 'Capital personnel'},
            {field: 'emprunts', header: 'Emprunts'},
            {field: 'resultat', header: 'Resultat'},
            {field: 'totalFinnancementPermanant', header: 'Total finnancement permanant'},
            {field: 'dettesFournisseurs', header: 'Dettes fournisseurs'},
            {field: 'autresDettesCirculantes', header: 'Autres dettes circulantes'},
            {field: 'totalPassifCirculant', header: 'Total passif circulant'},
            {field: 'totalPassif', header: 'Total passif'},
        ];
    }


    public async loadSociete(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Bilan', 'list');
        isPermistted ? this.societeService.findAllOptimized().subscribe(societes => this.societes = societes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: BilanDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                 'Annee': e.annee ,
                'Societe': e.societe?.ice ,
                 'Immobilisations incorporelles': e.immobilisationsIncorporelles ,
                 'Immobilisations corporelles': e.immobilisationsCorporelles ,
                 'Immobilisations financieres': e.immobilisationsFinancieres ,
                 'Total actif immobolise': e.totalActifImmobolise ,
                 'Stocks': e.stocks ,
                 'Creances clients': e.creancesClients ,
                 'Total actif circulant': e.totalActifCirculant ,
                 'Depot en banque': e.depotEnBanque ,
                 'Avoir en caisse': e.avoirEnCaisse ,
                 'Total tresorie actif': e.totalTresorieActif ,
                 'Total actif': e.totalActif ,
                 'Capital personnel': e.capitalPersonnel ,
                 'Emprunts': e.emprunts ,
                 'Resultat': e.resultat ,
                 'Total finnancement permanant': e.totalFinnancementPermanant ,
                 'Dettes fournisseurs': e.dettesFournisseurs ,
                 'Autres dettes circulantes': e.autresDettesCirculantes ,
                 'Total passif circulant': e.totalPassifCirculant ,
                 'Total passif': e.totalPassif ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
            'Annee Min': this.criteria.anneeMin ? this.criteria.anneeMin : environment.emptyForExport ,
            'Annee Max': this.criteria.anneeMax ? this.criteria.anneeMax : environment.emptyForExport ,
        //'Societe': this.criteria.societe?.ice ? this.criteria.societe?.ice : environment.emptyForExport ,
            'Immobilisations incorporelles Min': this.criteria.immobilisationsIncorporellesMin ? this.criteria.immobilisationsIncorporellesMin : environment.emptyForExport ,
            'Immobilisations incorporelles Max': this.criteria.immobilisationsIncorporellesMax ? this.criteria.immobilisationsIncorporellesMax : environment.emptyForExport ,
            'Immobilisations corporelles Min': this.criteria.immobilisationsCorporellesMin ? this.criteria.immobilisationsCorporellesMin : environment.emptyForExport ,
            'Immobilisations corporelles Max': this.criteria.immobilisationsCorporellesMax ? this.criteria.immobilisationsCorporellesMax : environment.emptyForExport ,
            'Immobilisations financieres Min': this.criteria.immobilisationsFinancieresMin ? this.criteria.immobilisationsFinancieresMin : environment.emptyForExport ,
            'Immobilisations financieres Max': this.criteria.immobilisationsFinancieresMax ? this.criteria.immobilisationsFinancieresMax : environment.emptyForExport ,
            'Total actif immobolise Min': this.criteria.totalActifImmoboliseMin ? this.criteria.totalActifImmoboliseMin : environment.emptyForExport ,
            'Total actif immobolise Max': this.criteria.totalActifImmoboliseMax ? this.criteria.totalActifImmoboliseMax : environment.emptyForExport ,
            'Stocks Min': this.criteria.stocksMin ? this.criteria.stocksMin : environment.emptyForExport ,
            'Stocks Max': this.criteria.stocksMax ? this.criteria.stocksMax : environment.emptyForExport ,
            'Creances clients Min': this.criteria.creancesClientsMin ? this.criteria.creancesClientsMin : environment.emptyForExport ,
            'Creances clients Max': this.criteria.creancesClientsMax ? this.criteria.creancesClientsMax : environment.emptyForExport ,
            'Total actif circulant Min': this.criteria.totalActifCirculantMin ? this.criteria.totalActifCirculantMin : environment.emptyForExport ,
            'Total actif circulant Max': this.criteria.totalActifCirculantMax ? this.criteria.totalActifCirculantMax : environment.emptyForExport ,
            'Depot en banque Min': this.criteria.depotEnBanqueMin ? this.criteria.depotEnBanqueMin : environment.emptyForExport ,
            'Depot en banque Max': this.criteria.depotEnBanqueMax ? this.criteria.depotEnBanqueMax : environment.emptyForExport ,
            'Avoir en caisse Min': this.criteria.avoirEnCaisseMin ? this.criteria.avoirEnCaisseMin : environment.emptyForExport ,
            'Avoir en caisse Max': this.criteria.avoirEnCaisseMax ? this.criteria.avoirEnCaisseMax : environment.emptyForExport ,
            'Total tresorie actif Min': this.criteria.totalTresorieActifMin ? this.criteria.totalTresorieActifMin : environment.emptyForExport ,
            'Total tresorie actif Max': this.criteria.totalTresorieActifMax ? this.criteria.totalTresorieActifMax : environment.emptyForExport ,
            'Total actif Min': this.criteria.totalActifMin ? this.criteria.totalActifMin : environment.emptyForExport ,
            'Total actif Max': this.criteria.totalActifMax ? this.criteria.totalActifMax : environment.emptyForExport ,
            'Capital personnel Min': this.criteria.capitalPersonnelMin ? this.criteria.capitalPersonnelMin : environment.emptyForExport ,
            'Capital personnel Max': this.criteria.capitalPersonnelMax ? this.criteria.capitalPersonnelMax : environment.emptyForExport ,
            'Emprunts Min': this.criteria.empruntsMin ? this.criteria.empruntsMin : environment.emptyForExport ,
            'Emprunts Max': this.criteria.empruntsMax ? this.criteria.empruntsMax : environment.emptyForExport ,
            'Resultat Min': this.criteria.resultatMin ? this.criteria.resultatMin : environment.emptyForExport ,
            'Resultat Max': this.criteria.resultatMax ? this.criteria.resultatMax : environment.emptyForExport ,
            'Total finnancement permanant Min': this.criteria.totalFinnancementPermanantMin ? this.criteria.totalFinnancementPermanantMin : environment.emptyForExport ,
            'Total finnancement permanant Max': this.criteria.totalFinnancementPermanantMax ? this.criteria.totalFinnancementPermanantMax : environment.emptyForExport ,
            'Dettes fournisseurs Min': this.criteria.dettesFournisseursMin ? this.criteria.dettesFournisseursMin : environment.emptyForExport ,
            'Dettes fournisseurs Max': this.criteria.dettesFournisseursMax ? this.criteria.dettesFournisseursMax : environment.emptyForExport ,
            'Autres dettes circulantes Min': this.criteria.autresDettesCirculantesMin ? this.criteria.autresDettesCirculantesMin : environment.emptyForExport ,
            'Autres dettes circulantes Max': this.criteria.autresDettesCirculantesMax ? this.criteria.autresDettesCirculantesMax : environment.emptyForExport ,
            'Total passif circulant Min': this.criteria.totalPassifCirculantMin ? this.criteria.totalPassifCirculantMin : environment.emptyForExport ,
            'Total passif circulant Max': this.criteria.totalPassifCirculantMax ? this.criteria.totalPassifCirculantMax : environment.emptyForExport ,
            'Total passif Min': this.criteria.totalPassifMin ? this.criteria.totalPassifMin : environment.emptyForExport ,
            'Total passif Max': this.criteria.totalPassifMax ? this.criteria.totalPassifMax : environment.emptyForExport ,
        }];
      }
}
