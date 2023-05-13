package com.example.moexbondservice.service.utils;

import com.example.moexbondservice.dto.BondDto;

import java.util.List;

public interface BondParser {

    List<BondDto> parse(String ratesAsString);
}
