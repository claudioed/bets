package tech.claudioed.matches.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private String homeTeam;

    private String awayTeam;

    private String championship;

}