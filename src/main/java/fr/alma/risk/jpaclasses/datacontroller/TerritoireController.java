package fr.alma.risk.jpaclasses.datacontroller;

import fr.alma.risk.datatypes.Territoire;
import fr.alma.risk.jpaclasses.accessingdatamysql.TerritoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/territoire")
public class TerritoireController {

    @Autowired
    private TerritoireRepository territoireRepository;

    @PostMapping(path = "/addTerritoire")
    public @ResponseBody String addNewTerritoire(@RequestParam String nom){
        Territoire territoire = new Territoire(nom);
        territoireRepository.save(territoire);
        return "Territoire : "+territoire.getNom()+" a ete sauvergarde.";
    }



    @GetMapping(path="/allTerritoire")
    public @ResponseBody Iterable<Territoire> getAllMissions() {
        return territoireRepository.findAll();
    }
}
