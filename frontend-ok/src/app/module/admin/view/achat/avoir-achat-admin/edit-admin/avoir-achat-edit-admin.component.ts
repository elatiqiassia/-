import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AvoirAchatService} from 'src/app/controller/service/AvoirAchat.service';
import {AvoirAchatDto} from 'src/app/controller/model/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/AvoirAchatCriteria.model';


import {AvoirAchatItemDto} from 'src/app/controller/model/AvoirAchatItem.model';
import {AvoirAchatItemService} from 'src/app/controller/service/AvoirAchatItem.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/EtatAvoirAchat.model';
import {EtatAvoirAchatService} from 'src/app/controller/service/EtatAvoirAchat.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AchatService} from 'src/app/controller/service/Achat.service';

@Component({
  selector: 'app-avoir-achat-edit-admin',
  templateUrl: './avoir-achat-edit-admin.component.html'
})
export class AvoirAchatEditAdminComponent extends AbstractEditController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatService>   implements OnInit {

    private _avoirAchatItemsElement = new AvoirAchatItemDto();


    private _validAchatReference = true;
    private _validEtatAvoirAchatLibelle = true;
    private _validEtatAvoirAchatCode = true;



    constructor( private avoirAchatService: AvoirAchatService , private avoirAchatItemService: AvoirAchatItemService, private etatAvoirAchatService: EtatAvoirAchatService, private produitService: ProduitService, private achatService: AchatService) {
        super(avoirAchatService);
    }

    ngOnInit(): void {
        this.avoirAchatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

    this.achat = new AchatDto();
    this.achatService.findAll().subscribe((data) => this.achats = data);
    this.etatAvoirAchat = new EtatAvoirAchatDto();
    this.etatAvoirAchatService.findAll().subscribe((data) => this.etatAvoirAchats = data);
}
    public prepareEdit() {
        this.item.dateAvoir = this.avoirAchatService.format(this.item.dateAvoir);
    }



    public validateAvoirAchatItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addAvoirAchatItems() {
        if( this.item.avoirAchatItems == null )
            this.item.avoirAchatItems = new Array<AvoirAchatItemDto>();
       this.validateAvoirAchatItems();
       if (this.errorMessages.length === 0) {
            if(this.avoirAchatItemsElement.id == null){
                this.item.avoirAchatItems.push(this.avoirAchatItemsElement);
            }else{
                const index = this.item.avoirAchatItems.findIndex(e => e.id == this.avoirAchatItemsElement.id);
                this.item.avoirAchatItems[index] = this.avoirAchatItemsElement;
            }
          this.avoirAchatItemsElement = new AvoirAchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirAchatItem(p: AvoirAchatItemDto) {
        this.item.avoirAchatItems.forEach((element, index) => {
            if (element === p) { this.item.avoirAchatItems.splice(index, 1); }
        });
    }

    public editAvoirAchatItem(p: AvoirAchatItemDto) {
        this.avoirAchatItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateEtatAvoirAchat(etatAvoirAchat: string) {
        const isPermistted = await this.roleService.isPermitted('EtatAvoirAchat', 'edit');
        if(isPermistted) {
             this.etatAvoirAchat = new EtatAvoirAchatDto();
             this.createEtatAvoirAchatDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateAchat(achat: string) {
        const isPermistted = await this.roleService.isPermitted('Achat', 'edit');
        if(isPermistted) {
             this.achat = new AchatDto();
             this.createAchatDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get etatAvoirAchat(): EtatAvoirAchatDto {
       return this.etatAvoirAchatService.item;
   }
  set etatAvoirAchat(value: EtatAvoirAchatDto) {
        this.etatAvoirAchatService.item = value;
   }
   get etatAvoirAchats(): Array<EtatAvoirAchatDto> {
        return this.etatAvoirAchatService.items;
   }
   set etatAvoirAchats(value: Array<EtatAvoirAchatDto>) {
        this.etatAvoirAchatService.items = value;
   }
   get createEtatAvoirAchatDialog(): boolean {
       return this.etatAvoirAchatService.createDialog;
   }
  set createEtatAvoirAchatDialog(value: boolean) {
       this.etatAvoirAchatService.createDialog= value;
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
   get achat(): AchatDto {
       return this.achatService.item;
   }
  set achat(value: AchatDto) {
        this.achatService.item = value;
   }
   get achats(): Array<AchatDto> {
        return this.achatService.items;
   }
   set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
   }
   get createAchatDialog(): boolean {
       return this.achatService.createDialog;
   }
  set createAchatDialog(value: boolean) {
       this.achatService.createDialog= value;
   }

    get avoirAchatItemsElement(): AvoirAchatItemDto {
        if( this._avoirAchatItemsElement == null )
            this._avoirAchatItemsElement = new AvoirAchatItemDto();
         return this._avoirAchatItemsElement;
    }

    set avoirAchatItemsElement(value: AvoirAchatItemDto) {
        this._avoirAchatItemsElement = value;
    }


    get validAchatReference(): boolean {
        return this._validAchatReference;
    }
    set validAchatReference(value: boolean) {
        this._validAchatReference = value;
    }
    get validEtatAvoirAchatLibelle(): boolean {
        return this._validEtatAvoirAchatLibelle;
    }
    set validEtatAvoirAchatLibelle(value: boolean) {
        this._validEtatAvoirAchatLibelle = value;
    }
    get validEtatAvoirAchatCode(): boolean {
        return this._validEtatAvoirAchatCode;
    }
    set validEtatAvoirAchatCode(value: boolean) {
        this._validEtatAvoirAchatCode = value;
    }
}
