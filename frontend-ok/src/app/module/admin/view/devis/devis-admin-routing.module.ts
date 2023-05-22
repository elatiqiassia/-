
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { DevisFournisseurListAdminComponent } from './devis-fournisseur-admin/list-admin/devis-fournisseur-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'devis-fournisseur',
                            children: [
                                {
                                    path: 'list',
                                    component: DevisFournisseurListAdminComponent ,
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
export class DevisAdminRoutingModule { }
