import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatPaiementCommandeDto} from '../model/EtatPaiementCommande.model';
import {EtatPaiementCommandeCriteria} from '../criteria/EtatPaiementCommandeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatPaiementCommandeService extends AbstractService<EtatPaiementCommandeDto, EtatPaiementCommandeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatPaiementCommande/');
    }

    public constrcutDto(): EtatPaiementCommandeDto {
        return new EtatPaiementCommandeDto();
    }

    public constrcutCriteria(): EtatPaiementCommandeCriteria {
        return new EtatPaiementCommandeCriteria();
    }
}
