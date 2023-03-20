package com.example.moexbondservice.service.utils;

import com.example.moexbondservice.client.GovernmentBondClient;
import com.example.moexbondservice.dto.BondDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GovernmentBondService {
    private final GovernmentBondClient governmentBondClient;
    private final BondParser bondParser;
    private final MoexBondValidator validator;


    @Cacheable(value = "govs")
    public List<BondDto> getGovernmentBonds() {
        final String governmentRates = governmentBondClient.getBondsFromMoex();
        List<BondDto> bonds = bondParser.parse(governmentRates);
        validator.validateMoexLimitation(bonds);

        return bonds;
    }
}
