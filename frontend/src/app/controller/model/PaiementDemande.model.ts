import {DemandeDto} from './Demande.model';
import {ModePaiementDto} from './ModePaiement.model';
import {EtatPaiementDemandeDto} from './EtatPaiementDemande.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaiementDemandeDto  extends BaseDto{

    public id: number;
    public reference: string;
   public datePaiement: Date;
    public montant: number;
    public description: string;
   public chequeVire: null | boolean;
    public datePaiementMax: string ;
    public datePaiementMin: string ;
    public montantMax: string ;
    public montantMin: string ;
    public demande: DemandeDto ;
    public modePaiement: ModePaiementDto ;
    public etatPaiementDemande: EtatPaiementDemandeDto ;

}
