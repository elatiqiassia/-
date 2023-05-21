import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProprietaireChequeService} from 'src/app/controller/service/ProprietaireCheque.service';
import {ProprietaireChequeDto} from 'src/app/controller/model/ProprietaireCheque.model';
import {ProprietaireChequeCriteria} from 'src/app/controller/criteria/ProprietaireChequeCriteria.model';



@Component({
  selector: 'app-proprietaire-cheque-edit-admin',
  templateUrl: './proprietaire-cheque-edit-admin.component.html'
})
export class ProprietaireChequeEditAdminComponent extends AbstractEditController<ProprietaireChequeDto, ProprietaireChequeCriteria, ProprietaireChequeService>   implements OnInit {


    private _validProprietaireChequeNom = true;
    private _validProprietaireChequeCode = true;




    constructor( private proprietaireChequeService: ProprietaireChequeService ) {
        super(proprietaireChequeService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validProprietaireChequeNom = value;
        this.validProprietaireChequeCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProprietaireChequeNom();
        this.validateProprietaireChequeCode();
    }
    public validateProprietaireChequeNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validProprietaireChequeNom = false;
        } else {
            this.validProprietaireChequeNom = true;
        }
    }
    public validateProprietaireChequeCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validProprietaireChequeCode = false;
        } else {
            this.validProprietaireChequeCode = true;
        }
    }






    get validProprietaireChequeNom(): boolean {
        return this._validProprietaireChequeNom;
    }
    set validProprietaireChequeNom(value: boolean) {
        this._validProprietaireChequeNom = value;
    }
    get validProprietaireChequeCode(): boolean {
        return this._validProprietaireChequeCode;
    }
    set validProprietaireChequeCode(value: boolean) {
        this._validProprietaireChequeCode = value;
    }

}
