import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {BilanDto} from '../model/Bilan.model';
import {BilanCriteria} from '../criteria/BilanCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SocieteDto} from '../model/Societe.model';

@Injectable({
  providedIn: 'root'
})
export class BilanService extends AbstractService<BilanDto, BilanCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/bilan/');
    }

    public constrcutDto(): BilanDto {
        return new BilanDto();
    }

    public constrcutCriteria(): BilanCriteria {
        return new BilanCriteria();
    }
}
