import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableCriteria} from 'src/app/controller/criteria/SousClassComptableCriteria.model';

import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';
@Component({
  selector: 'app-sous-class-comptable-view-admin',
  templateUrl: './sous-class-comptable-view-admin.component.html'
})
export class SousClassComptableViewAdminComponent extends AbstractViewController<SousClassComptableDto, SousClassComptableCriteria, SousClassComptableService> implements OnInit {


    constructor(private sousClassComptableService: SousClassComptableService, private classComptableService: ClassComptableService){
        super(sousClassComptableService);
    }

    ngOnInit(): void {
        this.classComptable = new ClassComptableDto();
        this.classComptableService.findAll().subscribe((data) => this.classComptables = data);
    }


    get classComptable(): ClassComptableDto {
       return this.classComptableService.item;
    }
    set classComptable(value: ClassComptableDto) {
        this.classComptableService.item = value;
    }
    get classComptables():Array<ClassComptableDto> {
       return this.classComptableService.items;
    }
    set classComptables(value: Array<ClassComptableDto>) {
        this.classComptableService.items = value;
    }


}
