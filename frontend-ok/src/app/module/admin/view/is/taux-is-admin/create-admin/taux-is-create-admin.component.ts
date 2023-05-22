import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TauxIsService} from 'src/app/controller/service/TauxIs.service';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';
import {TauxIsCriteria} from 'src/app/controller/criteria/TauxIsCriteria.model';
@Component({
  selector: 'app-taux-is-create-admin',
  templateUrl: './taux-is-create-admin.component.html'
})
export class TauxIsCreateAdminComponent extends AbstractCreateController<TauxIsDto, TauxIsCriteria, TauxIsService>  implements OnInit {




    constructor( private tauxIsService: TauxIsService ) {
        super(tauxIsService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}
