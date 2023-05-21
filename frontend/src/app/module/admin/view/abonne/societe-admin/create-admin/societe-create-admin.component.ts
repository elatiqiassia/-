import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SocieteService} from 'src/app/controller/service/Societe.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteCriteria} from 'src/app/controller/criteria/SocieteCriteria.model';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {AbonneDto} from 'src/app/controller/model/Abonne.model';
import {AbonneService} from 'src/app/controller/service/Abonne.service';
@Component({
  selector: 'app-societe-create-admin',
  templateUrl: './societe-create-admin.component.html'
})
export class SocieteCreateAdminComponent extends AbstractCreateController<SocieteDto, SocieteCriteria, SocieteService>  implements OnInit {

    private _storesElement = new StoreDto();


   private _validSocieteIce = true;
    private _validStoresLibelle = true;
    private _validStoresReference = true;
    private _validAbonneCode = true;

    constructor( private societeService: SocieteService , private storeService: StoreService, private abonneService: AbonneService) {
        super(societeService);
    }

    ngOnInit(): void {
    this.abonne = new AbonneDto();
    this.abonneService.findAll().subscribe((data) => this.abonnes = data);
}



    validateStores(){
        this.errorMessages = new Array();
        this.validateStoresLibelle();
        this.validateStoresReference();
    }


    public setValidation(value: boolean){
        this.validSocieteIce = value;
        this.validStoresLibelle = value;
        this.validStoresReference = value;
    }

    public addStores() {
        if( this.item.stores == null )
            this.item.stores = new Array<StoreDto>();
       this.validateStores();
       if (this.errorMessages.length === 0) {
              this.item.stores.push({... this.storesElement});
              this.storesElement = new StoreDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteStore(p: StoreDto) {
        this.item.stores.forEach((element, index) => {
            if (element === p) { this.item.stores.splice(index, 1); }
        });
    }

    public editStore(p: StoreDto) {
        this.storesElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSocieteIce();
    }

    public validateSocieteIce(){
        if (this.stringUtilService.isEmpty(this.item.ice)) {
        this.errorMessages.push('Ice non valide');
        this.validSocieteIce = false;
        } else {
            this.validSocieteIce = true;
        }
    }

    public validateStoresLibelle(){
        if (this.storesElement.libelle == null) {
            this.errorMessages.push('Libelle de la store est  invalide');
            this.validStoresLibelle = false;
        } else {
            this.validStoresLibelle = true;
        }
    }
    public validateStoresReference(){
        if (this.storesElement.reference == null) {
            this.errorMessages.push('Reference de la store est  invalide');
            this.validStoresReference = false;
        } else {
            this.validStoresReference = true;
        }
    }

    public async openCreateAbonne(abonne: string) {
    const isPermistted = await this.roleService.isPermitted('Abonne', 'add');
    if(isPermistted) {
         this.abonne = new AbonneDto();
         this.createAbonneDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get abonne(): AbonneDto {
        return this.abonneService.item;
    }
    set abonne(value: AbonneDto) {
        this.abonneService.item = value;
    }
    get abonnes(): Array<AbonneDto> {
        return this.abonneService.items;
    }
    set abonnes(value: Array<AbonneDto>) {
        this.abonneService.items = value;
    }
    get createAbonneDialog(): boolean {
       return this.abonneService.createDialog;
    }
    set createAbonneDialog(value: boolean) {
        this.abonneService.createDialog= value;
    }



    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }

    set validSocieteIce(value: boolean) {
         this._validSocieteIce = value;
    }

    get validStoresLibelle(): boolean {
        return this._validStoresLibelle;
    }
    set validStoresLibelle(value: boolean) {
        this._validStoresLibelle = value;
    }
    get validStoresReference(): boolean {
        return this._validStoresReference;
    }
    set validStoresReference(value: boolean) {
        this._validStoresReference = value;
    }
    get validAbonneCode(): boolean {
        return this._validAbonneCode;
    }
    set validAbonneCode(value: boolean) {
        this._validAbonneCode = value;
    }

    get storesElement(): StoreDto {
        if( this._storesElement == null )
            this._storesElement = new StoreDto();
        return this._storesElement;
    }

    set storesElement(value: StoreDto) {
        this._storesElement = value;
    }

}
