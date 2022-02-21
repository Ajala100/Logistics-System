package africa.semicolon.logisticSystem.data.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrackingData {
    private LocalDateTime dateTimeOfEvent = LocalDateTime.now();
    private String event;

}
