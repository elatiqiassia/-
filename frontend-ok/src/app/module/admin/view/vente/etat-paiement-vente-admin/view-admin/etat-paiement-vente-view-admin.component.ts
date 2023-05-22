import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatPaiementVenteService} from 'src/app/controller/service/EtatPaiementVente.service';
import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {EtatPaiementVenteCriteria} from 'src/app/controller/criteria/EtatPaiementVenteCriteria.model';

@Component({
  selector: 'app-etat-paiement-vente-view-admin',
  templateUrl: './etat-paiement-vente-view-admin.component.html'
})
export class EtatPaiementVenteViewAdminComponent extends AbstractViewController<EtatPaiementVenteDto, EtatPaiementVenteCriteria, EtatPaiementVenteService> implements OnInit {


    constructor(private etatPaiementVenteService: EtatPaiementVenteService){
        super(etatPaiementVenteService);
    }

    ngOnInit(): void {
    }




}
