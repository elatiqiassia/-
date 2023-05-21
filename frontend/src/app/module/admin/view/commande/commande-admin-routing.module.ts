
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { EtatReceptionListAdminComponent } from './etat-reception-admin/list-admin/etat-reception-list-admin.component';
import { EtatCommandeListAdminComponent } from './etat-commande-admin/list-admin/etat-commande-list-admin.component';
import { PaiementCommandeListAdminComponent } from './paiement-commande-admin/list-admin/paiement-commande-list-admin.component';
import { ReceptionListAdminComponent } from './reception-admin/list-admin/reception-list-admin.component';
import { EtatPaiementCommandeListAdminComponent } from './etat-paiement-commande-admin/list-admin/etat-paiement-commande-list-admin.component';
import { CommandeListAdminComponent } from './commande-admin/list-admin/commande-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'etat-reception',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatReceptionListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-commande',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatCommandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'paiement-commande',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementCommandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'reception',
                            children: [
                                {
                                    path: 'list',
                                    component: ReceptionListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-paiement-commande',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatPaiementCommandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'commande',
                            children: [
                                {
                                    path: 'list',
                                    component: CommandeListAdminComponent ,
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
export class CommandeAdminRoutingModule { }
