import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TauxRetardTvaService} from 'src/app/controller/service/TauxRetardTva.service';
import {TauxRetardTvaDto} from 'src/app/controller/model/TauxRetardTva.model';
import {TauxRetardTvaCriteria} from 'src/app/controller/criteria/TauxRetardTvaCriteria.model';



@Component({
  selector: 'app-taux-retard-tva-edit-admin',
  templateUrl: './taux-retard-tva-edit-admin.component.html'
})
export class TauxRetardTvaEditAdminComponent extends AbstractEditController<TauxRetardTvaDto, TauxRetardTvaCriteria, TauxRetardTvaService>   implements OnInit {






    constructor( private tauxRetardTvaService: TauxRetardTvaService ) {
        super(tauxRetardTvaService);
    }

    ngOnInit(): void {
}
    public prepareEdit() {
        this.item.dateApplicationMin = this.tauxRetardTvaService.format(this.item.dateApplicationMin);
        this.item.dateApplicationMax = this.tauxRetardTvaService.format(this.item.dateApplicationMax);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}
