import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ComptableTraitantService} from 'src/app/controller/service/ComptableTraitant.service';
import {ComptableTraitantDto} from 'src/app/controller/model/ComptableTraitant.model';
import {ComptableTraitantCriteria} from 'src/app/controller/criteria/ComptableTraitantCriteria.model';
@Component({
  selector: 'app-comptable-traitant-create-admin',
  templateUrl: './comptable-traitant-create-admin.component.html'
})
export class ComptableTraitantCreateAdminComponent extends AbstractCreateController<ComptableTraitantDto, ComptableTraitantCriteria, ComptableTraitantService>  implements OnInit {



   private _validComptableTraitantCin = true;

    constructor( private comptableTraitantService: ComptableTraitantService ) {
        super(comptableTraitantService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validComptableTraitantCin = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateComptableTraitantCin();
    }

    public validateComptableTraitantCin(){
        if (this.stringUtilService.isEmpty(this.item.cin)) {
        this.errorMessages.push('Cin non valide');
        this.validComptableTraitantCin = false;
        } else {
            this.validComptableTraitantCin = true;
        }
    }






    get validComptableTraitantCin(): boolean {
        return this._validComptableTraitantCin;
    }

    set validComptableTraitantCin(value: boolean) {
         this._validComptableTraitantCin = value;
    }



}
