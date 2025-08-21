package managers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Singleton
public class DarkStoreManager {

    private static DarkStoreManager instance = new DarkStoreManager();

    public static DarkStoreManager getInstance(){
        return instance;
    }

    private DarkStoreManager() {
        this.stores = new ArrayList<>();
    }

    List<DarkStore> stores;

    public void registerDarkStore(DarkStore darkStore){

        stores.add(darkStore);
    }

    public List<DarkStore> getNearbyDarkStores(double ux, double uy, double maxDistance) {
        List<Pair<Double,DarkStore>> distList = new ArrayList<>();
        for (DarkStore ds : stores) {
            double d = ds.distanceTo(ux, uy);
            if (d <= maxDistance) {
                distList.add(new Pair<>(d, ds));
            }
        }
        distList.sort(Comparator.comparing(Pair::getKey));
        List<DarkStore> result = new ArrayList<>();
        for (Pair<Double,DarkStore> p : distList) {
            result.add(p.getValue());
        }
        return result;
    }

}
