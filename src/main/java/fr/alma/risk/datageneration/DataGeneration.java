package fr.alma.risk.datageneration;

import fr.alma.risk.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataGeneration {

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
        Territoire etatdelouest = new Territoire("Etat de L'Ouest");
        Territoire etatdelest = new Territoire("Etat De L'Est");
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
        japon.sontVoinsins(kamchakta);
        japon.sontVoinsins(mongolie);
        kamchakta.sontVoinsins(alaska);
        kamchakta.sontVoinsins(yakoutie);
        kamchakta.sontVoinsins(tchita);
        kamchakta.sontVoinsins(mongolie);
        yakoutie.sontVoinsins(kamchakta);
        yakoutie.sontVoinsins(tchita);
        yakoutie.sontVoinsins(sibérie);
        tchita.sontVoinsins(mongolie);
        tchita.sontVoinsins(sibérie);
        sibérie.sontVoinsins(oural);
        sibérie.sontVoinsins(chine);
        mongolie.sontVoinsins(chine);
        chine.sontVoinsins(siam);
        chine.sontVoinsins(afghanistan);
        chine.sontVoinsins(inde);
        oural.sontVoinsins(ukraine);
        oural.sontVoinsins(afghanistan);
        afghanistan.sontVoinsins(ukraine);
        afghanistan.sontVoinsins(inde);
        afghanistan.sontVoinsins(moyenorient);
        siam.sontVoinsins(inde);
        siam.sontVoinsins(indonésie);
        inde.sontVoinsins(moyenorient);
        moyenorient.sontVoinsins(egypte);
        moyenorient.sontVoinsins(ukraine);
        moyenorient.sontVoinsins(europedusud);

        /*--------------------Europe--------------------*/
        islande.sontVoinsins(groenland);
        islande.sontVoinsins(grandebretagne);
        islande.sontVoinsins(scandinavie);
        scandinavie.sontVoinsins(ukraine);
        scandinavie.sontVoinsins(europedunord);
        scandinavie.sontVoinsins(grandebretagne);
        ukraine.sontVoinsins(europedusud);
        ukraine.sontVoinsins(europedunord);
        europedunord.sontVoinsins(grandebretagne);
        europedunord.sontVoinsins(europeoccidentale);
        europedunord.sontVoinsins(europedusud);
        europeoccidentale.sontVoinsins(grandebretagne);
        europeoccidentale.sontVoinsins(afriquedunord);
        europeoccidentale.sontVoinsins(europedusud);
        europedusud.sontVoinsins(egypte);
        europedusud.sontVoinsins(afriquedunord);

        /*--------------------Australie--------------------*/
        indonésie.sontVoinsins(nouvelleguinee);
        indonésie.sontVoinsins(australieoccidentale);
        nouvelleguinee.sontVoinsins(australieoccidentale);
        nouvelleguinee.sontVoinsins(australieorientale);
        australieoccidentale.sontVoinsins(australieorientale);

        /*--------------------Afrique--------------------*/
        egypte.sontVoinsins(afriqueoccidentale);
        egypte.sontVoinsins(afriquedunord);
        afriqueoccidentale.sontVoinsins(moyenorient);
        afriqueoccidentale.sontVoinsins(congo);
        afriqueoccidentale.sontVoinsins(afriquedusud);
        afriqueoccidentale.sontVoinsins(madagascar);
        afriquedusud.sontVoinsins(madagascar);
        afriquedusud.sontVoinsins(congo);
        congo.sontVoinsins(afriquedunord);
        afriquedunord.sontVoinsins(bresil);

        /*--------------------Amerique Du Nord--------------------*/
        alaska.sontVoinsins(territoiredunordouest);
        alaska.sontVoinsins(alberta);
        territoiredunordouest.sontVoinsins(alberta);
        territoiredunordouest.sontVoinsins(groenland);
        territoiredunordouest.sontVoinsins(ontario);
        groenland.sontVoinsins(islande);
        groenland.sontVoinsins(quebec);
        groenland.sontVoinsins(ontario);
        alberta.sontVoinsins(ontario);
        alberta.sontVoinsins(etatdelouest);
        quebec.sontVoinsins(ontario);
        quebec.sontVoinsins(etatdelest);
        etatdelest.sontVoinsins(ontario);
        etatdelest.sontVoinsins(etatdelouest);
        etatdelest.sontVoinsins(ameriquecentrale);
        etatdelouest.sontVoinsins(ameriquecentrale);
        ameriquecentrale.sontVoinsins(venezuela);

        /*--------------------Amerique Du Sud--------------------*/
        venezuela.sontVoinsins(bresil);
        venezuela.sontVoinsins(perou);
        bresil.sontVoinsins(perou);
        bresil.sontVoinsins(argentine);
        perou.sontVoinsins(argentine);
        bresil.sontVoinsins(afriquedunord);

        /*__________________________________Déclaration des trois sets a retourner__________________________________*/
        /*--------------------Ensemble des Continents--------------------*/
        Set<Continent> continents = new HashSet<>();
        continents.add(asie);
        continents.add(europe);
        continents.add(australie);
        continents.add(afrique);
        continents.add(ameriqueDuNord);
        continents.add(ameriqueDuSud);

        /*--------------------Ensemble des Territoires--------------------*/
        Set<Territoire> territoires = new HashSet<>();
        territoires.addAll(territoireSetAsie);
        territoires.addAll(territoireSetEurope);
        territoires.addAll(territoireSetAustralie);
        territoires.addAll(territoireSetAfrique);
        territoires.addAll(territoireSetAmeriqueDuNord);
        territoires.addAll(territoireSetAmeriqueDuSud);

        /*--------------------Ensemble des Missions--------------------*/
        Set<Mission> missions = generateMission(continents);


        /*--------------------Retour des Generated Data--------------------*/
        return new GeneratedData(continents,territoires,missions);

    }

    public static Set<Mission> generateMission(Set<Continent> continentSet){
        Set<Mission> missions = new HashSet<>();



        /*--------------------Récupération des continents--------------------*/
        List<Continent> continentList = new ArrayList<>();
        continentList.addAll(continentSet);

        for(int i=0;i<continentList.size();i++){
            for(int j=i;j<continentList.size();j++){
                if(j!=i){
                    missions.add(new MissionConqueteContinent(continentList.get(i),continentList.get(j)));
                }
            }
        }

        /*--------------------Mission Elimination--------------------*/
        missions.add(new MissionElimination("Noir"));
        missions.add(new MissionElimination("Bleu"));
        missions.add(new MissionElimination("Rouge"));
        missions.add(new MissionElimination("Vert"));
        missions.add(new MissionElimination("Rose"));
        missions.add(new MissionElimination("Jaune"));

        /*--------------------Mission Conquete Continent--------------------*/


        /*--------------------Mission Conquete Territoire--------------------*/
        missions.add(new MissionConqueteTerritoire(24));

        return missions;
    }
}
