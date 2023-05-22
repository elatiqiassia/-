
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { VenteListAdminComponent } from './vente-admin/list-admin/vente-list-admin.component';
import { EtatAvoirVenteListAdminComponent } from './etat-avoir-vente-admin/list-admin/etat-avoir-vente-list-admin.component';
import { EtatVenteListAdminComponent } from './etat-vente-admin/list-admin/etat-vente-list-admin.component';
import { AvoirVenteListAdminComponent } from './avoir-vente-admin/list-admin/avoir-vente-list-admin.component';
import { PaiementVenteListAdminComponent } from './paiement-vente-admin/list-admin/paiement-vente-list-admin.component';
import { EtatPaiementVenteListAdminComponent } from './etat-paiement-vente-admin/list-admin/etat-paiement-vente-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'vente',
                            children: [
                                {
                                    path: 'list',
                                    component: VenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-avoir-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatAvoirVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'avoir-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: AvoirVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'paiement-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-paiement-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatPaiementVenteListAdminComponent ,
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
export class VenteAdminRoutingModule { }
