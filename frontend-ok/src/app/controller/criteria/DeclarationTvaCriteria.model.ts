import {SocieteCriteria} from './SocieteCriteria.model';
import {ComptableValidateurCriteria} from './ComptableValidateurCriteria.model';
import {ComptableTraitantCriteria} from './ComptableTraitantCriteria.model';
import {TauxRetardTvaCriteria} from './TauxRetardTvaCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DeclarationTvaCriteria  extends   BaseCriteria  {

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
     public totalTvaCollecte: number;
     public totalTvaCollecteMin: number;
     public totalTvaCollecteMax: number;
     public totalTvaDue: number;
     public totalTvaDueMin: number;
     public totalTvaDueMax: number;
     public differenceTva: number;
     public differenceTvaMin: number;
     public differenceTvaMax: number;
     public montantTva: number;
     public montantTvaMin: number;
     public montantTvaMax: number;
  public societe: SocieteCriteria ;
  public societes: Array<SocieteCriteria> ;
  public tauxRetardTva: TauxRetardTvaCriteria ;
  public tauxRetardTvas: Array<TauxRetardTvaCriteria> ;
  public comptableTraitant: ComptableTraitantCriteria ;
  public comptableTraitants: Array<ComptableTraitantCriteria> ;
  public comptableValidateur: ComptableValidateurCriteria ;
  public comptableValidateurs: Array<ComptableValidateurCriteria> ;

}
