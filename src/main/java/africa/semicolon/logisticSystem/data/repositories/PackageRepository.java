package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;

import java.util.List;

public interface PackageRepository {
    List<Package> findAll();
    Package save(Package apackage);
    void delete (Package aPackage);
    void delete (Integer id);
    Package findPackageBySenderEmail(String email) throws UserDoesNotExistException;
    Package findPackageById(Integer id);
}
