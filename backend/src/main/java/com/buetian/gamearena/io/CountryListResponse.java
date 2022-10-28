package com.buetian.gamearena.io;

import com.buetian.gamearena.model.Country;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CountryListResponse {
    List<Country> countries;
}
