import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TauxIsService} from 'src/app/controller/service/TauxIs.service';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';
import {TauxIsCriteria} from 'src/app/controller/criteria/TauxIsCriteria.model';



@Component({
  selector: 'app-taux-is-edit-admin',
  templateUrl: './taux-is-edit-admin.component.html'
})
export class TauxIsEditAdminComponent extends AbstractEditController<TauxIsDto, TauxIsCriteria, TauxIsService>   implements OnInit {






    constructor( private tauxIsService: TauxIsService ) {
        super(tauxIsService);
    }

    ngOnInit(): void {
}
    public prepareEdit() {
        this.item.dateApplicationMin = this.tauxIsService.format(this.item.dateApplicationMin);
        this.item.dateApplicationMax = this.tauxIsService.format(this.item.dateApplicationMax);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}
