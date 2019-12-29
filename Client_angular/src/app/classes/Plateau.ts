import { Territoire } from './Territoire';

export class Plateau {

  private carte: Set<Territoire>;

  public constructor(initPlateau:Set<Territoire>) {
    this.carte=initPlateau;
  }

  public mettreAJour(nouvPlateau: Set<Territoire>):void {
    //Replace the elements in the carte attribute
    this.carte.forEach(function(carteValue){
      nouvPlateau.forEach(function(nouvValue){
        if (carteValue.getNom()===nouvValue.getNom()) {
          this.carte.remove(carteValue);
          this.carte.add(nouvValue);
        }
      })
    })
  }
}
