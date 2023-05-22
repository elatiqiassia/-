import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatPaiementVenteService} from 'src/app/controller/service/EtatPaiementVente.service';
import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {EtatPaiementVenteCriteria} from 'src/app/controller/criteria/EtatPaiementVenteCriteria.model';
@Component({
  selector: 'app-etat-paiement-vente-create-admin',
  templateUrl: './etat-paiement-vente-create-admin.component.html'
})
export class EtatPaiementVenteCreateAdminComponent extends AbstractCreateController<EtatPaiementVenteDto, EtatPaiementVenteCriteria, EtatPaiementVenteService>  implements OnInit {



   private _validEtatPaiementVenteLibelle = true;
   private _validEtatPaiementVenteCode = true;

    constructor( private etatPaiementVenteService: EtatPaiementVenteService ) {
        super(etatPaiementVenteService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatPaiementVenteLibelle = value;
        this.validEtatPaiementVenteCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatPaiementVenteLibelle();
        this.validateEtatPaiementVenteCode();
    }

    public validateEtatPaiementVenteLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatPaiementVenteLibelle = false;
        } else {
            this.validEtatPaiementVenteLibelle = true;
        }
    }
    public validateEtatPaiementVenteCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatPaiementVenteCode = false;
        } else {
            this.validEtatPaiementVenteCode = true;
        }
    }






    get validEtatPaiementVenteLibelle(): boolean {
        return this._validEtatPaiementVenteLibelle;
    }

    set validEtatPaiementVenteLibelle(value: boolean) {
         this._validEtatPaiementVenteLibelle = value;
    }
    get validEtatPaiementVenteCode(): boolean {
        return this._validEtatPaiementVenteCode;
    }

    set validEtatPaiementVenteCode(value: boolean) {
         this._validEtatPaiementVenteCode = value;
    }



}
