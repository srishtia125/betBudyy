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
public class ProfitPlayerDTO {

    @CsvBindByName(column ="PLAYER_ID")
    private int playerId;
    @CsvBindByName(column ="AMOUNT_WON")
    private double amtWon;
    @CsvBindByName(column ="AMOUNT_WAGERED")
    private double amtWagered;
    @CsvBindByName(column ="PROFIT")
    private double profit;
}
