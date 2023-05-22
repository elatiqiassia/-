import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatDemandeService} from 'src/app/controller/service/EtatDemande.service';
import {EtatDemandeDto} from 'src/app/controller/model/EtatDemande.model';
import {EtatDemandeCriteria} from 'src/app/controller/criteria/EtatDemandeCriteria.model';

@Component({
  selector: 'app-etat-demande-view-admin',
  templateUrl: './etat-demande-view-admin.component.html'
})
export class EtatDemandeViewAdminComponent extends AbstractViewController<EtatDemandeDto, EtatDemandeCriteria, EtatDemandeService> implements OnInit {


    constructor(private etatDemandeService: EtatDemandeService){
        super(etatDemandeService);
    }

    ngOnInit(): void {
    }




}
