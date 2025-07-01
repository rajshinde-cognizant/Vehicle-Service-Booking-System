package com.example.booking_service.service;

import com.example.booking_service.client.UserClient;
import com.example.booking_service.client.VehicleClient;
import com.example.booking_service.dto.BookingRequest;
import com.example.booking_service.dto.BookingResponse;
import com.example.booking_service.entity.Booking;
import com.example.booking_service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService {
 
    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final VehicleClient vehicleClient;
 
    public BookingResponse createBooking(BookingRequest request) {
        userClient.getUserById(request.getUserId()); // Validate user
        vehicleClient.getVehicleById(request.getVehicleId()); // Validate vehicle
 
        Booking booking = Booking.builder()
                .userId(request.getUserId())
                .vehicleId(request.getVehicleId())
                .bookingDate(request.getBookingDate())
                .status(request.getStatus())
                .build();
booking = bookingRepository.save(booking);
log.info("Booking created with ID: {}", booking.getId());
        return toResponse(booking);
    }
 
    public List<BookingResponse> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
 
    public BookingResponse getBooking(Long id) {
        return bookingRepository.findById(id).map(this::toResponse).orElse(null);
    }
 
    public BookingResponse updateBooking(Long id, BookingRequest request) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setBookingDate(request.getBookingDate());
        booking.setStatus(request.getStatus());
booking = bookingRepository.save(booking);
log.info("Booking updated with ID: {}", booking.getId());
        return toResponse(booking);
    }
 
    public void deleteBooking(Long id) {
log.info("Deleting booking with ID: {}", id);
        bookingRepository.deleteById(id);
    }
 
    private BookingResponse toResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .userId(booking.getUserId())
                .vehicleId(booking.getVehicleId())
                .bookingDate(booking.getBookingDate())
                .status(booking.getStatus())
                .build();
    }
}