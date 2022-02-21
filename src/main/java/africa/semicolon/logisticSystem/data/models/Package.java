package africa.semicolon.logisticSystem.data.models;

import lombok.Data;

@Data
public class Package {
    private Integer id;
    private String name;
    private String senderEmail;
    private String ReceiverName;
    private String deliverAddress;
    private double netWeight;
    private String receiverPhone;
}
