import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {FournisseurService} from 'src/app/controller/service/Fournisseur.service';
import {FournisseurDto} from 'src/app/controller/model/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/FournisseurCriteria.model';
@Component({
  selector: 'app-fournisseur-create-admin',
  templateUrl: './fournisseur-create-admin.component.html'
})
export class FournisseurCreateAdminComponent extends AbstractCreateController<FournisseurDto, FournisseurCriteria, FournisseurService>  implements OnInit {



   private _validFournisseurIce = true;
   private _validFournisseurNom = true;

    constructor( private fournisseurService: FournisseurService ) {
        super(fournisseurService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validFournisseurIce = value;
        this.validFournisseurNom = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateFournisseurIce();
        this.validateFournisseurNom();
    }

    public validateFournisseurIce(){
        if (this.stringUtilService.isEmpty(this.item.ice)) {
        this.errorMessages.push('Ice non valide');
        this.validFournisseurIce = false;
        } else {
            this.validFournisseurIce = true;
        }
    }
    public validateFournisseurNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validFournisseurNom = false;
        } else {
            this.validFournisseurNom = true;
        }
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



}
