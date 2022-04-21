package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.persistence.CityStore;

import java.util.List;

@Service
public class CityService {
    private final CityStore store;

    public CityService(CityStore store) {
        this.store = store;
    }

    public List<City> getAllCities() {
        return store.getAllCities();
    }

    public City findById(int id) {
        return store.findById(id);
    }
}
