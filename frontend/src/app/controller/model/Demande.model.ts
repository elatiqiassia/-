import {EtatDemandeDto} from './EtatDemande.model';
import {ClientDto} from './Client.model';
import {DemandeItemDto} from './DemandeItem.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DemandeDto  extends BaseDto{

    public id: number;
    public reference: string;
   public dateCommande: Date;
    public totalCheque: number;
    public totalEspece: number;
    public total: number;
    public totalePaye: number;
    public dateCommandeMax: string ;
    public dateCommandeMin: string ;
    public totalChequeMax: string ;
    public totalChequeMin: string ;
    public totalEspeceMax: string ;
    public totalEspeceMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public totalePayeMax: string ;
    public totalePayeMin: string ;
    public client: ClientDto ;
    public etatDemande: EtatDemandeDto ;
     public demandeItems: Array<DemandeItemDto>;

}
