package tech.claudioed.matches.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bets {

  private String match;

  private String email;

  private String championship;

  private String awayTeamScore;

  private String homeTeamScore;

}
