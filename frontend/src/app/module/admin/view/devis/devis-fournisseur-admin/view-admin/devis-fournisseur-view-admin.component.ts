import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DevisFournisseurService} from 'src/app/controller/service/DevisFournisseur.service';
import {DevisFournisseurDto} from 'src/app/controller/model/DevisFournisseur.model';
import {DevisFournisseurCriteria} from 'src/app/controller/criteria/DevisFournisseurCriteria.model';

import {DevisItemFournisseurDto} from 'src/app/controller/model/DevisItemFournisseur.model';
import {DevisItemFournisseurService} from 'src/app/controller/service/DevisItemFournisseur.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {FournisseurDto} from 'src/app/controller/model/Fournisseur.model';
import {FournisseurService} from 'src/app/controller/service/Fournisseur.service';
@Component({
  selector: 'app-devis-fournisseur-view-admin',
  templateUrl: './devis-fournisseur-view-admin.component.html'
})
export class DevisFournisseurViewAdminComponent extends AbstractViewController<DevisFournisseurDto, DevisFournisseurCriteria, DevisFournisseurService> implements OnInit {

    devisItemFournisseurs = new DevisItemFournisseurDto();
    devisItemFournisseurss: Array<DevisItemFournisseurDto> = [];

    constructor(private devisFournisseurService: DevisFournisseurService, private devisItemFournisseurService: DevisItemFournisseurService, private produitService: ProduitService, private fournisseurService: FournisseurService){
        super(devisFournisseurService);
    }

    ngOnInit(): void {
        this.devisItemFournisseurs.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
    }


    get produit(): ProduitDto {
       return this.produitService.item;
    }
    set produit(value: ProduitDto) {
        this.produitService.item = value;
    }
    get produits():Array<ProduitDto> {
       return this.produitService.items;
    }
    set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
    }
    get fournisseur(): FournisseurDto {
       return this.fournisseurService.item;
    }
    set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
    }
    get fournisseurs():Array<FournisseurDto> {
       return this.fournisseurService.items;
    }
    set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
    }


}
