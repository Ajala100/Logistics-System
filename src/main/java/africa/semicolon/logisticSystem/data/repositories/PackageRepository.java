package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;

import java.util.List;

public interface PackageRepository {
    List<Package> findAll();
    Package save(Package apackage);
    void delete (Package aPackage);
    void delete (Integer id);
    Package findPackageBySenderEmail(String email);
    Package findPackageById(Integer id);
}
