package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SenderService {
    RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest);

    List<Sender> getSenders();

    void deleteAllSenders();

    Optional<Sender> findSenderByEmail(String email) throws UserDoesNotExistException;

}
