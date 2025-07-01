package com.example.booking_service.client;

import com.example.booking_service.config.FeignClientConfig;
import com.example.booking_service.dto.VehicleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
@FeignClient(name = "vehicle-service", configuration = FeignClientConfig.class)
public interface VehicleClient {
 
    @GetMapping("/api/vehicles/{id}")
    VehicleResponse getVehicleById(@PathVariable("id") Long id);
}