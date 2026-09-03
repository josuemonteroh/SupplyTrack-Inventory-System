# SupplyTrack Inventory System

SupplyTrack is a collaborative inventory and supplier management web application developed with Java, Spring Boot, Thymeleaf, and MySQL.

The system was built as an academic software development project at Universidad Fidélitas, applying a layered MVC architecture, relational database integration, CRUD operations, server-side rendering, validation, and collaborative development practices using Git and GitHub.

The project models an inventory management environment where products, suppliers, categories, stores, and inventory information can be managed through a structured web application.

---

## Project Overview

SupplyTrack was designed to provide a centralized web-based solution for managing inventory-related operations.

The application combines a Spring Boot backend with Thymeleaf-based server-side views and MySQL persistence through Spring Data JPA and Hibernate.

Its architecture separates the application into domain, repository, service, controller, and presentation layers, providing practical experience with the structure of a Java enterprise-style web application.

The project was developed collaboratively using feature branches, pull requests, integration, and testing before changes were incorporated into the main development flow.

---

## Main Features

- Product management
- Supplier management
- Category management
- Store management
- Inventory management
- Product search
- Inventory queries by store
- Database-backed dashboard counters
- CRUD operations
- Form and entity validation
- Relational database persistence
- Reusable Thymeleaf fragments
- Shared application layouts
- Responsive web interface
- Modular application structure
- Safe placeholder views for modules that remained under development

---

## Implemented Modules

### Products

The Product module manages product information through the different layers of the application.

Its implementation includes:

- Product domain entity
- Spring Data JPA repository
- Service layer
- Spring MVC controller
- Thymeleaf views
- Database persistence
- Product listing and management
- Integration with categories and stores

### Suppliers

The Supplier module provides functionality for managing supplier information through CRUD operations and database persistence.

The project also includes domain support for supplier companies as part of the broader business model.

### Categories

Categories are managed as structured entities rather than simple text values.

The module includes:

- Domain model
- Repository
- Service
- Controller
- Thymeleaf views
- Integration with product management

### Stores

The Store module manages store information and its relationship with other parts of the inventory system.

Implemented functionality includes:

- Store creation
- Store editing
- Store deletion
- Validation
- Database persistence
- Integration with products and inventory

### Inventory

The Inventory module manages inventory information stored in the database and connects products with their corresponding inventory context.

The application includes dedicated inventory controllers, services, repositories, domain models, and Thymeleaf views.

### Queries

SupplyTrack includes dedicated consultation functionality for retrieving operational information.

Implemented queries include:

- Product search
- Inventory by store

### Dashboard

The main dashboard provides an overview of information stored in the system.

Database-backed counters are used to display real application data rather than static values.

---

## Domain Model

SupplyTrack contains a broader domain model designed around inventory and business operations.

The application includes entities for:

- Product
- Category
- Inventory
- Supplier
- Supplier Company
- Store
- User
- Role
- Purchase Order
- Purchase Order Detail
- Reception
- Reception Detail
- Invoice
- Invoice Detail
- Inventory Adjustment
- Transfer

Some entities form part of the application's broader domain structure even when their complete user-facing modules were not finished during the academic development period.

This distinction allows the repository to document the intended business model without presenting unfinished modules as completed functionality.

---

## Architecture

SupplyTrack follows a layered application architecture based on Spring MVC.

```text
Browser
   |
   v
Thymeleaf Views
   |
   v
Spring MVC Controllers
   |
   v
Service Layer
   |
   v
Spring Data JPA Repositories
   |
   v
MySQL Database
```

The main responsibilities are separated into:

```text
controller/
domain/
repository/
service/
resources/templates/
```

### Controller Layer

Handles HTTP requests, coordinates application operations, prepares data for the views, and connects the web interface with the service layer.

### Service Layer

Contains application logic and coordinates operations between controllers and repositories.

### Repository Layer

Provides database access through Spring Data JPA repositories.

### Domain Layer

Contains the entities representing the application's inventory and business model.

### Presentation Layer

Uses Thymeleaf templates, Bootstrap, reusable fragments, and shared layouts to render the web interface.

