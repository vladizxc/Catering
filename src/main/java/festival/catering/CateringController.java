package festival.catering;

import org.salespointframework.catalog.Product;
import org.salespointframework.inventory.UniqueInventory;
import org.salespointframework.inventory.UniqueInventoryItem;
import org.salespointframework.order.Cart;
import org.salespointframework.quantity.Quantity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CateringController {

    private final CateringCatalog cateringCatalog;
    private final UniqueInventory<UniqueInventoryItem> inventory;

    CateringController(CateringCatalog cateringCatalog, UniqueInventory<UniqueInventoryItem> inventory) {
        this.cateringCatalog = cateringCatalog;
        this.inventory = inventory;
    }

    @ModelAttribute("cart")
    Cart initializeCart() {return new Cart();}

    @GetMapping("/")
    String catering(Model model, @ModelAttribute Cart cart) {
        model.addAttribute("catalog", cateringCatalog.findAll());
        model.addAttribute("cart", cart);
        return "catering";
    }

    @PostMapping("/cart")
    String addFood(@RequestParam("pid")Product.ProductIdentifier productId, @ModelAttribute Cart cart) {
        Product product = cateringCatalog.findById(productId).orElseThrow();
        if (product instanceof Food) {
            Food food = (Food) product;
            cart.addOrUpdateItem(food, Quantity.of(1));
        }
        return "redirect:/";
    }
}
