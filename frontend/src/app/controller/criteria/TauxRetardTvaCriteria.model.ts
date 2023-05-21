import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class TauxRetardTvaCriteria  extends   BaseCriteria  {

    public id: number;
    public dateApplicationMin: Date;
    public dateApplicationMinFrom: Date;
    public dateApplicationMinTo: Date;
    public dateApplicationMax: Date;
    public dateApplicationMaxFrom: Date;
    public dateApplicationMaxTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;

}