---

## Technology Stack

### Backend

- Java 17
- Spring Boot 4
- Spring MVC
- Spring Data JPA
- Hibernate ORM
- Bean Validation
- Lombok

### Frontend

- HTML5
- CSS3
- JavaScript
- Thymeleaf
- Bootstrap 5
- Font Awesome
- jQuery

### Database

- MySQL

### Build & Development

- Maven
- Git
- GitHub

---

## Persistence Layer

Database persistence is implemented using Spring Data JPA with Hibernate ORM and MySQL.

The project uses repository interfaces for multiple domain entities, including:

```text
AjusteInventarioRepository
CategoriaRepository
DetalleFacturaRepository
DetalleOrdenCompraRepository
DetalleRecepcionRepository
EmpresaProveedoraRepository
FacturaRepository
InventarioRepository
OrdenCompraRepository
ProductoRepository
ProveedorRepository
RecepcionRepository
RolRepository
TiendaRepository
TrasladoRepository
UsuarioRepository
```

This structure provides a dedicated persistence layer while keeping database access separated from controllers and presentation logic.

---

## Web Interface

The frontend is rendered server-side using Thymeleaf.

The application organizes templates by module:

```text
templates/
├── categoria/
│   ├── fragmentos.html
│   └── listado.html
│
├── consultas/
│   ├── busqueda-productos.html
│   └── inventario-por-tienda.html
│
├── fragments/
│   ├── footer.html
│   └── header.html
│
├── general/
│   ├── en-desarrollo.html
│   └── fragmentos.html
│
├── inventario/
│   ├── fragmentos.html
│   └── listado.html
│
├── productos/
│   ├── fragmentos.html
│   └── listado.html
│
├── proveedor/
│   ├── fragmentos.html
│   └── listado.html
│
├── tienda/
│
└── index.html
```

Reusable Thymeleaf fragments are used to maintain common interface elements and reduce duplication across the application.

---

## Project Structure

```text
src/main/
├── java/com/proyecto/SupplyTrack/
│   │
│   ├── controller/
│   │   ├── CategoriaController.java
│   │   ├── ConsultaController.java
│   │   ├── IndexController.java
│   │   ├── InventarioController.java
│   │   ├── ProductoController.java
│   │   ├── ProveedorController.java
│   │   └── TiendaController.java
│   │
│   ├── domain/
│   │   ├── AjusteInventario.java
│   │   ├── Categoria.java
│   │   ├── DetalleFactura.java
│   │   ├── DetalleOrdenCompra.java
│   │   ├── DetalleRecepcion.java
│   │   ├── EmpresaProveedora.java
│   │   ├── Factura.java
│   │   ├── Inventario.java
│   │   ├── OrdenCompra.java
│   │   ├── Producto.java
│   │   ├── Proveedor.java
│   │   ├── Recepcion.java
│   │   ├── Rol.java
│   │   ├── Tienda.java
│   │   ├── Traslado.java
│   │   └── Usuario.java
│   │
│   ├── repository/
│   │   ├── AjusteInventarioRepository.java
│   │   ├── CategoriaRepository.java
│   │   ├── DetalleFacturaRepository.java
│   │   ├── DetalleOrdenCompraRepository.java
│   │   ├── DetalleRecepcionRepository.java
│   │   ├── EmpresaProveedoraRepository.java
│   │   ├── FacturaRepository.java
│   │   ├── InventarioRepository.java
│   │   ├── OrdenCompraRepository.java
│   │   ├── ProductoRepository.java
│   │   ├── ProveedorRepository.java
│   │   ├── RecepcionRepository.java
│   │   ├── RolRepository.java
│   │   ├── TiendaRepository.java
│   │   ├── TrasladoRepository.java
│   │   └── UsuarioRepository.java
│   │
│   ├── service/
│   │   ├── CategoriaService.java
│   │   ├── ConsultaService.java
│   │   ├── EmpresaProveedoraService.java
│   │   ├── InventarioService.java
│   │   ├── ProductoService.java
│   │   ├── ProveedorService.java
│   │   └── TiendaService.java
│   │
│   └── SupplyTrackApplication.java
│
└── resources/
    ├── static/
    │   └── img/
    │
    ├── templates/
    │   ├── categoria/
    │   ├── consultas/
    │   ├── fragments/
    │   ├── general/
    │   ├── inventario/
    │   ├── productos/
    │   ├── proveedor/
    │   ├── tienda/
    │   └── index.html
    │
    └── application.properties
```

