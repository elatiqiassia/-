import {DevisItemFournisseurCriteria} from './DevisItemFournisseurCriteria.model';
import {FournisseurCriteria} from './FournisseurCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DevisFournisseurCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateDevis: Date;
    public dateDevisFrom: Date;
    public dateDevisTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
    public description: string;
    public descriptionLike: string;
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;
      public devisItemFournisseurs: Array<DevisItemFournisseurCriteria>;

}
