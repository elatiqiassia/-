import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-vente-edit-admin',
  templateUrl: './vente-edit-admin.component.html'
})
export class VenteEditAdminComponent extends AbstractEditController<VenteDto, VenteCriteria, VenteService>   implements OnInit {

    private _venteItemsElement = new VenteItemDto();

    private _validVenteReference = true;

    private _validStoreLibelle = true;
    private _validStoreReference = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validEtatVenteLibelle = true;
    private _validEtatVenteCode = true;



    constructor( private venteService: VenteService , private etatVenteService: EtatVenteService, private storeService: StoreService, private venteItemService: VenteItemService, private produitService: ProduitService, private clientService: ClientService) {
        super(venteService);
    }

    ngOnInit(): void {
        this.venteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
    this.etatVente = new EtatVenteDto();
    this.etatVenteService.findAll().subscribe((data) => this.etatVentes = data);
}
    public prepareEdit() {
        this.item.dateVente = this.venteService.format(this.item.dateVente);
    }



    public validateVenteItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        this.validVenteReference = value;
        }
   public addVenteItems() {
        if( this.item.venteItems == null )
            this.item.venteItems = new Array<VenteItemDto>();
       this.validateVenteItems();
       if (this.errorMessages.length === 0) {
            if(this.venteItemsElement.id == null){
                this.item.venteItems.push(this.venteItemsElement);
            }else{
                const index = this.item.venteItems.findIndex(e => e.id == this.venteItemsElement.id);
                this.item.venteItems[index] = this.venteItemsElement;
            }
          this.venteItemsElement = new VenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteVenteItem(p: VenteItemDto) {
        this.item.venteItems.forEach((element, index) => {
            if (element === p) { this.item.venteItems.splice(index, 1); }
        });
    }

    public editVenteItem(p: VenteItemDto) {
        this.venteItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVenteReference();
    }
    public validateVenteReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validVenteReference = false;
        } else {
            this.validVenteReference = true;
        }
    }



   public async openCreateEtatVente(etatVente: string) {
        const isPermistted = await this.roleService.isPermitted('EtatVente', 'edit');
        if(isPermistted) {
             this.etatVente = new EtatVenteDto();
             this.createEtatVenteDialog = true;
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
   get client(): ClientDto {
       return this.clientService.item;
   }
  set client(value: ClientDto) {
        this.clientService.item = value;
   }
   get clients(): Array<ClientDto> {
        return this.clientService.items;
   }
   set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
   }
   get createClientDialog(): boolean {
       return this.clientService.createDialog;
   }
  set createClientDialog(value: boolean) {
       this.clientService.createDialog= value;
   }
   get etatVente(): EtatVenteDto {
       return this.etatVenteService.item;
   }
  set etatVente(value: EtatVenteDto) {
        this.etatVenteService.item = value;
   }
   get etatVentes(): Array<EtatVenteDto> {
        return this.etatVenteService.items;
   }
   set etatVentes(value: Array<EtatVenteDto>) {
        this.etatVenteService.items = value;
   }
   get createEtatVenteDialog(): boolean {
       return this.etatVenteService.createDialog;
   }
  set createEtatVenteDialog(value: boolean) {
       this.etatVenteService.createDialog= value;
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

    get venteItemsElement(): VenteItemDto {
        if( this._venteItemsElement == null )
            this._venteItemsElement = new VenteItemDto();
         return this._venteItemsElement;
    }

    set venteItemsElement(value: VenteItemDto) {
        this._venteItemsElement = value;
    }

    get validVenteReference(): boolean {
        return this._validVenteReference;
    }
    set validVenteReference(value: boolean) {
        this._validVenteReference = value;
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
    get validClientCin(): boolean {
        return this._validClientCin;
    }
    set validClientCin(value: boolean) {
        this._validClientCin = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }
    get validEtatVenteLibelle(): boolean {
        return this._validEtatVenteLibelle;
    }
    set validEtatVenteLibelle(value: boolean) {
        this._validEtatVenteLibelle = value;
    }
    get validEtatVenteCode(): boolean {
        return this._validEtatVenteCode;
    }
    set validEtatVenteCode(value: boolean) {
        this._validEtatVenteCode = value;
    }
}
