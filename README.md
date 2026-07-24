# Petland

Aplicação Spring Boot desenvolvida acompanhando aulas da plataforma RocketSeat, com foco em uma API para gestão de pet shop. O projeto organiza cadastros, animais, produtos/serviços e atendimentos em uma arquitetura em camadas, usando Spring Boot, JPA, validação, Lombok e PostgreSQL.

## Visão Geral

O Petland foi pensado para centralizar as principais operações de um sistema de pet shop:

- cadastro de pessoas e perfis de acesso/negócio;
- cadastro de animais vinculados a um registro;
- cadastro de produtos e serviços;
- cadastro de atendimentos e agendamentos;
- carga inicial de dados para facilitar testes e demonstrações.

O projeto também serve como exercício prático de boas práticas de organização de código, separação de responsabilidades e uso de padrões clássicos da stack Spring.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Lombok
- Docker Compose
- spring-dotenv
- Maven

## Principais Funcionalidades

### 1. Registros
Módulo responsável pelo cadastro de entidades base do sistema, como clientes, prestadores e fornecedores.

Campos presentes no domínio:

- nome
- e-mail
- endereço completo
- perfil

### 2. Animais
Cadastro de animais associados a um registro.

Campos comuns no domínio:

- nome
- descrição
- espécie
- data de nascimento
- vínculo com o cadastro responsável

### 3. Produtos e Serviços
Cadastro do catálogo da empresa, separando itens de venda e serviços prestados.

Campos comuns no domínio:

- nome
- preço
- indicador de serviço ou produto

### 4. Atendimentos / Customer Services
Registra agendamentos, consultas e eventos ligados a clientes, animais e serviços.

Campos comuns no domínio:

- descrição
- data
- hora
- preço
- emergência
- status
- tipo
- cliente
- animal
- serviço

### 5. Seeds de inicialização
O projeto possui uma rotina de carga inicial para popular o banco com dados de exemplo sempre que a aplicação sobe.

## Arquitetura e Organização

O projeto segue uma arquitetura em camadas, com divisão clara entre responsabilidade de entrada, regra de negócio, persistência e modelo de dados.

Fluxo geral:

- Controller: recebe requisições HTTP e devolve respostas;
- Service: concentra a regra de negócio;
- Repository: faz a comunicação com o banco via JPA;
- DTO: representa os dados de entrada e saída;
- Model/Entity: representa as tabelas e relacionamentos do domínio;
- Exception: padroniza falhas de negócio e recursos inexistentes;
- Utils: contém apoio reutilizável;
- Seeds: popula dados iniciais;
- Start: executa lógica no boot da aplicação.

## Design Patterns e Boas Práticas Usadas

O projeto aplica alguns patterns e decisões de arquitetura bem definidos:

- **Arquitetura em camadas**: separa controller, service e repository para reduzir acoplamento.
- **Repository Pattern**: os repositórios extendem `JpaRepository`, encapsulando acesso a dados.
- **Service Layer**: cada caso de uso fica concentrado em serviços específicos, o que deixa a regra de negócio isolada da camada web.
- **DTO Pattern**: as rotas recebem e processam DTOs em vez de expor diretamente as entidades em toda a entrada da aplicação.
- **Builder Pattern**: usado nas entidades para facilitar a criação de objetos com múltiplos campos.
- **Dependency Injection**: o Spring injeta dependências automaticamente via construtores.
- **CommandLineRunner / ApplicationRunner**: usado para inicialização e seed de dados na subida da aplicação.
- **Enum-based modeling**: estados, tipos e perfis são representados por enums para aumentar a consistência do domínio.
- **Utility de cópia parcial**: o utilitário de mapeamento ajuda a preservar campos não nulos em operações de atualização.

## Estrutura de Pastas

