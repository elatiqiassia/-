import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ClientService} from 'src/app/controller/service/Client.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/ClientCriteria.model';



@Component({
  selector: 'app-client-edit-admin',
  templateUrl: './client-edit-admin.component.html'
})
export class ClientEditAdminComponent extends AbstractEditController<ClientDto, ClientCriteria, ClientService>   implements OnInit {


    private _validClientCin = true;
    private _validClientNom = true;




    constructor( private clientService: ClientService ) {
        super(clientService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validClientCin = value;
        this.validClientNom = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateClientCin();
        this.validateClientNom();
    }
    public validateClientCin(){
        if (this.stringUtilService.isEmpty(this.item.cin)) {
            this.errorMessages.push('Cin non valide');
            this.validClientCin = false;
        } else {
            this.validClientCin = true;
        }
    }
    public validateClientNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validClientNom = false;
        } else {
            this.validClientNom = true;
        }
    }






    get validClientCin(): boolean {
        return this._validClientCin;
    }
    set validClientCin(value: boolean) {
        this._validClientCin = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }

}
