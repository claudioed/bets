package tech.claudioed.matches.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.claudioed.matches.domain.Championship;

@Service
public class ChampionshipService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ChampionshipService.class);

  private final RestTemplate restTemplate;

  private final String championshipSVC;

  public ChampionshipService(RestTemplate restTemplate,@Value("${system.championship}")String championshipSVC) {
    this.restTemplate = restTemplate;
    this.championshipSVC = championshipSVC;
  }

  public Championship championship(String id){
    var url = this.championshipSVC;
    LOGGER.info("Calling {}",url);
    var response = this.restTemplate.getForEntity(url, Championship.class);
    return response.getBody();
  }

}
