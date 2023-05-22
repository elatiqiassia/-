import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AvoirVenteService} from 'src/app/controller/service/AvoirVente.service';
import {AvoirVenteDto} from 'src/app/controller/model/AvoirVente.model';
import {AvoirVenteCriteria} from 'src/app/controller/criteria/AvoirVenteCriteria.model';

import {VenteDto} from 'src/app/controller/model/Vente.model';
import {VenteService} from 'src/app/controller/service/Vente.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/AvoirVenteItem.model';
import {AvoirVenteItemService} from 'src/app/controller/service/AvoirVenteItem.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/EtatAvoirVente.model';
import {EtatAvoirVenteService} from 'src/app/controller/service/EtatAvoirVente.service';
@Component({
  selector: 'app-avoir-vente-view-admin',
  templateUrl: './avoir-vente-view-admin.component.html'
})
export class AvoirVenteViewAdminComponent extends AbstractViewController<AvoirVenteDto, AvoirVenteCriteria, AvoirVenteService> implements OnInit {

    avoirVenteItems = new AvoirVenteItemDto();
    avoirVenteItemss: Array<AvoirVenteItemDto> = [];

    constructor(private avoirVenteService: AvoirVenteService, private venteService: VenteService, private produitService: ProduitService, private avoirVenteItemService: AvoirVenteItemService, private etatAvoirVenteService: EtatAvoirVenteService){
        super(avoirVenteService);
    }

    ngOnInit(): void {
        this.avoirVenteItems.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
        this.etatAvoirVente = new EtatAvoirVenteDto();
        this.etatAvoirVenteService.findAll().subscribe((data) => this.etatAvoirVentes = data);
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
    get etatAvoirVente(): EtatAvoirVenteDto {
       return this.etatAvoirVenteService.item;
    }
    set etatAvoirVente(value: EtatAvoirVenteDto) {
        this.etatAvoirVenteService.item = value;
    }
    get etatAvoirVentes():Array<EtatAvoirVenteDto> {
       return this.etatAvoirVenteService.items;
    }
    set etatAvoirVentes(value: Array<EtatAvoirVenteDto>) {
        this.etatAvoirVenteService.items = value;
    }


}
