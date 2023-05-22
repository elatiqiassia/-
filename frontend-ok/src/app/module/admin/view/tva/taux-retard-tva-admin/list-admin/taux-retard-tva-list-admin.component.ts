import {Component, OnInit} from '@angular/core';
import {TauxRetardTvaService} from 'src/app/controller/service/TauxRetardTva.service';
import {TauxRetardTvaDto} from 'src/app/controller/model/TauxRetardTva.model';
import {TauxRetardTvaCriteria} from 'src/app/controller/criteria/TauxRetardTvaCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-taux-retard-tva-list-admin',
  templateUrl: './taux-retard-tva-list-admin.component.html'
})
export class TauxRetardTvaListAdminComponent extends AbstractListController<TauxRetardTvaDto, TauxRetardTvaCriteria, TauxRetardTvaService>  implements OnInit {

    fileName = 'TauxRetardTva';

  
    constructor(tauxRetardTvaService: TauxRetardTvaService) {
        super(tauxRetardTvaService);
        this.pdfName='TauxRetardTva.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadTauxRetardTvas(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('TauxRetardTva', 'list');
        isPermistted ? this.service.findAll().subscribe(tauxRetardTvas => this.items = tauxRetardTvas,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'dateApplicationMin', header: 'Date application min'},
            {field: 'dateApplicationMax', header: 'Date application max'},
            {field: 'montant', header: 'Montant'},
        ];
    }



	public initDuplicate(res: TauxRetardTvaDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Date application min': this.datePipe.transform(e.dateApplicationMin , 'dd/MM/yyyy hh:mm'),
                'Date application max': this.datePipe.transform(e.dateApplicationMax , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
            }
        });

        this.criteriaData = [{
            'Date application min Min': this.criteria.dateApplicationMinFrom ? this.datePipe.transform(this.criteria.dateApplicationMinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date application min Max': this.criteria.dateApplicationMinTo ? this.datePipe.transform(this.criteria.dateApplicationMinTo , this.dateFormat) : environment.emptyForExport ,
            'Date application max Min': this.criteria.dateApplicationMaxFrom ? this.datePipe.transform(this.criteria.dateApplicationMaxFrom , this.dateFormat) : environment.emptyForExport ,
            'Date application max Max': this.criteria.dateApplicationMaxTo ? this.datePipe.transform(this.criteria.dateApplicationMaxTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        }];
      }
}
