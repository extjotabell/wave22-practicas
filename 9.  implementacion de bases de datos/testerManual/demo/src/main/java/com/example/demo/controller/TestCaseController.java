package com.example.demo.controller;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    ITestCaseService testCaseService;
    public TestCaseController(ITestCaseService testCaseService){
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.ok(testCaseService.create(testCaseDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(testCaseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getById(@PathVariable Long id) {
        TestCaseDTO testCase = testCaseService.getById(id);
        if (testCase != null) {
            return ResponseEntity.ok(testCase);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> update(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {
        TestCaseDTO updatedTestCase = testCaseService.update(id, testCaseDTO);
        if (updatedTestCase != null) {
            return ResponseEntity.ok(updatedTestCase);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (testCaseService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "last_update")
    public ResponseEntity<List<TestCaseDTO>> getByLastUpdate(@RequestParam("last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        List<TestCaseDTO> testCases = testCaseService.getByLastUpdate(lastUpdate);
        return ResponseEntity.ok(testCases);
    }


}
