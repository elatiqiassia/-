
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { SousClassComptableListAdminComponent } from './sous-class-comptable-admin/list-admin/sous-class-comptable-list-admin.component';
import { ClassComptableListAdminComponent } from './class-comptable-admin/list-admin/class-comptable-list-admin.component';
import { OperationComptableListAdminComponent } from './operation-comptable-admin/list-admin/operation-comptable-list-admin.component';
import { CompteComptableListAdminComponent } from './compte-comptable-admin/list-admin/compte-comptable-list-admin.component';
import { BilanListAdminComponent } from './bilan-admin/list-admin/bilan-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'sous-class-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: SousClassComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'class-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: ClassComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'operation-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: OperationComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'compte-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: CompteComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'bilan',
                            children: [
                                {
                                    path: 'list',
                                    component: BilanListAdminComponent ,
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
export class BilanAdminRoutingModule { }
