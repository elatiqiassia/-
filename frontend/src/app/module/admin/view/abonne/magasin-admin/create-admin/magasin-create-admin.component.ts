import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {MagasinService} from 'src/app/controller/service/Magasin.service';
import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinCriteria} from 'src/app/controller/criteria/MagasinCriteria.model';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-magasin-create-admin',
  templateUrl: './magasin-create-admin.component.html'
})
export class MagasinCreateAdminComponent extends AbstractCreateController<MagasinDto, MagasinCriteria, MagasinService>  implements OnInit {



   private _validMagasinReference = true;
    private _validStoreLibelle = true;
    private _validStoreReference = true;

    constructor( private magasinService: MagasinService , private storeService: StoreService) {
        super(magasinService);
    }

    ngOnInit(): void {
    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
}





    public setValidation(value: boolean){
        this.validMagasinReference = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateMagasinReference();
    }

    public validateMagasinReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validMagasinReference = false;
        } else {
            this.validMagasinReference = true;
        }
    }


    public async openCreateStore(store: string) {
    const isPermistted = await this.roleService.isPermitted('Store', 'add');
    if(isPermistted) {
         this.store = new StoreDto();
         this.createStoreDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get store(): StoreDto {
        return this.storeService.item;
    }
    set store(value: StoreDto) {
        this.storeService.item = value;
    }
    get stores(): Array<StoreDto> {
        return this.storeService.items;
    }
    set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
    }
    get createStoreDialog(): boolean {
       return this.storeService.createDialog;
    }
    set createStoreDialog(value: boolean) {
        this.storeService.createDialog= value;
    }



    get validMagasinReference(): boolean {
        return this._validMagasinReference;
    }

    set validMagasinReference(value: boolean) {
         this._validMagasinReference = value;
    }

    get validStoreLibelle(): boolean {
        return this._validStoreLibelle;
    }
    set validStoreLibelle(value: boolean) {
        this._validStoreLibelle = value;
    }
    get validStoreReference(): boolean {
        return this._validStoreReference;
    }
    set validStoreReference(value: boolean) {
        this._validStoreReference = value;
    }


}
