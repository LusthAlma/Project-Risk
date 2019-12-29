export class Territoire {
  private nom: string;
  private possesseur: string;
  private nbUnites: number;

  public constructor(nom:string) {
    this.nom=nom;
    this.possesseur=null;
    this.nbUnites=0;
  }

  public getNom(): string {
    return this.nom;
  }

  public getPossesseur(): string {
    return this.possesseur;
  }

  public getNbUnites(): number {
    return this.nbUnites;
  }

  public setNbUnites(nb:number):void {
    this.nbUnites=nb;
  }

  public setPossesseur(nouv:string) {
    this.possesseur=nouv;
  }
}
