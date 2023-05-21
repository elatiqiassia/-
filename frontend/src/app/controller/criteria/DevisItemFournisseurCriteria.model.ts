import {DevisFournisseurCriteria} from './DevisFournisseurCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DevisItemFournisseurCriteria  extends   BaseCriteria  {

    public id: number;
     public prixUnitaire: number;
     public prixUnitaireMin: number;
     public prixUnitaireMax: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
     public remise: number;
     public remiseMin: number;
     public remiseMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public devisFournisseur: DevisFournisseurCriteria ;
  public devisFournisseurs: Array<DevisFournisseurCriteria> ;

}
