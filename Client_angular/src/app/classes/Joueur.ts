import { Territoire } from './Territoire';

export class Joueur {

        nom: string;
        couleur: string;
        mission: string;
        tourEnCours: boolean;
        renfortsAPlacer: number;
        territoiresPossedes: Set<Territoire>;

        constructor(nom: string, couleur:string, mission: string, unitesDeBase: number, territoiresDeBase: Set<Territoire>) {
                this.nom=nom;
                this.couleur=couleur;
                this.mission=mission;
                this.tourEnCours=false;
                this.renfortsAPlacer=unitesDeBase;
                this.territoiresPossedes=territoiresDeBase;
        }

        ajoutTerritoire(terr: Territoire):void {
                this.territoiresPossedes.add(terr);
                terr.setPossesseur(this.nom);
        }

        enleveTerritoire(terr:Territoire):void {
                this.territoiresPossedes.delete(terr);
        }

        debuterTour():void {
                this.tourEnCours=true;
        }

        finirTour():void {
                this.tourEnCours=false;
        }

        donnerRenforts(renforts: number) {
                this.renfortsAPlacer+=renforts;
        }

}