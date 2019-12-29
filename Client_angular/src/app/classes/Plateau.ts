import { Territoire } from './Territoire';

export class Plateau {

  carte: Set<Territoire>;

  constructor(initPlateau:Set<Territoire>) {
    this.carte=initPlateau;
  }

  mettreAJour(nouvPlateau: Set<Territoire>):void {
    //Replace the elements in the carte attribute
    this.carte.forEach(function(carteValue){
      nouvPlateau.forEach(function(nouvValue){
        if (carteValue.nom=nouvValue.nom) {
          this.carte.remove(carteValue);
          this.carte.add(nouvValue);
        }
      })
    })
  }
}
