import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatAvoirAchatService} from 'src/app/controller/service/EtatAvoirAchat.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from 'src/app/controller/criteria/EtatAvoirAchatCriteria.model';
@Component({
  selector: 'app-etat-avoir-achat-create-admin',
  templateUrl: './etat-avoir-achat-create-admin.component.html'
})
export class EtatAvoirAchatCreateAdminComponent extends AbstractCreateController<EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatService>  implements OnInit {



   private _validEtatAvoirAchatLibelle = true;
   private _validEtatAvoirAchatCode = true;

    constructor( private etatAvoirAchatService: EtatAvoirAchatService ) {
        super(etatAvoirAchatService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatAvoirAchatLibelle = value;
        this.validEtatAvoirAchatCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatAvoirAchatLibelle();
        this.validateEtatAvoirAchatCode();
    }

    public validateEtatAvoirAchatLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatAvoirAchatLibelle = false;
        } else {
            this.validEtatAvoirAchatLibelle = true;
        }
    }
    public validateEtatAvoirAchatCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatAvoirAchatCode = false;
        } else {
            this.validEtatAvoirAchatCode = true;
        }
    }






    get validEtatAvoirAchatLibelle(): boolean {
        return this._validEtatAvoirAchatLibelle;
    }

    set validEtatAvoirAchatLibelle(value: boolean) {
         this._validEtatAvoirAchatLibelle = value;
    }
    get validEtatAvoirAchatCode(): boolean {
        return this._validEtatAvoirAchatCode;
    }

    set validEtatAvoirAchatCode(value: boolean) {
         this._validEtatAvoirAchatCode = value;
    }



}
