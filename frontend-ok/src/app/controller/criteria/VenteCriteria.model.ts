import {VenteItemCriteria} from './VenteItemCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {EtatVenteCriteria} from './EtatVenteCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class VenteCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateVente: Date;
    public dateVenteFrom: Date;
    public dateVenteTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaye: number;
     public totalPayeMin: number;
     public totalPayeMax: number;
    public description: string;
    public descriptionLike: string;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public etatVente: EtatVenteCriteria ;
  public etatVentes: Array<EtatVenteCriteria> ;
      public venteItems: Array<VenteItemCriteria>;

}
