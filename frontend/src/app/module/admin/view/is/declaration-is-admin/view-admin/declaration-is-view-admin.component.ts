import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DeclarationIsService} from 'src/app/controller/service/DeclarationIs.service';
import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';
import {DeclarationIsCriteria} from 'src/app/controller/criteria/DeclarationIsCriteria.model';

import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';
import {TauxIsService} from 'src/app/controller/service/TauxIs.service';
import {ComptableTraitantDto} from 'src/app/controller/model/ComptableTraitant.model';
import {ComptableTraitantService} from 'src/app/controller/service/ComptableTraitant.service';
import {ComptableValidateurDto} from 'src/app/controller/model/ComptableValidateur.model';
import {ComptableValidateurService} from 'src/app/controller/service/ComptableValidateur.service';
@Component({
  selector: 'app-declaration-is-view-admin',
  templateUrl: './declaration-is-view-admin.component.html'
})
export class DeclarationIsViewAdminComponent extends AbstractViewController<DeclarationIsDto, DeclarationIsCriteria, DeclarationIsService> implements OnInit {


    constructor(private declarationIsService: DeclarationIsService, private societeService: SocieteService, private tauxIsService: TauxIsService, private comptableTraitantService: ComptableTraitantService, private comptableValidateurService: ComptableValidateurService){
        super(declarationIsService);
    }

    ngOnInit(): void {
        this.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
        this.tauxIs = new TauxIsDto();
        this.tauxIsService.findAll().subscribe((data) => this.tauxIss = data);
        this.comptableTraitant = new ComptableTraitantDto();
        this.comptableTraitantService.findAll().subscribe((data) => this.comptableTraitants = data);
        this.comptableValidateur = new ComptableValidateurDto();
        this.comptableValidateurService.findAll().subscribe((data) => this.comptableValidateurs = data);
    }


    get societe(): SocieteDto {
       return this.societeService.item;
    }
    set societe(value: SocieteDto) {
        this.societeService.item = value;
    }
    get societes():Array<SocieteDto> {
       return this.societeService.items;
    }
    set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
    }
    get tauxIs(): TauxIsDto {
       return this.tauxIsService.item;
    }
    set tauxIs(value: TauxIsDto) {
        this.tauxIsService.item = value;
    }
    get tauxIss():Array<TauxIsDto> {
       return this.tauxIsService.items;
    }
    set tauxIss(value: Array<TauxIsDto>) {
        this.tauxIsService.items = value;
    }
    get comptableTraitant(): ComptableTraitantDto {
       return this.comptableTraitantService.item;
    }
    set comptableTraitant(value: ComptableTraitantDto) {
        this.comptableTraitantService.item = value;
    }
    get comptableTraitants():Array<ComptableTraitantDto> {
       return this.comptableTraitantService.items;
    }
    set comptableTraitants(value: Array<ComptableTraitantDto>) {
        this.comptableTraitantService.items = value;
    }
    get comptableValidateur(): ComptableValidateurDto {
       return this.comptableValidateurService.item;
    }
    set comptableValidateur(value: ComptableValidateurDto) {
        this.comptableValidateurService.item = value;
    }
    get comptableValidateurs():Array<ComptableValidateurDto> {
       return this.comptableValidateurService.items;
    }
    set comptableValidateurs(value: Array<ComptableValidateurDto>) {
        this.comptableValidateurService.items = value;
    }


}
