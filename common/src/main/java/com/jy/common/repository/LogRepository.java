package com.jy.common.repository;


import com.jy.common.model.sys.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
