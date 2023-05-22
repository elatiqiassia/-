import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TauxRetardTvaService} from 'src/app/controller/service/TauxRetardTva.service';
import {TauxRetardTvaDto} from 'src/app/controller/model/TauxRetardTva.model';
import {TauxRetardTvaCriteria} from 'src/app/controller/criteria/TauxRetardTvaCriteria.model';

@Component({
  selector: 'app-taux-retard-tva-view-admin',
  templateUrl: './taux-retard-tva-view-admin.component.html'
})
export class TauxRetardTvaViewAdminComponent extends AbstractViewController<TauxRetardTvaDto, TauxRetardTvaCriteria, TauxRetardTvaService> implements OnInit {


    constructor(private tauxRetardTvaService: TauxRetardTvaService){
        super(tauxRetardTvaService);
    }

    ngOnInit(): void {
    }




}
