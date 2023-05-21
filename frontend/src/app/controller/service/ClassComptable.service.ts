import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ClassComptableDto} from '../model/ClassComptable.model';
import {ClassComptableCriteria} from '../criteria/ClassComptableCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ClassComptableService extends AbstractService<ClassComptableDto, ClassComptableCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/classComptable/');
    }

    public constrcutDto(): ClassComptableDto {
        return new ClassComptableDto();
    }

    public constrcutCriteria(): ClassComptableCriteria {
        return new ClassComptableCriteria();
    }
}
