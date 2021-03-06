package fr.alma.risk.datageneration;

import fr.alma.risk.datatypes.map.Continent;
import fr.alma.risk.datatypes.map.Territoire;
import fr.alma.risk.datatypes.mission.Mission;
import fr.alma.risk.datatypes.mission.MissionConqueteContinent;
import fr.alma.risk.datatypes.mission.MissionConqueteTerritoire;
import fr.alma.risk.datatypes.mission.MissionElimination;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataGeneration {

    /**
     * Cette méthode permet de générer tous les territoires,contients et missions de base.
     * @return un objet contenant l'ensemble des territoires, l'ensemble des continents et l'ensemble des missions.
     */
    public static GeneratedData generate(){

        /*__________________________________Déclaration des pays et des Continents__________________________________*/
        /*--------------------Asie--------------------*/
        Set<Territoire> territoireSetAsie = new HashSet<>();
        Territoire japon = new Territoire("Japon");
        Territoire chine = new Territoire("Chine");
        Territoire inde = new Territoire("Inde");
        Territoire afghanistan = new Territoire("Afghanistan");
        Territoire moyenorient = new Territoire("Moyen-Orient");
        Territoire kamchakta = new Territoire("Kamchakta");
        Territoire tchita = new Territoire("Tchita");
        Territoire sibérie = new Territoire("Siberie");
        Territoire yakoutie = new Territoire("Yakoutie");
        Territoire oural = new Territoire("Oural");
        Territoire siam = new Territoire("Siam");
        Territoire mongolie = new Territoire("Mongolie");

        territoireSetAsie.add(japon);
        territoireSetAsie.add(chine);
        territoireSetAsie.add(inde);
        territoireSetAsie.add(afghanistan);
        territoireSetAsie.add(moyenorient);
        territoireSetAsie.add(kamchakta);
        territoireSetAsie.add(tchita);
        territoireSetAsie.add(sibérie);
        territoireSetAsie.add(yakoutie);
        territoireSetAsie.add(oural);
        territoireSetAsie.add(siam);
        territoireSetAsie.add(mongolie);

        Continent asie = new Continent("Asie", 7, territoireSetAsie);

        /*--------------------Europe--------------------*/
        Set<Territoire> territoireSetEurope = new HashSet<>();
        Territoire islande = new Territoire("Islande");
        Territoire ukraine = new Territoire("Ukraine");
        Territoire europeoccidentale = new Territoire("Europe Occidentale");
        Territoire europedunord = new Territoire("Europe Du Nord");
        Territoire europedusud = new Territoire("Europe Du Sud");
        Territoire scandinavie = new Territoire("Scandinavie");
        Territoire grandebretagne = new Territoire("Grande Bretagne");

        territoireSetEurope.add(islande);
        territoireSetEurope.add(ukraine);
        territoireSetEurope.add(europeoccidentale);
        territoireSetEurope.add(europedunord);
        territoireSetEurope.add(europedusud);
        territoireSetEurope.add(scandinavie);
        territoireSetEurope.add(grandebretagne);

        Continent europe = new Continent("Europe",5,territoireSetEurope);

        /*--------------------Australie--------------------*/
        Set<Territoire> territoireSetAustralie = new HashSet<>();
        Territoire australieoccidentale = new Territoire("Australie Occidentale");
        Territoire australieorientale = new Territoire("Australie Orientale");
        Territoire indonésie = new Territoire("Indonésie");
        Territoire nouvelleguinee = new Territoire("Nouvelle Guinée");

        territoireSetAustralie.add(australieoccidentale);
        territoireSetAustralie.add(australieorientale);
        territoireSetAustralie.add(indonésie);
        territoireSetAustralie.add(nouvelleguinee);

        Continent australie = new Continent("Australie",2, territoireSetAustralie);

        /*--------------------Afrique--------------------*/
        Set<Territoire> territoireSetAfrique = new HashSet<>();
        Territoire egypte = new Territoire("Egypte");
        Territoire afriquedunord = new Territoire("Afrique Du Nord");
        Territoire afriqueoccidentale = new Territoire("Afrique Occidentale");
        Territoire congo = new Territoire("Congo");
        Territoire afriquedusud = new Territoire("Afrique Du Sud");
        Territoire madagascar = new Territoire("Madagascar");

        territoireSetAfrique.add(egypte);
        territoireSetAfrique.add(afriquedunord);
        territoireSetAfrique.add(afriqueoccidentale);
        territoireSetAfrique.add(congo);
        territoireSetAfrique.add(afriquedusud);
        territoireSetAfrique.add(madagascar);

        Continent afrique = new Continent("Afrique",3,territoireSetAfrique);

        /*--------------------Amerique Du Nord--------------------*/
        Set<Territoire> territoireSetAmeriqueDuNord = new HashSet<>();
        Territoire alaska = new Territoire("Alaska");
        Territoire territoiredunordouest = new Territoire("Territoire Du Nord Ouest");
        Territoire groenland = new Territoire("Groenland");
        Territoire alberta = new Territoire("Alberta");
        Territoire ontario = new Territoire("Ontario");
        Territoire quebec = new Territoire("Quebec");
        Territoire etatdelouest = new Territoire("Etat de LOuest");
        Territoire etatdelest = new Territoire("Etat De LEst");
        Territoire ameriquecentrale = new Territoire("Amerique Centrale");

        territoireSetAmeriqueDuNord.add(alaska);
        territoireSetAmeriqueDuNord.add(territoiredunordouest);
        territoireSetAmeriqueDuNord.add(groenland);
        territoireSetAmeriqueDuNord.add(alberta);
        territoireSetAmeriqueDuNord.add(ontario);
        territoireSetAmeriqueDuNord.add(quebec);
        territoireSetAmeriqueDuNord.add(etatdelouest);
        territoireSetAmeriqueDuNord.add(etatdelest);
        territoireSetAmeriqueDuNord.add(ameriquecentrale);

        Continent ameriqueDuNord = new Continent("Amerique Du Nord",5,territoireSetAmeriqueDuNord);

        /*--------------------Amerique Du Sud--------------------*/
        Set<Territoire> territoireSetAmeriqueDuSud = new HashSet<>();
        Territoire argentine = new Territoire("Argentine");
        Territoire bresil = new Territoire("Brésil");
        Territoire perou = new Territoire("Perou");
        Territoire venezuela = new Territoire("Venezuela");

        territoireSetAmeriqueDuSud.add(argentine);
        territoireSetAmeriqueDuSud.add(bresil);
        territoireSetAmeriqueDuSud.add(perou);
        territoireSetAmeriqueDuSud.add(venezuela);

        Continent ameriqueDuSud = new Continent("Amerique Du Sud",2,territoireSetAmeriqueDuSud);

        /*__________________________________Déclaration des voisins des pays__________________________________*/
        /*--------------------Asie--------------------*/
        japon.ajoutVoisin(kamchakta);
        japon.ajoutVoisin(mongolie);
        kamchakta.ajoutVoisin(alaska);
        kamchakta.ajoutVoisin(yakoutie);
        kamchakta.ajoutVoisin(tchita);
        kamchakta.ajoutVoisin(mongolie);
        yakoutie.ajoutVoisin(kamchakta);
        yakoutie.ajoutVoisin(tchita);
        yakoutie.ajoutVoisin(sibérie);
        tchita.ajoutVoisin(mongolie);
        tchita.ajoutVoisin(sibérie);
        sibérie.ajoutVoisin(oural);
        sibérie.ajoutVoisin(chine);
        mongolie.ajoutVoisin(chine);
        chine.ajoutVoisin(siam);
        chine.ajoutVoisin(afghanistan);
        chine.ajoutVoisin(inde);
        oural.ajoutVoisin(ukraine);
        oural.ajoutVoisin(afghanistan);
        afghanistan.ajoutVoisin(ukraine);
        afghanistan.ajoutVoisin(inde);
        afghanistan.ajoutVoisin(moyenorient);
        siam.ajoutVoisin(inde);
        siam.ajoutVoisin(indonésie);
        inde.ajoutVoisin(moyenorient);
        moyenorient.ajoutVoisin(egypte);
        moyenorient.ajoutVoisin(ukraine);
        moyenorient.ajoutVoisin(europedusud);

        /*--------------------Europe--------------------*/
        islande.ajoutVoisin(groenland);
        islande.ajoutVoisin(grandebretagne);
        islande.ajoutVoisin(scandinavie);
        scandinavie.ajoutVoisin(ukraine);
        scandinavie.ajoutVoisin(europedunord);
        scandinavie.ajoutVoisin(grandebretagne);
        ukraine.ajoutVoisin(europedusud);
        ukraine.ajoutVoisin(europedunord);
        europedunord.ajoutVoisin(grandebretagne);
        europedunord.ajoutVoisin(europeoccidentale);
        europedunord.ajoutVoisin(europedusud);
        europeoccidentale.ajoutVoisin(grandebretagne);
        europeoccidentale.ajoutVoisin(afriquedunord);
        europeoccidentale.ajoutVoisin(europedusud);
        europedusud.ajoutVoisin(egypte);
        europedusud.ajoutVoisin(afriquedunord);

        /*--------------------Australie--------------------*/
        indonésie.ajoutVoisin(nouvelleguinee);
        indonésie.ajoutVoisin(australieoccidentale);
        nouvelleguinee.ajoutVoisin(australieoccidentale);
        nouvelleguinee.ajoutVoisin(australieorientale);
        australieoccidentale.ajoutVoisin(australieorientale);

        /*--------------------Afrique--------------------*/
        egypte.ajoutVoisin(afriqueoccidentale);
        egypte.ajoutVoisin(afriquedunord);
        afriqueoccidentale.ajoutVoisin(moyenorient);
        afriqueoccidentale.ajoutVoisin(congo);
        afriqueoccidentale.ajoutVoisin(afriquedusud);
        afriqueoccidentale.ajoutVoisin(madagascar);
        afriquedusud.ajoutVoisin(madagascar);
        afriquedusud.ajoutVoisin(congo);
        congo.ajoutVoisin(afriquedunord);
        afriquedunord.ajoutVoisin(bresil);

        /*--------------------Amerique Du Nord--------------------*/
        alaska.ajoutVoisin(territoiredunordouest);
        alaska.ajoutVoisin(alberta);
        territoiredunordouest.ajoutVoisin(alberta);
        territoiredunordouest.ajoutVoisin(groenland);
        territoiredunordouest.ajoutVoisin(ontario);
        groenland.ajoutVoisin(islande);
        groenland.ajoutVoisin(quebec);
        groenland.ajoutVoisin(ontario);
        alberta.ajoutVoisin(ontario);
        alberta.ajoutVoisin(etatdelouest);
        quebec.ajoutVoisin(ontario);
        quebec.ajoutVoisin(etatdelest);
        etatdelest.ajoutVoisin(ontario);
        etatdelest.ajoutVoisin(etatdelouest);
        etatdelest.ajoutVoisin(ameriquecentrale);
        etatdelouest.ajoutVoisin(ameriquecentrale);
        ameriquecentrale.ajoutVoisin(venezuela);

        /*--------------------Amerique Du Sud--------------------*/
        venezuela.ajoutVoisin(bresil);
        venezuela.ajoutVoisin(perou);
        bresil.ajoutVoisin(perou);
        bresil.ajoutVoisin(argentine);
        perou.ajoutVoisin(argentine);
        bresil.ajoutVoisin(afriquedunord);

        /*__________________________________Déclaration des trois sets a retourner__________________________________*/
        /*--------------------Ensemble des Continents--------------------*/
        Set<Continent> continents = getContinents(asie, europe, australie, afrique, ameriqueDuNord, ameriqueDuSud);

        /*--------------------Ensemble des Territoires--------------------*/
        Set<Territoire> territoires = getTerritoires(territoireSetAsie, territoireSetEurope, territoireSetAustralie, territoireSetAfrique, territoireSetAmeriqueDuNord, territoireSetAmeriqueDuSud);

        /*--------------------Ensemble des Missions--------------------*/
        Set<Mission> missions = generateMission(continents);


        /*--------------------Retour des Generated Data--------------------*/
        return new GeneratedData(continents,territoires,missions);

    }

    /**
     * Cette méthode permet d'obtenir l'ensemble des continents
     * @param asie continent asie
     * @param europe continent europe
     * @param australie continent australie
     * @param afrique continent afrique
     * @param ameriqueDuNord continent amerique du nord
     * @param ameriqueDuSud continent amerique du sud
     * @return un ensemble de tous ces continents.
     */
    private static Set<Continent> getContinents(Continent asie, Continent europe, Continent australie, Continent afrique, Continent ameriqueDuNord, Continent ameriqueDuSud) {
        Set<Continent> continents = new HashSet<>();
        continents.add(asie);
        continents.add(europe);
        continents.add(australie);
        continents.add(afrique);
        continents.add(ameriqueDuNord);
        continents.add(ameriqueDuSud);
        return continents;
    }

    /**
     * Cette methode permet d'obtenir un ensemble de tous les territoires;
     * @param territoireSetAsie territoires d'asie
     * @param territoireSetEurope territoires d'europe
     * @param territoireSetAustralie territoires d'australie
     * @param territoireSetAfrique territoires d'afrique
     * @param territoireSetAmeriqueDuNord territoires d'amerique du nord
     * @param territoireSetAmeriqueDuSud territoires d'amerique du sud
     * @return un ensemble de tous ces territoires
     */
    private static Set<Territoire> getTerritoires(Set<Territoire> territoireSetAsie, Set<Territoire> territoireSetEurope, Set<Territoire> territoireSetAustralie, Set<Territoire> territoireSetAfrique, Set<Territoire> territoireSetAmeriqueDuNord, Set<Territoire> territoireSetAmeriqueDuSud) {
        Set<Territoire> territoires = new HashSet<>();
        territoires.addAll(territoireSetAsie);
        territoires.addAll(territoireSetEurope);
        territoires.addAll(territoireSetAustralie);
        territoires.addAll(territoireSetAfrique);
        territoires.addAll(territoireSetAmeriqueDuNord);
        territoires.addAll(territoireSetAmeriqueDuSud);
        return territoires;
    }

    /**
     * Cette méthode permet de generer toutes les missions.
     * @param continentSet ensemble des continents
     * @return l'ensemble des missions générées.
     */
    private static Set<Mission> generateMission(Set<Continent> continentSet){
        Set<Mission> missions = new HashSet<>();
        /*--------------------Récupération des continents--------------------*/
        List<Continent> continentList = new ArrayList<>();
        continentList.addAll(continentSet);



        /*--------------------Mission Elimination--------------------*/
        missions.add(new MissionElimination(Color.BLACK));
        missions.add(new MissionElimination(Color.BLUE));
        missions.add(new MissionElimination(Color.RED));
        missions.add(new MissionElimination(Color.GREEN));
        missions.add(new MissionElimination(Color.PINK));
        missions.add(new MissionElimination(Color.YELLOW));

        /*--------------------Mission Conquete Continent--------------------*/
        for(int i=0;i<continentList.size();i++){
            for(int j=i;j<continentList.size();j++){
                if(j!=i){
                    missions.add(new MissionConqueteContinent(continentList.get(i),continentList.get(j)));
                }
            }
        }

        /*--------------------Mission Conquete Territoire--------------------*/
        missions.add(new MissionConqueteTerritoire(24));

        return missions;
    }
}
