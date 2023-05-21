import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatPaiementCommandeService} from 'src/app/controller/service/EtatPaiementCommande.service';
import {EtatPaiementCommandeDto} from 'src/app/controller/model/EtatPaiementCommande.model';
import {EtatPaiementCommandeCriteria} from 'src/app/controller/criteria/EtatPaiementCommandeCriteria.model';
@Component({
  selector: 'app-etat-paiement-commande-create-admin',
  templateUrl: './etat-paiement-commande-create-admin.component.html'
})
export class EtatPaiementCommandeCreateAdminComponent extends AbstractCreateController<EtatPaiementCommandeDto, EtatPaiementCommandeCriteria, EtatPaiementCommandeService>  implements OnInit {



   private _validEtatPaiementCommandeLibelle = true;
   private _validEtatPaiementCommandeCode = true;

    constructor( private etatPaiementCommandeService: EtatPaiementCommandeService ) {
        super(etatPaiementCommandeService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatPaiementCommandeLibelle = value;
        this.validEtatPaiementCommandeCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatPaiementCommandeLibelle();
        this.validateEtatPaiementCommandeCode();
    }

    public validateEtatPaiementCommandeLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatPaiementCommandeLibelle = false;
        } else {
            this.validEtatPaiementCommandeLibelle = true;
        }
    }
    public validateEtatPaiementCommandeCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatPaiementCommandeCode = false;
        } else {
            this.validEtatPaiementCommandeCode = true;
        }
    }






    get validEtatPaiementCommandeLibelle(): boolean {
        return this._validEtatPaiementCommandeLibelle;
    }

    set validEtatPaiementCommandeLibelle(value: boolean) {
         this._validEtatPaiementCommandeLibelle = value;
    }
    get validEtatPaiementCommandeCode(): boolean {
        return this._validEtatPaiementCommandeCode;
    }

    set validEtatPaiementCommandeCode(value: boolean) {
         this._validEtatPaiementCommandeCode = value;
    }



}
