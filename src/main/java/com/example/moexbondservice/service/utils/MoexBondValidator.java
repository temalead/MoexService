package com.example.moexbondservice.service.utils;

import com.example.moexbondservice.dto.BondDto;
import com.example.moexbondservice.exception.LimitMoexRequestExceededException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MoexBondValidator {

    public void validateMoexLimitation(List<BondDto> bonds) {
        if (bonds.isEmpty()) {
            log.error("Exceeded limits of MOEX requests");
            throw new LimitMoexRequestExceededException("Exceeded limits of MOEX requests");
        }
    }

}
