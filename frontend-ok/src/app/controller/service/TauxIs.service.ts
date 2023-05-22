import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TauxIsDto} from '../model/TauxIs.model';
import {TauxIsCriteria} from '../criteria/TauxIsCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TauxIsService extends AbstractService<TauxIsDto, TauxIsCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/tauxIs/');
    }

    public constrcutDto(): TauxIsDto {
        return new TauxIsDto();
    }

    public constrcutCriteria(): TauxIsCriteria {
        return new TauxIsCriteria();
    }
}
