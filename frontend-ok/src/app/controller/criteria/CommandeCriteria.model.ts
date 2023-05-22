import {EtatCommandeCriteria} from './EtatCommandeCriteria.model';
import {CommandeItemCriteria} from './CommandeItemCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class CommandeCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateCommande: Date;
    public dateCommandeFrom: Date;
    public dateCommandeTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalePaye: number;
     public totalePayeMin: number;
     public totalePayeMax: number;
     public totalPayeCheque: number;
     public totalPayeChequeMin: number;
     public totalPayeChequeMax: number;
     public totalPayeEspece: number;
     public totalPayeEspeceMin: number;
     public totalPayeEspeceMax: number;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public etatCommande: EtatCommandeCriteria ;
  public etatCommandes: Array<EtatCommandeCriteria> ;
      public commandeItems: Array<CommandeItemCriteria>;

}
