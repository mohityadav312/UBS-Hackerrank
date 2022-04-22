package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    private Map<Furniture,Integer> furnitureOrderMap;

    FurnitureOrder() {
        this.furnitureOrderMap = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        this.furnitureOrderMap.put(type,furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return this.furnitureOrderMap;
    }

    public float getTotalOrderCost() {
        float totalOrderCost = 0.0f;
        for (Map.Entry<Furniture,Integer> furnitureOrderEntry : this.furnitureOrderMap.entrySet()) {
            totalOrderCost = totalOrderCost + (furnitureOrderEntry.getKey().cost()*furnitureOrderEntry.getValue());
        }
        return totalOrderCost;
    }

    public int getTypeCount(Furniture type) {
        int typeCount = 0;
        for (Map.Entry<Furniture,Integer> furnitureOrderEntry : this.furnitureOrderMap.entrySet()) {
            if(furnitureOrderEntry.getKey().label().equals(type.label())){
                typeCount = typeCount + furnitureOrderEntry.getValue();
            }
        }
        return typeCount;
    }

    public float getTypeCost(Furniture type) {
        float typeCost = 0.0f;
        for (Map.Entry<Furniture,Integer> furnitureOrderEntry : this.furnitureOrderMap.entrySet()) {
            if(furnitureOrderEntry.getKey().label().equals(type.label())){
                typeCost = typeCost + furnitureOrderEntry.getKey().cost();
            }
        }
        return typeCost;
    }

    public int getTotalOrderQuantity() {
        return this.furnitureOrderMap.values().stream().mapToInt(Integer::parseInt).sum();
    }
}
