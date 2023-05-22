import {DevisItemFournisseurDto} from './DevisItemFournisseur.model';
import {FournisseurDto} from './Fournisseur.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DevisFournisseurDto  extends BaseDto{

    public id: number;
    public reference: string;
   public dateDevis: Date;
    public total: number;
    public description: string;
    public dateDevisMax: string ;
    public dateDevisMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public fournisseur: FournisseurDto ;
     public devisItemFournisseurs: Array<DevisItemFournisseurDto>;

}
