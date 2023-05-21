import {Component, OnInit} from '@angular/core';
import {UniteMesureService} from 'src/app/controller/service/UniteMesure.service';
import {UniteMesureDto} from 'src/app/controller/model/UniteMesure.model';
import {UniteMesureCriteria} from 'src/app/controller/criteria/UniteMesureCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-unite-mesure-list-admin',
  templateUrl: './unite-mesure-list-admin.component.html'
})
export class UniteMesureListAdminComponent extends AbstractListController<UniteMesureDto, UniteMesureCriteria, UniteMesureService>  implements OnInit {

    fileName = 'UniteMesure';

  
    constructor(uniteMesureService: UniteMesureService) {
        super(uniteMesureService);
        this.pdfName='UniteMesure.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadUniteMesures(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('UniteMesure', 'list');
        isPermistted ? this.service.findAll().subscribe(uniteMesures => this.items = uniteMesures,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: UniteMesureDto) {
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
