import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatLivraisonService} from 'src/app/controller/service/EtatLivraison.service';
import {EtatLivraisonDto} from 'src/app/controller/model/EtatLivraison.model';
import {EtatLivraisonCriteria} from 'src/app/controller/criteria/EtatLivraisonCriteria.model';



@Component({
  selector: 'app-etat-livraison-edit-admin',
  templateUrl: './etat-livraison-edit-admin.component.html'
})
export class EtatLivraisonEditAdminComponent extends AbstractEditController<EtatLivraisonDto, EtatLivraisonCriteria, EtatLivraisonService>   implements OnInit {


    private _validEtatLivraisonLibelle = true;
    private _validEtatLivraisonCode = true;




    constructor( private etatLivraisonService: EtatLivraisonService ) {
        super(etatLivraisonService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validEtatLivraisonLibelle = value;
        this.validEtatLivraisonCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatLivraisonLibelle();
        this.validateEtatLivraisonCode();
    }
    public validateEtatLivraisonLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validEtatLivraisonLibelle = false;
        } else {
            this.validEtatLivraisonLibelle = true;
        }
    }
    public validateEtatLivraisonCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validEtatLivraisonCode = false;
        } else {
            this.validEtatLivraisonCode = true;
        }
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

}
