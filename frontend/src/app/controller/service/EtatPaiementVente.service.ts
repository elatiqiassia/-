import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatPaiementVenteDto} from '../model/EtatPaiementVente.model';
import {EtatPaiementVenteCriteria} from '../criteria/EtatPaiementVenteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatPaiementVenteService extends AbstractService<EtatPaiementVenteDto, EtatPaiementVenteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatPaiementVente/');
    }

    public constrcutDto(): EtatPaiementVenteDto {
        return new EtatPaiementVenteDto();
    }

    public constrcutCriteria(): EtatPaiementVenteCriteria {
        return new EtatPaiementVenteCriteria();
    }
}
