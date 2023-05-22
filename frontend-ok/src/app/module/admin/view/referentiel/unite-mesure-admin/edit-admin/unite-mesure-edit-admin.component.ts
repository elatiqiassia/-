import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {UniteMesureService} from 'src/app/controller/service/UniteMesure.service';
import {UniteMesureDto} from 'src/app/controller/model/UniteMesure.model';
import {UniteMesureCriteria} from 'src/app/controller/criteria/UniteMesureCriteria.model';



@Component({
  selector: 'app-unite-mesure-edit-admin',
  templateUrl: './unite-mesure-edit-admin.component.html'
})
export class UniteMesureEditAdminComponent extends AbstractEditController<UniteMesureDto, UniteMesureCriteria, UniteMesureService>   implements OnInit {


    private _validUniteMesureLibelle = true;
    private _validUniteMesureCode = true;




    constructor( private uniteMesureService: UniteMesureService ) {
        super(uniteMesureService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validUniteMesureLibelle = value;
        this.validUniteMesureCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateUniteMesureLibelle();
        this.validateUniteMesureCode();
    }
    public validateUniteMesureLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validUniteMesureLibelle = false;
        } else {
            this.validUniteMesureLibelle = true;
        }
    }
    public validateUniteMesureCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validUniteMesureCode = false;
        } else {
            this.validUniteMesureCode = true;
        }
    }






    get validUniteMesureLibelle(): boolean {
        return this._validUniteMesureLibelle;
    }
    set validUniteMesureLibelle(value: boolean) {
        this._validUniteMesureLibelle = value;
    }
    get validUniteMesureCode(): boolean {
        return this._validUniteMesureCode;
    }
    set validUniteMesureCode(value: boolean) {
        this._validUniteMesureCode = value;
    }

}
