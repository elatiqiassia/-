import {StoreCriteria} from './StoreCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class MagasinCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public adresse: string;
    public adresseLike: string;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;

}
