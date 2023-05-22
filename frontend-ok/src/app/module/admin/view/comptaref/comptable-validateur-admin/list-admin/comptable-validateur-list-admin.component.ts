import {Component, OnInit} from '@angular/core';
import {ComptableValidateurService} from 'src/app/controller/service/ComptableValidateur.service';
import {ComptableValidateurDto} from 'src/app/controller/model/ComptableValidateur.model';
import {ComptableValidateurCriteria} from 'src/app/controller/criteria/ComptableValidateurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-comptable-validateur-list-admin',
  templateUrl: './comptable-validateur-list-admin.component.html'
})
export class ComptableValidateurListAdminComponent extends AbstractListController<ComptableValidateurDto, ComptableValidateurCriteria, ComptableValidateurService>  implements OnInit {

    fileName = 'ComptableValidateur';

  
    constructor(comptableValidateurService: ComptableValidateurService) {
        super(comptableValidateurService);
        this.pdfName='ComptableValidateur.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadComptableValidateurs(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ComptableValidateur', 'list');
        isPermistted ? this.service.findAll().subscribe(comptableValidateurs => this.items = comptableValidateurs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
        ];
    }



	public initDuplicate(res: ComptableValidateurDto) {
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
