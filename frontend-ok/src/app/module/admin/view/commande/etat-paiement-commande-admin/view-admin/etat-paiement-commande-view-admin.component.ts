import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatPaiementCommandeService} from 'src/app/controller/service/EtatPaiementCommande.service';
import {EtatPaiementCommandeDto} from 'src/app/controller/model/EtatPaiementCommande.model';
import {EtatPaiementCommandeCriteria} from 'src/app/controller/criteria/EtatPaiementCommandeCriteria.model';

@Component({
  selector: 'app-etat-paiement-commande-view-admin',
  templateUrl: './etat-paiement-commande-view-admin.component.html'
})
export class EtatPaiementCommandeViewAdminComponent extends AbstractViewController<EtatPaiementCommandeDto, EtatPaiementCommandeCriteria, EtatPaiementCommandeService> implements OnInit {


    constructor(private etatPaiementCommandeService: EtatPaiementCommandeService){
        super(etatPaiementCommandeService);
    }

    ngOnInit(): void {
    }




}
