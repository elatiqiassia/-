import {SocieteDto} from './Societe.model';
import {ComptableValidateurDto} from './ComptableValidateur.model';
import {ComptableTraitantDto} from './ComptableTraitant.model';
import {TauxIsDto} from './TauxIs.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DeclarationIsDto  extends BaseDto{

    public id: number;
    public reference: string;
   public dateDeclaration: Date;
   public trimistre: number;
   public annee: number;
    public totalCharge: number;
    public totalProduit: number;
    public resultatAvantImpot: number;
    public montantImpot: number;
    public resultatApresImpot: number;
    public dateDeclarationMax: string ;
    public dateDeclarationMin: string ;
    public trimistreMax: string ;
    public trimistreMin: string ;
    public anneeMax: string ;
    public anneeMin: string ;
    public totalChargeMax: string ;
    public totalChargeMin: string ;
    public totalProduitMax: string ;
    public totalProduitMin: string ;
    public resultatAvantImpotMax: string ;
    public resultatAvantImpotMin: string ;
    public montantImpotMax: string ;
    public montantImpotMin: string ;
    public resultatApresImpotMax: string ;
    public resultatApresImpotMin: string ;
    public societe: SocieteDto ;
    public tauxIs: TauxIsDto ;
    public comptableTraitant: ComptableTraitantDto ;
    public comptableValidateur: ComptableValidateurDto ;

}
