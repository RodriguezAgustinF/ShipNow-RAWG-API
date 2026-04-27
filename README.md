# Requisitos del sistema

- Java JDK 17 o superior instalado
- JAVA_HOME configurado correctamente
- Maven Wrapper incluido en el proyecto (no requiere instalación de Maven)

# Como ejecutar el script

## 1. Clonar el repositorio
Primero hay que clonar el repositorio y pararse en la carpeta del script desde la terminal.

git clone &lt;repo&gt;

cd &lt;repo&gt;

## 2. Configurar la API Key

Antes de ejecutar el proyecto, crear una variable de entorno:

### Windows (PowerShell)
$env:API_KEY="tu_api_key"

### Mac / Linux
export API_KEY=tu_api_key

## 3. Ejecutar el script

Para ejecutar el script utilizar el comando .\mvnw.cmd compile exec:java desde la misma terminal.

## Acerca del ejercicio

Uno de los principales retos del proyecto fue el tratamiento de los requisitos mínimos de los videojuegos obtenidos desde la API de RAWG.

Los datos recibidos no siguen un formato único ni consistente. En algunos casos se entregan como texto plano, mientras que en otros vienen como HTML embebido dentro del JSON, incluyendo etiquetas como &lt;strong&gt;, &lt;ul&gt; y &lt;li&gt;.

Además, incluso en los casos de texto plano, la información no siempre venía bien estructurada: en varias respuestas las palabras aparecían sin separaciones claras o con formatos concatenados, lo que dificultaba aún más su interpretación.

Esto hizo que el procesamiento de esta información fuera complejo, ya que no existía una estructura confiable que permitiera separar correctamente cada requisito (OS, memoria, gráficos, etc.) para poder utilizarlos en operaciones como el ordenamiento de videojuegos.

Se intentaron enfoques basados en expresiones regulares para extraer y separar los distintos campos, pero debido a la inconsistencia y variabilidad del formato de los datos, no logre una solución completamente fiable.

Por este motivo, decidi no realizar una normalización avanzada de estos datos y priorizar el funcionamiento general del sistema, enfocado en el consumo de la API y exportación de la información.
