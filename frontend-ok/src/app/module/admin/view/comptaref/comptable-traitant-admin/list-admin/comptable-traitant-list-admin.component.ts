import {Component, OnInit} from '@angular/core';
import {ComptableTraitantService} from 'src/app/controller/service/ComptableTraitant.service';
import {ComptableTraitantDto} from 'src/app/controller/model/ComptableTraitant.model';
import {ComptableTraitantCriteria} from 'src/app/controller/criteria/ComptableTraitantCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-comptable-traitant-list-admin',
  templateUrl: './comptable-traitant-list-admin.component.html'
})
export class ComptableTraitantListAdminComponent extends AbstractListController<ComptableTraitantDto, ComptableTraitantCriteria, ComptableTraitantService>  implements OnInit {

    fileName = 'ComptableTraitant';

  
    constructor(comptableTraitantService: ComptableTraitantService) {
        super(comptableTraitantService);
        this.pdfName='ComptableTraitant.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadComptableTraitants(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ComptableTraitant', 'list');
        isPermistted ? this.service.findAll().subscribe(comptableTraitants => this.items = comptableTraitants,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
        ];
    }



	public initDuplicate(res: ComptableTraitantDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Cin': e.cin ,
                 'Nom': e.nom ,
                 'Prenom': e.prenom ,
            }
        });

        this.criteriaData = [{
            'Cin': this.criteria.cin ? this.criteria.cin : environment.emptyForExport ,
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Prenom': this.criteria.prenom ? this.criteria.prenom : environment.emptyForExport ,
        }];
      }
}
