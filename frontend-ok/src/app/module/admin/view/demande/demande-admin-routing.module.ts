
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { PaiementDemandeListAdminComponent } from './paiement-demande-admin/list-admin/paiement-demande-list-admin.component';
import { EtatLivraisonListAdminComponent } from './etat-livraison-admin/list-admin/etat-livraison-list-admin.component';
import { LivraisonListAdminComponent } from './livraison-admin/list-admin/livraison-list-admin.component';
import { EtatPaiementLivraisonListAdminComponent } from './etat-paiement-livraison-admin/list-admin/etat-paiement-livraison-list-admin.component';
import { EtatDemandeListAdminComponent } from './etat-demande-admin/list-admin/etat-demande-list-admin.component';
import { PaiementLivraisonListAdminComponent } from './paiement-livraison-admin/list-admin/paiement-livraison-list-admin.component';
import { EtatPaiementDemandeListAdminComponent } from './etat-paiement-demande-admin/list-admin/etat-paiement-demande-list-admin.component';
import { DemandeListAdminComponent } from './demande-admin/list-admin/demande-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'paiement-demande',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementDemandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-livraison',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatLivraisonListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'livraison',
                            children: [
                                {
                                    path: 'list',
                                    component: LivraisonListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-paiement-livraison',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatPaiementLivraisonListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-demande',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatDemandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'paiement-livraison',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementLivraisonListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-paiement-demande',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatPaiementDemandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'demande',
                            children: [
                                {
                                    path: 'list',
                                    component: DemandeListAdminComponent ,
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
export class DemandeAdminRoutingModule { }
