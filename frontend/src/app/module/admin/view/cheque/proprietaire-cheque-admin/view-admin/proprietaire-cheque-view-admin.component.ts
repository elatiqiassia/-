import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProprietaireChequeService} from 'src/app/controller/service/ProprietaireCheque.service';
import {ProprietaireChequeDto} from 'src/app/controller/model/ProprietaireCheque.model';
import {ProprietaireChequeCriteria} from 'src/app/controller/criteria/ProprietaireChequeCriteria.model';

@Component({
  selector: 'app-proprietaire-cheque-view-admin',
  templateUrl: './proprietaire-cheque-view-admin.component.html'
})
export class ProprietaireChequeViewAdminComponent extends AbstractViewController<ProprietaireChequeDto, ProprietaireChequeCriteria, ProprietaireChequeService> implements OnInit {


    constructor(private proprietaireChequeService: ProprietaireChequeService){
        super(proprietaireChequeService);
    }

    ngOnInit(): void {
    }




}
