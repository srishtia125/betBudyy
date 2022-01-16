package test.playtech.service;


import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;
import test.playtech.dto.SessionWonWageredDto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class CSVWriteService {

        public void csvWriterAll(List<?> sessionWonWageredDtoList, String fileName)  {
            Writer writer = null;
            try {
                writer = new FileWriter("files/"+fileName);
               StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(sessionWonWageredDtoList);
                writer.close();
            } catch (CsvDataTypeMismatchException |CsvRequiredFieldEmptyException |IOException e) {
            }
        }
}
