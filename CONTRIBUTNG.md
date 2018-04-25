# ¿Cómo contribuir a este proyecto?

# Tabla de contenido

- [Empezando](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#1-empezando)
- [Desarrollo de una tarea](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#2-desarrollo-de-una-tarea)
- [Estructura del proyecto](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#3-estructura-del-proyecto)
- [Entorno de desarrollo](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#4-entorno-de-desarrollo)
- [Configuración de un entorno de desarrollo](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#5-configuraci%C3%B3n-de-un-entorno-de-desarrollo)
  - [1. Wildfly](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#51-wildfly)
    - [1.1. Ejecución en un Wildfly local](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#511-ejecuci%C3%B3n-en-un-wildfly-local)
    - [1.2. Cambios que afecten a la configuración de Wildfly](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#512-cambios-que-afecten-a-la-configuraci%C3%B3n-de-wildfly)
  - [2. Servidor SMTP local](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#52-servidor-smtp-local)
- [Control de versiones (Git)](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#6-control-de-versiones-git)
  - [1.](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#61-commits-con-errores-de-construcci%C3%B3n) [_Commits_](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#61-commits-con-errores-de-construcci%C3%B3n) [con errores de construcción](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#61-commits-con-errores-de-construcci%C3%B3n)
  - [2.](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#62-push-con-commits-nuevos-en-el-servidor-remoto) [_Push_](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#62-push-con-commits-nuevos-en-el-servidor-remoto) [con](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#62-push-con-commits-nuevos-en-el-servidor-remoto) [_commits_](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#62-push-con-commits-nuevos-en-el-servidor-remoto) [nuevos en el servidor remoto](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#62-push-con-commits-nuevos-en-el-servidor-remoto)
  - [3. Hacer](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#63-hacer-pull) [_pull_](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#63-hacer-pull)
  - [4.](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#64-pull-con-cambios-locales-no-commiteados) [_Pull_](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#64-pull-con-cambios-locales-no-commiteados) [con cambios locales no](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#64-pull-con-cambios-locales-no-commiteados) [_commiteados_](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#64-pull-con-cambios-locales-no-commiteados)
- [Tests](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#7-tests)
  - [1 Tests por módulo](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#71-tests-por-m%C3%B3dulo)
  - [2 El módulo tests](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#72-el-m%C3%B3dulo-test)
  - [3 Ejecución de los tests](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#73-ejecuci%C3%B3n-de-los-tests)
    - [3.1 Ejecución de los tests en Maven](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#731-ejecuci%C3%B3n-de-los-tests-en-maven)
    - [3.2 Ejecución de los tests en Eclipse](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#732-ejecuci%C3%B3n-de-los-tests-en-eclipse)
  - [4 Análisis de los resultados de los tests](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#74-an%C3%A1lisis-de-los-resultados-de-los-tests)
- [Guía de estilo](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#8-gu%C3%ADa-de-estilo)
  - [1. Código fuente](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#81-c%C3%B3digo-fuente)
  - [2. Control de versiones](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#82-control-de-versiones)

# 1. Empezando

El proyecto LETTA se desarrolla en un entorno de integración continua con despliegue continuo en un servidor de pre-producción (_staging_). Este entorno está compuesto por varias herramientas que automatizan el proceso, todas ellas dirigidas por el POM de este proyecto.

En este documento encontrarás una descripción de este entorno y las instrucciones para saber como contribuir correctamente a este proyecto.

# 2. Desarrollo de una tarea

El proceso habitual para realizar una tarea será, normalmente, el siguiente:

1. En Kunagi selecciona la tarea de la que seas responsable que deseas desarrollar y lee bien la descripción de la misma.
2. Abre el entorno de desarrollo.
3. Verifica que te encuentras en la rama develop. Si no es así, cámbiate a esta rama.
4. Haz _pull_ de los últimos cambios (ver [sección 6](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#6-control-de-versiones-git)).
5. Crear una rama para la funcionalidad que se va a desarrollar, si no existe, con el título de la historia de usuario a implementar.
6. Implementa la solución, incluyendo los tests (ver [sección 7](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#7-tests)).
  1. Haz un _commit_ con cada parte estable (completa y testeada) que desarrolles.
  2. Cada vez que hagas un _commit_ envíalo al repositorio central para compartirlo con el resto del equipo (ver [sección 6](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#6-control-de-versiones-git)).
  3. Al finalizar la implementacion, otra pareja revisara el codigo, y si es correcto se mezcla con la rama develop.
  4. Si existe algún fallo después de la mezcla de las dos ramas, se valorará si corregir este fallo en la propia rama develop o en otra diferente (Volver al paso 6.3).
  5. Si la construcción es correcta, comprueba que el proyecto se ha desplegado y funciona correctamente en el servidor local de pre-producción y que el repositorio Maven tiene una nueva versión del proyecto (ver [sección 4](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#4-entorno-de-desarrollo)).
7. Cuando acabes la jornada de trabajo recuerda introducir las horas en la tarea de Kunagi.

En las siguientes secciones encontrarás información que te ayudará a realizar este trabajo.

# 3. Estructura del proyecto

Este proyecto está estructurado en 7 módulos:

- **tests** : Módulo que contiene utilidades para realizar los tests. Este módulo será importado por el resto de módulos con el _scope_ tests para hacer uso de sus utilidades.
- **entities** : Módulo que contiene las clases de dominio (entidades).
- **rest** : Módulo que contiene una capa de servicios REST.
- **Angular** : Módulo que contiene la interfaz Web del sistema implementada con Angular.
- **target** : Módulo que está destinado a la construcción del WAR desplegable del sistema.
- **additional-material** : Este último no es realmente un módulo del proyecto. Simplemente es un directorio que acompaña al resto del proyecto en el que se almacenarán ficheros adicionales que puedan resultar de utilidad. Algunos ejemplos de ficheros que pueden ir en este directorio son plantillas HTML, scripts de BD.

# 4. Entorno de desarrollo

Las herramientas que componen el entorno de integración continua son las siguientes:

- **Maven 3** : Maven es un entorno de construcción de proyectos para Java. Esta será una herramienta clave, ya que es quien dirigirá todo el proyecto. Es necesario que tengas instalado Maven 3 en tu equipo de desarrollo para poder construir el proyecto.
- **Kunagi** : Es una herramienta de gestión de proyectos Scrum. En ella encontrarás toda la información sobre las funcionalidades desarrolladas y por desarrollar, el alcance de las publicaciones, el estado de desarrollo, etc. Puedes acceder a través del siguiente [enlace](http://sing.ei.uvigo.es/dt/kunagi).
- **Git y Gitlab** : Git es el sistema de control de versiones que se utiliza en el proyecto. Es un sistema de control de versiones distribuido que facilita la colaboración entre desarrolladores. Es necesario que tengas instalado Git en tu sistema para poder realizar cambios en el proyecto y colaborar con el resto del equipo. Por otro lado, Gitlab es un _front-end_ del repositorio Git común. Esta herramienta facilita la visualización de los _commits_ y ficheros del proyecto, además de proporcionar alguna otra funcionalidad que mejora la colaboración. Puedes acceder a través del siguiente [enlace](http://sing.ei.uvigo.es/dt/gitlab).
- **Tomcat local** : Para poder ejecutar el servidor en tu entorno de desarrollo también será necesario que dispongas de un Tomcat local. En la [sección 5.1](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#511-ejecuci%C3%B3n-en-un-wildfly-local) encontrarás una explicación de cómo instalarlo y configurarlo.
- **MySQL** : MySQL es el sistema gestor de base de datos (SGDB) que utilizará el sistema definitivo. En la explicación de cómo ejecutar el sistema en local utilizaremos este SGBD, por lo que deberás tenerlo instalado en tu equipo.

# 5. Configuración de un entorno de desarrollo

Empezar a trabajar en el proyecto es tan sencillo como seguir los siguientes pasos:

1. Instala Git y Maven. Si estás en un entorno Ubuntu es tan sencillo como ejecutar sudo apt-get install git maven. También es recomendable que instales algún visor de Git como gitk o qgit.
2. Clona el repositorio Git utilizando el comando:
3. ```git clone http://sing-group.org/dt/gitlab/daa1718-teamC/letta.git```
4. Instala Eclipse Mars for Java EE (opcional pero recomendado):
  1. Descarga el IDE desde [http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1)
  2. Importa el proyecto en Eclipse utilizando ..-&gt;Existing Maven projects, selecciona el directorio del proyecto en Root directory y marca todos los proyectos que aparezcan.

En la [sección 7.3](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#73-ejecuci%C3%B3n-de-los-tests-en-eclipse) aparece detallada la configuración necesaria para ejecutar los tests desde Eclipse.

Con esto ya sería suficiente para poder empezar a trabajar en el proyecto. Si, además, quieres poder ejecutarlo de forma local, deberás seguir las siguientes instrucciones.

5.1. Tomcat

El proyecto está configurado y preparado para ser ejecutado en un servidor Tomcat 8.x. Esto signfica que tanto los tests, como la ejecución local y el despliegue de pre-producción se harán en un servidor Tomcat.

**5.1.1. Ejecución en un Tomcat local**

La ejecución del proyecto en un Tomcat local requiere la instalación del propio servidor, de un SGBD MySQL y la configuración del servidor Tomcat.

Por lo tanto, para configurar un Tomcat local debes seguir los siguientes pasos:

1. Instala MySQL. Si estás en un entorno Ubuntu es tan sencillo como ejecutar sudo apt-get install mysql. Durante la instalación te pedirán que introduzcas la clave de _root_, que es importante que recuerdes.
2. Importa la base de datos en MySQL. En el directorio db del proyecto db están los almacenados los _scripts_ de creación de la base de datos. El `script_sql` contiene la creación completa de la base de datos, incluyendo la creación del esquema y del usuario usado por la aplicación. Y el script letta-with-inserts.sql que contendrá lo descrito anteriormente, más datos a usar en la aplicación. Por lo tanto, si estás en un sistema Ubuntu, puedes realizar la importación desde la raíz del proyecto con el siguiente comando:
3. ```mysql -u root -p **&lt;** db/letta.sql``` o ```mysql -u root -p **&lt;** db/letta-with-inserts.sql```
4. Instala Tomcat como servidor local. Para ello, debes descargar la versión 8.x de [https://tomcat.apache.org/download-80.cgi](https://tomcat.apache.org/download-80.cgi) y descomprimirla en un directorio local.

Con esto ya estaría configurado el Tomcat local y ejecutarlo es tan sencillo como invocar los siguientes comandos desde el directorio del Tomcat:

```
[Linux] mvn -Prun-tomcat-mysql -DskipTests=true package cargo:run

[Linux] mvn -Prun-tomcat-mysql -DskipTests=true package cargo:start fizzed-watcher:run

[Windows] Puedes ejecutar cualquier servidor (por ejemplo XAMPP).
```

# 6. Control de versiones (Git)

El modelo de control de versiones que utilizaremos inicialmente será muy sencillo ya que solo utilizaremos dos ramas principales:

- master: A esta rama solo se enviarán los _commits_ cuando se llegue a una versión estable y publicable (una _release_). Estas versiones deberán estar etiquetadas con el número de versión correspondiente.
- develop: Esta será la rama principal de trabajo. Los _commits_ que se envíen deben ser estables, lo que supone que el código debe incluir tests y todos deben superarse exitosamente al construir la aplicación en local.
- feature/(nombre-funcionalidad): Esta será la rama donde se implementará una nueva funcionalidad al sistema

6.1. _Commits_ con errores de construcción

En el caso de exista un fallo, se solucionara en un nuevo commit si el error es facilmente detectable y corregible. Y sino se creara una nueva rama llamada issues/(nombre-issue) para solucionar el problema.

6.2. _Push_ con _commits_ nuevos en el servidor remoto

Si se desea hacer un _push_ a un servidor remoto en el cual hay _commits_ que nuevos que no tenemos en local, entonces Git muestra un error en el que nos indica que debemos hacer un _pull_ antes de poder hacer _push_.

Dado que no nos interesa tener que añadir un _commit_ de _merge_ adicional, el _pull_ debe hacerse aplicando un _rebase_. Para ello debe usarse el comando:

`git pull --rebase`

Este comando iniciará un proceso de _rebase_ entre desde la rama local hacia la rama remota. Es decir, los _commit_ locales no _pusheados_ pasarán a tener como padre el último _commit_ remoto.

6.3. _Pull_ con cambios locales no _commiteados_

En caso de que nos encontremos en medio de un _commit_ (no se ha completado los cambios necesarios para realizar un _commit_) y deseemos descargar nuevos _commits_ del servidor central, podemos hacerlo utilizando los comandos:
```
git stash

git pull --rebase

git stash pop
```
# 7. Tests

Lo primero que se debe tener en cuenta a la hora de realizar tests es la existencia del módulo tests. Este proyecto está pensado para recoger las clases de utilidad que puedan ser compartidas por los tests de los distintos módulos que forman el proyecto. Por lo tanto, siempre que exista una clase o fichero que sea compartido por varios proyectos, debería almacenarse en este módulo.

En segundo lugar, es importante ser consciente de que, dependiendo del módulo en el que nos encontremos, deberemos hacer diferentes tipos de test.

Por último, como norma general, los métodos de prueba deben ser **lo más sencillos posible** , de modo que sea sencillo comprender qué es lo que se está evaluando. En base a esta regla, no añadiremos documentación Javadoc a los métodos de prueba (esto no se aplica a las clases de utilidad del módulo tests, que sí que deben estar documentadas con Javadoc).

A continuación se detalla el proceso de realización de tests.

7.1 Tests por módulo

Los tests que se deben hacer varían según el módulo en el que nos encontremos. En concreto, los tests que habrá que hacer serán los siguientes:

- entities: Tests de unidad para probar las entidades. Solo se testearán los constructores y los métodos con una cierta lógica, como pueden ser los métodos de las relaciones. Dentro de los constructores no será necesario testear los constructores vacíos definidos para JPA.
- rest: Tests de unidad con EasyMock y REST Client.

7.2 El módulo tests

En el módulo tests se añadirán varias utilidades para realizar los tests, entre las que encontraremos, principalmente, tres tipos distintos:

- **Test Doubles** : Clases que sustituyan a otras implementando una lógica que sea útil para los tests. Por ejemplo, la clase TestPrincipal permite sustituir el Principal de la aplicación para poder modificar el usuario que ejecuta los tests.
- **Clases**  **Datasets** : Estas clases representan un conjunto de datos de pruebas. Contienen métodos para obtener a entidades que resultan de utilidad en los tests. Estas clases deben ubicarse en el mismo paquete que las entidades que contienen. El contenido de estas clases debe ser equivalente al contenido de los _datasets_ de DBUnit que se describe a continuación.
- **Datasets**  **DBUnit** : Los datasets DBUnit son representaciones en forma de XML de conjuntos de datos usados en los tests y pueden ser utilizados directamente por Arquillian con las anotaciones @UsingDataSet y @ShouldMatchDataSet. El contenido de estos ficheros debe ser el equivalente al de las clases _dataset_. Estos ficheros deben almacenarse en el directorio src/main/resources/datasets.
- **Matchers**  **Hamcrest para entidades** : Cada entidad debería tener un _matcher_ de Hamcrest que permita compararla con otras entidades. Para facilitar el desarrollo de estos _matchers_ se incluye la clase IsEqualsToEntity, que actúa como clase base para comparar dos entidades por sus propiedades. Las clases IsEqualsToUser e IsEqualsToRegistration sirven de ejemplo de como hacer esta implementación.

7.3 Ejecución de los tests

**7.3.1 Ejecución de los tests en Maven**

Todos los tests del proyecto están configurados para ser ejecutados como tests normales y no como tests de integración. Esto significa que se pueden lanzar todos simplemente ejecutando el comando:
```
mvn -Pacceptance-tests-cargo install
```
**7.3.2 Ejecución de los tests en Eclipse**

Para ejecutar los tests hacer click derecho en el proyecto importado en Eclipse &quot;Run as &gt; JUnit Test&quot;

7.4 Análisis de los resultados de los tests

Al realizar la ejecución desde Eclipse, la misma información que muestran los informes de JUnit nos aparecerá directamente en la vista de JUnit.

# 8. Guía de estilo

Un elemento importante para poder colaborar es que exista una uniformidad en el código y otros elementos que forman parte del desarrollo. Esta sección sirve como una pequeña guía de estilo que debe respetarse al trabajar en el proyecto.

8.1. Código fuente

Para uniformizar el código fuente deben respetarse las siguientes normas:

- **Idioma** : Todo el código (incluyendo la documentación) debe desarrollarse en inglés.
- **Formato de código** : El código debe estar formateado, preferiblemente, siguiendo la [Guía de Estilo para Java de Google](https://google.github.io/styleguide/javaguide.html) o, al menos, utilizando el formato de código de Eclipse (Ctrl+Mayus+F).
- **Comentarios** : Debe evitarse **completamente** el código comentado y, en la medida de lo posible, los comentarios en el código.
- **Documentación** : Todos los métodos públicos o protegidos deben incluir documentación Javadoc. Se recomienda que se verifique que la documentación es correcta utilizando el comando mvn javadoc:javadoc. Este comando generará la documentación en formato HTML y fallará si encuentra algún error en la documentación.

8.2. Control de versiones

Una de las bases de desarrollo que utilizaremos en este proyecto es el **integrar tan pronto como se pueda**. Para ello, deben seguirse las siguientes normas:

- **Contenido de los**  **commits** : Los _commits_ deben ser completos en el sentido de que no deben romper la construcción. Además, el código debe estar probado, incluyendo los tests descritos en la [sección 7](https://cursos.faitic.uvigo.es/tema1718/claroline/document/goto/index.php/Proyecto/CONTRIBUTING.md.html?cidReq=O06G150V01944#7-tests), para que el resto de desarrolladores puedan confiar en el código. Es muy recomendable revisar los informes de tests y de cobertura antes de hacer un _commit_.
- **Formato** : El formato de los _commits_ deberá respetar las siguientes normas:
  - Escritos en inglés.
  - Limitar el tamaño de línea a 80 columnas. Si se utiliza Eclipse, esto se hace de forma automática.
  - Primera línea descriptiva de lo que hace el _commit_:
    - Si está relacionado con alguna tarea concreta de las descritas en Kunagi, debe comenzar con el identificador de la tarea (p.ej. &quot;tsk1 Adds...&quot;).
    - Si está relacionado con varias tareas, su número se separará con un guión (p.ej. &quot;tsk1-2-13 Fixes...&quot;).
    - Debe estar redactada en tercera persona del presente (p.ej. _Adds..._, _Improves..._, _Modifies..._, etc.).
    - No debe llevar punto al final.
  - Cuerpo del _commit_ descriptivo. Con una línea vacía de separación de la primera línea, debe escribirse un texto de explique claramente el trabajo hecho en el _commit_.
- **Frecuencia de**  **commit** : Los _commits_ deben hacerse en pequeños pasos para que la frecuencia sea alta. Para ello es recomendable desarrollar de una forma ordenada, atacando partes concretas.
- **Frecuencia de**  **push** : Siempre que se haga un _commit_ debe hacerse un _push_. La única excepción a esta regla es que estemos haciendo pruebas locales para evaluar una posible solución. En tal caso, es recomendable que esto se haga en una rama independiente para evitar enviar _commits_ accidentalmente a la rama _develop_ remota.
