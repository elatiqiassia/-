import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementCriteria} from 'src/app/controller/criteria/ModePaiementCriteria.model';
@Component({
  selector: 'app-mode-paiement-create-admin',
  templateUrl: './mode-paiement-create-admin.component.html'
})
export class ModePaiementCreateAdminComponent extends AbstractCreateController<ModePaiementDto, ModePaiementCriteria, ModePaiementService>  implements OnInit {



   private _validModePaiementLibelle = true;
   private _validModePaiementCode = true;

    constructor( private modePaiementService: ModePaiementService ) {
        super(modePaiementService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validModePaiementLibelle = value;
        this.validModePaiementCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateModePaiementLibelle();
        this.validateModePaiementCode();
    }

    public validateModePaiementLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validModePaiementLibelle = false;
        } else {
            this.validModePaiementLibelle = true;
        }
    }
    public validateModePaiementCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validModePaiementCode = false;
        } else {
            this.validModePaiementCode = true;
        }
    }






    get validModePaiementLibelle(): boolean {
        return this._validModePaiementLibelle;
    }

    set validModePaiementLibelle(value: boolean) {
         this._validModePaiementLibelle = value;
    }
    get validModePaiementCode(): boolean {
        return this._validModePaiementCode;
    }

    set validModePaiementCode(value: boolean) {
         this._validModePaiementCode = value;
    }



}
