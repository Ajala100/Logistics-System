package africa.semicolon.logisticSystem.utils;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.models.TrackingData;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;

public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setDeliverAddress(aPackage.getDeliverAddress());
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
        aPackage.setReceiverPhone(aPackage.getReceiverPhone());
        aPackage.setReceiverName(addPackageRequest.getReceiverName());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage){
        AddPackageResponse response = new AddPackageResponse();
        response.setPackageName(savedPackage.getName());
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setTrackingNumber(savedPackage.getId());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        return response;
    }

    public static Sender map(RegisterSenderRequest registerSenderRequest){
        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());
        return sender;
    }

    public static RegisterSenderResponse map(Sender sender){
        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(sender.getEmailAddress());
        return response;
    }

    public static AddTrackingInfoResponse map(TrackingData trackingData, AddTrackingInfoRequest addTrackingInfoRequest) {
        AddTrackingInfoResponse addTrackingInfoResponse = new AddTrackingInfoResponse();
        addTrackingInfoResponse.setDateTime(trackingData.getDateTimeOfEvent());
        addTrackingInfoResponse.setEvent(trackingData.getEvent());
        addTrackingInfoResponse.setPackageId(addTrackingInfoRequest.getPackageId());
        return addTrackingInfoResponse;
    }
}
 