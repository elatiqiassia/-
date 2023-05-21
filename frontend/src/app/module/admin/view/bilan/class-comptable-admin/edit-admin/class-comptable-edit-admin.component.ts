import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';
import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableCriteria} from 'src/app/controller/criteria/ClassComptableCriteria.model';



@Component({
  selector: 'app-class-comptable-edit-admin',
  templateUrl: './class-comptable-edit-admin.component.html'
})
export class ClassComptableEditAdminComponent extends AbstractEditController<ClassComptableDto, ClassComptableCriteria, ClassComptableService>   implements OnInit {


    private _validClassComptableLibelle = true;
    private _validClassComptableCode = true;




    constructor( private classComptableService: ClassComptableService ) {
        super(classComptableService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validClassComptableLibelle = value;
        this.validClassComptableCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateClassComptableLibelle();
        this.validateClassComptableCode();
    }
    public validateClassComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validClassComptableLibelle = false;
        } else {
            this.validClassComptableLibelle = true;
        }
    }
    public validateClassComptableCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validClassComptableCode = false;
        } else {
            this.validClassComptableCode = true;
        }
    }






    get validClassComptableLibelle(): boolean {
        return this._validClassComptableLibelle;
    }
    set validClassComptableLibelle(value: boolean) {
        this._validClassComptableLibelle = value;
    }
    get validClassComptableCode(): boolean {
        return this._validClassComptableCode;
    }
    set validClassComptableCode(value: boolean) {
        this._validClassComptableCode = value;
    }

}
