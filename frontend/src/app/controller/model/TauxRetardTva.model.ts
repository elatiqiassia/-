import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class TauxRetardTvaDto  extends BaseDto{

    public id: number;
   public dateApplicationMin: Date;
   public dateApplicationMax: Date;
    public montant: number;
    public dateApplicationMinMax: string ;
    public dateApplicationMinMin: string ;
    public dateApplicationMaxMax: string ;
    public dateApplicationMaxMin: string ;
    public montantMax: string ;
    public montantMin: string ;

}
