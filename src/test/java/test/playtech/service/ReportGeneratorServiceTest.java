package test.playtech.service;

import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ReportGeneratorServiceTest {

    private CSVReadService csvReadService;
    private CSVWriteService csvWriteService;
    private ReportGeneratorService reportGeneratorService;
    private FileReader fileReader;
    private CsvToBeanBuilder csvToBeanBuilder;

    @Before
    public void setup() {

        csvReadService = mock(CSVReadService.class);
        csvToBeanBuilder = mock(CsvToBeanBuilder.class);
        fileReader = mock(FileReader.class);
        csvWriteService = mock(CSVWriteService.class);
        reportGeneratorService = new ReportGeneratorService(csvReadService, csvWriteService);

    }

    @Test
    public void testGenerateReport() {
        when(csvReadService.readCSV(anyString())).thenReturn(anyList());
        doNothing().when(csvWriteService).csvWriterAll(anyList(), anyString());
        reportGeneratorService.generateEventDataCSV();
        verify(csvReadService, only()).readCSV(anyString());
        verify(csvWriteService, times(4)).csvWriterAll(anyList(), anyString());


    }

}
