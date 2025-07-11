# Librería Validador de Datos 
## Equipo 11
### Descripción General

Este proyecto implementa una herramienta de validación de datos desarrollada en *Java, compuesta por una **librería de validaciones reutilizable* (Validador.java) y una *interfaz gráfica* (VentanaCliente.java) construida con *Java Swing*. El sistema está diseñado para validar entradas comunes en formularios de usuario, como nombre, edad, correo electrónico, teléfono, CURP y descripciones personales.

## Objetivo

Ofrecer una solución modular y reutilizable para validar campos comunes en formularios, que pueda integrarse fácilmente en otros proyectos Java y facilitar el desarrollo de interfaces seguras y consistentes.
##Propósito de la Librería

La librería Validador.java fue diseñada con el propósito de proporcionar una colección de validaciones comunes reutilizables para entradas de usuario, con el fin de facilitar el desarrollo de interfaces gráficas robustas y seguras. Se centra en la validación de textos, números, correos, teléfonos, CURP y cadenas alfabéticas.


## 1. Clase Validador.java

Ubicación: validadores/Validador.java

Esta clase contiene una colección de *métodos estáticos* que permiten validar distintos tipos de datos de entrada. Cada método retorna un valor booleano indicando si la entrada es válida.

### Métodos principales:

- **`noEsNuloNiVacio(String texto)`**  
  Verifica que el texto no sea `null` ni esté vacío o contenga solo espacios.

- **`esPositivo(int numero)`**  
  Evalúa si el número es estrictamente mayor a cero.

- **`esCorreoValido(String correo)`**  
  Utiliza una expresión regular para validar correos electrónicos con el formato estándar `usuario@dominio.com`.

- **`longitudMinima(String texto, int longitud)`**  
  Comprueba que el texto tenga al menos una longitud mínima especificada.

- **`esTelefonoValido(String telefono)`**  
  Valida que el número contenga exactamente 10 dígitos numéricos (formato nacional).

- **`esCurpValida(String curp)`**  
  Utiliza una expresión regular para validar que la CURP mexicana tenga el formato oficial (18 caracteres alfanuméricos, con letras mayúsculas y números).

- **`soloLetras(String texto)`**  
  Valida que el texto contenga exclusivamente letras (mayúsculas o minúsculas), incluyendo acentos y la letra `ñ`. También se permiten espacios.
  
## 2. Clase VentanaCliente.java

Ubicación: clienteValidacion/VentanaCliente.java

Esta clase representa una *interfaz gráfica construida con Java Swing*, que permite al usuario ingresar distintos campos y ver los resultados de la validación en pantalla.
### Campos incluidos:

- `Nombre`: Valida que no esté vacío, que tenga longitud mínima y solo letras.
- `Edad`: Valida que sea un número entero positivo.
- `Correo`: Valida el formato básico de un correo electrónico.
- `Teléfono`: Valida que tenga exactamente 10 dígitos.
- `CURP`: Valida el formato oficial de una CURP mexicana.
- `Descripción personal`: Valida que no esté vacía.


### Lógica del botón "Validar"

Cuando el usuario presiona el botón, se ejecutan las siguientes acciones:

```java
// Obtiene los valores ingresados en los campos
String texto = txtTexto.getText();
String numStr = txtNumero.getText();
String correo = txtCorreo.getText();
String telefono = txtTelefono.getText();
String curp = txtCurp.getText();
String descripcion = txtDescripcion.getText();

// Realiza validaciones y muestra los resultados en etiquetas
lblNulo.setText("Nombre: " + (Validador.noEsNuloNiVacio(texto) ? "VÁLIDO" : "NO VÁLIDO"));
lblLongitud.setText("Longitud: " + (Validador.longitudMinima(texto, 3) ? "VÁLIDO" : "NO VÁLIDO"));
lblSoloLetras.setText("Solo letras: " + (Validador.soloLetras(texto) ? "VÁLIDO" : "NO VÁLIDO"));

// Valida edad
try {
    int numero = Integer.parseInt(numStr);
    lblPositivo.setText("Número positivo: " + (Validador.esPositivo(numero) ? "VÁLIDO" : "NO VÁLIDO"));
} catch (NumberFormatException ex) {
    lblPositivo.setText("Número positivo: NO VÁLIDO (no es número)");
}

// Valida correo
lblCorreo.setText("Correo: " + (Validador.esCorreoValido(correo) ? "VÁLIDO" : "NO VÁLIDO"));

// Valida teléfono
lblTelefono.setText("Teléfono: " + (Validador.esTelefonoValido(telefono) ? "VÁLIDO" : "NO VÁLIDO"));

// Valida CURP
lblCurp.setText("CURP: " + (Validador.esCurpValida(curp) ? "VÁLIDO" : "NO VÁLIDO"));
// Valida descripción
lblDescripcion.setText("Descripción: " + (Validador.noEsNuloNiVacio(descripcion) ? "VÁLIDO" : "NO VÁLIDO"));
```
## Vista Previa de la Interfaz 
### Validación Exitosa
<img width="610" height="907" alt="Captura de pantalla 2025-07-10 211927" src="https://github.com/user-attachments/assets/f725ac3f-9c8d-4068-8309-131586eadba0" />

### Validación Fallida

<img width="607" height="904" alt="Captura de pantalla 2025-07-10 212003" src="https://github.com/user-attachments/assets/e0dc8f12-a74b-484e-8be1-253bf3e4913c" />


## ¿Cómo importar el archivo .jar en otro proyecto?

1. Compila la clase `Validador.java` en tu entorno.
2. Genera el archivo `.jar` desde NetBeans o cualquier IDE Java:
   - En NetBeans: clic derecho en el proyecto → "Clean and Build". El `.jar` se ubicará en la carpeta `dist`.
3. En el proyecto destino:
   - Clic derecho sobre "Libraries" → "Add JAR/Folder...".
   - Selecciona el `.jar` generado.
4. Importa la clase en tu código:
   ```java
   import validadores.Validador;
   ```
5. Ya puedes usar los métodos de validación directamente como:
   ```java
   boolean valido = Validador.esCorreoValido("ejemplo@gmail.com");
   ```
   
## Pasos para Ejecutar el proyecto.


### Requisitos

- Java JDK 8 o superior
- NetBeans IDE (u otro entorno compatible con Swing)
- Sistema operativo Windows, Linux o macOS

### Pasos

1. Clonar o descargar el proyecto.
2. Abrirlo en NetBeans.
3. Verificar que las clases `Validador.java` y `VentanaCliente.java` estén en los paquetes correctos.
4. Ejecutar la clase `VentanaCliente` como aplicación Java.

## Aplicaciones Posibles

- Formularios escolares o universitarios
- Módulos de registro en sistemas administrativos
- Validación en sistemas de salud, empleo o gobierno
- Prevalidación de datos antes de enviarlos a una base de datos

## GITHUB PAGES
https://saul-lt.github.io/Libreria-ValidadorDatos/


## Licencia

Este proyecto se proporciona con fines educativos. Puede ser adaptado, reutilizado o extendido en proyectos académicos o personales.

## Conclusión
Este validador de datos es una herramienta práctica, modular y extensible que puede ser integrada fácilmente en otros proyectos Java. La combinación de una librería independiente de validaciones con una interfaz intuitiva lo hace útil para prototipos, demostraciones académicas y aplicaciones reales.
## Autores

- *Melody Nathalie Mendoza Jiménez*  (https://github.com/Melody-Mendoza)

- *Josué Saúl López Trujillo*
