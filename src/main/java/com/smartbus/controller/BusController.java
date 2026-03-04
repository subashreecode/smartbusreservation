package com.smartbus.controller;

import com.smartbus.dto.BusSearchResponseDTO;
import com.smartbus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/search")
    public List<BusSearchResponseDTO> searchBuses(@RequestParam String source,
                                                  @RequestParam String destination,
                                                  @RequestParam LocalDate journeyDate)
    {
        return busService.searchBuses(source,destination,journeyDate);
    }


}
