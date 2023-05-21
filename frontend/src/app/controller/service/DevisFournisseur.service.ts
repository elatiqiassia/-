import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DevisFournisseurDto} from '../model/DevisFournisseur.model';
import {DevisFournisseurCriteria} from '../criteria/DevisFournisseurCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {DevisItemFournisseurDto} from '../model/DevisItemFournisseur.model';
import {FournisseurDto} from '../model/Fournisseur.model';

@Injectable({
  providedIn: 'root'
})
export class DevisFournisseurService extends AbstractService<DevisFournisseurDto, DevisFournisseurCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/devisFournisseur/');
    }

    public constrcutDto(): DevisFournisseurDto {
        return new DevisFournisseurDto();
    }

    public constrcutCriteria(): DevisFournisseurCriteria {
        return new DevisFournisseurCriteria();
    }
}
