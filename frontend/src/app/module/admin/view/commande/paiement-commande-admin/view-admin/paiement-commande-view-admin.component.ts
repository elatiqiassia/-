import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementCommandeService} from 'src/app/controller/service/PaiementCommande.service';
import {PaiementCommandeDto} from 'src/app/controller/model/PaiementCommande.model';
import {PaiementCommandeCriteria} from 'src/app/controller/criteria/PaiementCommandeCriteria.model';

import {CommandeDto} from 'src/app/controller/model/Commande.model';
import {CommandeService} from 'src/app/controller/service/Commande.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {EtatPaiementCommandeDto} from 'src/app/controller/model/EtatPaiementCommande.model';
import {EtatPaiementCommandeService} from 'src/app/controller/service/EtatPaiementCommande.service';
@Component({
  selector: 'app-paiement-commande-view-admin',
  templateUrl: './paiement-commande-view-admin.component.html'
})
export class PaiementCommandeViewAdminComponent extends AbstractViewController<PaiementCommandeDto, PaiementCommandeCriteria, PaiementCommandeService> implements OnInit {


    constructor(private paiementCommandeService: PaiementCommandeService, private commandeService: CommandeService, private modePaiementService: ModePaiementService, private etatPaiementCommandeService: EtatPaiementCommandeService){
        super(paiementCommandeService);
    }

    ngOnInit(): void {
        this.commande = new CommandeDto();
        this.commandeService.findAll().subscribe((data) => this.commandes = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.etatPaiementCommande = new EtatPaiementCommandeDto();
        this.etatPaiementCommandeService.findAll().subscribe((data) => this.etatPaiementCommandes = data);
    }


    get commande(): CommandeDto {
       return this.commandeService.item;
    }
    set commande(value: CommandeDto) {
        this.commandeService.item = value;
    }
    get commandes():Array<CommandeDto> {
       return this.commandeService.items;
    }
    set commandes(value: Array<CommandeDto>) {
        this.commandeService.items = value;
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
    get etatPaiementCommande(): EtatPaiementCommandeDto {
       return this.etatPaiementCommandeService.item;
    }
    set etatPaiementCommande(value: EtatPaiementCommandeDto) {
        this.etatPaiementCommandeService.item = value;
    }
    get etatPaiementCommandes():Array<EtatPaiementCommandeDto> {
       return this.etatPaiementCommandeService.items;
    }
    set etatPaiementCommandes(value: Array<EtatPaiementCommandeDto>) {
        this.etatPaiementCommandeService.items = value;
    }


}
