import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CompteComptableService} from 'src/app/controller/service/CompteComptable.service';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {CompteComptableCriteria} from 'src/app/controller/criteria/CompteComptableCriteria.model';

import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
@Component({
  selector: 'app-compte-comptable-view-admin',
  templateUrl: './compte-comptable-view-admin.component.html'
})
export class CompteComptableViewAdminComponent extends AbstractViewController<CompteComptableDto, CompteComptableCriteria, CompteComptableService> implements OnInit {


    constructor(private compteComptableService: CompteComptableService, private sousClassComptableService: SousClassComptableService){
        super(compteComptableService);
    }

    ngOnInit(): void {
        this.sousClassComptable = new SousClassComptableDto();
        this.sousClassComptableService.findAll().subscribe((data) => this.sousClassComptables = data);
    }


    get sousClassComptable(): SousClassComptableDto {
       return this.sousClassComptableService.item;
    }
    set sousClassComptable(value: SousClassComptableDto) {
        this.sousClassComptableService.item = value;
    }
    get sousClassComptables():Array<SousClassComptableDto> {
       return this.sousClassComptableService.items;
    }
    set sousClassComptables(value: Array<SousClassComptableDto>) {
        this.sousClassComptableService.items = value;
    }


}
