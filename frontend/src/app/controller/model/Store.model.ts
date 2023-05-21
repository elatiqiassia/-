import {SocieteDto} from './Societe.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class StoreDto  extends BaseDto{

    public id: number;
    public libelle: string;
    public reference: string;
    public societe: SocieteDto ;

}
