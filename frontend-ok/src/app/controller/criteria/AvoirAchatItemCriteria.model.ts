import {AvoirAchatCriteria} from './AvoirAchatCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class AvoirAchatItemCriteria  extends   BaseCriteria  {

    public id: number;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public avoirAchat: AvoirAchatCriteria ;
  public avoirAchats: Array<AvoirAchatCriteria> ;

}
