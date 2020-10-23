package tech.claudioed.matches.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.claudioed.matches.domain.Player;

@Service
public class PlayerService {

  private final RestTemplate restTemplate;

  private final String playerSVC;

  public PlayerService(RestTemplate restTemplate,@Value("${system.players}")String playerSVC) {
    this.restTemplate = restTemplate;
    this.playerSVC = playerSVC;
  }

  public Player player(String id){
    var url = this.playerSVC + "/" + id;
    var response = this.restTemplate.getForEntity(url, Player.class);
    return response.getBody();
  }

}
