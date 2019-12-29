import { Territoire } from './Territoire';

export class Joueur {

        private nom: string;
        private couleur: string;
        private mission: string;
        private tourEnCours: boolean;
        private renfortsAPlacer: number;
        private territoiresPossedes: Set<Territoire>;

        public constructor(nom: string, couleur:string, mission: string, unitesDeBase: number, territoiresDeBase: Set<Territoire>) {
                this.nom=nom;
                this.couleur=couleur;
                this.mission=mission;
                this.tourEnCours=false;
                this.renfortsAPlacer=unitesDeBase;
                this.territoiresPossedes=territoiresDeBase;
        }

        public getNom(): string {
                return this.nom;
        }

        public getRenforts(): number {
                return this.renfortsAPlacer;
        }

        public ajoutTerritoire(terr: Territoire):void {
                this.territoiresPossedes.add(terr);
                terr.setPossesseur(this.nom);
        }

        public enleveTerritoire(terr:Territoire):void {
                this.territoiresPossedes.delete(terr);
        }

        public debuterTour():void {
                this.tourEnCours=true;
        }

        public finirTour():void {
                this.tourEnCours=false;
        }

        public donnerRenforts(renforts: number) {
                this.renfortsAPlacer+=renforts;
        }

}