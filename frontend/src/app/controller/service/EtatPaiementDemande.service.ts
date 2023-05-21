import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatPaiementDemandeDto} from '../model/EtatPaiementDemande.model';
import {EtatPaiementDemandeCriteria} from '../criteria/EtatPaiementDemandeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatPaiementDemandeService extends AbstractService<EtatPaiementDemandeDto, EtatPaiementDemandeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatPaiementDemande/');
    }

    public constrcutDto(): EtatPaiementDemandeDto {
        return new EtatPaiementDemandeDto();
    }

    public constrcutCriteria(): EtatPaiementDemandeCriteria {
        return new EtatPaiementDemandeCriteria();
    }
}
