import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AchatService} from 'src/app/controller/service/Achat.service';
import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AchatCriteria} from 'src/app/controller/criteria/AchatCriteria.model';


import {EtatAchatDto} from 'src/app/controller/model/EtatAchat.model';
import {EtatAchatService} from 'src/app/controller/service/EtatAchat.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {FournisseurDto} from 'src/app/controller/model/Fournisseur.model';
import {FournisseurService} from 'src/app/controller/service/Fournisseur.service';
import {AchatItemDto} from 'src/app/controller/model/AchatItem.model';
import {AchatItemService} from 'src/app/controller/service/AchatItem.service';

@Component({
  selector: 'app-achat-edit-admin',
  templateUrl: './achat-edit-admin.component.html'
})
export class AchatEditAdminComponent extends AbstractEditController<AchatDto, AchatCriteria, AchatService>   implements OnInit {

    private _achatItemsElement = new AchatItemDto();

    private _validAchatReference = true;

    private _validFournisseurIce = true;
    private _validFournisseurNom = true;
    private _validStoreLibelle = true;
    private _validStoreReference = true;
    private _validEtatAchatLibelle = true;
    private _validEtatAchatCode = true;



    constructor( private achatService: AchatService , private etatAchatService: EtatAchatService, private storeService: StoreService, private produitService: ProduitService, private fournisseurService: FournisseurService, private achatItemService: AchatItemService) {
        super(achatService);
    }

    ngOnInit(): void {
        this.achatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

    this.fournisseur = new FournisseurDto();
    this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
    this.etatAchat = new EtatAchatDto();
    this.etatAchatService.findAll().subscribe((data) => this.etatAchats = data);
}
    public prepareEdit() {
        this.item.dateAchat = this.achatService.format(this.item.dateAchat);
    }



    public validateAchatItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        this.validAchatReference = value;
        }
   public addAchatItems() {
        if( this.item.achatItems == null )
            this.item.achatItems = new Array<AchatItemDto>();
       this.validateAchatItems();
       if (this.errorMessages.length === 0) {
            if(this.achatItemsElement.id == null){
                this.item.achatItems.push(this.achatItemsElement);
            }else{
                const index = this.item.achatItems.findIndex(e => e.id == this.achatItemsElement.id);
                this.item.achatItems[index] = this.achatItemsElement;
            }
          this.achatItemsElement = new AchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAchatItem(p: AchatItemDto) {
        this.item.achatItems.forEach((element, index) => {
            if (element === p) { this.item.achatItems.splice(index, 1); }
        });
    }

    public editAchatItem(p: AchatItemDto) {
        this.achatItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAchatReference();
    }
    public validateAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validAchatReference = false;
        } else {
            this.validAchatReference = true;
        }
    }



   public async openCreateEtatAchat(etatAchat: string) {
        const isPermistted = await this.roleService.isPermitted('EtatAchat', 'edit');
        if(isPermistted) {
             this.etatAchat = new EtatAchatDto();
             this.createEtatAchatDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get etatAchat(): EtatAchatDto {
       return this.etatAchatService.item;
   }
  set etatAchat(value: EtatAchatDto) {
        this.etatAchatService.item = value;
   }
   get etatAchats(): Array<EtatAchatDto> {
        return this.etatAchatService.items;
   }
   set etatAchats(value: Array<EtatAchatDto>) {
        this.etatAchatService.items = value;
   }
   get createEtatAchatDialog(): boolean {
       return this.etatAchatService.createDialog;
   }
  set createEtatAchatDialog(value: boolean) {
       this.etatAchatService.createDialog= value;
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
   get fournisseur(): FournisseurDto {
       return this.fournisseurService.item;
   }
  set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
   }
   get fournisseurs(): Array<FournisseurDto> {
        return this.fournisseurService.items;
   }
   set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
   }
   get createFournisseurDialog(): boolean {
       return this.fournisseurService.createDialog;
   }
  set createFournisseurDialog(value: boolean) {
       this.fournisseurService.createDialog= value;
   }

    get achatItemsElement(): AchatItemDto {
        if( this._achatItemsElement == null )
            this._achatItemsElement = new AchatItemDto();
         return this._achatItemsElement;
    }

    set achatItemsElement(value: AchatItemDto) {
        this._achatItemsElement = value;
    }

    get validAchatReference(): boolean {
        return this._validAchatReference;
    }
    set validAchatReference(value: boolean) {
        this._validAchatReference = value;
    }

    get validFournisseurIce(): boolean {
        return this._validFournisseurIce;
    }
    set validFournisseurIce(value: boolean) {
        this._validFournisseurIce = value;
    }
    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }
    set validFournisseurNom(value: boolean) {
        this._validFournisseurNom = value;
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
    get validEtatAchatLibelle(): boolean {
        return this._validEtatAchatLibelle;
    }
    set validEtatAchatLibelle(value: boolean) {
        this._validEtatAchatLibelle = value;
    }
    get validEtatAchatCode(): boolean {
        return this._validEtatAchatCode;
    }
    set validEtatAchatCode(value: boolean) {
        this._validEtatAchatCode = value;
    }
}
