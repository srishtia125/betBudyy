package test.playtech.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import test.playtech.dto.EventDataDTO;

import java.io.File;
import java.util.List;

import static test.playtech.helper.CSVHelper.generateGameSessionWWCSV;
import static test.playtech.helper.CSVHelper.generateProfitPlayerCSV;
import static test.playtech.helper.CSVHelper.generateGameWWCSV;
import static test.playtech.helper.CSVHelper.generateSessionWWCSV;


@Service
@AllArgsConstructor
public class ReportGeneratorService {

    private  CSVReadService csvReadService;
    private  CSVWriteService csvWriteService;

    public void generateEventDataCSV(){

        List<EventDataDTO> eventDataDTOSList = csvReadService.
                readCSV("files/game_event_data.csv");

        csvWriteService.csvWriterAll(generateSessionWWCSV(eventDataDTOSList),"session_wagered_won.csv");
        csvWriteService.csvWriterAll(generateGameWWCSV(eventDataDTOSList),"game_wagered_won.csv");
        csvWriteService.csvWriterAll(generateGameSessionWWCSV(eventDataDTOSList),"session_game_wagered_won.csv");
        csvWriteService.csvWriterAll(generateProfitPlayerCSV(eventDataDTOSList),"profit_players.csv");

    }

}
