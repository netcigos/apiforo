# API REST Foro Alura Challenger

## Descripción
Este proyecto implementa una API REST para realizar operaciones CRUD sobre los tópicos de un foro web. Es parte de un desafío que involucra el desarrollo de una API completa utilizando las mejores prácticas.

---

## Tecnologías utilizadas

- **Lenguaje**: Java 17
- **Framework**: Spring Boot
- **Autenticación**: JWT Token con Spring Security
- **Persistencia**: Spring Data JPA con base de datos MySQL
- **Documentación**: Spring Docs
- **Dependencias**: Maven
- **Utilidades**:
  - Lombok
  - Validation

---

## Endpoints de la API

### Autenticación
#### POST `/login`
Este endpoint permite a los usuarios autenticarse para obtener acceso a la API.

**Body JSON:**
```json
{
  "login": "emmanuel",
  "clave": "123456"
}
```

---

### Operaciones sobre Tópicos

#### 1. POST `/topicos`
Registra un nuevo tópico en el foro.

**Headers:**
- `Authorization: Bearer <JWT>`

**Body JSON:**
```json
{
  "usuario_id": "1",
  "titulo": "Hacer un Api Rest",
  "mensaje": "Como puedo hacer un api rest en spring boot en java",
  "nombredelcurso": "Alura Framework Spring boot"
}
```

---

#### 2. GET `/topicos`
Obtiene una lista de todos los tópicos almacenados.

---

#### 3. GET `/topicos/{id}`
Obtiene los detalles de un tópico específico.

---

#### 4. PUT `/topicos/{id}`
Actualiza un tópico específico.

**Headers:**
- `Authorization: Bearer <JWT>`

**Body JSON:**
```json
{
  "titulo": "Actualizar título",
  "mensaje": "Nuevo mensaje sobre el tópico",
  "nombredelcurso": "Nuevo curso"
}
```

---

#### 5. DELETE `/topicos/{id}`
Elimina un tópico específico de forma física en la base de datos.

**Headers:**
- `Authorization: Bearer <JWT>`

---

## Configuración del proyecto

1. **Clonar el repositorio**:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd foro-alura-challenger
   ```

2. **Configurar la base de datos**:
   Asegúrate de tener una instancia de MySQL corriendo y modifica el archivo `application.properties` o `application.yml` con tus credenciales y configuración:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/foro
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

3. **Compilar y ejecutar**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## Consideraciones

- Asegúrate de usar un cliente HTTP (como Postman o cURL) para probar los endpoints.
- Los tokens JWT deben ser enviados en el encabezado `Authorization` con el formato: `Bearer <JWT>`.

---

## Autor
- **Nombre**: [Tu nombre o alias]
- **Contacto**: [Tu email o redes sociales]


