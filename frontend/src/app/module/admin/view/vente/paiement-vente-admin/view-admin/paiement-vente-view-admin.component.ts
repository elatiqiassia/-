import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementVenteService} from 'src/app/controller/service/PaiementVente.service';
import {PaiementVenteDto} from 'src/app/controller/model/PaiementVente.model';
import {PaiementVenteCriteria} from 'src/app/controller/criteria/PaiementVenteCriteria.model';

import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {EtatPaiementVenteService} from 'src/app/controller/service/EtatPaiementVente.service';
import {VenteDto} from 'src/app/controller/model/Vente.model';
import {VenteService} from 'src/app/controller/service/Vente.service';
@Component({
  selector: 'app-paiement-vente-view-admin',
  templateUrl: './paiement-vente-view-admin.component.html'
})
export class PaiementVenteViewAdminComponent extends AbstractViewController<PaiementVenteDto, PaiementVenteCriteria, PaiementVenteService> implements OnInit {


    constructor(private paiementVenteService: PaiementVenteService, private modePaiementService: ModePaiementService, private etatPaiementVenteService: EtatPaiementVenteService, private venteService: VenteService){
        super(paiementVenteService);
    }

    ngOnInit(): void {
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.etatPaiementVente = new EtatPaiementVenteDto();
        this.etatPaiementVenteService.findAll().subscribe((data) => this.etatPaiementVentes = data);
    }


    get etatPaiementVente(): EtatPaiementVenteDto {
       return this.etatPaiementVenteService.item;
    }
    set etatPaiementVente(value: EtatPaiementVenteDto) {
        this.etatPaiementVenteService.item = value;
    }
    get etatPaiementVentes():Array<EtatPaiementVenteDto> {
       return this.etatPaiementVenteService.items;
    }
    set etatPaiementVentes(value: Array<EtatPaiementVenteDto>) {
        this.etatPaiementVenteService.items = value;
    }
    get vente(): VenteDto {
       return this.venteService.item;
    }
    set vente(value: VenteDto) {
        this.venteService.item = value;
    }
    get ventes():Array<VenteDto> {
       return this.venteService.items;
    }
    set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
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
