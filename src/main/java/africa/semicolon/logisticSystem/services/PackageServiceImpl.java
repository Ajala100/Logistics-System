package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.PackageRepository;
import africa.semicolon.logisticSystem.data.repositories.PackageRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.exceptions.InvalidPackageIdException;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;
import africa.semicolon.logisticSystem.utils.ModelMapper;

import java.util.Optional;

public class PackageServiceImpl implements PackageService{
    private final PackageRepository packageRepository = new PackageRepositoryImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        //Sender senderOptional = senderSer
        //convert addPackage request to a package
        Package aPackage = ModelMapper.map(addPackageRequest);
        if(aPackage == null) throw new IllegalArgumentException("Request is null");

        //save package
        Package savedPackage = packageRepository.save(aPackage);

        //convert saved package to addPackage response
        AddPackageResponse response = ModelMapper.map(savedPackage);

        //return converted response;
        return response;
    }

    @Override
    public Package findMyPackageWIthId(Integer id) {
        Optional<Package> queryResult = Optional.of(packageRepository.findPackageById(id));
        if(queryResult.isEmpty()) throw new InvalidPackageIdException("Package does not exist");
        else return queryResult.get();
    }
}
