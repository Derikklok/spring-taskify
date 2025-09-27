package com.taski.Task.Repository;

import com.taski.Task.Model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office,Long> {
}
