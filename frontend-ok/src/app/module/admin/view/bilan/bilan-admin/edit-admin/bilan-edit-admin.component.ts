import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BilanService} from 'src/app/controller/service/Bilan.service';
import {BilanDto} from 'src/app/controller/model/Bilan.model';
import {BilanCriteria} from 'src/app/controller/criteria/BilanCriteria.model';


import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';

@Component({
  selector: 'app-bilan-edit-admin',
  templateUrl: './bilan-edit-admin.component.html'
})
export class BilanEditAdminComponent extends AbstractEditController<BilanDto, BilanCriteria, BilanService>   implements OnInit {


    private _validBilanRef = true;

    private _validSocieteIce = true;



    constructor( private bilanService: BilanService , private societeService: SocieteService) {
        super(bilanService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
}


    public setValidation(value : boolean){
        this.validBilanRef = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateBilanRef();
    }
    public validateBilanRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
            this.errorMessages.push('Ref non valide');
            this.validBilanRef = false;
        } else {
            this.validBilanRef = true;
        }
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


    get validBilanRef(): boolean {
        return this._validBilanRef;
    }
    set validBilanRef(value: boolean) {
        this._validBilanRef = value;
    }

    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }
}
