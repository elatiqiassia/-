import {VenteItemDto} from './VenteItem.model';
import {StoreDto} from './Store.model';
import {EtatVenteDto} from './EtatVente.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class VenteDto  extends BaseDto{

    public id: number;
    public reference: string;
   public dateVente: Date;
    public total: number;
    public totalPaye: number;
    public description: string;
    public dateVenteMax: string ;
    public dateVenteMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public totalPayeMax: string ;
    public totalPayeMin: string ;
    public store: StoreDto ;
    public client: ClientDto ;
    public etatVente: EtatVenteDto ;
     public venteItems: Array<VenteItemDto>;

}
