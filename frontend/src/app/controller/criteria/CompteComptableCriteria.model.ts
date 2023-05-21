import {SousClassComptableCriteria} from './SousClassComptableCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class CompteComptableCriteria  extends   BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;
  public sousClassComptable: SousClassComptableCriteria ;
  public sousClassComptables: Array<SousClassComptableCriteria> ;

}
