import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaiementCommandeService} from 'src/app/controller/service/PaiementCommande.service';
import {PaiementCommandeDto} from 'src/app/controller/model/PaiementCommande.model';
import {PaiementCommandeCriteria} from 'src/app/controller/criteria/PaiementCommandeCriteria.model';
import {CommandeDto} from 'src/app/controller/model/Commande.model';
import {CommandeService} from 'src/app/controller/service/Commande.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {EtatPaiementCommandeDto} from 'src/app/controller/model/EtatPaiementCommande.model';
import {EtatPaiementCommandeService} from 'src/app/controller/service/EtatPaiementCommande.service';
@Component({
  selector: 'app-paiement-commande-create-admin',
  templateUrl: './paiement-commande-create-admin.component.html'
})
export class PaiementCommandeCreateAdminComponent extends AbstractCreateController<PaiementCommandeDto, PaiementCommandeCriteria, PaiementCommandeService>  implements OnInit {



   private _validPaiementCommandeReference = true;
    private _validCommandeReference = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;
    private _validEtatPaiementCommandeLibelle = true;
    private _validEtatPaiementCommandeCode = true;

    constructor( private paiementCommandeService: PaiementCommandeService , private commandeService: CommandeService, private modePaiementService: ModePaiementService, private etatPaiementCommandeService: EtatPaiementCommandeService) {
        super(paiementCommandeService);
    }

    ngOnInit(): void {
    this.commande = new CommandeDto();
    this.commandeService.findAll().subscribe((data) => this.commandes = data);
    this.modePaiement = new ModePaiementDto();
    this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
    this.etatPaiementCommande = new EtatPaiementCommandeDto();
    this.etatPaiementCommandeService.findAll().subscribe((data) => this.etatPaiementCommandes = data);
}





    public setValidation(value: boolean){
        this.validPaiementCommandeReference = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementCommandeReference();
    }

    public validatePaiementCommandeReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validPaiementCommandeReference = false;
        } else {
            this.validPaiementCommandeReference = true;
        }
    }


    public async openCreateCommande(commande: string) {
    const isPermistted = await this.roleService.isPermitted('Commande', 'add');
    if(isPermistted) {
         this.commande = new CommandeDto();
         this.createCommandeDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateEtatPaiementCommande(etatPaiementCommande: string) {
    const isPermistted = await this.roleService.isPermitted('EtatPaiementCommande', 'add');
    if(isPermistted) {
         this.etatPaiementCommande = new EtatPaiementCommandeDto();
         this.createEtatPaiementCommandeDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get commande(): CommandeDto {
        return this.commandeService.item;
    }
    set commande(value: CommandeDto) {
        this.commandeService.item = value;
    }
    get commandes(): Array<CommandeDto> {
        return this.commandeService.items;
    }
    set commandes(value: Array<CommandeDto>) {
        this.commandeService.items = value;
    }
    get createCommandeDialog(): boolean {
       return this.commandeService.createDialog;
    }
    set createCommandeDialog(value: boolean) {
        this.commandeService.createDialog= value;
    }
    get modePaiement(): ModePaiementDto {
        return this.modePaiementService.item;
    }
    set modePaiement(value: ModePaiementDto) {
        this.modePaiementService.item = value;
    }
    get modePaiements(): Array<ModePaiementDto> {
        return this.modePaiementService.items;
    }
    set modePaiements(value: Array<ModePaiementDto>) {
        this.modePaiementService.items = value;
    }
    get createModePaiementDialog(): boolean {
       return this.modePaiementService.createDialog;
    }
    set createModePaiementDialog(value: boolean) {
        this.modePaiementService.createDialog= value;
    }
    get etatPaiementCommande(): EtatPaiementCommandeDto {
        return this.etatPaiementCommandeService.item;
    }
    set etatPaiementCommande(value: EtatPaiementCommandeDto) {
        this.etatPaiementCommandeService.item = value;
    }
    get etatPaiementCommandes(): Array<EtatPaiementCommandeDto> {
        return this.etatPaiementCommandeService.items;
    }
    set etatPaiementCommandes(value: Array<EtatPaiementCommandeDto>) {
        this.etatPaiementCommandeService.items = value;
    }
    get createEtatPaiementCommandeDialog(): boolean {
       return this.etatPaiementCommandeService.createDialog;
    }
    set createEtatPaiementCommandeDialog(value: boolean) {
        this.etatPaiementCommandeService.createDialog= value;
    }



    get validPaiementCommandeReference(): boolean {
        return this._validPaiementCommandeReference;
    }

    set validPaiementCommandeReference(value: boolean) {
         this._validPaiementCommandeReference = value;
    }

    get validCommandeReference(): boolean {
        return this._validCommandeReference;
    }
    set validCommandeReference(value: boolean) {
        this._validCommandeReference = value;
    }
    get validModePaiementLibelle(): boolean {
        return this._validModePaiementLibelle;
    }
    set validModePaiementLibelle(value: boolean) {
        this._validModePaiementLibelle = value;
    }
    get validModePaiementCode(): boolean {
        return this._validModePaiementCode;
    }
    set validModePaiementCode(value: boolean) {
        this._validModePaiementCode = value;
    }
    get validEtatPaiementCommandeLibelle(): boolean {
        return this._validEtatPaiementCommandeLibelle;
    }
    set validEtatPaiementCommandeLibelle(value: boolean) {
        this._validEtatPaiementCommandeLibelle = value;
    }
    get validEtatPaiementCommandeCode(): boolean {
        return this._validEtatPaiementCommandeCode;
    }
    set validEtatPaiementCommandeCode(value: boolean) {
        this._validEtatPaiementCommandeCode = value;
    }


}
