package festival.catering;

import org.salespointframework.catalog.Catalog;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;

public interface CateringCatalog extends Catalog<Food> {
    static final Sort DEFAULT_SORT = Sort.sort(Food.class).by(Food::getId).descending();

    Streamable<Food> findByName(String name);
}