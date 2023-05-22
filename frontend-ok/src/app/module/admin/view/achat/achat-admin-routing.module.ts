
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { AvoirAchatListAdminComponent } from './avoir-achat-admin/list-admin/avoir-achat-list-admin.component';
import { EtatPaiementAchatListAdminComponent } from './etat-paiement-achat-admin/list-admin/etat-paiement-achat-list-admin.component';
import { PaiementAchatListAdminComponent } from './paiement-achat-admin/list-admin/paiement-achat-list-admin.component';
import { EtatAvoirAchatListAdminComponent } from './etat-avoir-achat-admin/list-admin/etat-avoir-achat-list-admin.component';
import { EtatAchatListAdminComponent } from './etat-achat-admin/list-admin/etat-achat-list-admin.component';
import { AchatListAdminComponent } from './achat-admin/list-admin/achat-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'avoir-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: AvoirAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-paiement-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatPaiementAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'paiement-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-avoir-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatAvoirAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'achat',
                            children: [
                                {
                                    path: 'list',
                                    component: AchatListAdminComponent ,
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
export class AchatAdminRoutingModule { }
