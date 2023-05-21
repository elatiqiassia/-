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

import { TauxRetardTvaCreateAdminComponent } from './taux-retard-tva-admin/create-admin/taux-retard-tva-create-admin.component';
import { TauxRetardTvaEditAdminComponent } from './taux-retard-tva-admin/edit-admin/taux-retard-tva-edit-admin.component';
import { TauxRetardTvaViewAdminComponent } from './taux-retard-tva-admin/view-admin/taux-retard-tva-view-admin.component';
import { TauxRetardTvaListAdminComponent } from './taux-retard-tva-admin/list-admin/taux-retard-tva-list-admin.component';
import { DeclarationTvaCreateAdminComponent } from './declaration-tva-admin/create-admin/declaration-tva-create-admin.component';
import { DeclarationTvaEditAdminComponent } from './declaration-tva-admin/edit-admin/declaration-tva-edit-admin.component';
import { DeclarationTvaViewAdminComponent } from './declaration-tva-admin/view-admin/declaration-tva-view-admin.component';
import { DeclarationTvaListAdminComponent } from './declaration-tva-admin/list-admin/declaration-tva-list-admin.component';

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

    TauxRetardTvaCreateAdminComponent,
    TauxRetardTvaListAdminComponent,
    TauxRetardTvaViewAdminComponent,
    TauxRetardTvaEditAdminComponent,
    DeclarationTvaCreateAdminComponent,
    DeclarationTvaListAdminComponent,
    DeclarationTvaViewAdminComponent,
    DeclarationTvaEditAdminComponent,
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
  TauxRetardTvaCreateAdminComponent,
  TauxRetardTvaListAdminComponent,
  TauxRetardTvaViewAdminComponent,
  TauxRetardTvaEditAdminComponent,
  DeclarationTvaCreateAdminComponent,
  DeclarationTvaListAdminComponent,
  DeclarationTvaViewAdminComponent,
  DeclarationTvaEditAdminComponent,
  ],
  entryComponents: [],
})
export class TvaAdminModule { }