import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatAvoirAchatService} from 'src/app/controller/service/EtatAvoirAchat.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from 'src/app/controller/criteria/EtatAvoirAchatCriteria.model';

@Component({
  selector: 'app-etat-avoir-achat-view-admin',
  templateUrl: './etat-avoir-achat-view-admin.component.html'
})
export class EtatAvoirAchatViewAdminComponent extends AbstractViewController<EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatService> implements OnInit {


    constructor(private etatAvoirAchatService: EtatAvoirAchatService){
        super(etatAvoirAchatService);
    }

    ngOnInit(): void {
    }




}
