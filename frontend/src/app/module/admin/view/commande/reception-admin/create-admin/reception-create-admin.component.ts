import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReceptionService} from 'src/app/controller/service/Reception.service';
import {ReceptionDto} from 'src/app/controller/model/Reception.model';
import {ReceptionCriteria} from 'src/app/controller/criteria/ReceptionCriteria.model';
import {CommandeDto} from 'src/app/controller/model/Commande.model';
import {CommandeService} from 'src/app/controller/service/Commande.service';
import {ReceptionItemDto} from 'src/app/controller/model/ReceptionItem.model';
import {ReceptionItemService} from 'src/app/controller/service/ReceptionItem.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {EtatReceptionDto} from 'src/app/controller/model/EtatReception.model';
import {EtatReceptionService} from 'src/app/controller/service/EtatReception.service';
import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinService} from 'src/app/controller/service/Magasin.service';
@Component({
  selector: 'app-reception-create-admin',
  templateUrl: './reception-create-admin.component.html'
})
export class ReceptionCreateAdminComponent extends AbstractCreateController<ReceptionDto, ReceptionCriteria, ReceptionService>  implements OnInit {

    private _receptionItemsElement = new ReceptionItemDto();


   private _validReceptionReference = true;
    private _validCommandeReference = true;
    private _validEtatReceptionLibelle = true;
    private _validEtatReceptionCode = true;

    constructor( private receptionService: ReceptionService , private commandeService: CommandeService, private receptionItemService: ReceptionItemService, private produitService: ProduitService, private etatReceptionService: EtatReceptionService, private magasinService: MagasinService) {
        super(receptionService);
    }

    ngOnInit(): void {
        this.receptionItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.receptionItemsElement.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
    this.commande = new CommandeDto();
    this.commandeService.findAll().subscribe((data) => this.commandes = data);
    this.etatReception = new EtatReceptionDto();
    this.etatReceptionService.findAll().subscribe((data) => this.etatReceptions = data);
}



    validateReceptionItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
        this.validReceptionReference = value;
    }

    public addReceptionItems() {
        if( this.item.receptionItems == null )
            this.item.receptionItems = new Array<ReceptionItemDto>();
       this.validateReceptionItems();
       if (this.errorMessages.length === 0) {
              this.item.receptionItems.push({... this.receptionItemsElement});
              this.receptionItemsElement = new ReceptionItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteReceptionItem(p: ReceptionItemDto) {
        this.item.receptionItems.forEach((element, index) => {
            if (element === p) { this.item.receptionItems.splice(index, 1); }
        });
    }

    public editReceptionItem(p: ReceptionItemDto) {
        this.receptionItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateReceptionReference();
    }

    public validateReceptionReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validReceptionReference = false;
        } else {
            this.validReceptionReference = true;
        }
    }


    public async openCreateEtatReception(etatReception: string) {
    const isPermistted = await this.roleService.isPermitted('EtatReception', 'add');
    if(isPermistted) {
         this.etatReception = new EtatReceptionDto();
         this.createEtatReceptionDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateCommande(commande: string) {
    const isPermistted = await this.roleService.isPermitted('Commande', 'add');
    if(isPermistted) {
         this.commande = new CommandeDto();
         this.createCommandeDialog = true;
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
    get etatReception(): EtatReceptionDto {
        return this.etatReceptionService.item;
    }
    set etatReception(value: EtatReceptionDto) {
        this.etatReceptionService.item = value;
    }
    get etatReceptions(): Array<EtatReceptionDto> {
        return this.etatReceptionService.items;
    }
    set etatReceptions(value: Array<EtatReceptionDto>) {
        this.etatReceptionService.items = value;
    }
    get createEtatReceptionDialog(): boolean {
       return this.etatReceptionService.createDialog;
    }
    set createEtatReceptionDialog(value: boolean) {
        this.etatReceptionService.createDialog= value;
    }
    get commande(): CommandeDto {
        return this.commandeService.item;
    }
    set commande(value: CommandeDto) {
        this.commandeService.item = value;
    }
    get commandes(): Array<CommandeDto> {
        return this.commandeService.items;
    }
    set commandes(value: Array<CommandeDto>) {
        this.commandeService.items = value;
    }
    get createCommandeDialog(): boolean {
       return this.commandeService.createDialog;
    }
    set createCommandeDialog(value: boolean) {
        this.commandeService.createDialog= value;
    }
    get magasin(): MagasinDto {
        return this.magasinService.item;
    }
    set magasin(value: MagasinDto) {
        this.magasinService.item = value;
    }
    get magasins(): Array<MagasinDto> {
        return this.magasinService.items;
    }
    set magasins(value: Array<MagasinDto>) {
        this.magasinService.items = value;
    }
    get createMagasinDialog(): boolean {
       return this.magasinService.createDialog;
    }
    set createMagasinDialog(value: boolean) {
        this.magasinService.createDialog= value;
    }



    get validReceptionReference(): boolean {
        return this._validReceptionReference;
    }

    set validReceptionReference(value: boolean) {
         this._validReceptionReference = value;
    }

    get validCommandeReference(): boolean {
        return this._validCommandeReference;
    }
    set validCommandeReference(value: boolean) {
        this._validCommandeReference = value;
    }
    get validEtatReceptionLibelle(): boolean {
        return this._validEtatReceptionLibelle;
    }
    set validEtatReceptionLibelle(value: boolean) {
        this._validEtatReceptionLibelle = value;
    }
    get validEtatReceptionCode(): boolean {
        return this._validEtatReceptionCode;
    }
    set validEtatReceptionCode(value: boolean) {
        this._validEtatReceptionCode = value;
    }

    get receptionItemsElement(): ReceptionItemDto {
        if( this._receptionItemsElement == null )
            this._receptionItemsElement = new ReceptionItemDto();
        return this._receptionItemsElement;
    }

    set receptionItemsElement(value: ReceptionItemDto) {
        this._receptionItemsElement = value;
    }

}
