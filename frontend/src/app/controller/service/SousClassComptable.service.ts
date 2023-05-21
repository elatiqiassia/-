import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SousClassComptableDto} from '../model/SousClassComptable.model';
import {SousClassComptableCriteria} from '../criteria/SousClassComptableCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ClassComptableDto} from '../model/ClassComptable.model';

@Injectable({
  providedIn: 'root'
})
export class SousClassComptableService extends AbstractService<SousClassComptableDto, SousClassComptableCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/sousClassComptable/');
    }

    public constrcutDto(): SousClassComptableDto {
        return new SousClassComptableDto();
    }

    public constrcutCriteria(): SousClassComptableCriteria {
        return new SousClassComptableCriteria();
    }
}
