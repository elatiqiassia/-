import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {LivraisonService} from 'src/app/controller/service/Livraison.service';
import {LivraisonDto} from 'src/app/controller/model/Livraison.model';
import {LivraisonCriteria} from 'src/app/controller/criteria/LivraisonCriteria.model';
import {EtatLivraisonDto} from 'src/app/controller/model/EtatLivraison.model';
import {EtatLivraisonService} from 'src/app/controller/service/EtatLivraison.service';
import {LivraisonItemDto} from 'src/app/controller/model/LivraisonItem.model';
import {LivraisonItemService} from 'src/app/controller/service/LivraisonItem.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {DemandeService} from 'src/app/controller/service/Demande.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinService} from 'src/app/controller/service/Magasin.service';
@Component({
  selector: 'app-livraison-create-admin',
  templateUrl: './livraison-create-admin.component.html'
})
export class LivraisonCreateAdminComponent extends AbstractCreateController<LivraisonDto, LivraisonCriteria, LivraisonService>  implements OnInit {

    private _livraisonItemsElement = new LivraisonItemDto();


    private _validDemandeReference = true;
    private _validEtatLivraisonLibelle = true;
    private _validEtatLivraisonCode = true;
    private _validClientCin = true;
    private _validClientNom = true;

    constructor( private livraisonService: LivraisonService , private etatLivraisonService: EtatLivraisonService, private livraisonItemService: LivraisonItemService, private produitService: ProduitService, private demandeService: DemandeService, private clientService: ClientService, private magasinService: MagasinService) {
        super(livraisonService);
    }

    ngOnInit(): void {
        this.livraisonItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.livraisonItemsElement.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
    this.demande = new DemandeDto();
    this.demandeService.findAll().subscribe((data) => this.demandes = data);
    this.etatLivraison = new EtatLivraisonDto();
    this.etatLivraisonService.findAll().subscribe((data) => this.etatLivraisons = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
}



    validateLivraisonItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
    }

    public addLivraisonItems() {
        if( this.item.livraisonItems == null )
            this.item.livraisonItems = new Array<LivraisonItemDto>();
       this.validateLivraisonItems();
       if (this.errorMessages.length === 0) {
              this.item.livraisonItems.push({... this.livraisonItemsElement});
              this.livraisonItemsElement = new LivraisonItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteLivraisonItem(p: LivraisonItemDto) {
        this.item.livraisonItems.forEach((element, index) => {
            if (element === p) { this.item.livraisonItems.splice(index, 1); }
        });
    }

    public editLivraisonItem(p: LivraisonItemDto) {
        this.livraisonItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateDemande(demande: string) {
    const isPermistted = await this.roleService.isPermitted('Demande', 'add');
    if(isPermistted) {
         this.demande = new DemandeDto();
         this.createDemandeDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateEtatLivraison(etatLivraison: string) {
    const isPermistted = await this.roleService.isPermitted('EtatLivraison', 'add');
    if(isPermistted) {
         this.etatLivraison = new EtatLivraisonDto();
         this.createEtatLivraisonDialog = true;
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
    get demande(): DemandeDto {
        return this.demandeService.item;
    }
    set demande(value: DemandeDto) {
        this.demandeService.item = value;
    }
    get demandes(): Array<DemandeDto> {
        return this.demandeService.items;
    }
    set demandes(value: Array<DemandeDto>) {
        this.demandeService.items = value;
    }
    get createDemandeDialog(): boolean {
       return this.demandeService.createDialog;
    }
    set createDemandeDialog(value: boolean) {
        this.demandeService.createDialog= value;
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
    get etatLivraison(): EtatLivraisonDto {
        return this.etatLivraisonService.item;
    }
    set etatLivraison(value: EtatLivraisonDto) {
        this.etatLivraisonService.item = value;
    }
    get etatLivraisons(): Array<EtatLivraisonDto> {
        return this.etatLivraisonService.items;
    }
    set etatLivraisons(value: Array<EtatLivraisonDto>) {
        this.etatLivraisonService.items = value;
    }
    get createEtatLivraisonDialog(): boolean {
       return this.etatLivraisonService.createDialog;
    }
    set createEtatLivraisonDialog(value: boolean) {
        this.etatLivraisonService.createDialog= value;
    }




    get validDemandeReference(): boolean {
        return this._validDemandeReference;
    }
    set validDemandeReference(value: boolean) {
        this._validDemandeReference = value;
    }
    get validEtatLivraisonLibelle(): boolean {
        return this._validEtatLivraisonLibelle;
    }
    set validEtatLivraisonLibelle(value: boolean) {
        this._validEtatLivraisonLibelle = value;
    }
    get validEtatLivraisonCode(): boolean {
        return this._validEtatLivraisonCode;
    }
    set validEtatLivraisonCode(value: boolean) {
        this._validEtatLivraisonCode = value;
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

    get livraisonItemsElement(): LivraisonItemDto {
        if( this._livraisonItemsElement == null )
            this._livraisonItemsElement = new LivraisonItemDto();
        return this._livraisonItemsElement;
    }

    set livraisonItemsElement(value: LivraisonItemDto) {
        this._livraisonItemsElement = value;
    }

}
