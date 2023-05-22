import {SocieteCriteria} from './SocieteCriteria.model';
import {ComptableValidateurCriteria} from './ComptableValidateurCriteria.model';
import {ComptableTraitantCriteria} from './ComptableTraitantCriteria.model';
import {TauxIsCriteria} from './TauxIsCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DeclarationIsCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateDeclaration: Date;
    public dateDeclarationFrom: Date;
    public dateDeclarationTo: Date;
     public trimistre: number;
     public trimistreMin: number;
     public trimistreMax: number;
     public annee: number;
     public anneeMin: number;
     public anneeMax: number;
     public totalCharge: number;
     public totalChargeMin: number;
     public totalChargeMax: number;
     public totalProduit: number;
     public totalProduitMin: number;
     public totalProduitMax: number;
     public resultatAvantImpot: number;
     public resultatAvantImpotMin: number;
     public resultatAvantImpotMax: number;
     public montantImpot: number;
     public montantImpotMin: number;
     public montantImpotMax: number;
     public resultatApresImpot: number;
     public resultatApresImpotMin: number;
     public resultatApresImpotMax: number;
  public societe: SocieteCriteria ;
  public societes: Array<SocieteCriteria> ;
  public tauxIs: TauxIsCriteria ;
  public tauxIss: Array<TauxIsCriteria> ;
  public comptableTraitant: ComptableTraitantCriteria ;
  public comptableTraitants: Array<ComptableTraitantCriteria> ;
  public comptableValidateur: ComptableValidateurCriteria ;
  public comptableValidateurs: Array<ComptableValidateurCriteria> ;

}
