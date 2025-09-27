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

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    public Office getOfficeById(Long id) {
        return officeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Office Not Found"));

    }

    public Office updateOffice(Long id, Office updateOffice) {
        Office office = getOfficeById(id);
        office.setOfficeName(updateOffice.getOfficeName());
        office.setAddress(updateOffice.getAddress());
        return officeRepository.save(office);
    }

    public void deleteOffice(Long id){
        officeRepository.deleteById(id);
    }
}
