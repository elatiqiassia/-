import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatPaiementAchatService} from 'src/app/controller/service/EtatPaiementAchat.service';
import {EtatPaiementAchatDto} from 'src/app/controller/model/EtatPaiementAchat.model';
import {EtatPaiementAchatCriteria} from 'src/app/controller/criteria/EtatPaiementAchatCriteria.model';
@Component({
  selector: 'app-etat-paiement-achat-create-admin',
  templateUrl: './etat-paiement-achat-create-admin.component.html'
})
export class EtatPaiementAchatCreateAdminComponent extends AbstractCreateController<EtatPaiementAchatDto, EtatPaiementAchatCriteria, EtatPaiementAchatService>  implements OnInit {



   private _validEtatPaiementAchatLibelle = true;
   private _validEtatPaiementAchatCode = true;

    constructor( private etatPaiementAchatService: EtatPaiementAchatService ) {
        super(etatPaiementAchatService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatPaiementAchatLibelle = value;
        this.validEtatPaiementAchatCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatPaiementAchatLibelle();
        this.validateEtatPaiementAchatCode();
    }

    public validateEtatPaiementAchatLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatPaiementAchatLibelle = false;
        } else {
            this.validEtatPaiementAchatLibelle = true;
        }
    }
    public validateEtatPaiementAchatCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatPaiementAchatCode = false;
        } else {
            this.validEtatPaiementAchatCode = true;
        }
    }






    get validEtatPaiementAchatLibelle(): boolean {
        return this._validEtatPaiementAchatLibelle;
    }

    set validEtatPaiementAchatLibelle(value: boolean) {
         this._validEtatPaiementAchatLibelle = value;
    }
    get validEtatPaiementAchatCode(): boolean {
        return this._validEtatPaiementAchatCode;
    }

    set validEtatPaiementAchatCode(value: boolean) {
         this._validEtatPaiementAchatCode = value;
    }



}
