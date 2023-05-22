import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementAchatService} from 'src/app/controller/service/PaiementAchat.service';
import {PaiementAchatDto} from 'src/app/controller/model/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/PaiementAchatCriteria.model';

import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AchatService} from 'src/app/controller/service/Achat.service';
import {EtatPaiementAchatDto} from 'src/app/controller/model/EtatPaiementAchat.model';
import {EtatPaiementAchatService} from 'src/app/controller/service/EtatPaiementAchat.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
@Component({
  selector: 'app-paiement-achat-view-admin',
  templateUrl: './paiement-achat-view-admin.component.html'
})
export class PaiementAchatViewAdminComponent extends AbstractViewController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatService> implements OnInit {


    constructor(private paiementAchatService: PaiementAchatService, private achatService: AchatService, private etatPaiementAchatService: EtatPaiementAchatService, private modePaiementService: ModePaiementService){
        super(paiementAchatService);
    }

    ngOnInit(): void {
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.etatPaiementAchat = new EtatPaiementAchatDto();
        this.etatPaiementAchatService.findAll().subscribe((data) => this.etatPaiementAchats = data);
    }


    get etatPaiementAchat(): EtatPaiementAchatDto {
       return this.etatPaiementAchatService.item;
    }
    set etatPaiementAchat(value: EtatPaiementAchatDto) {
        this.etatPaiementAchatService.item = value;
    }
    get etatPaiementAchats():Array<EtatPaiementAchatDto> {
       return this.etatPaiementAchatService.items;
    }
    set etatPaiementAchats(value: Array<EtatPaiementAchatDto>) {
        this.etatPaiementAchatService.items = value;
    }
    get achat(): AchatDto {
       return this.achatService.item;
    }
    set achat(value: AchatDto) {
        this.achatService.item = value;
    }
    get achats():Array<AchatDto> {
       return this.achatService.items;
    }
    set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
    }
    get modePaiement(): ModePaiementDto {
       return this.modePaiementService.item;
    }
    set modePaiement(value: ModePaiementDto) {
        this.modePaiementService.item = value;
    }
    get modePaiements():Array<ModePaiementDto> {
       return this.modePaiementService.items;
    }
    set modePaiements(value: Array<ModePaiementDto>) {
        this.modePaiementService.items = value;
    }


}
