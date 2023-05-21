import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementDemandeService} from 'src/app/controller/service/PaiementDemande.service';
import {PaiementDemandeDto} from 'src/app/controller/model/PaiementDemande.model';
import {PaiementDemandeCriteria} from 'src/app/controller/criteria/PaiementDemandeCriteria.model';

import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {DemandeService} from 'src/app/controller/service/Demande.service';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';
import {EtatPaiementDemandeService} from 'src/app/controller/service/EtatPaiementDemande.service';
@Component({
  selector: 'app-paiement-demande-view-admin',
  templateUrl: './paiement-demande-view-admin.component.html'
})
export class PaiementDemandeViewAdminComponent extends AbstractViewController<PaiementDemandeDto, PaiementDemandeCriteria, PaiementDemandeService> implements OnInit {


    constructor(private paiementDemandeService: PaiementDemandeService, private modePaiementService: ModePaiementService, private demandeService: DemandeService, private etatPaiementDemandeService: EtatPaiementDemandeService){
        super(paiementDemandeService);
    }

    ngOnInit(): void {
        this.demande = new DemandeDto();
        this.demandeService.findAll().subscribe((data) => this.demandes = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.etatPaiementDemande = new EtatPaiementDemandeDto();
        this.etatPaiementDemandeService.findAll().subscribe((data) => this.etatPaiementDemandes = data);
    }


    get etatPaiementDemande(): EtatPaiementDemandeDto {
       return this.etatPaiementDemandeService.item;
    }
    set etatPaiementDemande(value: EtatPaiementDemandeDto) {
        this.etatPaiementDemandeService.item = value;
    }
    get etatPaiementDemandes():Array<EtatPaiementDemandeDto> {
       return this.etatPaiementDemandeService.items;
    }
    set etatPaiementDemandes(value: Array<EtatPaiementDemandeDto>) {
        this.etatPaiementDemandeService.items = value;
    }
    get demande(): DemandeDto {
       return this.demandeService.item;
    }
    set demande(value: DemandeDto) {
        this.demandeService.item = value;
    }
    get demandes():Array<DemandeDto> {
       return this.demandeService.items;
    }
    set demandes(value: Array<DemandeDto>) {
        this.demandeService.items = value;
    }
    get modePaiement(): ModePaiementDto {
       return this.modePaiementService.item;
    }
    set modePaiement(value: ModePaiementDto) {
        this.modePaiementService.item = value;
    }
    get modePaiements():Array<ModePaiementDto> {
       return this.modePaiementService.items;
    }
    set modePaiements(value: Array<ModePaiementDto>) {
        this.modePaiementService.items = value;
    }


}
