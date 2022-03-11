package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;

public interface PackageService {
    AddPackageResponse addPackage(AddPackageRequest addPackageRequest) throws UserDoesNotExistException;
    Package findMyPackageWIthId(Integer id);
}
