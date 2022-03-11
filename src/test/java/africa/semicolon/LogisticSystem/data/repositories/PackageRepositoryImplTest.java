package africa.semicolon.LogisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.repositories.PackageRepository;
import africa.semicolon.logisticSystem.data.repositories.PackageRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    private PackageRepository packageRepository;

    @BeforeEach
    void setUp() {
        packageRepository = new PackageRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }


    public Package savePackage() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry");
        aPackage.setReceiverName("Dharmmy");
        aPackage.setReceiverPhone("004994883");
        aPackage.setDeliverAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);

        return packageRepository.save(aPackage);
    }

    @Test
    void saveNewPackageTest(){
        Package savedPackage = savePackage();
        assertEquals(1, savedPackage.getId());
    }


    @Test
    void findAll() {
        Package savedPackage = savePackage();
        assertEquals(1, packageRepository.findAll().size());
    }

    @Test
    void delete() {
        Package savedPackage = savePackage();
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.delete(savedPackage);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void deleteByTrackingNumber() {
        Package savedPackage = savePackage();
        assertEquals(savedPackage, packageRepository.findPackageById(1));
    }

    @Test
    void findPackageTrackingNumber() {
    }
}