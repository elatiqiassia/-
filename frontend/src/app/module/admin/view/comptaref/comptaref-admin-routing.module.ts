
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ComptableTraitantListAdminComponent } from './comptable-traitant-admin/list-admin/comptable-traitant-list-admin.component';
import { ComptableValidateurListAdminComponent } from './comptable-validateur-admin/list-admin/comptable-validateur-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'comptable-traitant',
                            children: [
                                {
                                    path: 'list',
                                    component: ComptableTraitantListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'comptable-validateur',
                            children: [
                                {
                                    path: 'list',
                                    component: ComptableValidateurListAdminComponent ,
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
export class ComptarefAdminRoutingModule { }
