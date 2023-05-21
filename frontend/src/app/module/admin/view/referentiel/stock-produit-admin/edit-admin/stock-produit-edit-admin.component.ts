import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StockProduitService} from 'src/app/controller/service/StockProduit.service';
import {StockProduitDto} from 'src/app/controller/model/StockProduit.model';
import {StockProduitCriteria} from 'src/app/controller/criteria/StockProduitCriteria.model';


import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinService} from 'src/app/controller/service/Magasin.service';

@Component({
  selector: 'app-stock-produit-edit-admin',
  templateUrl: './stock-produit-edit-admin.component.html'
})
export class StockProduitEditAdminComponent extends AbstractEditController<StockProduitDto, StockProduitCriteria, StockProduitService>   implements OnInit {



    private _validMagasinReference = true;
    private _validProduitReference = true;
    private _validProduitLibelle = true;



    constructor( private stockProduitService: StockProduitService , private produitService: ProduitService, private magasinService: MagasinService) {
        super(stockProduitService);
    }

    ngOnInit(): void {
    this.magasin = new MagasinDto();
    this.magasinService.findAll().subscribe((data) => this.magasins = data);
    this.produit = new ProduitDto();
    this.produitService.findAll().subscribe((data) => this.produits = data);
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateProduit(produit: string) {
        const isPermistted = await this.roleService.isPermitted('Produit', 'edit');
        if(isPermistted) {
             this.produit = new ProduitDto();
             this.createProduitDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get magasin(): MagasinDto {
       return this.magasinService.item;
   }
  set magasin(value: MagasinDto) {
        this.magasinService.item = value;
   }
   get magasins(): Array<MagasinDto> {
        return this.magasinService.items;
   }
   set magasins(value: Array<MagasinDto>) {
        this.magasinService.items = value;
   }
   get createMagasinDialog(): boolean {
       return this.magasinService.createDialog;
   }
  set createMagasinDialog(value: boolean) {
       this.magasinService.createDialog= value;
   }



    get validMagasinReference(): boolean {
        return this._validMagasinReference;
    }
    set validMagasinReference(value: boolean) {
        this._validMagasinReference = value;
    }
    get validProduitReference(): boolean {
        return this._validProduitReference;
    }
    set validProduitReference(value: boolean) {
        this._validProduitReference = value;
    }
    get validProduitLibelle(): boolean {
        return this._validProduitLibelle;
    }
    set validProduitLibelle(value: boolean) {
        this._validProduitLibelle = value;
    }
}
