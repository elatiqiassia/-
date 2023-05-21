import {CommandeCriteria} from './CommandeCriteria.model';
import {ReceptionItemCriteria} from './ReceptionItemCriteria.model';
import {EtatReceptionCriteria} from './EtatReceptionCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ReceptionCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateReception: Date;
    public dateReceptionFrom: Date;
    public dateReceptionTo: Date;
    public description: string;
    public descriptionLike: string;
  public commande: CommandeCriteria ;
  public commandes: Array<CommandeCriteria> ;
  public etatReception: EtatReceptionCriteria ;
  public etatReceptions: Array<EtatReceptionCriteria> ;
      public receptionItems: Array<ReceptionItemCriteria>;

}
