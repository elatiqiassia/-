import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {DevisFournisseurService} from 'src/app/controller/service/DevisFournisseur.service';
import {DevisFournisseurDto} from 'src/app/controller/model/DevisFournisseur.model';
import {DevisFournisseurCriteria} from 'src/app/controller/criteria/DevisFournisseurCriteria.model';
import {DevisItemFournisseurDto} from 'src/app/controller/model/DevisItemFournisseur.model';
import {DevisItemFournisseurService} from 'src/app/controller/service/DevisItemFournisseur.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {FournisseurDto} from 'src/app/controller/model/Fournisseur.model';
import {FournisseurService} from 'src/app/controller/service/Fournisseur.service';
@Component({
  selector: 'app-devis-fournisseur-create-admin',
  templateUrl: './devis-fournisseur-create-admin.component.html'
})
export class DevisFournisseurCreateAdminComponent extends AbstractCreateController<DevisFournisseurDto, DevisFournisseurCriteria, DevisFournisseurService>  implements OnInit {

    private _devisItemFournisseursElement = new DevisItemFournisseurDto();


   private _validDevisFournisseurReference = true;
    private _validFournisseurIce = true;
    private _validFournisseurNom = true;

    constructor( private devisFournisseurService: DevisFournisseurService , private devisItemFournisseurService: DevisItemFournisseurService, private produitService: ProduitService, private fournisseurService: FournisseurService) {
        super(devisFournisseurService);
    }

    ngOnInit(): void {
        this.devisItemFournisseursElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
    this.fournisseur = new FournisseurDto();
    this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
}



    validateDevisItemFournisseurs(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
        this.validDevisFournisseurReference = value;
    }

    public addDevisItemFournisseurs() {
        if( this.item.devisItemFournisseurs == null )
            this.item.devisItemFournisseurs = new Array<DevisItemFournisseurDto>();
       this.validateDevisItemFournisseurs();
       if (this.errorMessages.length === 0) {
              this.item.devisItemFournisseurs.push({... this.devisItemFournisseursElement});
              this.devisItemFournisseursElement = new DevisItemFournisseurDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteDevisItemFournisseur(p: DevisItemFournisseurDto) {
        this.item.devisItemFournisseurs.forEach((element, index) => {
            if (element === p) { this.item.devisItemFournisseurs.splice(index, 1); }
        });
    }

    public editDevisItemFournisseur(p: DevisItemFournisseurDto) {
        this.devisItemFournisseursElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDevisFournisseurReference();
    }

    public validateDevisFournisseurReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validDevisFournisseurReference = false;
        } else {
            this.validDevisFournisseurReference = true;
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



    get validDevisFournisseurReference(): boolean {
        return this._validDevisFournisseurReference;
    }

    set validDevisFournisseurReference(value: boolean) {
         this._validDevisFournisseurReference = value;
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

    get devisItemFournisseursElement(): DevisItemFournisseurDto {
        if( this._devisItemFournisseursElement == null )
            this._devisItemFournisseursElement = new DevisItemFournisseurDto();
        return this._devisItemFournisseursElement;
    }

    set devisItemFournisseursElement(value: DevisItemFournisseurDto) {
        this._devisItemFournisseursElement = value;
    }

}
