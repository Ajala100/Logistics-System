package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.exceptions.UserDoesNotExistException;
import africa.semicolon.logisticSystem.services.PackageService;
import africa.semicolon.logisticSystem.services.PackageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.attribute.IntegerSyntax;

public class PackageController {
    private final PackageService packageService = new PackageServiceImpl();
    @PostMapping("/api/addpackage")

    public ResponseEntity <?> addPackage(@RequestBody AddPackageRequest addPackageRequest){
        try{
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (UserDoesNotExistException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest){
//        return packageService.addPackage(addPackageRequest);
//    }

    public Package findPackageById(@PathVariable("id") Integer id){
        return packageService.findMyPackageWIthMy(id); }
//    @GetMapping("api/package/{email}")
//    public Package findPackageBySenderEmail(@PathVariable("email") String email){
//        return packageService.findMyPackageWIthSenderEmail(email);
//    }
}
