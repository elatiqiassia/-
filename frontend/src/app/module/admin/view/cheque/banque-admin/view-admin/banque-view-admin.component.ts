import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BanqueService} from 'src/app/controller/service/Banque.service';
import {BanqueDto} from 'src/app/controller/model/Banque.model';
import {BanqueCriteria} from 'src/app/controller/criteria/BanqueCriteria.model';

@Component({
  selector: 'app-banque-view-admin',
  templateUrl: './banque-view-admin.component.html'
})
export class BanqueViewAdminComponent extends AbstractViewController<BanqueDto, BanqueCriteria, BanqueService> implements OnInit {


    constructor(private banqueService: BanqueService){
        super(banqueService);
    }

    ngOnInit(): void {
    }




}
