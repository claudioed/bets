package tech.claudioed.matches.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.claudioed.matches.domain.Match;

@Service
public class MatchService {

  private final RestTemplate restTemplate;

  private final String matchSVC;

  public MatchService(RestTemplate restTemplate,@Value("${system.match}")String matchSVC) {
    this.restTemplate = restTemplate;
    this.matchSVC = matchSVC;
  }

  public Match match(String id){
    var url = this.matchSVC + "/" + id;
    var response = this.restTemplate.getForEntity(url, Match.class);
    return response.getBody();
  }

}
