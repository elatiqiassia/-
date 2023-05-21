import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ComptableValidateurService} from 'src/app/controller/service/ComptableValidateur.service';
import {ComptableValidateurDto} from 'src/app/controller/model/ComptableValidateur.model';
import {ComptableValidateurCriteria} from 'src/app/controller/criteria/ComptableValidateurCriteria.model';

@Component({
  selector: 'app-comptable-validateur-view-admin',
  templateUrl: './comptable-validateur-view-admin.component.html'
})
export class ComptableValidateurViewAdminComponent extends AbstractViewController<ComptableValidateurDto, ComptableValidateurCriteria, ComptableValidateurService> implements OnInit {


    constructor(private comptableValidateurService: ComptableValidateurService){
        super(comptableValidateurService);
    }

    ngOnInit(): void {
    }




}
