package festival.catering;

import org.springframework.util.Assert;
import org.salespointframework.core.DataInitializer;
import org.salespointframework.inventory.UniqueInventory;
import org.salespointframework.inventory.UniqueInventoryItem;
import org.salespointframework.quantity.Quantity;
import org.springframework.stereotype.Component;

@Component
class InventoryInitializer implements DataInitializer {

    private final UniqueInventory<UniqueInventoryItem> inventory;
    private final CateringCatalog cateringCatalog;

    InventoryInitializer(UniqueInventory<UniqueInventoryItem> inventory, CateringCatalog cateringCatalog) {
        Assert.notNull(inventory, "Inventory cannot be null");
        Assert.notNull(cateringCatalog, "Catalog cannot be null");

        this.inventory = inventory;
        this.cateringCatalog = cateringCatalog;
    }

    @Override
    public void initialize() {

        cateringCatalog.findAll().forEach(food -> {
            if (inventory.findByProduct(food).isEmpty()) {
                inventory.save(new UniqueInventoryItem(food, Quantity.of(10)));
            }
        });
    }
}
