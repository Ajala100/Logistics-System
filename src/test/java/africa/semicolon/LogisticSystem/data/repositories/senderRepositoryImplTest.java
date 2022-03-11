package africa.semicolon.LogisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.SenderRepository;
import africa.semicolon.logisticSystem.data.repositories.SenderRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        sender.setEmailAddress("Jerry@gmail.com");
        sender.setPhoneNumber("081234567");

        Sender savedSender = senderRepository.save(sender);
        assertEquals(sender, savedSender);
        assertEquals(1, senderRepository.findAll().size());
    }

    public Sender savedSender(){
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("Jerry@gmail.com");
        sender.setPhoneNumber("0903457632");

        return senderRepository.save(sender);
    }

    @Test
    void findSenderByEmail(){
        Sender savedSender = savedSender();
        assertEquals(savedSender, senderRepository.findSenderByEmail(savedSender.getEmailAddress()).get());
    }

    @Test
    void delete(){
        Sender savedSender = savedSender();
        senderRepository.delete(savedSender);
        assertEquals(0, senderRepository.findAll().size());
    }

    @Test
    void testDelete(){
        Sender savedSender = savedSender();
        senderRepository.deleteByEmail(savedSender().getEmailAddress());
        assertEquals(0, senderRepository.findAll().size());
    }
}
