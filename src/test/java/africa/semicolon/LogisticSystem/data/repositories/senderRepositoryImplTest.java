package africa.semicolon.LogisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.SenderRepository;
import africa.semicolon.logisticSystem.data.repositories.SenderRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class senderRepositoryImplTest {
    SenderRepository senderRepository;

    @BeforeEach
    void setUp() {
        senderRepository = new SenderRepositoryImpl();
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void save() {
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAdress("Jerry@gmail.com");
        sender.setPhoneNumber("081234567");
        sender
    }
}
