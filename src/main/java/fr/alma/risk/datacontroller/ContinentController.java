package fr.alma.risk.datacontroller;

import fr.alma.risk.Continent;
import fr.alma.risk.Territoire;
import fr.alma.risk.accessingdatamysql.ContinentRepository;
import fr.alma.risk.accessingdatamysql.TerritoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/continent")
public class ContinentController {

    @Autowired
    private ContinentRepository continentRepository;


    @PostMapping(path = "/addContinent")
    public @ResponseBody String addNewContinent(@RequestParam String nom,@RequestParam int renfortsBonus){
        Continent continent = new Continent(nom,renfortsBonus);
        continentRepository.save(continent);
        return "Continent : "+continent.getNom()+" a ete sauvergarde.";
    }



    @GetMapping(path="/allContinent")
    public @ResponseBody Iterable<Continent> getAllMissions() {
        return continentRepository.findAll();
    }
}
