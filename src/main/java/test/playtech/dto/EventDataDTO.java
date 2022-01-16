package test.playtech.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDataDTO {

    @CsvBindByName(column ="CODE")
    private int code;
    @CsvBindByName(column ="PLAYER_ID")
    private int playerId;
    @CsvBindByName(column ="AMOUNT")
    private double amount;
    @CsvBindByName(column ="EVENT_DATE")
    private String eventDate;
    @CsvBindByName(column ="CHAPTER")
    private String chapter;
    @CsvBindByName(column ="PARTNER_ID")
    private int partnerId;
    @CsvBindByName(column ="GAME_NAME")
    private String gameName;
    @CsvBindByName(column ="SESSION_ID")
    private int sessionId;

}
