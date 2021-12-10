package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    public static final int CAPACITY = 20;
    private List<Fish> fishs = new ArrayList<>();

    public void addFish(Fish fish) {
        int capacityNeeded = (fishs.size() + 1) * 5;
        if (capacityNeeded > CAPACITY) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
        fishs.add(fish);
    }

    public void feed() {
        for (Fish fish: fishs) {
            fish.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> overWeighted = new ArrayList<>();
        for (Fish fish: fishs) {
            if (fish.getWeight() > maxWeight) {
                overWeighted.add(fish);
            }
        }
        fishs.removeAll(overWeighted);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish fish: fishs) {
            result.add(fish.getStatus());
        }
        return result;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int result = 0;
        for (Fish fish: fishs) {
            if (fish.hasMemoryLoss()) {
                result++;
            }
        }
        return result;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish fish: fishs) {
            if (fish.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        Fish smallest = null;
        for (Fish fish: fishs) {
            if (smallest == null || fish.getWeight() < smallest.getWeight()) {
                smallest = fish;
            }
        }
        return smallest;
    }
}