---

## My Contribution

My contributions to SupplyTrack focused primarily on product development, database integration, system stability, and improvements to the web interface.

### Product Module

I implemented the Product module across multiple application layers, including:

- Product entity updates
- Spring Data JPA repository integration
- Service layer
- Spring MVC controller
- Thymeleaf views
- Database configuration
- Integration of the module into the existing application structure

The module was developed through a dedicated development branch and later integrated into the team's main development workflow through a pull request.

### Database

I updated and refined the database schema required by the application and contributed to connecting application functionality with persistent data.

### Store Module Stability

I worked on improving the stability of Store CRUD operations, including:

- Validation fixes
- Store creation
- Store editing
- Store deletion
- Error prevention during CRUD workflows

### Dashboard

I improved the dashboard by connecting its counters to real information retrieved from the database.

### UI and Thymeleaf Structure

I also contributed to interface and structural improvements, including:

- Application branding
- Sidebar and dashboard visual improvements
- Thymeleaf fragment refactoring
- Reusable interface organization
- Improvements to the module-under-development view
- Safer navigation to unfinished sections

These changes helped improve both application stability and consistency across the user interface.

---

## Collaborative Development

SupplyTrack was developed as a team project using Git and GitHub.

The workflow included:

- Dedicated development branches
- Feature development
- Pull requests
- Code integration
- Collaborative testing
- Main branch integration

My Product module was developed through the dedicated:

```text
DEV-josue
```

branch and subsequently integrated into the project's development flow through a pull request.

This project provided practical experience working with a shared codebase where different team members were responsible for different application modules.

---

## Running the Project

### Requirements

Before running SupplyTrack, the following tools are required:

- Java 17
- Maven
- MySQL
- Git

### Clone the Repository

```bash
git clone https://github.com/josuemonteroh/SupplyTrack-Inventory-System.git
cd SupplyTrack-Inventory-System
```

### Database Configuration

Configure the MySQL connection in:

```text
src/main/resources/application.properties
```

The required Spring datasource properties typically include:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD
```

Use the database configuration appropriate for your local environment.

### Run with Maven

```bash
mvn spring-boot:run
```

If the repository includes Maven Wrapper files, the application can alternatively be started with:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Once the application starts successfully, access it using the local server address configured by Spring Boot.

---

## Academic Context

SupplyTrack was developed as a collaborative academic project during my Computer Systems Engineering studies at Universidad Fidélitas.

The project provided practical experience with:

- Java web development
- Spring Boot
- Spring MVC
- Layered application architecture
- Spring Data JPA
- Hibernate ORM
- MySQL
- Relational database integration
- CRUD development
- Server-side rendering with Thymeleaf
- Form validation
- Maven
- Git
- GitHub
- Branch-based collaborative development
- Pull requests
- Integration of independently developed modules

---

## Key Learning Outcomes

Through SupplyTrack, I gained practical experience working across multiple layers of a Java web application rather than focusing exclusively on frontend or database development.

The project strengthened my understanding of:

- How Spring MVC applications are structured
- How controllers, services, repositories, and entities interact
- How Spring Data JPA connects application logic with relational persistence
- How Hibernate maps Java entities to database structures
- How Thymeleaf integrates backend data into server-rendered views
- How CRUD workflows are implemented across multiple layers
- How database-backed dashboards retrieve dynamic application information
- How modular development works in a shared Git repository
- How feature branches and pull requests support collaborative software development

---

## Status

**Completed Academic Project**

SupplyTrack is maintained as part of my software development portfolio and documents my practical experience with Java, Spring Boot, relational databases, MVC architecture, and collaborative development.
