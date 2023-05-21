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

import { StockProduitCreateAdminComponent } from './stock-produit-admin/create-admin/stock-produit-create-admin.component';
import { StockProduitEditAdminComponent } from './stock-produit-admin/edit-admin/stock-produit-edit-admin.component';
import { StockProduitViewAdminComponent } from './stock-produit-admin/view-admin/stock-produit-view-admin.component';
import { StockProduitListAdminComponent } from './stock-produit-admin/list-admin/stock-produit-list-admin.component';
import { ProduitCreateAdminComponent } from './produit-admin/create-admin/produit-create-admin.component';
import { ProduitEditAdminComponent } from './produit-admin/edit-admin/produit-edit-admin.component';
import { ProduitViewAdminComponent } from './produit-admin/view-admin/produit-view-admin.component';
import { ProduitListAdminComponent } from './produit-admin/list-admin/produit-list-admin.component';
import { MarqueCreateAdminComponent } from './marque-admin/create-admin/marque-create-admin.component';
import { MarqueEditAdminComponent } from './marque-admin/edit-admin/marque-edit-admin.component';
import { MarqueViewAdminComponent } from './marque-admin/view-admin/marque-view-admin.component';
import { MarqueListAdminComponent } from './marque-admin/list-admin/marque-list-admin.component';
import { ModePaiementCreateAdminComponent } from './mode-paiement-admin/create-admin/mode-paiement-create-admin.component';
import { ModePaiementEditAdminComponent } from './mode-paiement-admin/edit-admin/mode-paiement-edit-admin.component';
import { ModePaiementViewAdminComponent } from './mode-paiement-admin/view-admin/mode-paiement-view-admin.component';
import { ModePaiementListAdminComponent } from './mode-paiement-admin/list-admin/mode-paiement-list-admin.component';
import { UniteMesureCreateAdminComponent } from './unite-mesure-admin/create-admin/unite-mesure-create-admin.component';
import { UniteMesureEditAdminComponent } from './unite-mesure-admin/edit-admin/unite-mesure-edit-admin.component';
import { UniteMesureViewAdminComponent } from './unite-mesure-admin/view-admin/unite-mesure-view-admin.component';
import { UniteMesureListAdminComponent } from './unite-mesure-admin/list-admin/unite-mesure-list-admin.component';
import { CategorieProduitCreateAdminComponent } from './categorie-produit-admin/create-admin/categorie-produit-create-admin.component';
import { CategorieProduitEditAdminComponent } from './categorie-produit-admin/edit-admin/categorie-produit-edit-admin.component';
import { CategorieProduitViewAdminComponent } from './categorie-produit-admin/view-admin/categorie-produit-view-admin.component';
import { CategorieProduitListAdminComponent } from './categorie-produit-admin/list-admin/categorie-produit-list-admin.component';

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

    StockProduitCreateAdminComponent,
    StockProduitListAdminComponent,
    StockProduitViewAdminComponent,
    StockProduitEditAdminComponent,
    ProduitCreateAdminComponent,
    ProduitListAdminComponent,
    ProduitViewAdminComponent,
    ProduitEditAdminComponent,
    MarqueCreateAdminComponent,
    MarqueListAdminComponent,
    MarqueViewAdminComponent,
    MarqueEditAdminComponent,
    ModePaiementCreateAdminComponent,
    ModePaiementListAdminComponent,
    ModePaiementViewAdminComponent,
    ModePaiementEditAdminComponent,
    UniteMesureCreateAdminComponent,
    UniteMesureListAdminComponent,
    UniteMesureViewAdminComponent,
    UniteMesureEditAdminComponent,
    CategorieProduitCreateAdminComponent,
    CategorieProduitListAdminComponent,
    CategorieProduitViewAdminComponent,
    CategorieProduitEditAdminComponent,
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
  StockProduitCreateAdminComponent,
  StockProduitListAdminComponent,
  StockProduitViewAdminComponent,
  StockProduitEditAdminComponent,
  ProduitCreateAdminComponent,
  ProduitListAdminComponent,
  ProduitViewAdminComponent,
  ProduitEditAdminComponent,
  MarqueCreateAdminComponent,
  MarqueListAdminComponent,
  MarqueViewAdminComponent,
  MarqueEditAdminComponent,
  ModePaiementCreateAdminComponent,
  ModePaiementListAdminComponent,
  ModePaiementViewAdminComponent,
  ModePaiementEditAdminComponent,
  UniteMesureCreateAdminComponent,
  UniteMesureListAdminComponent,
  UniteMesureViewAdminComponent,
  UniteMesureEditAdminComponent,
  CategorieProduitCreateAdminComponent,
  CategorieProduitListAdminComponent,
  CategorieProduitViewAdminComponent,
  CategorieProduitEditAdminComponent,
  ],
  entryComponents: [],
})
export class ReferentielAdminModule { }