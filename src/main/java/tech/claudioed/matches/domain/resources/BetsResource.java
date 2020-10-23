package tech.claudioed.matches.domain.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.claudioed.matches.domain.Player;

@RestController
@RequestMapping("/api/players")
public class BetsResource {




    @GetMapping("/{id}")
    public ResponseEntity<Player> championships(@PathVariable("id")String id){
        final var player = Player.builder().name("Joe Doe").email("joe@doe.com").build();
        return ResponseEntity.ok(player);
    }

}
