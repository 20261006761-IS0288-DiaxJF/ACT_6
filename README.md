# Gestión de Inventario con Lista Enlazada Simple y Archivos CSV (Taller 6)

Para la realización del código de este taller se pidió una ayuda ligera de orientación para estructurar de manera adecuada el manejo de enlaces al ordenar nodos sin utilizar estructuras o arreglos auxiliares.

---

##  ¿Cómo funciona el programa y para qué sirve cada parte?

El objetivo de este proyecto es construir un sistema de administración de inventario manipulando directamente una **Lista Enlazada Simple** creada desde cero, aplicando persistencia de datos en un archivo plano CSV[cite: 3].

A continuación explico el propósito de cada clase implementada:

### 1. `Producto.java`
¿Para qué sirve? Es la clase modelo que contiene los datos principales del artículo: su ID, nombre y precio[cite: 3].

### 2. `Nodo.java`
¿Para qué sirve? Constituye el bloque básico de la lista enlazada[cite: 3]. Almacena la referencia del objeto `Producto` y el puntero `siguiente` que apunta al próximo nodo de la secuencia[cite: 3].

### 3. `ListaEnlazada.java`
¿Para qué sirve? Es la estructura de datos manual[cite: 3]. Contiene la referencia a la `cabeza` de la lista y realiza las operaciones CRUD básicas (insertar, eliminar por ID, buscar y mostrar)[cite: 3]. 

Además, incluye el método `ordenarPorPrecio()`. Este algoritmo aplica el método de la burbuja reconectando únicamente los punteros `siguiente` de los nodos, garantizando que no se modifiquen los datos internos del objeto ni se usen colecciones o arreglos de Java[cite: 3].

### 4. `GestorArchivo.java`
¿Para qué sirve? Maneja la persistencia del programa leyendo y escribiendo en un archivo `.csv`[cite: 3]. Al iniciar la aplicación lee las líneas guardadas y las inserta en la lista. Al salir, recorre la lista nodo por nodo y guarda el estado actual en el archivo[cite: 3].

### 5. `Main.java`
¿Para qué sirve? Ofrece un menú interactivo en consola para que el usuario gestione sus productos (agregar, buscar, eliminar, ordenar y guardar).

---

## 🔍 ¿Se usaron cosas de más?

No. Se utilizaron exclusivamente las herramientas fundamentales necesarias para el taller:
* Estructuras de nodos y referencias hechas desde cero sin importar bibliotecas de colecciones de Java (`ArrayList`, `LinkedList`, etc.)[cite: 3].
* Clases estándar de lectura y escritura de archivos (`BufferedReader` y `BufferedWriter`) para garantizar la persistencia solicitada en el archivo CSV[cite: 3].