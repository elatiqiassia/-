import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementCriteria} from 'src/app/controller/criteria/ModePaiementCriteria.model';

@Component({
  selector: 'app-mode-paiement-view-admin',
  templateUrl: './mode-paiement-view-admin.component.html'
})
export class ModePaiementViewAdminComponent extends AbstractViewController<ModePaiementDto, ModePaiementCriteria, ModePaiementService> implements OnInit {


    constructor(private modePaiementService: ModePaiementService){
        super(modePaiementService);
    }

    ngOnInit(): void {
    }




}
