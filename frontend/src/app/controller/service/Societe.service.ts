import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SocieteDto} from '../model/Societe.model';
import {SocieteCriteria} from '../criteria/SocieteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {AbonneDto} from '../model/Abonne.model';
import {StoreDto} from '../model/Store.model';

@Injectable({
  providedIn: 'root'
})
export class SocieteService extends AbstractService<SocieteDto, SocieteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/societe/');
    }

    public constrcutDto(): SocieteDto {
        return new SocieteDto();
    }

    public constrcutCriteria(): SocieteCriteria {
        return new SocieteCriteria();
    }
}
