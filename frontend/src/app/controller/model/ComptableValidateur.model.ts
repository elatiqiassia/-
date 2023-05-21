import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ComptableValidateurDto  extends BaseDto{

    public id: number;
    public cin: string;
    public nom: string;
    public prenom: string;

}
