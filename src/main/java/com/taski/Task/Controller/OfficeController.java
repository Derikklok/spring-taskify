package com.taski.Task.Controller;

import com.taski.Task.Model.Office;
import com.taski.Task.Service.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    @PostMapping
    public Office createOffice(@RequestBody Office office) {
        return officeService.createOffice(office);
    }

    @GetMapping("/{id}")
    public Office getOfficeById(@PathVariable Long id){
        return officeService.getOfficeById(id);
    }
}
