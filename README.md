# Calculadora crédito hipotecario - Challenge Tyba 

Este proyecto contiene el diseño y la automatización de casos de prueba, identificados en el
funcionamiento de la calculadora de crédito hipotecario y la calculadora de cuota del crédito. 
Para el desarrollo y la ejecución de los escenarios de prueba, se identificaron los factores 
asociadas al cálculo del crédito y la cuota del crédito según el plazo en años.

Lenguajes utilizados: el proyecto se desarrolló en el lenguaje Java y Gherkin. Se utilizó
gradle para la gestión de dependencias y construcción del proyecto.
Frameworks utilizados: cucumber, serenity BDD para la generación de reportes.
Librerías utilizadas: Serenity-core, para el uso de funcionalidades/métodos propios
de serenity.Serenity-cucumber, para la interpretación del lenguaje gherkin al lenguaje de máquina, en
este caso Java. Librería assertj-core, para la creación de aserciones. Librería slf4j-simple,
poder implementar logs durante la ejecución de los test.

## Precondiciones
Entorno de desarrollo utilizado: Intellij IDEA
Versión de Java: 1.8 o superior
La versión de Chromedriver depende de la versión del navegador utilizada. Luego de
descargar el driver, se debe guardar en la siguiente ubicación:
```bash
webdriver.chrome.driver= src/test/resources/webdriver/chromedriver.exe
```
Se utiliza gradle wrapper (versión 5.2)



## Instalación

```bash
git clone MI REPO
```

## Ejecución
Se ejecuta el siguiente comando gradlew en la terminal del IDE:

```bash
gradlew clean assemble test -i
```

## Reporte
Para la visualización del reporte de pruebas generado, se ingresa a la siguiente
ruta:

```bash
target/site/serenity/index.html
```
