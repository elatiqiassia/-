import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatPaiementLivraisonService} from 'src/app/controller/service/EtatPaiementLivraison.service';
import {EtatPaiementLivraisonDto} from 'src/app/controller/model/EtatPaiementLivraison.model';
import {EtatPaiementLivraisonCriteria} from 'src/app/controller/criteria/EtatPaiementLivraisonCriteria.model';

@Component({
  selector: 'app-etat-paiement-livraison-view-admin',
  templateUrl: './etat-paiement-livraison-view-admin.component.html'
})
export class EtatPaiementLivraisonViewAdminComponent extends AbstractViewController<EtatPaiementLivraisonDto, EtatPaiementLivraisonCriteria, EtatPaiementLivraisonService> implements OnInit {


    constructor(private etatPaiementLivraisonService: EtatPaiementLivraisonService){
        super(etatPaiementLivraisonService);
    }

    ngOnInit(): void {
    }




}
