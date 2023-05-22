import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from "primeng/fileupload";

import { PaiementDemandeCreateAdminComponent } from './paiement-demande-admin/create-admin/paiement-demande-create-admin.component';
import { PaiementDemandeEditAdminComponent } from './paiement-demande-admin/edit-admin/paiement-demande-edit-admin.component';
import { PaiementDemandeViewAdminComponent } from './paiement-demande-admin/view-admin/paiement-demande-view-admin.component';
import { PaiementDemandeListAdminComponent } from './paiement-demande-admin/list-admin/paiement-demande-list-admin.component';
import { EtatLivraisonCreateAdminComponent } from './etat-livraison-admin/create-admin/etat-livraison-create-admin.component';
import { EtatLivraisonEditAdminComponent } from './etat-livraison-admin/edit-admin/etat-livraison-edit-admin.component';
import { EtatLivraisonViewAdminComponent } from './etat-livraison-admin/view-admin/etat-livraison-view-admin.component';
import { EtatLivraisonListAdminComponent } from './etat-livraison-admin/list-admin/etat-livraison-list-admin.component';
import { LivraisonCreateAdminComponent } from './livraison-admin/create-admin/livraison-create-admin.component';
import { LivraisonEditAdminComponent } from './livraison-admin/edit-admin/livraison-edit-admin.component';
import { LivraisonViewAdminComponent } from './livraison-admin/view-admin/livraison-view-admin.component';
import { LivraisonListAdminComponent } from './livraison-admin/list-admin/livraison-list-admin.component';
import { EtatPaiementLivraisonCreateAdminComponent } from './etat-paiement-livraison-admin/create-admin/etat-paiement-livraison-create-admin.component';
import { EtatPaiementLivraisonEditAdminComponent } from './etat-paiement-livraison-admin/edit-admin/etat-paiement-livraison-edit-admin.component';
import { EtatPaiementLivraisonViewAdminComponent } from './etat-paiement-livraison-admin/view-admin/etat-paiement-livraison-view-admin.component';
import { EtatPaiementLivraisonListAdminComponent } from './etat-paiement-livraison-admin/list-admin/etat-paiement-livraison-list-admin.component';
import { EtatDemandeCreateAdminComponent } from './etat-demande-admin/create-admin/etat-demande-create-admin.component';
import { EtatDemandeEditAdminComponent } from './etat-demande-admin/edit-admin/etat-demande-edit-admin.component';
import { EtatDemandeViewAdminComponent } from './etat-demande-admin/view-admin/etat-demande-view-admin.component';
import { EtatDemandeListAdminComponent } from './etat-demande-admin/list-admin/etat-demande-list-admin.component';
import { PaiementLivraisonCreateAdminComponent } from './paiement-livraison-admin/create-admin/paiement-livraison-create-admin.component';
import { PaiementLivraisonEditAdminComponent } from './paiement-livraison-admin/edit-admin/paiement-livraison-edit-admin.component';
import { PaiementLivraisonViewAdminComponent } from './paiement-livraison-admin/view-admin/paiement-livraison-view-admin.component';
import { PaiementLivraisonListAdminComponent } from './paiement-livraison-admin/list-admin/paiement-livraison-list-admin.component';
import { EtatPaiementDemandeCreateAdminComponent } from './etat-paiement-demande-admin/create-admin/etat-paiement-demande-create-admin.component';
import { EtatPaiementDemandeEditAdminComponent } from './etat-paiement-demande-admin/edit-admin/etat-paiement-demande-edit-admin.component';
import { EtatPaiementDemandeViewAdminComponent } from './etat-paiement-demande-admin/view-admin/etat-paiement-demande-view-admin.component';
import { EtatPaiementDemandeListAdminComponent } from './etat-paiement-demande-admin/list-admin/etat-paiement-demande-list-admin.component';
import { DemandeCreateAdminComponent } from './demande-admin/create-admin/demande-create-admin.component';
import { DemandeEditAdminComponent } from './demande-admin/edit-admin/demande-edit-admin.component';
import { DemandeViewAdminComponent } from './demande-admin/view-admin/demande-view-admin.component';
import { DemandeListAdminComponent } from './demande-admin/list-admin/demande-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    PaiementDemandeCreateAdminComponent,
    PaiementDemandeListAdminComponent,
    PaiementDemandeViewAdminComponent,
    PaiementDemandeEditAdminComponent,
    EtatLivraisonCreateAdminComponent,
    EtatLivraisonListAdminComponent,
    EtatLivraisonViewAdminComponent,
    EtatLivraisonEditAdminComponent,
    LivraisonCreateAdminComponent,
    LivraisonListAdminComponent,
    LivraisonViewAdminComponent,
    LivraisonEditAdminComponent,
    EtatPaiementLivraisonCreateAdminComponent,
    EtatPaiementLivraisonListAdminComponent,
    EtatPaiementLivraisonViewAdminComponent,
    EtatPaiementLivraisonEditAdminComponent,
    EtatDemandeCreateAdminComponent,
    EtatDemandeListAdminComponent,
    EtatDemandeViewAdminComponent,
    EtatDemandeEditAdminComponent,
    PaiementLivraisonCreateAdminComponent,
    PaiementLivraisonListAdminComponent,
    PaiementLivraisonViewAdminComponent,
    PaiementLivraisonEditAdminComponent,
    EtatPaiementDemandeCreateAdminComponent,
    EtatPaiementDemandeListAdminComponent,
    EtatPaiementDemandeViewAdminComponent,
    EtatPaiementDemandeEditAdminComponent,
    DemandeCreateAdminComponent,
    DemandeListAdminComponent,
    DemandeViewAdminComponent,
    DemandeEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
  ],
  exports: [
  PaiementDemandeCreateAdminComponent,
  PaiementDemandeListAdminComponent,
  PaiementDemandeViewAdminComponent,
  PaiementDemandeEditAdminComponent,
  EtatLivraisonCreateAdminComponent,
  EtatLivraisonListAdminComponent,
  EtatLivraisonViewAdminComponent,
  EtatLivraisonEditAdminComponent,
  LivraisonCreateAdminComponent,
  LivraisonListAdminComponent,
  LivraisonViewAdminComponent,
  LivraisonEditAdminComponent,
  EtatPaiementLivraisonCreateAdminComponent,
  EtatPaiementLivraisonListAdminComponent,
  EtatPaiementLivraisonViewAdminComponent,
  EtatPaiementLivraisonEditAdminComponent,
  EtatDemandeCreateAdminComponent,
  EtatDemandeListAdminComponent,
  EtatDemandeViewAdminComponent,
  EtatDemandeEditAdminComponent,
  PaiementLivraisonCreateAdminComponent,
  PaiementLivraisonListAdminComponent,
  PaiementLivraisonViewAdminComponent,
  PaiementLivraisonEditAdminComponent,
  EtatPaiementDemandeCreateAdminComponent,
  EtatPaiementDemandeListAdminComponent,
  EtatPaiementDemandeViewAdminComponent,
  EtatPaiementDemandeEditAdminComponent,
  DemandeCreateAdminComponent,
  DemandeListAdminComponent,
  DemandeViewAdminComponent,
  DemandeEditAdminComponent,
  ],
  entryComponents: [],
})
export class DemandeAdminModule { }