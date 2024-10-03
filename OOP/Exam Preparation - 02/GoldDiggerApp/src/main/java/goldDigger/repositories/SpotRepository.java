package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpotRepository implements Repository<Spot> {
    private Map<String, Spot> spots;

    public SpotRepository() {
        this.spots = new LinkedHashMap<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(this.spots.values());
    }

    @Override
    public void add(Spot spot) {
        this.spots.put(spot.getName(), spot);
    }

    @Override
    public boolean remove(Spot spot) {
        return this.spots.remove(spot) != null;
    }

    @Override
    public Spot byName(String name) {
        return this.spots.get(name);
    }
}
