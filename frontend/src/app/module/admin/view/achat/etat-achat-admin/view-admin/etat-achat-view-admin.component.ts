import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatAchatService} from 'src/app/controller/service/EtatAchat.service';
import {EtatAchatDto} from 'src/app/controller/model/EtatAchat.model';
import {EtatAchatCriteria} from 'src/app/controller/criteria/EtatAchatCriteria.model';

@Component({
  selector: 'app-etat-achat-view-admin',
  templateUrl: './etat-achat-view-admin.component.html'
})
export class EtatAchatViewAdminComponent extends AbstractViewController<EtatAchatDto, EtatAchatCriteria, EtatAchatService> implements OnInit {


    constructor(private etatAchatService: EtatAchatService){
        super(etatAchatService);
    }

    ngOnInit(): void {
    }




}
