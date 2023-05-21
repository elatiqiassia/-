import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableCriteria} from 'src/app/controller/criteria/SousClassComptableCriteria.model';


import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';

@Component({
  selector: 'app-sous-class-comptable-edit-admin',
  templateUrl: './sous-class-comptable-edit-admin.component.html'
})
export class SousClassComptableEditAdminComponent extends AbstractEditController<SousClassComptableDto, SousClassComptableCriteria, SousClassComptableService>   implements OnInit {


    private _validSousClassComptableLibelle = true;
    private _validSousClassComptableCode = true;

    private _validClassComptableLibelle = true;
    private _validClassComptableCode = true;



    constructor( private sousClassComptableService: SousClassComptableService , private classComptableService: ClassComptableService) {
        super(sousClassComptableService);
    }

    ngOnInit(): void {
    this.classComptable = new ClassComptableDto();
    this.classComptableService.findAll().subscribe((data) => this.classComptables = data);
}


    public setValidation(value : boolean){
        this.validSousClassComptableLibelle = value;
        this.validSousClassComptableCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSousClassComptableLibelle();
        this.validateSousClassComptableCode();
    }
    public validateSousClassComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validSousClassComptableLibelle = false;
        } else {
            this.validSousClassComptableLibelle = true;
        }
    }
    public validateSousClassComptableCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validSousClassComptableCode = false;
        } else {
            this.validSousClassComptableCode = true;
        }
    }



   public async openCreateClassComptable(classComptable: string) {
        const isPermistted = await this.roleService.isPermitted('ClassComptable', 'edit');
        if(isPermistted) {
             this.classComptable = new ClassComptableDto();
             this.createClassComptableDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get classComptable(): ClassComptableDto {
       return this.classComptableService.item;
   }
  set classComptable(value: ClassComptableDto) {
        this.classComptableService.item = value;
   }
   get classComptables(): Array<ClassComptableDto> {
        return this.classComptableService.items;
   }
   set classComptables(value: Array<ClassComptableDto>) {
        this.classComptableService.items = value;
   }
   get createClassComptableDialog(): boolean {
       return this.classComptableService.createDialog;
   }
  set createClassComptableDialog(value: boolean) {
       this.classComptableService.createDialog= value;
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

    get validClassComptableLibelle(): boolean {
        return this._validClassComptableLibelle;
    }
    set validClassComptableLibelle(value: boolean) {
        this._validClassComptableLibelle = value;
    }
    get validClassComptableCode(): boolean {
        return this._validClassComptableCode;
    }
    set validClassComptableCode(value: boolean) {
        this._validClassComptableCode = value;
    }
}
