import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatAvoirVenteService} from 'src/app/controller/service/EtatAvoirVente.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/EtatAvoirVente.model';
import {EtatAvoirVenteCriteria} from 'src/app/controller/criteria/EtatAvoirVenteCriteria.model';

@Component({
  selector: 'app-etat-avoir-vente-view-admin',
  templateUrl: './etat-avoir-vente-view-admin.component.html'
})
export class EtatAvoirVenteViewAdminComponent extends AbstractViewController<EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteService> implements OnInit {


    constructor(private etatAvoirVenteService: EtatAvoirVenteService){
        super(etatAvoirVenteService);
    }

    ngOnInit(): void {
    }




}
