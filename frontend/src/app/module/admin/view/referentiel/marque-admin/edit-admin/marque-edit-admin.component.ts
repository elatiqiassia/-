import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {MarqueService} from 'src/app/controller/service/Marque.service';
import {MarqueDto} from 'src/app/controller/model/Marque.model';
import {MarqueCriteria} from 'src/app/controller/criteria/MarqueCriteria.model';



@Component({
  selector: 'app-marque-edit-admin',
  templateUrl: './marque-edit-admin.component.html'
})
export class MarqueEditAdminComponent extends AbstractEditController<MarqueDto, MarqueCriteria, MarqueService>   implements OnInit {


    private _validMarqueLibelle = true;
    private _validMarqueCode = true;




    constructor( private marqueService: MarqueService ) {
        super(marqueService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validMarqueLibelle = value;
        this.validMarqueCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateMarqueLibelle();
        this.validateMarqueCode();
    }
    public validateMarqueLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validMarqueLibelle = false;
        } else {
            this.validMarqueLibelle = true;
        }
    }
    public validateMarqueCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validMarqueCode = false;
        } else {
            this.validMarqueCode = true;
        }
    }






    get validMarqueLibelle(): boolean {
        return this._validMarqueLibelle;
    }
    set validMarqueLibelle(value: boolean) {
        this._validMarqueLibelle = value;
    }
    get validMarqueCode(): boolean {
        return this._validMarqueCode;
    }
    set validMarqueCode(value: boolean) {
        this._validMarqueCode = value;
    }

}
