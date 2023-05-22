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

import { StoreCreateAdminComponent } from './store-admin/create-admin/store-create-admin.component';
import { StoreEditAdminComponent } from './store-admin/edit-admin/store-edit-admin.component';
import { StoreViewAdminComponent } from './store-admin/view-admin/store-view-admin.component';
import { StoreListAdminComponent } from './store-admin/list-admin/store-list-admin.component';
import { MagasinCreateAdminComponent } from './magasin-admin/create-admin/magasin-create-admin.component';
import { MagasinEditAdminComponent } from './magasin-admin/edit-admin/magasin-edit-admin.component';
import { MagasinViewAdminComponent } from './magasin-admin/view-admin/magasin-view-admin.component';
import { MagasinListAdminComponent } from './magasin-admin/list-admin/magasin-list-admin.component';
import { AbonneCreateAdminComponent } from './abonne-admin/create-admin/abonne-create-admin.component';
import { AbonneEditAdminComponent } from './abonne-admin/edit-admin/abonne-edit-admin.component';
import { AbonneViewAdminComponent } from './abonne-admin/view-admin/abonne-view-admin.component';
import { AbonneListAdminComponent } from './abonne-admin/list-admin/abonne-list-admin.component';
import { SocieteCreateAdminComponent } from './societe-admin/create-admin/societe-create-admin.component';
import { SocieteEditAdminComponent } from './societe-admin/edit-admin/societe-edit-admin.component';
import { SocieteViewAdminComponent } from './societe-admin/view-admin/societe-view-admin.component';
import { SocieteListAdminComponent } from './societe-admin/list-admin/societe-list-admin.component';

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

    StoreCreateAdminComponent,
    StoreListAdminComponent,
    StoreViewAdminComponent,
    StoreEditAdminComponent,
    MagasinCreateAdminComponent,
    MagasinListAdminComponent,
    MagasinViewAdminComponent,
    MagasinEditAdminComponent,
    AbonneCreateAdminComponent,
    AbonneListAdminComponent,
    AbonneViewAdminComponent,
    AbonneEditAdminComponent,
    SocieteCreateAdminComponent,
    SocieteListAdminComponent,
    SocieteViewAdminComponent,
    SocieteEditAdminComponent,
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
  StoreCreateAdminComponent,
  StoreListAdminComponent,
  StoreViewAdminComponent,
  StoreEditAdminComponent,
  MagasinCreateAdminComponent,
  MagasinListAdminComponent,
  MagasinViewAdminComponent,
  MagasinEditAdminComponent,
  AbonneCreateAdminComponent,
  AbonneListAdminComponent,
  AbonneViewAdminComponent,
  AbonneEditAdminComponent,
  SocieteCreateAdminComponent,
  SocieteListAdminComponent,
  SocieteViewAdminComponent,
  SocieteEditAdminComponent,
  ],
  entryComponents: [],
})
export class AbonneAdminModule { }