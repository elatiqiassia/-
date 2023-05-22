import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatAchatService} from 'src/app/controller/service/EtatAchat.service';
import {EtatAchatDto} from 'src/app/controller/model/EtatAchat.model';
import {EtatAchatCriteria} from 'src/app/controller/criteria/EtatAchatCriteria.model';



@Component({
  selector: 'app-etat-achat-edit-admin',
  templateUrl: './etat-achat-edit-admin.component.html'
})
export class EtatAchatEditAdminComponent extends AbstractEditController<EtatAchatDto, EtatAchatCriteria, EtatAchatService>   implements OnInit {


    private _validEtatAchatLibelle = true;
    private _validEtatAchatCode = true;




    constructor( private etatAchatService: EtatAchatService ) {
        super(etatAchatService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validEtatAchatLibelle = value;
        this.validEtatAchatCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatAchatLibelle();
        this.validateEtatAchatCode();
    }
    public validateEtatAchatLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validEtatAchatLibelle = false;
        } else {
            this.validEtatAchatLibelle = true;
        }
    }
    public validateEtatAchatCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validEtatAchatCode = false;
        } else {
            this.validEtatAchatCode = true;
        }
    }






    get validEtatAchatLibelle(): boolean {
        return this._validEtatAchatLibelle;
    }
    set validEtatAchatLibelle(value: boolean) {
        this._validEtatAchatLibelle = value;
    }
    get validEtatAchatCode(): boolean {
        return this._validEtatAchatCode;
    }
    set validEtatAchatCode(value: boolean) {
        this._validEtatAchatCode = value;
    }

}
