package team.kasta.bridaya.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import team.kasta.bridaya.model.common.Business;
import team.kasta.bridaya.payload.request.BusinessRequest;
import team.kasta.bridaya.payload.response.BridayaResponse;
import team.kasta.bridaya.service.BusinessService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/business")
@CrossOrigin("*")
public class BusinessController {
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    public ResponseEntity addBusiness(@Valid @RequestBody BusinessRequest request){
        Business data = new Business(request.getName(), request.getAddress(), request.getContactNumber(), request.getEmail());
        Business result = businessService.createBusiness(data);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/business/{name}")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new BridayaResponse(200,"success", "Merchant created successfully"));
    }
}
