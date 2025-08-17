# 💱 Conversor de Monedas en Java

Este proyecto es un **conversor de monedas** hecho en **Java** con Maven.  
Utiliza la API [ExchangeRate](https://www.exchangerate-api.com/) para obtener los tipos de cambio en tiempo real y permite al usuario realizar conversiones desde consola.

---

## 📌 Características

- Conversión entre diferentes monedas.
- Registro de cada consulta en un archivo `historial.txt` con:
    - Moneda base
    - Moneda destino
    - Monto convertido
    - Resultado
    - Fecha y hora de la consulta
- Consulta de historial de conversiones, mostrando del más reciente al más antiguo.
- Manejo de errores cuando no hay conexión o la API no responde.
- Menú interactivo en consola.

---

## 🛠️ Tecnologías utilizadas

- **Java 11**
- **Maven**
- **Gson** (para manejar JSON)
- **ExchangeRate API**

---


## 📂 Estructura del proyecto

```text
conversorMonedas
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── caz
│   │               ├── Main.java
│   │               ├── ConsultaAPI.java
│   │               ├── HistorialConversiones.java
│   │               └── Hora.java
│   └── test
├── historial.txt
├── pom.xml
├── .gitignore
└── README.md
```