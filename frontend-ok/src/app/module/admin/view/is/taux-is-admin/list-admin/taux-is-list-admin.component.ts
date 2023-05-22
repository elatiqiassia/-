import {Component, OnInit} from '@angular/core';
import {TauxIsService} from 'src/app/controller/service/TauxIs.service';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';
import {TauxIsCriteria} from 'src/app/controller/criteria/TauxIsCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-taux-is-list-admin',
  templateUrl: './taux-is-list-admin.component.html'
})
export class TauxIsListAdminComponent extends AbstractListController<TauxIsDto, TauxIsCriteria, TauxIsService>  implements OnInit {

    fileName = 'TauxIs';

  
    constructor(tauxIsService: TauxIsService) {
        super(tauxIsService);
        this.pdfName='TauxIs.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadTauxIss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('TauxIs', 'list');
        isPermistted ? this.service.findAll().subscribe(tauxIss => this.items = tauxIss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'resultatMin', header: 'Resultat min'},
            {field: 'resultatMax', header: 'Resultat max'},
            {field: 'dateApplicationMin', header: 'Date application min'},
            {field: 'dateApplicationMax', header: 'Date application max'},
            {field: 'pourcentage', header: 'Pourcentage'},
        ];
    }



	public initDuplicate(res: TauxIsDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Resultat min': e.resultatMin ,
                 'Resultat max': e.resultatMax ,
                'Date application min': this.datePipe.transform(e.dateApplicationMin , 'dd/MM/yyyy hh:mm'),
                'Date application max': this.datePipe.transform(e.dateApplicationMax , 'dd/MM/yyyy hh:mm'),
                 'Pourcentage': e.pourcentage ,
            }
        });

        this.criteriaData = [{
            'Resultat min Min': this.criteria.resultatMinMin ? this.criteria.resultatMinMin : environment.emptyForExport ,
            'Resultat min Max': this.criteria.resultatMinMax ? this.criteria.resultatMinMax : environment.emptyForExport ,
            'Resultat max Min': this.criteria.resultatMaxMin ? this.criteria.resultatMaxMin : environment.emptyForExport ,
            'Resultat max Max': this.criteria.resultatMaxMax ? this.criteria.resultatMaxMax : environment.emptyForExport ,
            'Date application min Min': this.criteria.dateApplicationMinFrom ? this.datePipe.transform(this.criteria.dateApplicationMinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date application min Max': this.criteria.dateApplicationMinTo ? this.datePipe.transform(this.criteria.dateApplicationMinTo , this.dateFormat) : environment.emptyForExport ,
            'Date application max Min': this.criteria.dateApplicationMaxFrom ? this.datePipe.transform(this.criteria.dateApplicationMaxFrom , this.dateFormat) : environment.emptyForExport ,
            'Date application max Max': this.criteria.dateApplicationMaxTo ? this.datePipe.transform(this.criteria.dateApplicationMaxTo , this.dateFormat) : environment.emptyForExport ,
            'Pourcentage Min': this.criteria.pourcentageMin ? this.criteria.pourcentageMin : environment.emptyForExport ,
            'Pourcentage Max': this.criteria.pourcentageMax ? this.criteria.pourcentageMax : environment.emptyForExport ,
        }];
      }
}
