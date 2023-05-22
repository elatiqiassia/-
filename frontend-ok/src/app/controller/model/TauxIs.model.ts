import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class TauxIsDto  extends BaseDto{

    public id: number;
    public resultatMin: number;
    public resultatMax: number;
   public dateApplicationMin: Date;
   public dateApplicationMax: Date;
    public pourcentage: number;
    public resultatMinMax: string ;
    public resultatMinMin: string ;
    public resultatMaxMax: string ;
    public resultatMaxMin: string ;
    public dateApplicationMinMax: string ;
    public dateApplicationMinMin: string ;
    public dateApplicationMaxMax: string ;
    public dateApplicationMaxMin: string ;
    public pourcentageMax: string ;
    public pourcentageMin: string ;

}
