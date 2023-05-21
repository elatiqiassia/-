import {Component, OnInit} from '@angular/core';
import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';
import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableCriteria} from 'src/app/controller/criteria/ClassComptableCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-class-comptable-list-admin',
  templateUrl: './class-comptable-list-admin.component.html'
})
export class ClassComptableListAdminComponent extends AbstractListController<ClassComptableDto, ClassComptableCriteria, ClassComptableService>  implements OnInit {

    fileName = 'ClassComptable';

  
    constructor(classComptableService: ClassComptableService) {
        super(classComptableService);
        this.pdfName='ClassComptable.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadClassComptables(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ClassComptable', 'list');
        isPermistted ? this.service.findAll().subscribe(classComptables => this.items = classComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: ClassComptableDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