```text
src/main/java/com/jhonecmd/petland/
├── PetlandApplication.java
├── controller/
│   ├── animal/
│   ├── customer_service/
│   ├── productAndservice/
│   └── register/
├── dto/
├── exceptions/
├── model/
│   ├── animal/
│   ├── customer_service/
│   ├── productAndservice/
│   └── register/
├── repository/
├── seeds/
├── service/
│   ├── animal/
│   ├── customer_service/
│   ├── productAndservice/
│   └── register/
├── start/
└── utils/
```

### Responsabilidade de cada pasta

- `controller/`: endpoints REST da aplicação.
- `dto/`: contratos de entrada usados nas requisições.
- `exceptions/`: exceções de domínio e validação de negócio.
- `model/`: entidades e enums do domínio.
- `repository/`: interfaces JPA para persistência.
- `seeds/`: carga inicial de dados.
- `service/`: regras de negócio e orquestração de operações.
- `start/`: inicialização adicional na subida da aplicação.
- `utils/`: helpers reutilizáveis.

## Endpoints Principais

A aplicação expõe rotas REST por domínio.

### Registers
- `POST /register`
- `GET /register`
- `PUT /register/{id}`
- `DELETE /register/{id}`

### Animals
- `POST /animals`
- `GET /animals`
- `PUT /animals/{id}`
- `DELETE /animals/{id}`

### Products and Services
- `POST /products-services`
- `GET /products-services`
- `PUT /products-services/{id}`
- `DELETE /products-services/{id}`

### Customer Services
- `POST /customer-services`
- `GET /customer-services`
- `PUT /customer-services/{id}`
- `DELETE /customer-services/{id}`

## Banco de Dados

A aplicação utiliza PostgreSQL e lê as credenciais por variáveis de ambiente.

### Variáveis esperadas

```env
DATABASE_URL=jdbc:postgresql://localhost:5432/petland
DATABASE_USERNAME=docker
DATABASE_PASSWORD=docker
```

O arquivo `application.properties` está configurado com `ddl-auto=create-drop`, então o schema é recriado quando a aplicação sobe e é descartado quando ela encerra. Isso é útil para desenvolvimento e estudos, mas não é indicado para produção.

## Docker Compose

O projeto inclui um `docker-compose.yml` para subir um banco PostgreSQL local.

### Subir o banco

```bash
docker compose up -d
```

O serviço cria um container PostgreSQL com:

- usuário: `docker`
- senha: `docker`
- banco: `petland`
- porta: `5432`

## Como Executar Localmente

### 1. Subir o banco

```bash
docker compose up -d
```

### 2. Exportar as variáveis de ambiente

```bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/petland
export DATABASE_USERNAME=docker
export DATABASE_PASSWORD=docker
```

### 3. Rodar a aplicação

```bash
./mvnw spring-boot:run
```

Ou, se preferir gerar o build primeiro:

```bash
./mvnw clean package
java -jar target/petland-0.0.1-SNAPSHOT.jar
```

## Dados Iniciais

Na inicialização, a aplicação executa uma rotina de seeds que:

- remove os registros antigos das tabelas principais;
- cria exemplos de registros;
- cria animais vinculados aos registros;
- cria produtos e serviços;
- cria atendimentos com datas, horários e status variados.

Isso facilita testes rápidos e demonstra o fluxo completo da aplicação sem necessidade de cadastro manual inicial.

## Convenções de Código

- nomeação por domínio e funcionalidade;
- separação explícita por contexto de negócio;
- uso de `@Valid` para validação de payloads;
- respostas HTTP com `ResponseEntity`;
- tratamento simples de erros de negócio nas rotas;
- entidades criadas com `builder()` para melhorar legibilidade;
- repositórios com consultas derivadas do Spring Data quando necessário.

## Observações

- O projeto foi desenvolvido como estudo prático acompanhando aulas da RocketSeat.
- A estrutura atual privilegia aprendizado, organização e clareza do domínio.
- Como o schema está em modo `create-drop`, os dados não são persistidos entre reinicializações.

## Testes

Há uma suíte inicial de testes no projeto. Para executá-la:

```bash
./mvnw test
```

## Licença

Projeto acadêmico/didático, sem licença formal definida no momento.
