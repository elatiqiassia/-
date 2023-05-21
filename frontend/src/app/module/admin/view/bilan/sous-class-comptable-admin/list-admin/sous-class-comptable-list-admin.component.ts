import {Component, OnInit} from '@angular/core';
import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableCriteria} from 'src/app/controller/criteria/SousClassComptableCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ClassComptableService } from 'src/app/controller/service/ClassComptable.service';

import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';


@Component({
  selector: 'app-sous-class-comptable-list-admin',
  templateUrl: './sous-class-comptable-list-admin.component.html'
})
export class SousClassComptableListAdminComponent extends AbstractListController<SousClassComptableDto, SousClassComptableCriteria, SousClassComptableService>  implements OnInit {

    fileName = 'SousClassComptable';

    classComptables :Array<ClassComptableDto>;
  
    constructor(sousClassComptableService: SousClassComptableService, private classComptableService: ClassComptableService) {
        super(sousClassComptableService);
        this.pdfName='SousClassComptable.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadClassComptable();
    }

    public async loadSousClassComptables(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SousClassComptable', 'list');
        isPermistted ? this.service.findAll().subscribe(sousClassComptables => this.items = sousClassComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'classComptable?.libelle', header: 'Class comptable'},
        ];
    }


    public async loadClassComptable(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SousClassComptable', 'list');
        isPermistted ? this.classComptableService.findAllOptimized().subscribe(classComptables => this.classComptables = classComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SousClassComptableDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                'Class comptable': e.classComptable?.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Class comptable': this.criteria.classComptable?.libelle ? this.criteria.classComptable?.libelle : environment.emptyForExport ,
        }];
      }
}
