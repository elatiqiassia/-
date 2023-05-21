import {Component, OnInit} from '@angular/core';
import {BanqueService} from 'src/app/controller/service/Banque.service';
import {BanqueDto} from 'src/app/controller/model/Banque.model';
import {BanqueCriteria} from 'src/app/controller/criteria/BanqueCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-banque-list-admin',
  templateUrl: './banque-list-admin.component.html'
})
export class BanqueListAdminComponent extends AbstractListController<BanqueDto, BanqueCriteria, BanqueService>  implements OnInit {

    fileName = 'Banque';

  
    constructor(banqueService: BanqueService) {
        super(banqueService);
        this.pdfName='Banque.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadBanques(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Banque', 'list');
        isPermistted ? this.service.findAll().subscribe(banques => this.items = banques,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: BanqueDto) {
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
