import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {UniteMesureService} from 'src/app/controller/service/UniteMesure.service';
import {UniteMesureDto} from 'src/app/controller/model/UniteMesure.model';
import {UniteMesureCriteria} from 'src/app/controller/criteria/UniteMesureCriteria.model';

@Component({
  selector: 'app-unite-mesure-view-admin',
  templateUrl: './unite-mesure-view-admin.component.html'
})
export class UniteMesureViewAdminComponent extends AbstractViewController<UniteMesureDto, UniteMesureCriteria, UniteMesureService> implements OnInit {


    constructor(private uniteMesureService: UniteMesureService){
        super(uniteMesureService);
    }

    ngOnInit(): void {
    }




}
