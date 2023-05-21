import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class TauxIsCriteria  extends   BaseCriteria  {

    public id: number;
     public resultatMin: number;
     public resultatMinMin: number;
     public resultatMinMax: number;
     public resultatMax: number;
     public resultatMaxMin: number;
     public resultatMaxMax: number;
    public dateApplicationMin: Date;
    public dateApplicationMinFrom: Date;
    public dateApplicationMinTo: Date;
    public dateApplicationMax: Date;
    public dateApplicationMaxFrom: Date;
    public dateApplicationMaxTo: Date;
     public pourcentage: number;
     public pourcentageMin: number;
     public pourcentageMax: number;

}
