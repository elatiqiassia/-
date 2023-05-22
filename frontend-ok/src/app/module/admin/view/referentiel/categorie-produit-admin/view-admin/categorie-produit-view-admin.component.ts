import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategorieProduitService} from 'src/app/controller/service/CategorieProduit.service';
import {CategorieProduitDto} from 'src/app/controller/model/CategorieProduit.model';
import {CategorieProduitCriteria} from 'src/app/controller/criteria/CategorieProduitCriteria.model';

@Component({
  selector: 'app-categorie-produit-view-admin',
  templateUrl: './categorie-produit-view-admin.component.html'
})
export class CategorieProduitViewAdminComponent extends AbstractViewController<CategorieProduitDto, CategorieProduitCriteria, CategorieProduitService> implements OnInit {


    constructor(private categorieProduitService: CategorieProduitService){
        super(categorieProduitService);
    }

    ngOnInit(): void {
    }




}
