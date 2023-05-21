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
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import { VenteAdminModule } from './view/vente/vente-admin.module';
import { VenteAdminRoutingModule } from './view/vente/vente-admin-routing.module';
import { BilanAdminModule } from './view/bilan/bilan-admin.module';
import { BilanAdminRoutingModule } from './view/bilan/bilan-admin-routing.module';
import { AbonneAdminModule } from './view/abonne/abonne-admin.module';
import { AbonneAdminRoutingModule } from './view/abonne/abonne-admin-routing.module';
import { IsAdminModule } from './view/is/is-admin.module';
import { IsAdminRoutingModule } from './view/is/is-admin-routing.module';
import { CollaborateurAdminModule } from './view/collaborateur/collaborateur-admin.module';
import { CollaborateurAdminRoutingModule } from './view/collaborateur/collaborateur-admin-routing.module';
import { DevisAdminModule } from './view/devis/devis-admin.module';
import { DevisAdminRoutingModule } from './view/devis/devis-admin-routing.module';
import { CommandeAdminModule } from './view/commande/commande-admin.module';
import { CommandeAdminRoutingModule } from './view/commande/commande-admin-routing.module';
import { DemandeAdminModule } from './view/demande/demande-admin.module';
import { DemandeAdminRoutingModule } from './view/demande/demande-admin-routing.module';
import { ReferentielAdminModule } from './view/referentiel/referentiel-admin.module';
import { ReferentielAdminRoutingModule } from './view/referentiel/referentiel-admin-routing.module';
import { ChequeAdminModule } from './view/cheque/cheque-admin.module';
import { ChequeAdminRoutingModule } from './view/cheque/cheque-admin-routing.module';
import { ComptarefAdminModule } from './view/comptaref/comptaref-admin.module';
import { ComptarefAdminRoutingModule } from './view/comptaref/comptaref-admin-routing.module';
import { AchatAdminModule } from './view/achat/achat-admin.module';
import { AchatAdminRoutingModule } from './view/achat/achat-admin-routing.module';
import { TvaAdminModule } from './view/tva/tva-admin.module';
import { TvaAdminRoutingModule } from './view/tva/tva-admin-routing.module';


import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';


@NgModule({
  declarations: [
   LoginAdminComponent,
   RegisterAdminComponent
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
  VenteAdminModule,
  VenteAdminRoutingModule,
  BilanAdminModule,
  BilanAdminRoutingModule,
  AbonneAdminModule,
  AbonneAdminRoutingModule,
  IsAdminModule,
  IsAdminRoutingModule,
  CollaborateurAdminModule,
  CollaborateurAdminRoutingModule,
  DevisAdminModule,
  DevisAdminRoutingModule,
  CommandeAdminModule,
  CommandeAdminRoutingModule,
  DemandeAdminModule,
  DemandeAdminRoutingModule,
  ReferentielAdminModule,
  ReferentielAdminRoutingModule,
  ChequeAdminModule,
  ChequeAdminRoutingModule,
  ComptarefAdminModule,
  ComptarefAdminRoutingModule,
  AchatAdminModule,
  AchatAdminRoutingModule,
  TvaAdminModule,
  TvaAdminRoutingModule,
  ],
  exports: [
  LoginAdminComponent,
  RegisterAdminComponent,

    VenteAdminModule,
    BilanAdminModule,
    AbonneAdminModule,
    IsAdminModule,
    CollaborateurAdminModule,
    DevisAdminModule,
    CommandeAdminModule,
    DemandeAdminModule,
    ReferentielAdminModule,
    ChequeAdminModule,
    ComptarefAdminModule,
    AchatAdminModule,
    TvaAdminModule,
  ],
  entryComponents: [],
})
export class AdminModule { }
