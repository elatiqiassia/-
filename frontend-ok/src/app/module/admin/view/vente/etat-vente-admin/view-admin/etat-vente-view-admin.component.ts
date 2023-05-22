import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatVenteService} from 'src/app/controller/service/EtatVente.service';
import {EtatVenteDto} from 'src/app/controller/model/EtatVente.model';
import {EtatVenteCriteria} from 'src/app/controller/criteria/EtatVenteCriteria.model';

@Component({
  selector: 'app-etat-vente-view-admin',
  templateUrl: './etat-vente-view-admin.component.html'
})
export class EtatVenteViewAdminComponent extends AbstractViewController<EtatVenteDto, EtatVenteCriteria, EtatVenteService> implements OnInit {


    constructor(private etatVenteService: EtatVenteService){
        super(etatVenteService);
    }

    ngOnInit(): void {
    }




}
