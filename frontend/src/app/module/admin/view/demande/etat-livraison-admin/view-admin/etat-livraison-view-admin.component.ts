import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatLivraisonService} from 'src/app/controller/service/EtatLivraison.service';
import {EtatLivraisonDto} from 'src/app/controller/model/EtatLivraison.model';
import {EtatLivraisonCriteria} from 'src/app/controller/criteria/EtatLivraisonCriteria.model';

@Component({
  selector: 'app-etat-livraison-view-admin',
  templateUrl: './etat-livraison-view-admin.component.html'
})
export class EtatLivraisonViewAdminComponent extends AbstractViewController<EtatLivraisonDto, EtatLivraisonCriteria, EtatLivraisonService> implements OnInit {


    constructor(private etatLivraisonService: EtatLivraisonService){
        super(etatLivraisonService);
    }

    ngOnInit(): void {
    }




}
