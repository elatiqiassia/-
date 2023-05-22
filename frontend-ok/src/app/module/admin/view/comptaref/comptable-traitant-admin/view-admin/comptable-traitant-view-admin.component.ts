import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ComptableTraitantService} from 'src/app/controller/service/ComptableTraitant.service';
import {ComptableTraitantDto} from 'src/app/controller/model/ComptableTraitant.model';
import {ComptableTraitantCriteria} from 'src/app/controller/criteria/ComptableTraitantCriteria.model';

@Component({
  selector: 'app-comptable-traitant-view-admin',
  templateUrl: './comptable-traitant-view-admin.component.html'
})
export class ComptableTraitantViewAdminComponent extends AbstractViewController<ComptableTraitantDto, ComptableTraitantCriteria, ComptableTraitantService> implements OnInit {


    constructor(private comptableTraitantService: ComptableTraitantService){
        super(comptableTraitantService);
    }

    ngOnInit(): void {
    }




}
