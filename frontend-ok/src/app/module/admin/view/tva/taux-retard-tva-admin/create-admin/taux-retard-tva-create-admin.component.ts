import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TauxRetardTvaService} from 'src/app/controller/service/TauxRetardTva.service';
import {TauxRetardTvaDto} from 'src/app/controller/model/TauxRetardTva.model';
import {TauxRetardTvaCriteria} from 'src/app/controller/criteria/TauxRetardTvaCriteria.model';
@Component({
  selector: 'app-taux-retard-tva-create-admin',
  templateUrl: './taux-retard-tva-create-admin.component.html'
})
export class TauxRetardTvaCreateAdminComponent extends AbstractCreateController<TauxRetardTvaDto, TauxRetardTvaCriteria, TauxRetardTvaService>  implements OnInit {




    constructor( private tauxRetardTvaService: TauxRetardTvaService ) {
        super(tauxRetardTvaService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}
