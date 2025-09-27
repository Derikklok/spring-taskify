package com.taski.Task.Service;

import com.taski.Task.Model.Office;
import com.taski.Task.Repository.OfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAllOffices(){
        return officeRepository.findAll();
    }
}
