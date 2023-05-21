import {SocieteDto} from './Societe.model';
import {CompteComptableDto} from './CompteComptable.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class OperationComptableDto  extends BaseDto{

    public id: number;
   public dateOperationComptable: Date;
    public montant: number;
    public dateOperationComptableMax: string ;
    public dateOperationComptableMin: string ;
    public montantMax: string ;
    public montantMin: string ;
    public societe: SocieteDto ;
    public compteComptable: CompteComptableDto ;

}
