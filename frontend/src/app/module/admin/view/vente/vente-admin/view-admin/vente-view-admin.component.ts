import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {VenteService} from 'src/app/controller/service/Vente.service';
import {VenteDto} from 'src/app/controller/model/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/VenteCriteria.model';

import {EtatVenteDto} from 'src/app/controller/model/EtatVente.model';
import {EtatVenteService} from 'src/app/controller/service/EtatVente.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {VenteItemDto} from 'src/app/controller/model/VenteItem.model';
import {VenteItemService} from 'src/app/controller/service/VenteItem.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
@Component({
  selector: 'app-vente-view-admin',
  templateUrl: './vente-view-admin.component.html'
})
export class VenteViewAdminComponent extends AbstractViewController<VenteDto, VenteCriteria, VenteService> implements OnInit {

    venteItems = new VenteItemDto();
    venteItemss: Array<VenteItemDto> = [];

    constructor(private venteService: VenteService, private etatVenteService: EtatVenteService, private storeService: StoreService, private venteItemService: VenteItemService, private produitService: ProduitService, private clientService: ClientService){
        super(venteService);
    }

    ngOnInit(): void {
        this.venteItems.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatVente = new EtatVenteDto();
        this.etatVenteService.findAll().subscribe((data) => this.etatVentes = data);
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
    get etatVente(): EtatVenteDto {
       return this.etatVenteService.item;
    }
    set etatVente(value: EtatVenteDto) {
        this.etatVenteService.item = value;
    }
    get etatVentes():Array<EtatVenteDto> {
       return this.etatVenteService.items;
    }
    set etatVentes(value: Array<EtatVenteDto>) {
        this.etatVenteService.items = value;
    }
    get store(): StoreDto {
       return this.storeService.item;
    }
    set store(value: StoreDto) {
        this.storeService.item = value;
    }
    get stores():Array<StoreDto> {
       return this.storeService.items;
    }
    set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
    }


}
