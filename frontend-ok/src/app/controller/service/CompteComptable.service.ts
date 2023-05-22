import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CompteComptableDto} from '../model/CompteComptable.model';
import {CompteComptableCriteria} from '../criteria/CompteComptableCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SousClassComptableDto} from '../model/SousClassComptable.model';

@Injectable({
  providedIn: 'root'
})
export class CompteComptableService extends AbstractService<CompteComptableDto, CompteComptableCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/compteComptable/');
    }

    public constrcutDto(): CompteComptableDto {
        return new CompteComptableDto();
    }

    public constrcutCriteria(): CompteComptableCriteria {
        return new CompteComptableCriteria();
    }
}
