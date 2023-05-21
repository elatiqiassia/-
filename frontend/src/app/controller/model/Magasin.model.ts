import {StoreDto} from './Store.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class MagasinDto  extends BaseDto{

    public id: number;
    public reference: string;
    public adresse: string;
    public store: StoreDto ;

}
