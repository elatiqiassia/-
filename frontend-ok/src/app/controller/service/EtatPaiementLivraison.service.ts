import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatPaiementLivraisonDto} from '../model/EtatPaiementLivraison.model';
import {EtatPaiementLivraisonCriteria} from '../criteria/EtatPaiementLivraisonCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatPaiementLivraisonService extends AbstractService<EtatPaiementLivraisonDto, EtatPaiementLivraisonCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatPaiementLivraison/');
    }

    public constrcutDto(): EtatPaiementLivraisonDto {
        return new EtatPaiementLivraisonDto();
    }

    public constrcutCriteria(): EtatPaiementLivraisonCriteria {
        return new EtatPaiementLivraisonCriteria();
    }
}
