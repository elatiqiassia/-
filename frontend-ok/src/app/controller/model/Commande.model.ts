import {EtatCommandeDto} from './EtatCommande.model';
import {CommandeItemDto} from './CommandeItem.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CommandeDto  extends BaseDto{

    public id: number;
    public reference: string;
   public dateCommande: Date;
    public total: number;
    public totalePaye: number;
    public totalPayeCheque: number;
    public totalPayeEspece: number;
    public dateCommandeMax: string ;
    public dateCommandeMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public totalePayeMax: string ;
    public totalePayeMin: string ;
    public totalPayeChequeMax: string ;
    public totalPayeChequeMin: string ;
    public totalPayeEspeceMax: string ;
    public totalPayeEspeceMin: string ;
    public client: ClientDto ;
    public etatCommande: EtatCommandeDto ;
     public commandeItems: Array<CommandeItemDto>;

}
