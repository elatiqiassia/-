import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AchatService} from 'src/app/controller/service/Achat.service';
import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AchatCriteria} from 'src/app/controller/criteria/AchatCriteria.model';

import {EtatAchatDto} from 'src/app/controller/model/EtatAchat.model';
import {EtatAchatService} from 'src/app/controller/service/EtatAchat.service';
import {AchatItemDto} from 'src/app/controller/model/AchatItem.model';
import {AchatItemService} from 'src/app/controller/service/AchatItem.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {FournisseurDto} from 'src/app/controller/model/Fournisseur.model';
import {FournisseurService} from 'src/app/controller/service/Fournisseur.service';
@Component({
  selector: 'app-achat-view-admin',
  templateUrl: './achat-view-admin.component.html'
})
export class AchatViewAdminComponent extends AbstractViewController<AchatDto, AchatCriteria, AchatService> implements OnInit {

    achatItems = new AchatItemDto();
    achatItemss: Array<AchatItemDto> = [];

    constructor(private achatService: AchatService, private etatAchatService: EtatAchatService, private achatItemService: AchatItemService, private storeService: StoreService, private produitService: ProduitService, private fournisseurService: FournisseurService){
        super(achatService);
    }

    ngOnInit(): void {
        this.achatItems.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.etatAchat = new EtatAchatDto();
        this.etatAchatService.findAll().subscribe((data) => this.etatAchats = data);
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
    get etatAchat(): EtatAchatDto {
       return this.etatAchatService.item;
    }
    set etatAchat(value: EtatAchatDto) {
        this.etatAchatService.item = value;
    }
    get etatAchats():Array<EtatAchatDto> {
       return this.etatAchatService.items;
    }
    set etatAchats(value: Array<EtatAchatDto>) {
        this.etatAchatService.items = value;
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
    get fournisseur(): FournisseurDto {
       return this.fournisseurService.item;
    }
    set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
    }
    get fournisseurs():Array<FournisseurDto> {
       return this.fournisseurService.items;
    }
    set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
    }


}
