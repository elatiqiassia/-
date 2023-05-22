import {SocieteCriteria} from './SocieteCriteria.model';
import {CompteComptableCriteria} from './CompteComptableCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class OperationComptableCriteria  extends   BaseCriteria  {

    public id: number;
    public dateOperationComptable: Date;
    public dateOperationComptableFrom: Date;
    public dateOperationComptableTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public societe: SocieteCriteria ;
  public societes: Array<SocieteCriteria> ;
  public compteComptable: CompteComptableCriteria ;
  public compteComptables: Array<CompteComptableCriteria> ;

}
