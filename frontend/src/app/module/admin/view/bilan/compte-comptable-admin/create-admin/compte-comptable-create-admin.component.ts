import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CompteComptableService} from 'src/app/controller/service/CompteComptable.service';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {CompteComptableCriteria} from 'src/app/controller/criteria/CompteComptableCriteria.model';
import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
@Component({
  selector: 'app-compte-comptable-create-admin',
  templateUrl: './compte-comptable-create-admin.component.html'
})
export class CompteComptableCreateAdminComponent extends AbstractCreateController<CompteComptableDto, CompteComptableCriteria, CompteComptableService>  implements OnInit {



   private _validCompteComptableLibelle = true;
   private _validCompteComptableCode = true;
    private _validSousClassComptableLibelle = true;
    private _validSousClassComptableCode = true;

    constructor( private compteComptableService: CompteComptableService , private sousClassComptableService: SousClassComptableService) {
        super(compteComptableService);
    }

    ngOnInit(): void {
    this.sousClassComptable = new SousClassComptableDto();
    this.sousClassComptableService.findAll().subscribe((data) => this.sousClassComptables = data);
}





    public setValidation(value: boolean){
        this.validCompteComptableLibelle = value;
        this.validCompteComptableCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCompteComptableLibelle();
        this.validateCompteComptableCode();
    }

    public validateCompteComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validCompteComptableLibelle = false;
        } else {
            this.validCompteComptableLibelle = true;
        }
    }
    public validateCompteComptableCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validCompteComptableCode = false;
        } else {
            this.validCompteComptableCode = true;
        }
    }


    public async openCreateSousClassComptable(sousClassComptable: string) {
    const isPermistted = await this.roleService.isPermitted('SousClassComptable', 'add');
    if(isPermistted) {
         this.sousClassComptable = new SousClassComptableDto();
         this.createSousClassComptableDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get sousClassComptable(): SousClassComptableDto {
        return this.sousClassComptableService.item;
    }
    set sousClassComptable(value: SousClassComptableDto) {
        this.sousClassComptableService.item = value;
    }
    get sousClassComptables(): Array<SousClassComptableDto> {
        return this.sousClassComptableService.items;
    }
    set sousClassComptables(value: Array<SousClassComptableDto>) {
        this.sousClassComptableService.items = value;
    }
    get createSousClassComptableDialog(): boolean {
       return this.sousClassComptableService.createDialog;
    }
    set createSousClassComptableDialog(value: boolean) {
        this.sousClassComptableService.createDialog= value;
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

    get validSousClassComptableLibelle(): boolean {
        return this._validSousClassComptableLibelle;
    }
    set validSousClassComptableLibelle(value: boolean) {
        this._validSousClassComptableLibelle = value;
    }
    get validSousClassComptableCode(): boolean {
        return this._validSousClassComptableCode;
    }
    set validSousClassComptableCode(value: boolean) {
        this._validSousClassComptableCode = value;
    }


}
