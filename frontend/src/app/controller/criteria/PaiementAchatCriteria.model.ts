import {EtatPaiementAchatCriteria} from './EtatPaiementAchatCriteria.model';
import {AchatCriteria} from './AchatCriteria.model';
import {ModePaiementCriteria} from './ModePaiementCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PaiementAchatCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public datePaiement: Date;
    public datePaiementFrom: Date;
    public datePaiementTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
    public description: string;
    public descriptionLike: string;
  public achat: AchatCriteria ;
  public achats: Array<AchatCriteria> ;
  public modePaiement: ModePaiementCriteria ;
  public modePaiements: Array<ModePaiementCriteria> ;
  public etatPaiementAchat: EtatPaiementAchatCriteria ;
  public etatPaiementAchats: Array<EtatPaiementAchatCriteria> ;

}
