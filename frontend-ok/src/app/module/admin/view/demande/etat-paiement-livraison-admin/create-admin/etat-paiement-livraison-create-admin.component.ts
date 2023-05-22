import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatPaiementLivraisonService} from 'src/app/controller/service/EtatPaiementLivraison.service';
import {EtatPaiementLivraisonDto} from 'src/app/controller/model/EtatPaiementLivraison.model';
import {EtatPaiementLivraisonCriteria} from 'src/app/controller/criteria/EtatPaiementLivraisonCriteria.model';
@Component({
  selector: 'app-etat-paiement-livraison-create-admin',
  templateUrl: './etat-paiement-livraison-create-admin.component.html'
})
export class EtatPaiementLivraisonCreateAdminComponent extends AbstractCreateController<EtatPaiementLivraisonDto, EtatPaiementLivraisonCriteria, EtatPaiementLivraisonService>  implements OnInit {



   private _validEtatPaiementLivraisonLibelle = true;
   private _validEtatPaiementLivraisonCode = true;

    constructor( private etatPaiementLivraisonService: EtatPaiementLivraisonService ) {
        super(etatPaiementLivraisonService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatPaiementLivraisonLibelle = value;
        this.validEtatPaiementLivraisonCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatPaiementLivraisonLibelle();
        this.validateEtatPaiementLivraisonCode();
    }

    public validateEtatPaiementLivraisonLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatPaiementLivraisonLibelle = false;
        } else {
            this.validEtatPaiementLivraisonLibelle = true;
        }
    }
    public validateEtatPaiementLivraisonCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatPaiementLivraisonCode = false;
        } else {
            this.validEtatPaiementLivraisonCode = true;
        }
    }






    get validEtatPaiementLivraisonLibelle(): boolean {
        return this._validEtatPaiementLivraisonLibelle;
    }

    set validEtatPaiementLivraisonLibelle(value: boolean) {
         this._validEtatPaiementLivraisonLibelle = value;
    }
    get validEtatPaiementLivraisonCode(): boolean {
        return this._validEtatPaiementLivraisonCode;
    }

    set validEtatPaiementLivraisonCode(value: boolean) {
         this._validEtatPaiementLivraisonCode = value;
    }



}
