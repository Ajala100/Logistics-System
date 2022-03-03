package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.SenderRepository;
import africa.semicolon.logisticSystem.data.repositories.SenderRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exceptions.DuplicateUserException;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;
import africa.semicolon.logisticSystem.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class SenderServiceImpl implements SenderService {
    private static final SenderRepository senderRepository = new SenderRepositoryImpl();

    @Override
    public RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest){
        Optional<Sender> senderInDatabase = senderRepository.findSenderByEmail(registerSenderRequest.getSenderEmail());
        if(senderInDatabase.isPresent())
            throw new DuplicateUserException(registerSenderRequest.getSenderEmail() + " already exists");
//        convert to sender
//        Sender sender = new Sender();
//        sender.setSenderName(registerSenderRequest.getSenderName());
//        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
//        sender.setEmailAddress(registerSenderRequest.getSenderEmail());

        Sender sender = ModelMapper.map(registerSenderRequest);

        //save sender

        Sender savedSender = senderRepository.save(sender);

        //convert sender to DTO

////        RegisterSenderResponse response = new RegisterSenderResponse();
////        response.setSenderEmail(savedSender.getEmailAddress());
//        RegisterSenderResponse =

        // return DTO
        return ModelMapper.map(savedSender);
    }

    @Override
    public List<Sender> getSenders() {
        return senderRepository.findAll();
    }

    @Override
    public void deleteAllSenders() {senderRepository.deleteAll(); }

    @Override
    public Optional<Sender> findSenderByEmail(String email) throws UserDoesNotExistException {
        if(!senderRepository.findSenderByEmail(email).isPresent()) throw new UserDoesNotExistException("Sender does not exist");
        return senderRepository.findSenderByEmail(email);
    }
}
