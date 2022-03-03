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

    @Test
    void saveNewPackageTest() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry");
        aPackage.setReceiverName("Dharmmy");
        aPackage.setReceiverPhone("004994883");
        aPackage.setDeliverAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);

        Package savedPackage = packageRepository.save(aPackage);
        savedPackage.setName("Sniper");
        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, updatedPackage.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry@gmail.com");
        aPackage.setReceiverName("Dharmmy");
        aPackage.setReceiverPhone("004994883");
        aPackage.setDeliverAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.delete(savedPackage);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void deleteByTrackingNumber() {
    }

    @Test
    void findPackageTrackingNumber() {
    }
}