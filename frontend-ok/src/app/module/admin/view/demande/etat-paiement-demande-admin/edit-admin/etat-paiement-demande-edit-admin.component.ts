import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatPaiementDemandeService} from 'src/app/controller/service/EtatPaiementDemande.service';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';
import {EtatPaiementDemandeCriteria} from 'src/app/controller/criteria/EtatPaiementDemandeCriteria.model';



@Component({
  selector: 'app-etat-paiement-demande-edit-admin',
  templateUrl: './etat-paiement-demande-edit-admin.component.html'
})
export class EtatPaiementDemandeEditAdminComponent extends AbstractEditController<EtatPaiementDemandeDto, EtatPaiementDemandeCriteria, EtatPaiementDemandeService>   implements OnInit {


    private _validEtatPaiementDemandeLibelle = true;
    private _validEtatPaiementDemandeCode = true;




    constructor( private etatPaiementDemandeService: EtatPaiementDemandeService ) {
        super(etatPaiementDemandeService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validEtatPaiementDemandeLibelle = value;
        this.validEtatPaiementDemandeCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatPaiementDemandeLibelle();
        this.validateEtatPaiementDemandeCode();
    }
    public validateEtatPaiementDemandeLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validEtatPaiementDemandeLibelle = false;
        } else {
            this.validEtatPaiementDemandeLibelle = true;
        }
    }
    public validateEtatPaiementDemandeCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validEtatPaiementDemandeCode = false;
        } else {
            this.validEtatPaiementDemandeCode = true;
        }
    }






    get validEtatPaiementDemandeLibelle(): boolean {
        return this._validEtatPaiementDemandeLibelle;
    }
    set validEtatPaiementDemandeLibelle(value: boolean) {
        this._validEtatPaiementDemandeLibelle = value;
    }
    get validEtatPaiementDemandeCode(): boolean {
        return this._validEtatPaiementDemandeCode;
    }
    set validEtatPaiementDemandeCode(value: boolean) {
        this._validEtatPaiementDemandeCode = value;
    }

}
