# Java-9-Conversor-de-Monedas

Este proyecto es una aplicación de consola en Java que permite convertir diferentes divisas utilizando una API de tasas de cambio en tiempo real.

🚀 Características
Conversión entre pares comunes: Convierte directamente entre USD, ARS, BRL, etc

Conversión personalizada: Permite al usuario especificar cualquier tipo de cambio de origen y destino compatible con la API.

Interfaz de menú: Navegación sencilla a través de opciones numeradas.

Validación de entrada: Manejo básico de errores para entradas no numéricas.

Reutilización: Permite realizar múltiples conversiones en una misma sesión.

🛠️ Tecnologías Utilizadas
Java 21

Librerías: Para la conexión a la API y el manejo de JSON (como Gson).

⚙️ Cómo Funciona
La aplicación se conecta a una API externa para obtener las tasas de cambio más recientes. Cuando el usuario selecciona un par de monedas y una cantidad, la aplicación realiza una solicitud a la API, procesa la respuesta y muestra el resultado de la conversión.

🏁 Cómo Empezar
Prerrequisitos
Asegúrate de tener instalado el Java Development Kit (JDK) 17 o superior.

Ejecución
Clona el repositorio: (Si tu proyecto está en un repositorio, de lo contrario, puedes omitir este paso o indicar cómo obtener los archivos).

Compila el proyecto: Desde la raíz de tu proyecto en la terminal, ejecuta:

Bash

javac -d out src/*.java
(Ajusta src/*.java y out según la estructura de tus carpetas si es diferente. Asegúrate de incluir todos los archivos .java necesarios, como MenuPresentacion.java, HttpAPICliente.java, TiposDeCambio.java si los tienes en la misma carpeta o en subdirectorios.)

Ejecuta la aplicación:

Bash

java -cp out PrincipalCambios
(Si tienes librerías externas, deberás incluirlas en el classpath con -cp)

📚 Estructura del Código
PrincipalCambios.java: Contiene el método main y la lógica principal del programa.

MenuPresentacion.java: Contiene la lógica para generar y mostrar el menú de opciones al usuario.

HttpAPICliente.java: Clase encargada de realizar las peticiones HTTP a la API de conversión de monedas.

TiposDeCambio.java: Una clase Record para mapear la respuesta JSON de la API (cpntine campos como base_code, conversion_rate y conversion_result).

