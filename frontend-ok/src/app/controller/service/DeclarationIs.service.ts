import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DeclarationIsDto} from '../model/DeclarationIs.model';
import {DeclarationIsCriteria} from '../criteria/DeclarationIsCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SocieteDto} from '../model/Societe.model';
import {ComptableValidateurDto} from '../model/ComptableValidateur.model';
import {ComptableTraitantDto} from '../model/ComptableTraitant.model';
import {TauxIsDto} from '../model/TauxIs.model';

@Injectable({
  providedIn: 'root'
})
export class DeclarationIsService extends AbstractService<DeclarationIsDto, DeclarationIsCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/declarationIs/');
    }

    public constrcutDto(): DeclarationIsDto {
        return new DeclarationIsDto();
    }

    public constrcutCriteria(): DeclarationIsCriteria {
        return new DeclarationIsCriteria();
    }
}
