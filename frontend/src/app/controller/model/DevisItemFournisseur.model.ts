import {DevisFournisseurDto} from './DevisFournisseur.model';
import {ProduitDto} from './Produit.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DevisItemFournisseurDto  extends BaseDto{

    public id: number;
    public prixUnitaire: number;
    public quantite: number;
    public remise: number;
    public prixUnitaireMax: string ;
    public prixUnitaireMin: string ;
    public quantiteMax: string ;
    public quantiteMin: string ;
    public remiseMax: string ;
    public remiseMin: string ;
    public produit: ProduitDto ;
    public devisFournisseur: DevisFournisseurDto ;

}
