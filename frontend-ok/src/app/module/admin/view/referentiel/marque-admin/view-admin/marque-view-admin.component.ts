import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {MarqueService} from 'src/app/controller/service/Marque.service';
import {MarqueDto} from 'src/app/controller/model/Marque.model';
import {MarqueCriteria} from 'src/app/controller/criteria/MarqueCriteria.model';

@Component({
  selector: 'app-marque-view-admin',
  templateUrl: './marque-view-admin.component.html'
})
export class MarqueViewAdminComponent extends AbstractViewController<MarqueDto, MarqueCriteria, MarqueService> implements OnInit {


    constructor(private marqueService: MarqueService){
        super(marqueService);
    }

    ngOnInit(): void {
    }




}
