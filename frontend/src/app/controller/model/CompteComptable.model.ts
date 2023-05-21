import {SousClassComptableDto} from './SousClassComptable.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CompteComptableDto  extends BaseDto{

    public id: number;
    public libelle: string;
    public code: string;
    public sousClassComptable: SousClassComptableDto ;

}
