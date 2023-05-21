import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatPaiementAchatService} from 'src/app/controller/service/EtatPaiementAchat.service';
import {EtatPaiementAchatDto} from 'src/app/controller/model/EtatPaiementAchat.model';
import {EtatPaiementAchatCriteria} from 'src/app/controller/criteria/EtatPaiementAchatCriteria.model';

@Component({
  selector: 'app-etat-paiement-achat-view-admin',
  templateUrl: './etat-paiement-achat-view-admin.component.html'
})
export class EtatPaiementAchatViewAdminComponent extends AbstractViewController<EtatPaiementAchatDto, EtatPaiementAchatCriteria, EtatPaiementAchatService> implements OnInit {


    constructor(private etatPaiementAchatService: EtatPaiementAchatService){
        super(etatPaiementAchatService);
    }

    ngOnInit(): void {
    }




}
