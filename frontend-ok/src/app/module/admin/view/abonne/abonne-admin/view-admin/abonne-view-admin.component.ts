import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AbonneService} from 'src/app/controller/service/Abonne.service';
import {AbonneDto} from 'src/app/controller/model/Abonne.model';
import {AbonneCriteria} from 'src/app/controller/criteria/AbonneCriteria.model';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-abonne-view-admin',
  templateUrl: './abonne-view-admin.component.html'
})
export class AbonneViewAdminComponent extends AbstractViewController<AbonneDto, AbonneCriteria, AbonneService> implements OnInit {

    societes = new SocieteDto();
    societess: Array<SocieteDto> = [];

    constructor(private abonneService: AbonneService, private societeService: SocieteService){
        super(abonneService);
    }

    ngOnInit(): void {
    }




}
