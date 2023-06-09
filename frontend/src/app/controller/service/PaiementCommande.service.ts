import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PaiementCommandeDto} from '../model/PaiementCommande.model';
import {PaiementCommandeCriteria} from '../criteria/PaiementCommandeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {EtatPaiementCommandeDto} from '../model/EtatPaiementCommande.model';
import {CommandeDto} from '../model/Commande.model';
import {ModePaiementDto} from '../model/ModePaiement.model';

@Injectable({
  providedIn: 'root'
})
export class PaiementCommandeService extends AbstractService<PaiementCommandeDto, PaiementCommandeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paiementCommande/');
    }

    public constrcutDto(): PaiementCommandeDto {
        return new PaiementCommandeDto();
    }

    public constrcutCriteria(): PaiementCommandeCriteria {
        return new PaiementCommandeCriteria();
    }
}
