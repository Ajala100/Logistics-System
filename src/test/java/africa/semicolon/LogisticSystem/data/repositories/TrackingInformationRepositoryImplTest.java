package africa.semicolon.LogisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.TrackingData;
import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import africa.semicolon.logisticSystem.data.repositories.TrackingInformationRepository;
import africa.semicolon.logisticSystem.data.repositories.TrackingInformationRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInformationRepositoryImplTest {
    TrackingInformationRepository trackingInformationRepository;

    @BeforeEach
    void setUp() {
        trackingInformationRepository = new TrackingInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save(){
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId();
    }


    @Test
    void findAll(){
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
    }

    private TrackingInformation saveTestHelper(){
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(342234);
        TrackingData trackingData = new TrackingData();
        trackingData.setEvent("Package Ready for Dispatch");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation savedInfo = trackingInformationRepository.save(trackingInformation);
        return  savedInfo;
    }
    @Test
    void deleteAll(){
        saveTestHelper();
        assertEquals(1,trackingInformationRepository.findAll().size());
        trackingInformationRepository.deleteAll();
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void findByPackageId(){
        TrackingInformation savedTrackingInformation = saveTestHelper();
        Optional <TrackingInformation> optionalTrackingInformation = trackingInformationRepository.findByPackageId(savedTrackingInformaion.getPackageId());
        assertTrue (optionalTrackingInformation.isPresent());
        assertEquals (savedTrackingInformation, optionalTrackingInformation.get());
    }

    @Test
    void delete(){
        TrackingInformation savedTrackingInformation = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedTrackingInformation.getPackageId());
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void testDelete(){
        TrackingInformation savedInfo = saveTestHelper();
        assertEquals(1,trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedInfo);
        assertEquals((0, trackingInformationRepository.findAll().size());
    }
}