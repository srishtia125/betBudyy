package test.playtech.service;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import test.playtech.dto.EventDataDTO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


@Service
public class CSVReadService  {

    public List<EventDataDTO> readCSV(String fileName) {
        List<EventDataDTO> eventDataDTOSList = new ArrayList<>();
        try {
            eventDataDTOSList = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(EventDataDTO.class)
                    .build()
                    .parse();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return eventDataDTOSList;
    }
}
