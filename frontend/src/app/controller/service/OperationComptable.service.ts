import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {OperationComptableDto} from '../model/OperationComptable.model';
import {OperationComptableCriteria} from '../criteria/OperationComptableCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SocieteDto} from '../model/Societe.model';
import {CompteComptableDto} from '../model/CompteComptable.model';

@Injectable({
  providedIn: 'root'
})
export class OperationComptableService extends AbstractService<OperationComptableDto, OperationComptableCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/operationComptable/');
    }

    public constrcutDto(): OperationComptableDto {
        return new OperationComptableDto();
    }

    public constrcutCriteria(): OperationComptableCriteria {
        return new OperationComptableCriteria();
    }
}
