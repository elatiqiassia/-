import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatPaiementDemandeService} from 'src/app/controller/service/EtatPaiementDemande.service';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';
import {EtatPaiementDemandeCriteria} from 'src/app/controller/criteria/EtatPaiementDemandeCriteria.model';

@Component({
  selector: 'app-etat-paiement-demande-view-admin',
  templateUrl: './etat-paiement-demande-view-admin.component.html'
})
export class EtatPaiementDemandeViewAdminComponent extends AbstractViewController<EtatPaiementDemandeDto, EtatPaiementDemandeCriteria, EtatPaiementDemandeService> implements OnInit {


    constructor(private etatPaiementDemandeService: EtatPaiementDemandeService){
        super(etatPaiementDemandeService);
    }

    ngOnInit(): void {
    }




}
