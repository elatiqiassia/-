import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AbonneService} from 'src/app/controller/service/Abonne.service';
import {AbonneDto} from 'src/app/controller/model/Abonne.model';
import {AbonneCriteria} from 'src/app/controller/criteria/AbonneCriteria.model';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-abonne-create-admin',
  templateUrl: './abonne-create-admin.component.html'
})
export class AbonneCreateAdminComponent extends AbstractCreateController<AbonneDto, AbonneCriteria, AbonneService>  implements OnInit {

    private _societesElement = new SocieteDto();


   private _validAbonneCode = true;
    private _validSocietesIce = true;

    constructor( private abonneService: AbonneService , private societeService: SocieteService) {
        super(abonneService);
    }

    ngOnInit(): void {
}



    validateSocietes(){
        this.errorMessages = new Array();
        this.validateSocietesIce();
    }


    public setValidation(value: boolean){
        this.validAbonneCode = value;
        this.validSocietesIce = value;
    }

    public addSocietes() {
        if( this.item.societes == null )
            this.item.societes = new Array<SocieteDto>();
       this.validateSocietes();
       if (this.errorMessages.length === 0) {
              this.item.societes.push({... this.societesElement});
              this.societesElement = new SocieteDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteSociete(p: SocieteDto) {
        this.item.societes.forEach((element, index) => {
            if (element === p) { this.item.societes.splice(index, 1); }
        });
    }

    public editSociete(p: SocieteDto) {
        this.societesElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAbonneCode();
    }

    public validateAbonneCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validAbonneCode = false;
        } else {
            this.validAbonneCode = true;
        }
    }

    public validateSocietesIce(){
        if (this.societesElement.ice == null) {
            this.errorMessages.push('Ice de la societe est  invalide');
            this.validSocietesIce = false;
        } else {
            this.validSocietesIce = true;
        }
    }





    get validAbonneCode(): boolean {
        return this._validAbonneCode;
    }

    set validAbonneCode(value: boolean) {
         this._validAbonneCode = value;
    }

    get validSocietesIce(): boolean {
        return this._validSocietesIce;
    }
    set validSocietesIce(value: boolean) {
        this._validSocietesIce = value;
    }

    get societesElement(): SocieteDto {
        if( this._societesElement == null )
            this._societesElement = new SocieteDto();
        return this._societesElement;
    }

    set societesElement(value: SocieteDto) {
        this._societesElement = value;
    }

}
