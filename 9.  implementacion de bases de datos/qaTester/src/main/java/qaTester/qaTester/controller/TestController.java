package qaTester.qaTester.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qaTester.qaTester.dto.MessageDto;
import qaTester.qaTester.dto.TestCaseDto;
import qaTester.qaTester.service.ITestService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    ITestService service;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<MessageDto> createTestCase(@RequestBody TestCaseDto testCaseDto){
        service.createTestCase(testCaseDto);
        return new ResponseEntity<>(new MessageDto("Test case created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDto>> getTestCases(){
        return new ResponseEntity<>(service.getTestCases(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable long id){
        return new ResponseEntity<>(service.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<MessageDto> updateTestCase(@PathVariable long id,
                                                     @RequestBody TestCaseDto testCaseDto){
        service.updateTestCase(id, testCaseDto);
        return new ResponseEntity<>(new MessageDto("Test case " + id + " has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<MessageDto> deleteTestCase(@PathVariable long id){
        service.deleteTestCase(id);
        return new ResponseEntity<>(new MessageDto("Test case " + id + " deleted successfully"), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/date")
    public ResponseEntity<List<TestCaseDto>> getTestCasesByDate(@RequestParam LocalDate lastUpdate){
        return new ResponseEntity<>(service.getTestCasesByDate(lastUpdate), HttpStatus.OK);
    }
}
