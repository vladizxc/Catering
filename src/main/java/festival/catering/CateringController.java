package festival.catering;

import org.salespointframework.inventory.UniqueInventory;
import org.salespointframework.inventory.UniqueInventoryItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CateringController {

    private final CateringCatalog cateringCatalog;
    private final UniqueInventory<UniqueInventoryItem> inventory;

    CateringController(CateringCatalog cateringCatalog, UniqueInventory<UniqueInventoryItem> inventory) {
        this.cateringCatalog = cateringCatalog;
        this.inventory = inventory;
    }

    @GetMapping("/catering")
    String catering(Model model) {
        model.addAttribute("catalog", cateringCatalog.findAll());
        return "catering";
    }
}
