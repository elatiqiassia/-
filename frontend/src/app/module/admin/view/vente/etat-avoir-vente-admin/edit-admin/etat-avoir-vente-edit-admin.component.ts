import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatAvoirVenteService} from 'src/app/controller/service/EtatAvoirVente.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/EtatAvoirVente.model';
import {EtatAvoirVenteCriteria} from 'src/app/controller/criteria/EtatAvoirVenteCriteria.model';



@Component({
  selector: 'app-etat-avoir-vente-edit-admin',
  templateUrl: './etat-avoir-vente-edit-admin.component.html'
})
export class EtatAvoirVenteEditAdminComponent extends AbstractEditController<EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteService>   implements OnInit {


    private _validEtatAvoirVenteLibelle = true;
    private _validEtatAvoirVenteCode = true;




    constructor( private etatAvoirVenteService: EtatAvoirVenteService ) {
        super(etatAvoirVenteService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validEtatAvoirVenteLibelle = value;
        this.validEtatAvoirVenteCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatAvoirVenteLibelle();
        this.validateEtatAvoirVenteCode();
    }
    public validateEtatAvoirVenteLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validEtatAvoirVenteLibelle = false;
        } else {
            this.validEtatAvoirVenteLibelle = true;
        }
    }
    public validateEtatAvoirVenteCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validEtatAvoirVenteCode = false;
        } else {
            this.validEtatAvoirVenteCode = true;
        }
    }






    get validEtatAvoirVenteLibelle(): boolean {
        return this._validEtatAvoirVenteLibelle;
    }
    set validEtatAvoirVenteLibelle(value: boolean) {
        this._validEtatAvoirVenteLibelle = value;
    }
    get validEtatAvoirVenteCode(): boolean {
        return this._validEtatAvoirVenteCode;
    }
    set validEtatAvoirVenteCode(value: boolean) {
        this._validEtatAvoirVenteCode = value;
    }

}
