
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { StockProduitListAdminComponent } from './stock-produit-admin/list-admin/stock-produit-list-admin.component';
import { ProduitListAdminComponent } from './produit-admin/list-admin/produit-list-admin.component';
import { MarqueListAdminComponent } from './marque-admin/list-admin/marque-list-admin.component';
import { ModePaiementListAdminComponent } from './mode-paiement-admin/list-admin/mode-paiement-list-admin.component';
import { UniteMesureListAdminComponent } from './unite-mesure-admin/list-admin/unite-mesure-list-admin.component';
import { CategorieProduitListAdminComponent } from './categorie-produit-admin/list-admin/categorie-produit-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'stock-produit',
                            children: [
                                {
                                    path: 'list',
                                    component: StockProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'produit',
                            children: [
                                {
                                    path: 'list',
                                    component: ProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'marque',
                            children: [
                                {
                                    path: 'list',
                                    component: MarqueListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'mode-paiement',
                            children: [
                                {
                                    path: 'list',
                                    component: ModePaiementListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'unite-mesure',
                            children: [
                                {
                                    path: 'list',
                                    component: UniteMesureListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'categorie-produit',
                            children: [
                                {
                                    path: 'list',
                                    component: CategorieProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class ReferentielAdminRoutingModule { }
