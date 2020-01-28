package team.kasta.bridaya.controller.cashier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import team.kasta.bridaya.model.cashier.Item;
import team.kasta.bridaya.payload.request.ItemRequest;
import team.kasta.bridaya.payload.response.BridayaResponse;
import team.kasta.bridaya.service.ItemService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public ResponseEntity addItem(@Valid @RequestBody ItemRequest request){
        Item item = new Item(request.getName(), request.getPrice(), request.getStatus(), request.getDescription());
        Item result = itemService.createItem(item);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/items/{name}")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new BridayaResponse(200,"success", "Item created successfully"));
    }
}
