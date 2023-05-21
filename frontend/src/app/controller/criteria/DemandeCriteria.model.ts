import {EtatDemandeCriteria} from './EtatDemandeCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {DemandeItemCriteria} from './DemandeItemCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DemandeCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateCommande: Date;
    public dateCommandeFrom: Date;
    public dateCommandeTo: Date;
     public totalCheque: number;
     public totalChequeMin: number;
     public totalChequeMax: number;
     public totalEspece: number;
     public totalEspeceMin: number;
     public totalEspeceMax: number;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalePaye: number;
     public totalePayeMin: number;
     public totalePayeMax: number;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public etatDemande: EtatDemandeCriteria ;
  public etatDemandes: Array<EtatDemandeCriteria> ;
      public demandeItems: Array<DemandeItemCriteria>;

}
