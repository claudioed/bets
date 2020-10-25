package tech.claudioed.matches.domain.resources;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import tech.claudioed.matches.domain.Bets;
import tech.claudioed.matches.domain.Championship;
import tech.claudioed.matches.domain.Match;
import tech.claudioed.matches.domain.Player;
import tech.claudioed.matches.domain.service.ChampionshipService;
import tech.claudioed.matches.domain.service.MatchService;
import tech.claudioed.matches.domain.service.PlayerService;

@RestController
@RequestMapping("/api/bets")
public class BetsResource {

  private final MatchService matchService;

  private final PlayerService playerService;

  private final ChampionshipService championshipService;

  public BetsResource(MatchService matchService, PlayerService playerService,
      ChampionshipService championshipService) {
    this.matchService = matchService;
    this.playerService = playerService;
    this.championshipService = championshipService;
  }

  @PostMapping
  public ResponseEntity<Bets> championships(@RequestBody Bets bets, UriComponentsBuilder builder) {
    var championship = this.championshipService.championship(bets.getChampionship());
    var match = this.matchService.match(bets.getMatch());
    var player = this.playerService.player(bets.getEmail());
    return ResponseEntity.created(builder.path("/api/bets/{id}").buildAndExpand(UUID.randomUUID().toString()).toUri()).body(bets);
  }

}
