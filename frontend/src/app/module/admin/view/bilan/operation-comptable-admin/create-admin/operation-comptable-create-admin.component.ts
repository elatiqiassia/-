import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {OperationComptableService} from 'src/app/controller/service/OperationComptable.service';
import {OperationComptableDto} from 'src/app/controller/model/OperationComptable.model';
import {OperationComptableCriteria} from 'src/app/controller/criteria/OperationComptableCriteria.model';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {CompteComptableService} from 'src/app/controller/service/CompteComptable.service';
@Component({
  selector: 'app-operation-comptable-create-admin',
  templateUrl: './operation-comptable-create-admin.component.html'
})
export class OperationComptableCreateAdminComponent extends AbstractCreateController<OperationComptableDto, OperationComptableCriteria, OperationComptableService>  implements OnInit {



    private _validSocieteIce = true;
    private _validCompteComptableLibelle = true;
    private _validCompteComptableCode = true;

    constructor( private operationComptableService: OperationComptableService , private societeService: SocieteService, private compteComptableService: CompteComptableService) {
        super(operationComptableService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.compteComptable = new CompteComptableDto();
    this.compteComptableService.findAll().subscribe((data) => this.compteComptables = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateCompteComptable(compteComptable: string) {
    const isPermistted = await this.roleService.isPermitted('CompteComptable', 'add');
    if(isPermistted) {
         this.compteComptable = new CompteComptableDto();
         this.createCompteComptableDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get compteComptable(): CompteComptableDto {
        return this.compteComptableService.item;
    }
    set compteComptable(value: CompteComptableDto) {
        this.compteComptableService.item = value;
    }
    get compteComptables(): Array<CompteComptableDto> {
        return this.compteComptableService.items;
    }
    set compteComptables(value: Array<CompteComptableDto>) {
        this.compteComptableService.items = value;
    }
    get createCompteComptableDialog(): boolean {
       return this.compteComptableService.createDialog;
    }
    set createCompteComptableDialog(value: boolean) {
        this.compteComptableService.createDialog= value;
    }
    get societe(): SocieteDto {
        return this.societeService.item;
    }
    set societe(value: SocieteDto) {
        this.societeService.item = value;
    }
    get societes(): Array<SocieteDto> {
        return this.societeService.items;
    }
    set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
    }
    get createSocieteDialog(): boolean {
       return this.societeService.createDialog;
    }
    set createSocieteDialog(value: boolean) {
        this.societeService.createDialog= value;
    }




    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }
    get validCompteComptableLibelle(): boolean {
        return this._validCompteComptableLibelle;
    }
    set validCompteComptableLibelle(value: boolean) {
        this._validCompteComptableLibelle = value;
    }
    get validCompteComptableCode(): boolean {
        return this._validCompteComptableCode;
    }
    set validCompteComptableCode(value: boolean) {
        this._validCompteComptableCode = value;
    }


}
