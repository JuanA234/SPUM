# 🛠️ SPUM Backend

Este es el backend del sistema **SPUM** (Sistema de Préstamo Universitario de Material), desarrollado con **Spring Boot**. Proporciona una API RESTful para gestionar usuarios, estudiantes, artículos, reservas y penalizaciones en una institución educativa.

---

## 📦 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Security con JWT
- JPA (Hibernate)
- PostgreSQL
- Maven

---

## ⚙️ Configuración e instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/spum_backend.git
   cd spum_backend
   ```

2. **Configurar base de datos en application.properties**
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/spum
   spring.datasource.username=postgres
   spring.datasource.password=1234
   ```

3. **Compilar y ejecutar**
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 🔐 Autenticación

El sistema utiliza JWT. Se requiere autenticarse para consumir recursos protegidos.

### Endpoints de autenticación:

- **Registro de usuario:**
  ```
  POST /auth/register-user
  ```

- **Registro de estudiante:**
  ```
  POST /auth/register-student
  ```

- **Login:**
  ```
  POST /auth/login
  ```

Devuelve un token JWT que debe ser usado en el header `Authorization: Bearer {token}`.

---

## 📚 Endpoints principales

### 🎓 Estudiantes
- `GET /students` – Listar todos
- `DELETE /students/{email}` – Eliminar estudiante

### 👤 Usuarios
- `GET /users` – Listar usuarios
- `PUT /users/{id}` – Editar rol de usuario
- `DELETE /users/{id}` – Eliminar usuario

### 📦 Artículos y categorías
- `POST /categories` – Crear tipo de artículo
- `GET /categories` – Listar tipos
- `DELETE /categories/{id}` – Eliminar tipo
- `POST /items` – Crear artículo
- `GET /items` – Listar artículos

### 📆 Reservas
- `POST /bookings` – Crear reserva
- `GET /bookings/status/IN_PROCESS` – Ver reservas activas

---

## 🧪 Pruebas con Postman

Puedes importar el archivo de colección `SPUM.postman_collection.json` en Postman y probar todos los endpoints con ejemplos ya listos.

👉 [Colección SPUM en Postman](https://dark-station-5492176.postman.co/workspace/Juan-Avenda%C3%B1o's-Workspace~114dd96d-7017-46ee-89ea-ff60e87ae903/collection/45173369-9882fead-00f5-4816-b055-7aee69fcec2a?action=share&creator=45173369&active-environment=45173369-370b77fb-44d3-4ec8-be5c-7225de94450c)

---

## ⏱️ Tareas automatizadas

El proyecto incluye tareas programadas para revisar y asignar penalidades automáticamente según el estado de las reservas.

---

## 👨‍💻 Autores

* **Juan Andrés Avendaño Luján**
* **Rafael Eduardo Ortiz Reales**
* **David de Jesus Giraldo Luna**
* **Arturo Andrés Velásquez Ortiz**
