package com.jhonecmd.petland.seeds;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.model.animal.AnimalSpecie;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.model.register.FullAddress;
import com.jhonecmd.petland.model.register.Profile;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;
import com.jhonecmd.petland.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SeedsRunner {

    private final RegisterRepository registerRepository;
    private final AnimalRepository animalRepository;
    private final ProductAndServiceRepository productAndServiceRepository;

    @Bean
    public CommandLineRunner runSeeds() {
        return args -> {

            registerRepository.deleteAll();
            animalRepository.deleteAll();
            productAndServiceRepository.deleteAll();

            FullAddress address1 = new FullAddress("Rua das Flores", "123");
            FullAddress address2 = new FullAddress("Avenida Central", "456 B");
            FullAddress address3 = new FullAddress("Niterói", "1789");

            RegisterEntity register1 = new RegisterEntity("John Doe", "johndoe@email.com", address1, Profile.CLIENT);
            RegisterEntity register2 = new RegisterEntity("Jane Doe", "janedoe@email.com", address2, Profile.PROVIDER);
            RegisterEntity register3 = new RegisterEntity("Maria Doe", "mariadoe@email.com", address3, Profile.SUPPLIER);

            registerRepository.saveAll(List.of(register1, register2, register3));

            AnimalEntity animal1 = new AnimalEntity(
                    "Bob",
                    "Cachorro da Raça Labrador.",
                    AnimalSpecie.DOG,
                    LocalDate.of(2026, 1, 2)
            );

            AnimalEntity animal2 = new AnimalEntity(
                    "Belinha",
                    "Gata mansa.",
                    AnimalSpecie.CAT,
                    LocalDate.of(2024, 6, 24)
            );

            AnimalEntity animal3 = new AnimalEntity(
                    "Red",
                    "Pássaro Sabiá",
                    AnimalSpecie.BIRDS,
                    LocalDate.of(2023, 5, 3)
            );

            animalRepository.saveAll(List.of(animal1, animal2, animal3));

            ProductAndServiceEntity service1 = new ProductAndServiceEntity("Tosa", 120.50, true);
            ProductAndServiceEntity service2 = new ProductAndServiceEntity("Creche", 75.60, true);
            ProductAndServiceEntity product = new ProductAndServiceEntity("Coleira", 41.56, false);

            productAndServiceRepository.saveAll(List.of(service1,service2,product));

            System.out.println("✅ Seeds salvos com sucesso!");
        };
    }
}