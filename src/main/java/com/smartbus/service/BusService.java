package com.smartbus.service;

import com.smartbus.dto.BusSearchResponseDTO;
import com.smartbus.model.Bus;
import com.smartbus.model.Seat;
import com.smartbus.repository.BusRepository;
import com.smartbus.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
@Service
public class BusService {

    @Autowired
    BusRepository busRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatLockService seatLockService;

    Logger logger = Logger.getLogger(BusService.class.getName());

    public void demoSeatLocking()
    {
        Seat seat = seatRepository.findById(10L).get();
        logger.info("Before calling method: " + seat.getBooked());
        seatLockService.lockSeat(seat);
        logger.info("After calling method: " + seat.getBooked());

    }


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
        return busRepository.findAll().stream().
                collect(Collectors.groupingBy(Bus::getOperatorName));
    }
}
