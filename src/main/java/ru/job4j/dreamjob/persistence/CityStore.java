package ru.job4j.dreamjob.persistence;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CityStore {

    private final Map<Integer, City> cities = new ConcurrentHashMap<>();

    public CityStore() {
        cities.put(1, new City(1, "Москва"));
        cities.put(2, new City(2, "Санкт-Петербург"));
        cities.put(3, new City(3, "Екатеринбург"));
        cities.put(4, new City(4, "Лондон"));
        cities.put(5, new City(5, "Лос-Анджелес"));
        cities.put(6, new City(6, "Берлин"));
        cities.put(7, new City(7, "Минск"));
        cities.put(8, new City(8, "Тель-Авив"));
        cities.put(9, new City(9, "Нью-Йорк"));
    }

    public List<City> getAllCities() {
        return new ArrayList<>(cities.values());
    }

    public City findById(int id) {
        return cities.get(id);
    }
}
