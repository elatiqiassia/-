import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatReceptionService} from 'src/app/controller/service/EtatReception.service';
import {EtatReceptionDto} from 'src/app/controller/model/EtatReception.model';
import {EtatReceptionCriteria} from 'src/app/controller/criteria/EtatReceptionCriteria.model';

@Component({
  selector: 'app-etat-reception-view-admin',
  templateUrl: './etat-reception-view-admin.component.html'
})
export class EtatReceptionViewAdminComponent extends AbstractViewController<EtatReceptionDto, EtatReceptionCriteria, EtatReceptionService> implements OnInit {


    constructor(private etatReceptionService: EtatReceptionService){
        super(etatReceptionService);
    }

    ngOnInit(): void {
    }




}
