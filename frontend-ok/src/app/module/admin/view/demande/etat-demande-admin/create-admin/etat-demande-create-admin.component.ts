import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatDemandeService} from 'src/app/controller/service/EtatDemande.service';
import {EtatDemandeDto} from 'src/app/controller/model/EtatDemande.model';
import {EtatDemandeCriteria} from 'src/app/controller/criteria/EtatDemandeCriteria.model';
@Component({
  selector: 'app-etat-demande-create-admin',
  templateUrl: './etat-demande-create-admin.component.html'
})
export class EtatDemandeCreateAdminComponent extends AbstractCreateController<EtatDemandeDto, EtatDemandeCriteria, EtatDemandeService>  implements OnInit {



   private _validEtatDemandeLibelle = true;
   private _validEtatDemandeCode = true;

    constructor( private etatDemandeService: EtatDemandeService ) {
        super(etatDemandeService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatDemandeLibelle = value;
        this.validEtatDemandeCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatDemandeLibelle();
        this.validateEtatDemandeCode();
    }

    public validateEtatDemandeLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatDemandeLibelle = false;
        } else {
            this.validEtatDemandeLibelle = true;
        }
    }
    public validateEtatDemandeCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatDemandeCode = false;
        } else {
            this.validEtatDemandeCode = true;
        }
    }






    get validEtatDemandeLibelle(): boolean {
        return this._validEtatDemandeLibelle;
    }

    set validEtatDemandeLibelle(value: boolean) {
         this._validEtatDemandeLibelle = value;
    }
    get validEtatDemandeCode(): boolean {
        return this._validEtatDemandeCode;
    }

    set validEtatDemandeCode(value: boolean) {
         this._validEtatDemandeCode = value;
    }



}
