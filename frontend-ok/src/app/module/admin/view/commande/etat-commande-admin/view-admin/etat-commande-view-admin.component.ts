import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatCommandeService} from 'src/app/controller/service/EtatCommande.service';
import {EtatCommandeDto} from 'src/app/controller/model/EtatCommande.model';
import {EtatCommandeCriteria} from 'src/app/controller/criteria/EtatCommandeCriteria.model';

@Component({
  selector: 'app-etat-commande-view-admin',
  templateUrl: './etat-commande-view-admin.component.html'
})
export class EtatCommandeViewAdminComponent extends AbstractViewController<EtatCommandeDto, EtatCommandeCriteria, EtatCommandeService> implements OnInit {


    constructor(private etatCommandeService: EtatCommandeService){
        super(etatCommandeService);
    }

    ngOnInit(): void {
    }




}
