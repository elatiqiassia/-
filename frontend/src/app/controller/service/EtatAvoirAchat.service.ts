import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatAvoirAchatDto} from '../model/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from '../criteria/EtatAvoirAchatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatAvoirAchatService extends AbstractService<EtatAvoirAchatDto, EtatAvoirAchatCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatAvoirAchat/');
    }

    public constrcutDto(): EtatAvoirAchatDto {
        return new EtatAvoirAchatDto();
    }

    public constrcutCriteria(): EtatAvoirAchatCriteria {
        return new EtatAvoirAchatCriteria();
    }
}
