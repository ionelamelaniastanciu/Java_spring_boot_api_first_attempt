package com.rest_api_java.api;

import com.rest_api_java.api.manage_files.ManageCounties;
import com.rest_api_java.api.manage_files.ManageLocalities;
import com.rest_api_java.api.model.County;
import com.rest_api_java.api.model.Locality;
import com.rest_api_java.api.repositories.CountyRepository;
import com.rest_api_java.api.repositories.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan({"com.rest_api_java.api.repositories", "com.rest_api_java.api.controllers", "com.rest_api_java.api.services"})
public class ApiApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(ApiApplication.class, args);
    }

    //----------------------------------------------------------------------

    @Autowired
    private CountyRepository countyRepository;

    @Autowired
    private LocalityRepository localityRepository;

    @Override
    public void run(String... args) throws Exception {

           manageCounties();
           manageLocalities();
    }

    //----------------------------------------------------------------------

    public void manageCounties() throws Exception {

        List<County> localities = new ManageCounties().readCounties();
        localities.forEach(x -> {
            if (!countyRepository.existsById(x.getIdCounty()))
                countyRepository.save(x);
        });
        //  countyRepository.saveAll(readCounties());
    }

    //----------------------------------------------------------------------

    public void manageLocalities() throws IOException {

        List<Locality> localities = new ManageLocalities().readLocalities();
        localities.forEach(x -> {
            if (!localityRepository.existsById(x.getIdLocality()))
                localityRepository.save(x);
        });
//        localityRepository.saveAll(readLocalities());
    }
}
