import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatPaiementAchatDto} from '../model/EtatPaiementAchat.model';
import {EtatPaiementAchatCriteria} from '../criteria/EtatPaiementAchatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatPaiementAchatService extends AbstractService<EtatPaiementAchatDto, EtatPaiementAchatCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatPaiementAchat/');
    }

    public constrcutDto(): EtatPaiementAchatDto {
        return new EtatPaiementAchatDto();
    }

    public constrcutCriteria(): EtatPaiementAchatCriteria {
        return new EtatPaiementAchatCriteria();
    }
}
