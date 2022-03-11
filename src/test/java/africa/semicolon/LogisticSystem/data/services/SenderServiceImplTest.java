package africa.semicolon.LogisticSystem.data.services;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dtos.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exceptions.DuplicateUserException;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;
import africa.semicolon.logisticSystem.services.SenderService;
import africa.semicolon.logisticSystem.services.SenderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SenderServiceImplTest {
    SenderService senderService;
    @BeforeEach
    void setUp(){
       senderService = new SenderServiceImpl();
    }

    @AfterEach
    void tearDown(){
        senderService.deleteAllSenders();
    }
    @Test
    void registerSender(){
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Jerry");
        registerSenderRequest.setSenderEmail("Jerry@email.com");
        registerSenderRequest.setPhoneNumber("1234567");
        RegisterSenderResponse response = senderService.registerSender(registerSenderRequest);

        assertEquals(response.getSenderEmail(), registerSenderRequest.getSenderEmail());
        assertEquals(1, senderService.getSenders().size());
    }

    public RegisterSenderResponse registerSenderTestHelper(){
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Jerry");
        registerSenderRequest.setSenderEmail("Jerry@email.com");
        registerSenderRequest.setPhoneNumber("1234567");
        return  senderService.registerSender((registerSenderRequest));

    }

    @Test
    void duplicateEmail_throwsExceptionTest(){
        registerSenderTestHelper();
        assertThrows(DuplicateUserException.class, ()-> registerSenderTestHelper());
    }

    @Test
    void nonExistingSenderEmail_ThrowsException(){
        registerSenderTestHelper();
        assertThrows(UserDoesNotExistException.class, ()-> senderService.findSenderByEmail("bola@gmail.com"));
    }
}
