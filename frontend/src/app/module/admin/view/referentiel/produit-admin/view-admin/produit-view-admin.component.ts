import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProduitService} from 'src/app/controller/service/Produit.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/ProduitCriteria.model';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {CategorieProduitDto} from 'src/app/controller/model/CategorieProduit.model';
import {CategorieProduitService} from 'src/app/controller/service/CategorieProduit.service';
import {UniteMesureDto} from 'src/app/controller/model/UniteMesure.model';
import {UniteMesureService} from 'src/app/controller/service/UniteMesure.service';
import {MarqueDto} from 'src/app/controller/model/Marque.model';
import {MarqueService} from 'src/app/controller/service/Marque.service';
@Component({
  selector: 'app-produit-view-admin',
  templateUrl: './produit-view-admin.component.html'
})
export class ProduitViewAdminComponent extends AbstractViewController<ProduitDto, ProduitCriteria, ProduitService> implements OnInit {


    constructor(private produitService: ProduitService, private storeService: StoreService, private categorieProduitService: CategorieProduitService, private uniteMesureService: UniteMesureService, private marqueService: MarqueService){
        super(produitService);
    }

    ngOnInit(): void {
        this.categorieProduit = new CategorieProduitDto();
        this.categorieProduitService.findAll().subscribe((data) => this.categorieProduits = data);
        this.uniteMesure = new UniteMesureDto();
        this.uniteMesureService.findAll().subscribe((data) => this.uniteMesures = data);
        this.marque = new MarqueDto();
        this.marqueService.findAll().subscribe((data) => this.marques = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
    }


    get categorieProduit(): CategorieProduitDto {
       return this.categorieProduitService.item;
    }
    set categorieProduit(value: CategorieProduitDto) {
        this.categorieProduitService.item = value;
    }
    get categorieProduits():Array<CategorieProduitDto> {
       return this.categorieProduitService.items;
    }
    set categorieProduits(value: Array<CategorieProduitDto>) {
        this.categorieProduitService.items = value;
    }
    get uniteMesure(): UniteMesureDto {
       return this.uniteMesureService.item;
    }
    set uniteMesure(value: UniteMesureDto) {
        this.uniteMesureService.item = value;
    }
    get uniteMesures():Array<UniteMesureDto> {
       return this.uniteMesureService.items;
    }
    set uniteMesures(value: Array<UniteMesureDto>) {
        this.uniteMesureService.items = value;
    }
    get marque(): MarqueDto {
       return this.marqueService.item;
    }
    set marque(value: MarqueDto) {
        this.marqueService.item = value;
    }
    get marques():Array<MarqueDto> {
       return this.marqueService.items;
    }
    set marques(value: Array<MarqueDto>) {
        this.marqueService.items = value;
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
