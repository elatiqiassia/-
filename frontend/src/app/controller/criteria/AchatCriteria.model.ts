import {FournisseurCriteria} from './FournisseurCriteria.model';
import {AchatItemCriteria} from './AchatItemCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {EtatAchatCriteria} from './EtatAchatCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class AchatCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateAchat: Date;
    public dateAchatFrom: Date;
    public dateAchatTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaye: number;
     public totalPayeMin: number;
     public totalPayeMax: number;
    public description: string;
    public descriptionLike: string;
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;
  public etatAchat: EtatAchatCriteria ;
  public etatAchats: Array<EtatAchatCriteria> ;
      public achatItems: Array<AchatItemCriteria>;

}
