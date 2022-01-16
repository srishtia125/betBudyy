package test.playtech.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GameSessionWonWageredDTO {

    @CsvBindByName(column ="PLAYER_ID")
    private int playerId;
    @CsvBindByName(column ="SESSION_ID")
    private int sessionId;
    @CsvBindByName(column ="GAME_NAME")
    private String gameName;
    @CsvBindByName(column ="AMOUNT_WON")
    private double amtWon;
    @CsvBindByName(column ="AMOUNT_WAGERED")
    private double amtWagered;

}
