package com.example.booking_service.dto;

import lombok.*;
import java.time.LocalDate;
 
@Data
@Builder
public class BookingResponse {
    private Long id;
    private Long userId;
    private Long vehicleId;
    private LocalDate bookingDate;
    private String status;
}
