package test.playtech.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.playtech.service.ReportGeneratorService;

@RestController
@AllArgsConstructor
public class ReportDataController {


    private ReportGeneratorService reportGeneratorService;

   @PostMapping("/reports")
    public ResponseEntity generateEventDataCSV(){
        reportGeneratorService.generateEventDataCSV();
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
