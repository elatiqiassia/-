import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DemandeService} from 'src/app/controller/service/Demande.service';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {DemandeCriteria} from 'src/app/controller/criteria/DemandeCriteria.model';

import {DemandeItemDto} from 'src/app/controller/model/DemandeItem.model';
import {DemandeItemService} from 'src/app/controller/service/DemandeItem.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {EtatDemandeDto} from 'src/app/controller/model/EtatDemande.model';
import {EtatDemandeService} from 'src/app/controller/service/EtatDemande.service';
@Component({
  selector: 'app-demande-view-admin',
  templateUrl: './demande-view-admin.component.html'
})
export class DemandeViewAdminComponent extends AbstractViewController<DemandeDto, DemandeCriteria, DemandeService> implements OnInit {

    demandeItems = new DemandeItemDto();
    demandeItemss: Array<DemandeItemDto> = [];

    constructor(private demandeService: DemandeService, private demandeItemService: DemandeItemService, private produitService: ProduitService, private clientService: ClientService, private etatDemandeService: EtatDemandeService){
        super(demandeService);
    }

    ngOnInit(): void {
        this.demandeItems.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatDemande = new EtatDemandeDto();
        this.etatDemandeService.findAll().subscribe((data) => this.etatDemandes = data);
    }


    get produit(): ProduitDto {
       return this.produitService.item;
    }
    set produit(value: ProduitDto) {
        this.produitService.item = value;
    }
    get produits():Array<ProduitDto> {
       return this.produitService.items;
    }
    set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
    }
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get etatDemande(): EtatDemandeDto {
       return this.etatDemandeService.item;
    }
    set etatDemande(value: EtatDemandeDto) {
        this.etatDemandeService.item = value;
    }
    get etatDemandes():Array<EtatDemandeDto> {
       return this.etatDemandeService.items;
    }
    set etatDemandes(value: Array<EtatDemandeDto>) {
        this.etatDemandeService.items = value;
    }


}
