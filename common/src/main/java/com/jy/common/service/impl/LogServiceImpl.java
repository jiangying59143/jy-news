package com.jy.common.service.impl;

import com.jy.common.model.sys.Log;
import com.jy.common.repository.LogRepository;
import com.jy.common.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Integer saveLog(Log log) {
        return logRepository.save(log).getId();
    }
}
