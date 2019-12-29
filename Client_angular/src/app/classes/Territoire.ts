export class Territoire {
  nom: string;
  possesseur: string;
  nbUnites: number;

  constructor(nom:string) {
    this.nom=nom;
    this.possesseur=null;
    this.nbUnites=0;
  }

  setNbUnite(nb:number):void {
    this.nbUnites=nb;
  }

  setPossesseur(nouv:string) {
    this.possesseur=nouv;
  }
}
