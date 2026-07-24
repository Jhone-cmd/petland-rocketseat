package com.jhonecmd.petland.seeds;

import com.jhonecmd.petland.model.animal.AnimalEntity;
import com.jhonecmd.petland.model.animal.AnimalSpecie;
import com.jhonecmd.petland.model.customer_service.CustomerServiceEntity;
import com.jhonecmd.petland.model.customer_service.CustomerServiceStatus;
import com.jhonecmd.petland.model.customer_service.CustomerServiceType;
import com.jhonecmd.petland.model.productAndservice.ProductAndServiceEntity;
import com.jhonecmd.petland.model.register.FullAddress;
import com.jhonecmd.petland.model.register.Profile;
import com.jhonecmd.petland.model.register.RegisterEntity;
import com.jhonecmd.petland.repository.AnimalRepository;
import com.jhonecmd.petland.repository.CustomerServiceRepository;
import com.jhonecmd.petland.repository.ProductAndServiceRepository;
import com.jhonecmd.petland.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SeedsRunner {

    private final RegisterRepository registerRepository;
    private final AnimalRepository animalRepository;
    private final ProductAndServiceRepository productAndServiceRepository;
    private final CustomerServiceRepository customerServiceRepository;

    @Bean
    public CommandLineRunner runSeeds() {
        return args -> {

            // Limpeza dos dados
            customerServiceRepository.deleteAll();
            animalRepository.deleteAll();
            productAndServiceRepository.deleteAll();
            registerRepository.deleteAll();

            // --- 1. REGISTROS (CLIENTES, PRESTADORES E FORNECEDORES) ---
            FullAddress address1 = new FullAddress("Rua das Flores", "123");
            FullAddress address2 = new FullAddress("Avenida Central", "456 B");
            FullAddress address3 = new FullAddress("Niterói", "1789");
            FullAddress address4 = new FullAddress("Alameda dos Anjos", "88");
            FullAddress address5 = new FullAddress("Rua São Paulo", "1020");

            RegisterEntity register1 = new RegisterEntity("John Doe", "johndoe@email.com", address1, Profile.CLIENT);
            RegisterEntity register2 = new RegisterEntity("Jane Doe", "janedoe@email.com", address2, Profile.PROVIDER);
            RegisterEntity register3 = new RegisterEntity("Maria Doe", "mariadoe@email.com", address3, Profile.SUPPLIER);
            RegisterEntity register4 = new RegisterEntity("Carlos Silva", "carlos.silva@email.com", address4, Profile.CLIENT);
            RegisterEntity register5 = new RegisterEntity("Dra. Amanda Lima", "amanda.vet@email.com", address5, Profile.PROVIDER);

            registerRepository.saveAll(List.of(register1, register2, register3, register4, register5));

            // --- 2. ANIMAIS ---
            AnimalEntity animal1 = new AnimalEntity(
                    "Bob",
                    "Cachorro da Raça Labrador.",
                    AnimalSpecie.DOG,
                    LocalDate.of(2023, 1, 2),
                    register1.getId()
            );

            AnimalEntity animal2 = new AnimalEntity(
                    "Belinha",
                    "Gata mansa.",
                    AnimalSpecie.CAT,
                    LocalDate.of(2024, 6, 24),
                    register1.getId()
            );

            AnimalEntity animal3 = new AnimalEntity(
                    "Red",
                    "Pássaro Sabiá.",
                    AnimalSpecie.BIRDS,
                    LocalDate.of(2023, 5, 3),
                    register1.getId()
            );

            AnimalEntity animal4 = new AnimalEntity(
                    "Thor",
                    "Golden Retriever brincalhão.",
                    AnimalSpecie.DOG,
                    LocalDate.of(2022, 11, 15),
                    register4.getId()
            );

            AnimalEntity animal5 = new AnimalEntity(
                    "Luna",
                    "Gata Siamês com olhos azuis.",
                    AnimalSpecie.CAT,
                    LocalDate.of(2025, 2, 10),
                    register4.getId()
            );

            animalRepository.saveAll(List.of(animal1, animal2, animal3, animal4, animal5));

            // --- 3. PRODUTOS E SERVIÇOS ---
            ProductAndServiceEntity service1 = new ProductAndServiceEntity("Tosa Higiênica", 120.50, true);
            ProductAndServiceEntity service2 = new ProductAndServiceEntity("Exame de Sangue", 75.60, true);
            ProductAndServiceEntity service3 = new ProductAndServiceEntity("Consulta Veterinária", 200.00, true);
            ProductAndServiceEntity service4 = new ProductAndServiceEntity("Vacinação Antirrábica", 85.00, true);

            ProductAndServiceEntity product1 = new ProductAndServiceEntity("Coleira", 41.56, false);
            ProductAndServiceEntity product2 = new ProductAndServiceEntity("Ração Premium 10kg", 189.90, false);
            ProductAndServiceEntity product3 = new ProductAndServiceEntity("Brinquedo Mordedor", 25.00, false);

            productAndServiceRepository.saveAll(List.of(
                    service1, service2, service3, service4,
                    product1, product2, product3
            ));

            // --- 4. ATENDIMENTOS (CUSTOMER SERVICE) ---
            CustomerServiceEntity appointment1 = new CustomerServiceEntity(
                    "Tosa higiênica e banho completo para o Bob",
                    LocalDate.now().plusDays(1),
                    LocalTime.of(14, 30),
                    service1.getPrice(),
                    false,
                    CustomerServiceStatus.SCHEDULED,
                    CustomerServiceType.SANITIZATION,
                    register1.getId(),
                    animal1.getId(),
                    service1.getId()
            );

            CustomerServiceEntity appointment2 = new CustomerServiceEntity(
                    "Exame de Sangue para a Belinha",
                    LocalDate.now(),
                    LocalTime.of(8, 0),
                    service2.getPrice(),
                    false,
                    CustomerServiceStatus.IN_PROGRESS,
                    CustomerServiceType.EXAMINATION,
                    register1.getId(),
                    animal2.getId(),
                    service2.getId()
            );

            CustomerServiceEntity appointment3 = new CustomerServiceEntity(
                    "Consulta emergencial - Thor ingeriu objeto estranho",
                    LocalDate.now(),
                    LocalTime.of(10, 15),
                    300.0,
                    true,
                    CustomerServiceStatus.COMPLETED,
                    CustomerServiceType.CONSULTATION,
                    register4.getId(),
                    animal4.getId(),
                    service3.getId()
            );

            CustomerServiceEntity appointment4 = new CustomerServiceEntity(
                    "Aplicação de vacina anual na Luna",
                    LocalDate.now().plusDays(3),
                    LocalTime.of(16, 0),
                    service4.getPrice(),
                    false,
                    CustomerServiceStatus.SCHEDULED,
                    CustomerServiceType.VACCINATION,
                    register4.getId(),
                    animal5.getId(),
                    service4.getId()
            );

            customerServiceRepository.saveAll(List.of(appointment1, appointment2, appointment3, appointment4));

            System.out.println("✅ Seeds salvos com sucesso!");
        };
    }
}