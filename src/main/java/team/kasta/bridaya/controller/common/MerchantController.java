package team.kasta.bridaya.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import team.kasta.bridaya.model.common.Merchant;
import team.kasta.bridaya.payload.request.MerchantRequest;
import team.kasta.bridaya.payload.response.BridayaResponse;
import team.kasta.bridaya.security.CurrentUser;
import team.kasta.bridaya.security.UserPrincipal;
import team.kasta.bridaya.service.MerchantService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/merchants")
@CrossOrigin("*")
public class MerchantController {
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody MerchantRequest request, @CurrentUser UserPrincipal currentUser){
        Merchant data = new Merchant(request.getName(), request.getAddress(), request.getContactNumber(), request.getEmail());
        Merchant result = merchantService.createMerchant(data);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/merchants/{name}")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new BridayaResponse(200,"success", "Merchant created successfully"));
    }
}
