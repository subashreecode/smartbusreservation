package com.smartbus.service;

import com.smartbus.dto.BusSearchResponseDTO;
import com.smartbus.model.Bus;
import com.smartbus.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BusService {

    @Autowired
    BusRepository busRepository;

    public List<Bus> routeDateFilter(String source, String destination, LocalDate date)
    {

        return  busRepository.findAll().stream().filter(bus->bus.getRoute()!=null)
                .filter(bus->bus.getRoute().getSource().equalsIgnoreCase(source))
                .filter(bus->bus.getRoute().getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());

    }

    public List<BusSearchResponseDTO> mapToDTO(List<Bus> buses)
    {
        return buses.stream().map(bus ->
                new BusSearchResponseDTO(bus.getId(),bus.getBusNumber(),bus.getOperatorName(),
                        bus.getDepartureTime(),bus.getArrivalTime(),bus.getPrice())).collect(Collectors.toList());
    }

    public Map<String,List<Bus>> groupByOperator()
    {
        return busRepository.findAll().stream().collect(Collectors.groupingBy(Bus::getOperatorName));
    }
}
