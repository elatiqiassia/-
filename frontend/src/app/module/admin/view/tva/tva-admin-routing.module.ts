
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { TauxRetardTvaListAdminComponent } from './taux-retard-tva-admin/list-admin/taux-retard-tva-list-admin.component';
import { DeclarationTvaListAdminComponent } from './declaration-tva-admin/list-admin/declaration-tva-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'taux-retard-tva',
                            children: [
                                {
                                    path: 'list',
                                    component: TauxRetardTvaListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'declaration-tva',
                            children: [
                                {
                                    path: 'list',
                                    component: DeclarationTvaListAdminComponent ,
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
export class TvaAdminRoutingModule { }
