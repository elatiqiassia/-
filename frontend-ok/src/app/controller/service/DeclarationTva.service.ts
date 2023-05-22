import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DeclarationTvaDto} from '../model/DeclarationTva.model';
import {DeclarationTvaCriteria} from '../criteria/DeclarationTvaCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SocieteDto} from '../model/Societe.model';
import {ComptableValidateurDto} from '../model/ComptableValidateur.model';
import {ComptableTraitantDto} from '../model/ComptableTraitant.model';
import {TauxRetardTvaDto} from '../model/TauxRetardTva.model';

@Injectable({
  providedIn: 'root'
})
export class DeclarationTvaService extends AbstractService<DeclarationTvaDto, DeclarationTvaCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/declarationTva/');
    }

    public constrcutDto(): DeclarationTvaDto {
        return new DeclarationTvaDto();
    }

    public constrcutCriteria(): DeclarationTvaCriteria {
        return new DeclarationTvaCriteria();
    }
}
