# 📚 ForoHub API

API REST desarrollada con **Java 17 y Spring Boot** para la gestión de **tópicos de un foro**.
Permite a los usuarios **crear, consultar, actualizar y eliminar tópicos**, utilizando **autenticación JWT** para proteger los endpoints.

Los resultados de consulta están **paginados** para optimizar el rendimiento y el manejo de grandes cantidades de datos.

---

# 🚀 Tecnologías utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Token)**
* **Lombok**
* **Spring Data JPA**
* **MySQL / SQL**
* **Flyway (migraciones de base de datos)**

---

# 🔐 Autenticación

La API utiliza **JWT (JSON Web Token)** para autenticar las solicitudes.

## Flujo de autenticación

1. El usuario envía sus credenciales al endpoint `/auth`.
2. El servidor valida las credenciales.
3. Si son correctas, se genera un **token JWT**.
   
---

# 📌 Endpoints

## 🔑 Autenticación

### POST `/auth`

Autentica al usuario y devuelve un **token JWT**.

### Request

```json
{
  "correoElectronico": "usuario@foro.com",
  "contrasena": "123456"
}
```

### Response

```json
{
  "jwttoken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

# 📝 Tópicos

Todos los endpoints de tópicos requieren **JWT**.

---

# 📌 Crear tópico

### POST `/topicos`

Crea un nuevo tópico en el foro.

### Request

```json
{
  "idUsuario": 1,
  "mensaje": "¿Cómo implementar JWT en Spring?",
  "curso": "Spring Security",
  "titulo": "Duda sobre Spring Security",

}
```

### Response

```json
{
  "id": 1,
  "titulo": "Duda sobre Spring Security",
  "mensaje": "¿Cómo implementar JWT en Spring?",
  "curso": "Spring Boot",
  "fechaCreacion": "2026-03-10T20:30:00.5300096",
  "status": "ABIERTO"
}
```

---

# 📖 Listar tópicos (Paginado)

### GET `/topicos`

Devuelve la lista de tópicos paginados.

### Parámetros opcionales

| Parámetro | Descripción                      |
| --------- | -------------------------------- |
| page      | número de página                 |
| size      | cantidad de registros por página |
| sort      | campo para ordenar               |

### Ejemplo

```
GET /topicos
```

### Response

```json
{
  "content": [
    {
      "id": 1,
      "titulo": "Duda sobre Spring",
      "mensaje": "¿Cómo usar JWT?",
      "curso": "Spring Boot",
      "fechaCreacion": "2026-03-10T20:30:00"
    }
  ],
  "page": {
    "size": 10,
    "number": 0,
    "totalElements": 25,
    "totalPages": 3
  }
}
```

---

# 🔎 Ver un tópico específico

### GET `/topicos/{id}`

Obtiene los detalles de un tópico específico.

### Response

```json
{
  "id": 1,
  "titulo": "Duda sobre Spring",
  "mensaje": "¿Cómo usar JWT?",
  "curso": "Spring Boot",
  "fechaCreacion": "2026-03-10T20:30:00"
  "status":"ABIERTO"
}
```

---

# ✏️ Actualizar un tópico

### PUT `/topicos/{id}`

Actualiza la información de un tópico existente.

### Request

```json
{
  "id":1,
  "curso": "Duda actualizada sobre Spring",
  "titulo": "Necesito ayuda con autenticación JWT",
  "mensaje": "Spring Boot"
}
```

---

# ❌ Eliminar un tópico

### DELETE `/topicos/{id}`

Elimina un tópico del sistema.

---

# ⚙️ Configuración

Archivo `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost/forohub
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=validate

api.security.token.secret=123456
```

---

# ▶️ Ejecutar el proyecto

### 1️⃣ Clonar el repositorio

```
git clone https://github.com/tuusuario/forohub-api.git
```

### 2️⃣ Entrar al proyecto

```
cd forohub
```

### 3️⃣ Ejecutar la aplicación

```
./mvnw spring-boot:run
```

La API estará disponible en:

```
http://localhost:8080
```

---

# 📌 Posibles mejoras

* Sistema de **roles y permisos**
* **Comentarios** en los tópicos
* **Documentación con Swagger / OpenAPI**
* **Cache para consultas frecuentes**
* **Rate limiting**

---

# 👨‍💻 Autor
Santiago Monsalve Zapata
Proyecto desarrollado como práctica de **API REST con Spring Boot, seguridad con JWT y persistencia con JPA**.
