import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TauxIsService} from 'src/app/controller/service/TauxIs.service';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';
import {TauxIsCriteria} from 'src/app/controller/criteria/TauxIsCriteria.model';

@Component({
  selector: 'app-taux-is-view-admin',
  templateUrl: './taux-is-view-admin.component.html'
})
export class TauxIsViewAdminComponent extends AbstractViewController<TauxIsDto, TauxIsCriteria, TauxIsService> implements OnInit {


    constructor(private tauxIsService: TauxIsService){
        super(tauxIsService);
    }

    ngOnInit(): void {
    }




}
