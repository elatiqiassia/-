
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';

@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {
                            path: 'login',
                            children: [
                                {
                                    path: '',
                                    component: LoginAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'register',
                            children: [
                                {
                                    path: '',
                                    component: RegisterAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {

                            path: 'vente',
                            loadChildren: () => import('./view/vente/vente-admin-routing.module').then(x=>x.VenteAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'bilan',
                            loadChildren: () => import('./view/bilan/bilan-admin-routing.module').then(x=>x.BilanAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'abonne',
                            loadChildren: () => import('./view/abonne/abonne-admin-routing.module').then(x=>x.AbonneAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'is',
                            loadChildren: () => import('./view/is/is-admin-routing.module').then(x=>x.IsAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'collaborateur',
                            loadChildren: () => import('./view/collaborateur/collaborateur-admin-routing.module').then(x=>x.CollaborateurAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'devis',
                            loadChildren: () => import('./view/devis/devis-admin-routing.module').then(x=>x.DevisAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'commande',
                            loadChildren: () => import('./view/commande/commande-admin-routing.module').then(x=>x.CommandeAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'demande',
                            loadChildren: () => import('./view/demande/demande-admin-routing.module').then(x=>x.DemandeAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'referentiel',
                            loadChildren: () => import('./view/referentiel/referentiel-admin-routing.module').then(x=>x.ReferentielAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'cheque',
                            loadChildren: () => import('./view/cheque/cheque-admin-routing.module').then(x=>x.ChequeAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'comptaref',
                            loadChildren: () => import('./view/comptaref/comptaref-admin-routing.module').then(x=>x.ComptarefAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'achat',
                            loadChildren: () => import('./view/achat/achat-admin-routing.module').then(x=>x.AchatAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'tva',
                            loadChildren: () => import('./view/tva/tva-admin-routing.module').then(x=>x.TvaAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AdminRoutingModule { }
