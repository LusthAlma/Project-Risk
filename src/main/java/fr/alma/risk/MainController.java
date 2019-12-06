package fr.alma.risk;

import fr.alma.risk.accessingdatamysql.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private MissionRepository missionRepository;


    @PostMapping(path = "/add/mission/continent")
    public @ResponseBody String addNewMissionConqueteContinent(@RequestParam String premierContient, @RequestParam String secondContinent){
        Mission newMission = new MissionConqueteContinent(premierContient,secondContinent);
        missionRepository.save(newMission);
        return "Mission de Conquete des Continents "+premierContient+ " et "+secondContinent+" , a été sauvegardé";
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewMissionConqueteTerritoire(@RequestParam int nbTerritoire){
        Mission newMission = new MissionConqueteTerritoire(nbTerritoire);
        missionRepository.save(newMission);
        return "Mission de Conquete de "+nbTerritoire+" territoires"+", a été sauvegardé";
    }

    @PostMapping(path = "/add/mission/elimination")
    public @ResponseBody String addNewMissionElimination(@RequestParam String cible){
        Mission newMission = new MissionElimination(cible);
        missionRepository.save(newMission);
        return "Mission d'élimination du joueur "+cible+", a été sauvegardé";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Mission> getAllMissions() {
        return missionRepository.findAll();
    }
}
