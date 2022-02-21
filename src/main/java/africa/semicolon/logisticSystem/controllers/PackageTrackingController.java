package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import africa.semicolon.logisticSystem.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticSystem.services.TrackingService;
import africa.semicolon.logisticSystem.services.TrackingServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PackageTrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PostMapping("/api/trackingInfo")
    public AddTrackingInfoResponse addTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackingInfo/{id}")
        public TrackingInformation getTrackingInfo(@PathVariable("id") Integer trackingId){
        return trackingService.trackPackage(trackingId);
        }
}
