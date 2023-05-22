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

import { VenteCreateAdminComponent } from './vente-admin/create-admin/vente-create-admin.component';
import { VenteEditAdminComponent } from './vente-admin/edit-admin/vente-edit-admin.component';
import { VenteViewAdminComponent } from './vente-admin/view-admin/vente-view-admin.component';
import { VenteListAdminComponent } from './vente-admin/list-admin/vente-list-admin.component';
import { EtatAvoirVenteCreateAdminComponent } from './etat-avoir-vente-admin/create-admin/etat-avoir-vente-create-admin.component';
import { EtatAvoirVenteEditAdminComponent } from './etat-avoir-vente-admin/edit-admin/etat-avoir-vente-edit-admin.component';
import { EtatAvoirVenteViewAdminComponent } from './etat-avoir-vente-admin/view-admin/etat-avoir-vente-view-admin.component';
import { EtatAvoirVenteListAdminComponent } from './etat-avoir-vente-admin/list-admin/etat-avoir-vente-list-admin.component';
import { EtatVenteCreateAdminComponent } from './etat-vente-admin/create-admin/etat-vente-create-admin.component';
import { EtatVenteEditAdminComponent } from './etat-vente-admin/edit-admin/etat-vente-edit-admin.component';
import { EtatVenteViewAdminComponent } from './etat-vente-admin/view-admin/etat-vente-view-admin.component';
import { EtatVenteListAdminComponent } from './etat-vente-admin/list-admin/etat-vente-list-admin.component';
import { AvoirVenteCreateAdminComponent } from './avoir-vente-admin/create-admin/avoir-vente-create-admin.component';
import { AvoirVenteEditAdminComponent } from './avoir-vente-admin/edit-admin/avoir-vente-edit-admin.component';
import { AvoirVenteViewAdminComponent } from './avoir-vente-admin/view-admin/avoir-vente-view-admin.component';
import { AvoirVenteListAdminComponent } from './avoir-vente-admin/list-admin/avoir-vente-list-admin.component';
import { PaiementVenteCreateAdminComponent } from './paiement-vente-admin/create-admin/paiement-vente-create-admin.component';
import { PaiementVenteEditAdminComponent } from './paiement-vente-admin/edit-admin/paiement-vente-edit-admin.component';
import { PaiementVenteViewAdminComponent } from './paiement-vente-admin/view-admin/paiement-vente-view-admin.component';
import { PaiementVenteListAdminComponent } from './paiement-vente-admin/list-admin/paiement-vente-list-admin.component';
import { EtatPaiementVenteCreateAdminComponent } from './etat-paiement-vente-admin/create-admin/etat-paiement-vente-create-admin.component';
import { EtatPaiementVenteEditAdminComponent } from './etat-paiement-vente-admin/edit-admin/etat-paiement-vente-edit-admin.component';
import { EtatPaiementVenteViewAdminComponent } from './etat-paiement-vente-admin/view-admin/etat-paiement-vente-view-admin.component';
import { EtatPaiementVenteListAdminComponent } from './etat-paiement-vente-admin/list-admin/etat-paiement-vente-list-admin.component';

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

    VenteCreateAdminComponent,
    VenteListAdminComponent,
    VenteViewAdminComponent,
    VenteEditAdminComponent,
    EtatAvoirVenteCreateAdminComponent,
    EtatAvoirVenteListAdminComponent,
    EtatAvoirVenteViewAdminComponent,
    EtatAvoirVenteEditAdminComponent,
    EtatVenteCreateAdminComponent,
    EtatVenteListAdminComponent,
    EtatVenteViewAdminComponent,
    EtatVenteEditAdminComponent,
    AvoirVenteCreateAdminComponent,
    AvoirVenteListAdminComponent,
    AvoirVenteViewAdminComponent,
    AvoirVenteEditAdminComponent,
    PaiementVenteCreateAdminComponent,
    PaiementVenteListAdminComponent,
    PaiementVenteViewAdminComponent,
    PaiementVenteEditAdminComponent,
    EtatPaiementVenteCreateAdminComponent,
    EtatPaiementVenteListAdminComponent,
    EtatPaiementVenteViewAdminComponent,
    EtatPaiementVenteEditAdminComponent,
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
  VenteCreateAdminComponent,
  VenteListAdminComponent,
  VenteViewAdminComponent,
  VenteEditAdminComponent,
  EtatAvoirVenteCreateAdminComponent,
  EtatAvoirVenteListAdminComponent,
  EtatAvoirVenteViewAdminComponent,
  EtatAvoirVenteEditAdminComponent,
  EtatVenteCreateAdminComponent,
  EtatVenteListAdminComponent,
  EtatVenteViewAdminComponent,
  EtatVenteEditAdminComponent,
  AvoirVenteCreateAdminComponent,
  AvoirVenteListAdminComponent,
  AvoirVenteViewAdminComponent,
  AvoirVenteEditAdminComponent,
  PaiementVenteCreateAdminComponent,
  PaiementVenteListAdminComponent,
  PaiementVenteViewAdminComponent,
  PaiementVenteEditAdminComponent,
  EtatPaiementVenteCreateAdminComponent,
  EtatPaiementVenteListAdminComponent,
  EtatPaiementVenteViewAdminComponent,
  EtatPaiementVenteEditAdminComponent,
  ],
  entryComponents: [],
})
export class VenteAdminModule { }