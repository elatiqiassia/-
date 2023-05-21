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

import { EtatReceptionCreateAdminComponent } from './etat-reception-admin/create-admin/etat-reception-create-admin.component';
import { EtatReceptionEditAdminComponent } from './etat-reception-admin/edit-admin/etat-reception-edit-admin.component';
import { EtatReceptionViewAdminComponent } from './etat-reception-admin/view-admin/etat-reception-view-admin.component';
import { EtatReceptionListAdminComponent } from './etat-reception-admin/list-admin/etat-reception-list-admin.component';
import { EtatCommandeCreateAdminComponent } from './etat-commande-admin/create-admin/etat-commande-create-admin.component';
import { EtatCommandeEditAdminComponent } from './etat-commande-admin/edit-admin/etat-commande-edit-admin.component';
import { EtatCommandeViewAdminComponent } from './etat-commande-admin/view-admin/etat-commande-view-admin.component';
import { EtatCommandeListAdminComponent } from './etat-commande-admin/list-admin/etat-commande-list-admin.component';
import { PaiementCommandeCreateAdminComponent } from './paiement-commande-admin/create-admin/paiement-commande-create-admin.component';
import { PaiementCommandeEditAdminComponent } from './paiement-commande-admin/edit-admin/paiement-commande-edit-admin.component';
import { PaiementCommandeViewAdminComponent } from './paiement-commande-admin/view-admin/paiement-commande-view-admin.component';
import { PaiementCommandeListAdminComponent } from './paiement-commande-admin/list-admin/paiement-commande-list-admin.component';
import { ReceptionCreateAdminComponent } from './reception-admin/create-admin/reception-create-admin.component';
import { ReceptionEditAdminComponent } from './reception-admin/edit-admin/reception-edit-admin.component';
import { ReceptionViewAdminComponent } from './reception-admin/view-admin/reception-view-admin.component';
import { ReceptionListAdminComponent } from './reception-admin/list-admin/reception-list-admin.component';
import { EtatPaiementCommandeCreateAdminComponent } from './etat-paiement-commande-admin/create-admin/etat-paiement-commande-create-admin.component';
import { EtatPaiementCommandeEditAdminComponent } from './etat-paiement-commande-admin/edit-admin/etat-paiement-commande-edit-admin.component';
import { EtatPaiementCommandeViewAdminComponent } from './etat-paiement-commande-admin/view-admin/etat-paiement-commande-view-admin.component';
import { EtatPaiementCommandeListAdminComponent } from './etat-paiement-commande-admin/list-admin/etat-paiement-commande-list-admin.component';
import { CommandeCreateAdminComponent } from './commande-admin/create-admin/commande-create-admin.component';
import { CommandeEditAdminComponent } from './commande-admin/edit-admin/commande-edit-admin.component';
import { CommandeViewAdminComponent } from './commande-admin/view-admin/commande-view-admin.component';
import { CommandeListAdminComponent } from './commande-admin/list-admin/commande-list-admin.component';

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

    EtatReceptionCreateAdminComponent,
    EtatReceptionListAdminComponent,
    EtatReceptionViewAdminComponent,
    EtatReceptionEditAdminComponent,
    EtatCommandeCreateAdminComponent,
    EtatCommandeListAdminComponent,
    EtatCommandeViewAdminComponent,
    EtatCommandeEditAdminComponent,
    PaiementCommandeCreateAdminComponent,
    PaiementCommandeListAdminComponent,
    PaiementCommandeViewAdminComponent,
    PaiementCommandeEditAdminComponent,
    ReceptionCreateAdminComponent,
    ReceptionListAdminComponent,
    ReceptionViewAdminComponent,
    ReceptionEditAdminComponent,
    EtatPaiementCommandeCreateAdminComponent,
    EtatPaiementCommandeListAdminComponent,
    EtatPaiementCommandeViewAdminComponent,
    EtatPaiementCommandeEditAdminComponent,
    CommandeCreateAdminComponent,
    CommandeListAdminComponent,
    CommandeViewAdminComponent,
    CommandeEditAdminComponent,
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
  EtatReceptionCreateAdminComponent,
  EtatReceptionListAdminComponent,
  EtatReceptionViewAdminComponent,
  EtatReceptionEditAdminComponent,
  EtatCommandeCreateAdminComponent,
  EtatCommandeListAdminComponent,
  EtatCommandeViewAdminComponent,
  EtatCommandeEditAdminComponent,
  PaiementCommandeCreateAdminComponent,
  PaiementCommandeListAdminComponent,
  PaiementCommandeViewAdminComponent,
  PaiementCommandeEditAdminComponent,
  ReceptionCreateAdminComponent,
  ReceptionListAdminComponent,
  ReceptionViewAdminComponent,
  ReceptionEditAdminComponent,
  EtatPaiementCommandeCreateAdminComponent,
  EtatPaiementCommandeListAdminComponent,
  EtatPaiementCommandeViewAdminComponent,
  EtatPaiementCommandeEditAdminComponent,
  CommandeCreateAdminComponent,
  CommandeListAdminComponent,
  CommandeViewAdminComponent,
  CommandeEditAdminComponent,
  ],
  entryComponents: [],
})
export class CommandeAdminModule { }