package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;
import africa.semicolon.logisticSystem.services.SenderService;
import africa.semicolon.logisticSystem.services.SenderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class SenderController {
    private SenderService senderService = new SenderServiceImpl();

    @PostMapping("/api/sender")
    public RegisterSenderResponse registerSender(@RequestBody RegisterSenderRequest registerSenderRequest){
        return senderService.registerSender(registerSenderRequest);
    }

    @GetMapping("/api/v1/sender/{email}")
    public Optional <Sender> getSenderById(@PathVariable String email) throws UserDoesNotExistException {
        return senderService.findSenderByEmail(email);
    }
}
