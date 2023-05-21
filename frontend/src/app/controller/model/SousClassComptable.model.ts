import {ClassComptableDto} from './ClassComptable.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SousClassComptableDto  extends BaseDto{

    public id: number;
    public libelle: string;
    public code: string;
    public classComptable: ClassComptableDto ;

}
