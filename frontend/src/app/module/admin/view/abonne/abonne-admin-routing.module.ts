
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { StoreListAdminComponent } from './store-admin/list-admin/store-list-admin.component';
import { MagasinListAdminComponent } from './magasin-admin/list-admin/magasin-list-admin.component';
import { AbonneListAdminComponent } from './abonne-admin/list-admin/abonne-list-admin.component';
import { SocieteListAdminComponent } from './societe-admin/list-admin/societe-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'store',
                            children: [
                                {
                                    path: 'list',
                                    component: StoreListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'magasin',
                            children: [
                                {
                                    path: 'list',
                                    component: MagasinListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'abonne',
                            children: [
                                {
                                    path: 'list',
                                    component: AbonneListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'societe',
                            children: [
                                {
                                    path: 'list',
                                    component: SocieteListAdminComponent ,
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
export class AbonneAdminRoutingModule { }
