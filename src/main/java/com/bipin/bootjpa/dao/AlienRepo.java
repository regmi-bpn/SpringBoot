package com.bipin.bootjpa.dao;

import com.bipin.bootjpa.model.Alien;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer>
{
        List<Alien> findByTech(String tech);
}
