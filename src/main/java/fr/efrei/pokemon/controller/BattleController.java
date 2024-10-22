package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Battle;
import fr.efrei.pokemon.services.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battles")
public class BattleController {

    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @GetMapping
    public ResponseEntity<List<Battle>> findAll() {
        return new ResponseEntity<>(battleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battle> findById(@PathVariable String id) {
        Battle battle = battleService.findById(id);
        if (battle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(battle, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Battle battle) {
        battleService.save(battle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Battle battle) {
        Battle existingBattle = battleService.findById(id);
        if (existingBattle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        battleService.update(id, battle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Battle battle = battleService.findById(id);
        if (battle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        battleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
