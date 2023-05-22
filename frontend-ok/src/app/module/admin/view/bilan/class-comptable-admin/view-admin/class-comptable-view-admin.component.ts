import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';
import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableCriteria} from 'src/app/controller/criteria/ClassComptableCriteria.model';

@Component({
  selector: 'app-class-comptable-view-admin',
  templateUrl: './class-comptable-view-admin.component.html'
})
export class ClassComptableViewAdminComponent extends AbstractViewController<ClassComptableDto, ClassComptableCriteria, ClassComptableService> implements OnInit {


    constructor(private classComptableService: ClassComptableService){
        super(classComptableService);
    }

    ngOnInit(): void {
    }




}
