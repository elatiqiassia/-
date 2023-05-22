import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CategorieProduitService} from 'src/app/controller/service/CategorieProduit.service';
import {CategorieProduitDto} from 'src/app/controller/model/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/controller/criteria/CategorieProduitCriteria.model';



@Component({
  selector: 'app-categorie-produit-edit-admin',
  templateUrl: './categorie-produit-edit-admin.component.html'
})
export class CategorieProduitEditAdminComponent extends AbstractEditController<CategorieProduitDto, CategorieProduitCriteria, CategorieProduitService>   implements OnInit {


    private _validCategorieProduitReference = true;
    private _validCategorieProduitLibelle = true;




    constructor( private categorieProduitService: CategorieProduitService ) {
        super(categorieProduitService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validCategorieProduitReference = value;
        this.validCategorieProduitLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategorieProduitReference();
        this.validateCategorieProduitLibelle();
    }
    public validateCategorieProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validCategorieProduitReference = false;
        } else {
            this.validCategorieProduitReference = true;
        }
    }
    public validateCategorieProduitLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validCategorieProduitLibelle = false;
        } else {
            this.validCategorieProduitLibelle = true;
        }
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

}
