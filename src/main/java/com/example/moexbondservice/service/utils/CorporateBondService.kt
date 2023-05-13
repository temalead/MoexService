package com.example.moexbondservice.service.utils;

import com.example.moexbondservice.client.CorporateBondClient;
import com.example.moexbondservice.dto.BondDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CorporateBondService {
    private final BondParser bondParser;
    private final CorporateBondClient corporateBondClient;
    private final MoexBondValidator validator;

    @Cacheable(value = "corps")
    public List<BondDto> getCorporateBonds() {
        final String corporateRates = corporateBondClient.getBondsFromMoex();
        List<BondDto> bonds = bondParser.parse(corporateRates);
        validator.validateMoexLimitation(bonds);

        return bonds;
    }

}
