import {AbonneDto} from './Abonne.model';
import {StoreDto} from './Store.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SocieteDto  extends BaseDto{

    public id: number;
    public ice: string;
    public siege: string;
   public dernierAnneePayerIs: number;
   public dernierTrimestrePayerIs: number;
   public dernierAnneePayerTva: number;
   public dernierTrimestrePayerTva: number;
   public bloqued: null | boolean;
    public dernierAnneePayerIsMax: string ;
    public dernierAnneePayerIsMin: string ;
    public dernierTrimestrePayerIsMax: string ;
    public dernierTrimestrePayerIsMin: string ;
    public dernierAnneePayerTvaMax: string ;
    public dernierAnneePayerTvaMin: string ;
    public dernierTrimestrePayerTvaMax: string ;
    public dernierTrimestrePayerTvaMin: string ;
    public abonne: AbonneDto ;
     public stores: Array<StoreDto>;

}
