import {SocieteDto} from './Societe.model';
import {ComptableValidateurDto} from './ComptableValidateur.model';
import {ComptableTraitantDto} from './ComptableTraitant.model';
import {TauxRetardTvaDto} from './TauxRetardTva.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DeclarationTvaDto  extends BaseDto{

    public id: number;
    public reference: string;
   public dateDeclaration: Date;
   public trimistre: number;
   public annee: number;
    public totalTvaCollecte: number;
    public totalTvaDue: number;
    public differenceTva: number;
    public montantTva: number;
    public dateDeclarationMax: string ;
    public dateDeclarationMin: string ;
    public trimistreMax: string ;
    public trimistreMin: string ;
    public anneeMax: string ;
    public anneeMin: string ;
    public totalTvaCollecteMax: string ;
    public totalTvaCollecteMin: string ;
    public totalTvaDueMax: string ;
    public totalTvaDueMin: string ;
    public differenceTvaMax: string ;
    public differenceTvaMin: string ;
    public montantTvaMax: string ;
    public montantTvaMin: string ;
    public societe: SocieteDto ;
    public tauxRetardTva: TauxRetardTvaDto ;
    public comptableTraitant: ComptableTraitantDto ;
    public comptableValidateur: ComptableValidateurDto ;

}
