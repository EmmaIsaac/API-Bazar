# 🧾 Sistema de Gestión de Ventas para Bazar

Este proyecto implementa una API REST en Java (Spring Boot) para gestionar las operaciones de un bazar. Permite realizar un seguimiento de productos, clientes y ventas de forma centralizada, accesible tanto desde una aplicación web como desde una futura aplicación mobile.

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Base de Datos Relacional (MySQL / H2)
- Maven

## 📦 Modelado de Entidades

### Producto
- `Long codigo_producto`
- `String nombre`
- `String marca`
- `Double costo`
- `Double cantidad_disponible`

### Cliente
- `Long id_cliente`
- `String nombre`
- `String apellido`
- `String dni`

### Venta
- `Long codigo_venta`
- `LocalDate fecha_venta`
- `Double total`
- `List<Producto> listaProductos`
- `Cliente unCliente`

## 📡 Endpoints Disponibles

### 🛍️ Productos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST   | `/productos/crear` | Crear un nuevo producto |
| GET    | `/productos` | Obtener todos los productos |
| GET    | `/productos/{codigo_producto}` | Obtener un producto específico |
| DELETE | `/productos/eliminar/{codigo_producto}` | Eliminar un producto |
| PUT    | `/productos/editar` | Editar un producto existente |
| GET    | `/productos/falta_stock` | Obtener productos con stock menor a 5 |

---

### 👤 Clientes

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST   | `/clientes/crear` | Crear un nuevo cliente |
| GET    | `/clientes` | Obtener todos los clientes |
| GET    | `/clientes/{id_cliente}` | Obtener un cliente específico |
| DELETE | `/clientes/eliminar/{id_cliente}` | Eliminar un cliente |
| PUT    | `/clientes/editar` | Editar un cliente existente |

---

### 💸 Ventas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST   | `/ventas/crear` | Crear una nueva venta |
| GET    | `/ventas` | Obtener todas las ventas |
| GET    | `/ventas/{codigo_venta}` | Obtener una venta específica |
| DELETE | `/ventas/eliminar/{codigo_venta}` | Eliminar una venta |
| PUT    | `/ventas/editar` | Editar una venta existente |
| GET    | `/ventas/productos/{codigo_venta}` | Obtener productos de una venta |
| GET    | `/ventas/fecha` | Obtener suma total y cantidad de ventas en una fecha |
| GET    | `/ventas/mayor_venta` | Obtener la venta con el mayor monto (usando DTO) |



## 📱 Arquitectura

Este backend servirá tanto para:
- Una aplicación web (Frontend no incluido en este repositorio).
- Una futura aplicación mobile, reutilizando la misma API REST.

---

## 🛠️ Instalación

1. Clonar el repositorio.
2. Configurar las credenciales de la base de datos en `application.properties`.
3. Ejecutar el proyecto con Maven:

```bash
mvn spring-boot:run

````

4. Acceder a los endpoints en http://localhost:8080.

