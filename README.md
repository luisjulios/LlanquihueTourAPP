![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Actividad Formativa 3: Construyendo una lista de objetos desde archivo – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Luis Antonio Julio Saurith
- **Sección:** PRY2202-004A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Actividad Formativa 3 de la asignatura *Desarrollo Orientado a Objetos I*. LlanquihueTour es una aplicación de consola desarrollada en Java 21 que lee registros de tours desde `resources/tours.txt`, crea objetos `Tour` y los almacena en un `ArrayList<Tour>`.

La aplicación muestra el listado completo y filtra los tours por categoría mediante un bucle `for` y una condición `if` en `Main.java`. La categoría configurada actualmente es `Aventura`; la comparación utiliza `equalsIgnoreCase()`, por lo que no distingue mayúsculas y minúsculas. No requiere ingreso de datos por teclado.

El diseño aplica encapsulamiento en `Tour` y separa la representación de datos, la lectura del archivo y la presentación en consola en los paquetes `model`, `data` y `ui`. Utiliza la biblioteca estándar de Java, sin frameworks ni dependencias externas.

---

## 🧱 Estructura general del proyecto

Las clases se organizan bajo el paquete base `cl.duoc.llanquihuetour`, con los sub-paquetes `data`, `model` y `ui`.

```plaintext
Llanquihue-Tour/
├── src/cl/duoc/llanquihuetour/
│   ├── data/
│   │   └── GestorDatos.java # Lectura y conversión de registros en objetos Tour
│   ├── model/
│   │   └── Tour.java        # Nombre, ubicación, valor y categoría del tour
│   └── ui/
│       ├── Main.java        # Inicio, listado y filtrado por categoría
│       └── Consola.java     # Mensajes operativos y presentación de tours
├── resources/
│   └── tours.txt            # Registros de tours separados por punto y coma
├── .idea/                  # Configuración de IntelliJ IDEA
├── .gitignore              # Archivos y carpetas excluidos del control de versiones
├── Llanquihue-tour.iml      # Configuración del módulo de IntelliJ IDEA
└── README.md               # Descripción e instrucciones del proyecto
```

---

## Validaciones y excepciones

`GestorDatos.cargarDatos(Path rutaArchivo)` lee el archivo con `BufferedReader` y `FileReader`, crea los objetos `Tour` y devuelve un `ArrayList<Tour>` en el orden de lectura. El archivo no tiene encabezado y contiene un registro por línea con el formato `nombre;ubicación;valor;categoría`. Por ejemplo:

```text
Isla Huar;Calbuco;1200;Cultural
Saltos del Petrohue;Puerto Varas;1800;Naturaleza
```

Durante la carga se aplican las siguientes comprobaciones:

- Las líneas en blanco se ignoran.
- Cada línea se separa con `split(";")`; si el resultado no contiene cuatro campos, el registro se omite.
- El valor se convierte a `int` mediante `Integer.parseInt()`. Si no puede convertirse, se captura `NumberFormatException` y se omite el registro.
- Al completar la lectura, los registros omitidos se informan mediante un único mensaje `[WARN]` con los conteos por motivo.

No se eliminan espacios de los campos ni registros duplicados. `Tour` contiene los atributos privados `nombre`, `ubicacion`, `valor` y `categoria`, con constructor, getters y setters; no incorpora validaciones adicionales, como exigir valores positivos.

El lector se cierra automáticamente mediante `try-with-resources`. Si ocurre una `IOException` al abrir, leer o cerrar el archivo, se propaga hasta `Main`, que muestra un único mensaje `[ERROR]` con la ruta absoluta y una indicación para comprobar la existencia y los permisos del archivo. No se devuelve una lista parcial ni se informa una carga exitosa en ese caso.

`Consola` centraliza los encabezados, la presentación numerada mediante `mostrarTour(int numero, Tour tour)` y los mensajes `[INFO]`, `[OK]`, `[WARN]` y `[ERROR]`. Los errores se envían a `System.err`; el resto de la salida utiliza `System.out`. `Main` muestra avisos cuando la colección está vacía o el filtro no encuentra coincidencias. La presentación de los tours utiliza sus getters, no `Tour.toString()`.

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Instala Git, IntelliJ IDEA y un JDK 21, que es la versión configurada para el proyecto.

2. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/luisjulios/Llanquihue-Tour.git
```

3. Abre la carpeta `Llanquihue-Tour` en IntelliJ IDEA.

4. En **File → Project Structure → Project**, selecciona el JDK 21 como SDK del proyecto. Si IntelliJ no reconoce las clases, haz clic derecho sobre `src` y selecciona **Mark Directory as → Sources Root**.

5. Selecciona **Build → Build Project** para compilar el proyecto y verifica que la compilación finalice sin errores.

6. Abre `src/cl/duoc/llanquihuetour/ui/Main.java`, correspondiente a la clase `cl.duoc.llanquihuetour.ui.Main`, y ejecuta el método `main` mediante el botón de ejecución junto a su declaración. En la configuración de ejecución, establece el directorio de trabajo en la raíz del proyecto (`Llanquihue-Tour`), ya que la ruta `resources/tours.txt` es relativa a ese directorio.

7. Revisa la consola de IntelliJ: con el archivo actual se cargan y muestran 10 tours. El filtro de la categoría `Aventura` muestra `Volcan Osorno` y `Cascadas del Rio Pescado`, con un total de 2 coincidencias. Los conteos se calculan a partir de los datos cargados. Para probar otra categoría, cambia el valor de `categoriaAFiltrar` en `Main.java`; no existe un menú interactivo.

---

**Repositorio GitHub:** https://github.com/luisjulios/Llanquihue-Tour.git

**Fecha de entrega:** \[15/11/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Formativa Semana 4
