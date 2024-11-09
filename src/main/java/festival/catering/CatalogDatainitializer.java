package festival.catering;

import org.springframework.util.Assert;
import org.javamoney.moneta.Money;
import org.salespointframework.core.DataInitializer;
import org.springframework.stereotype.Component;

import static org.salespointframework.core.Currencies.EURO;

@Component
public class CatalogDatainitializer implements DataInitializer {

    private final CateringCatalog cateringCatalog;

    CatalogDatainitializer(CateringCatalog cateringCatalog) {
        Assert.notNull(cateringCatalog, "Catering catalog must not be null");
        this.cateringCatalog = cateringCatalog;
    }

    @Override
    public void initialize() {

        if (cateringCatalog.findAll().iterator().hasNext()) {
            return;
        }

        cateringCatalog.save(new Food( "Bratwurst", Money.of(4.99, EURO)));
        cateringCatalog.save(new Food( "Crêpe", Money.of(5.99, EURO)));
    }
}
