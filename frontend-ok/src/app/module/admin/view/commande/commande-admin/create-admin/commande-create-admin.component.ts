import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CommandeService} from 'src/app/controller/service/Commande.service';
import {CommandeDto} from 'src/app/controller/model/Commande.model';
import {CommandeCriteria} from 'src/app/controller/criteria/CommandeCriteria.model';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {CommandeItemDto} from 'src/app/controller/model/CommandeItem.model';
import {CommandeItemService} from 'src/app/controller/service/CommandeItem.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {EtatCommandeDto} from 'src/app/controller/model/EtatCommande.model';
import {EtatCommandeService} from 'src/app/controller/service/EtatCommande.service';
@Component({
  selector: 'app-commande-create-admin',
  templateUrl: './commande-create-admin.component.html'
})
export class CommandeCreateAdminComponent extends AbstractCreateController<CommandeDto, CommandeCriteria, CommandeService>  implements OnInit {

    private _commandeItemsElement = new CommandeItemDto();


   private _validCommandeReference = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validEtatCommandeLibelle = true;
    private _validEtatCommandeCode = true;

    constructor( private commandeService: CommandeService , private produitService: ProduitService, private commandeItemService: CommandeItemService, private clientService: ClientService, private etatCommandeService: EtatCommandeService) {
        super(commandeService);
    }

    ngOnInit(): void {
        this.commandeItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
    this.etatCommande = new EtatCommandeDto();
    this.etatCommandeService.findAll().subscribe((data) => this.etatCommandes = data);
}



    validateCommandeItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
        this.validCommandeReference = value;
    }

    public addCommandeItems() {
        if( this.item.commandeItems == null )
            this.item.commandeItems = new Array<CommandeItemDto>();
       this.validateCommandeItems();
       if (this.errorMessages.length === 0) {
              this.item.commandeItems.push({... this.commandeItemsElement});
              this.commandeItemsElement = new CommandeItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteCommandeItem(p: CommandeItemDto) {
        this.item.commandeItems.forEach((element, index) => {
            if (element === p) { this.item.commandeItems.splice(index, 1); }
        });
    }

    public editCommandeItem(p: CommandeItemDto) {
        this.commandeItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCommandeReference();
    }

    public validateCommandeReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validCommandeReference = false;
        } else {
            this.validCommandeReference = true;
        }
    }


    public async openCreateEtatCommande(etatCommande: string) {
    const isPermistted = await this.roleService.isPermitted('EtatCommande', 'add');
    if(isPermistted) {
         this.etatCommande = new EtatCommandeDto();
         this.createEtatCommandeDialog = true;
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
    get etatCommande(): EtatCommandeDto {
        return this.etatCommandeService.item;
    }
    set etatCommande(value: EtatCommandeDto) {
        this.etatCommandeService.item = value;
    }
    get etatCommandes(): Array<EtatCommandeDto> {
        return this.etatCommandeService.items;
    }
    set etatCommandes(value: Array<EtatCommandeDto>) {
        this.etatCommandeService.items = value;
    }
    get createEtatCommandeDialog(): boolean {
       return this.etatCommandeService.createDialog;
    }
    set createEtatCommandeDialog(value: boolean) {
        this.etatCommandeService.createDialog= value;
    }



    get validCommandeReference(): boolean {
        return this._validCommandeReference;
    }

    set validCommandeReference(value: boolean) {
         this._validCommandeReference = value;
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
    get validEtatCommandeLibelle(): boolean {
        return this._validEtatCommandeLibelle;
    }
    set validEtatCommandeLibelle(value: boolean) {
        this._validEtatCommandeLibelle = value;
    }
    get validEtatCommandeCode(): boolean {
        return this._validEtatCommandeCode;
    }
    set validEtatCommandeCode(value: boolean) {
        this._validEtatCommandeCode = value;
    }

    get commandeItemsElement(): CommandeItemDto {
        if( this._commandeItemsElement == null )
            this._commandeItemsElement = new CommandeItemDto();
        return this._commandeItemsElement;
    }

    set commandeItemsElement(value: CommandeItemDto) {
        this._commandeItemsElement = value;
    }

}
