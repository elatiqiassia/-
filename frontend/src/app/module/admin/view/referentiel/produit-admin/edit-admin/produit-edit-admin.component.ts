import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-produit-edit-admin',
  templateUrl: './produit-edit-admin.component.html'
})
export class ProduitEditAdminComponent extends AbstractEditController<ProduitDto, ProduitCriteria, ProduitService>   implements OnInit {


    private _validProduitReference = true;
    private _validProduitLibelle = true;

    private _validCategorieProduitReference = true;
    private _validCategorieProduitLibelle = true;
    private _validUniteMesureLibelle = true;
    private _validUniteMesureCode = true;
    private _validMarqueLibelle = true;
    private _validMarqueCode = true;
    private _validStoreLibelle = true;
    private _validStoreReference = true;



    constructor( private produitService: ProduitService , private storeService: StoreService, private categorieProduitService: CategorieProduitService, private uniteMesureService: UniteMesureService, private marqueService: MarqueService) {
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


    public setValidation(value : boolean){
        this.validProduitReference = value;
        this.validProduitLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProduitReference();
        this.validateProduitLibelle();
    }
    public validateProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validProduitReference = false;
        } else {
            this.validProduitReference = true;
        }
    }
    public validateProduitLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validProduitLibelle = false;
        } else {
            this.validProduitLibelle = true;
        }
    }



   public async openCreateCategorieProduit(categorieProduit: string) {
        const isPermistted = await this.roleService.isPermitted('CategorieProduit', 'edit');
        if(isPermistted) {
             this.categorieProduit = new CategorieProduitDto();
             this.createCategorieProduitDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateUniteMesure(uniteMesure: string) {
        const isPermistted = await this.roleService.isPermitted('UniteMesure', 'edit');
        if(isPermistted) {
             this.uniteMesure = new UniteMesureDto();
             this.createUniteMesureDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateMarque(marque: string) {
        const isPermistted = await this.roleService.isPermitted('Marque', 'edit');
        if(isPermistted) {
             this.marque = new MarqueDto();
             this.createMarqueDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get categorieProduit(): CategorieProduitDto {
       return this.categorieProduitService.item;
   }
  set categorieProduit(value: CategorieProduitDto) {
        this.categorieProduitService.item = value;
   }
   get categorieProduits(): Array<CategorieProduitDto> {
        return this.categorieProduitService.items;
   }
   set categorieProduits(value: Array<CategorieProduitDto>) {
        this.categorieProduitService.items = value;
   }
   get createCategorieProduitDialog(): boolean {
       return this.categorieProduitService.createDialog;
   }
  set createCategorieProduitDialog(value: boolean) {
       this.categorieProduitService.createDialog= value;
   }
   get uniteMesure(): UniteMesureDto {
       return this.uniteMesureService.item;
   }
  set uniteMesure(value: UniteMesureDto) {
        this.uniteMesureService.item = value;
   }
   get uniteMesures(): Array<UniteMesureDto> {
        return this.uniteMesureService.items;
   }
   set uniteMesures(value: Array<UniteMesureDto>) {
        this.uniteMesureService.items = value;
   }
   get createUniteMesureDialog(): boolean {
       return this.uniteMesureService.createDialog;
   }
  set createUniteMesureDialog(value: boolean) {
       this.uniteMesureService.createDialog= value;
   }
   get marque(): MarqueDto {
       return this.marqueService.item;
   }
  set marque(value: MarqueDto) {
        this.marqueService.item = value;
   }
   get marques(): Array<MarqueDto> {
        return this.marqueService.items;
   }
   set marques(value: Array<MarqueDto>) {
        this.marqueService.items = value;
   }
   get createMarqueDialog(): boolean {
       return this.marqueService.createDialog;
   }
  set createMarqueDialog(value: boolean) {
       this.marqueService.createDialog= value;
   }
   get store(): StoreDto {
       return this.storeService.item;
   }
  set store(value: StoreDto) {
        this.storeService.item = value;
   }
   get stores(): Array<StoreDto> {
        return this.storeService.items;
   }
   set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
   }
   get createStoreDialog(): boolean {
       return this.storeService.createDialog;
   }
  set createStoreDialog(value: boolean) {
       this.storeService.createDialog= value;
   }


    get validProduitReference(): boolean {
        return this._validProduitReference;
    }
    set validProduitReference(value: boolean) {
        this._validProduitReference = value;
    }
    get validProduitLibelle(): boolean {
        return this._validProduitLibelle;
    }
    set validProduitLibelle(value: boolean) {
        this._validProduitLibelle = value;
    }

    get validCategorieProduitReference(): boolean {
        return this._validCategorieProduitReference;
    }
    set validCategorieProduitReference(value: boolean) {
        this._validCategorieProduitReference = value;
    }
    get validCategorieProduitLibelle(): boolean {
        return this._validCategorieProduitLibelle;
    }
    set validCategorieProduitLibelle(value: boolean) {
        this._validCategorieProduitLibelle = value;
    }
    get validUniteMesureLibelle(): boolean {
        return this._validUniteMesureLibelle;
    }
    set validUniteMesureLibelle(value: boolean) {
        this._validUniteMesureLibelle = value;
    }
    get validUniteMesureCode(): boolean {
        return this._validUniteMesureCode;
    }
    set validUniteMesureCode(value: boolean) {
        this._validUniteMesureCode = value;
    }
    get validMarqueLibelle(): boolean {
        return this._validMarqueLibelle;
    }
    set validMarqueLibelle(value: boolean) {
        this._validMarqueLibelle = value;
    }
    get validMarqueCode(): boolean {
        return this._validMarqueCode;
    }
    set validMarqueCode(value: boolean) {
        this._validMarqueCode = value;
    }
    get validStoreLibelle(): boolean {
        return this._validStoreLibelle;
    }
    set validStoreLibelle(value: boolean) {
        this._validStoreLibelle = value;
    }
    get validStoreReference(): boolean {
        return this._validStoreReference;
    }
    set validStoreReference(value: boolean) {
        this._validStoreReference = value;
    }
}
