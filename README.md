>.[!CAUTION].
> La Api de OpenAi se debe pagar para poder utilizarla como si fuese (ChatGpt)

# 🤖 ChatBot con React + Spring Boot + OpenAI

Este proyecto es un ChatBot de tipo asistente que utiliza la API de OpenAI para generar respuestas inteligentes a partir de entradas del usuario. Cuenta con una arquitectura **frontend - backend desacoplada**, donde:

- El **frontend** está hecho en **ReactJS**.
- El **backend** está desarrollado con **Spring Boot**.
- La comunicación entre ellos se realiza mediante peticiones HTTP RESTful.
- El backend se conecta con la **API oficial de OpenAI** para generar respuestas.

---

## 📁 Estructura del proyecto
ChatBotOpenAi/
├── chatbot-frontend/ # Proyecto frontend (React)
└── chatbot-backend/ # Proyecto backend (Spring Boot)

---

## 🚀 Cómo ejecutar el proyecto

### ✅ 1. Clonar el repositorio

```bash
git clone https://github.com/AnderCode19/ChatBotOpenAi.git
cd ChatBotOpenAi

---

🛠️ Configurar y ejecutar el backend
📌 Requisitos:
Java 17+

Maven

🔑 Paso 1: Agrega tu clave API de OpenAI
Crea un archivo llamado application.properties en chatbot-backend/src/main/resources/ con lo siguiente:
openai.api.key=tu_clave_aqui

💡 Nota: Puedes conseguir una clave en https://platform.openai.com/account/api-keys

▶️ Paso 2: Ejecutar el backend
Desde la raíz del backend:
cd chatbot-backend
mvn spring-boot:run

El servidor quedará escuchando en:
http://localhost:8080

🌐 Configurar y ejecutar el frontend
📌 Requisitos:
Node.js

npm

▶️ Paso 1: Instalar dependencias
bash
cd ../chatbot-frontend
npm install

▶️ Paso 2: Ejecutar el frontend
bash
npm start

Abre el navegador en:
http://localhost:3000

---

✉️ ¿Cómo funciona?
El usuario escribe un mensaje en la interfaz React.

Se envía una petición al backend (Spring Boot) mediante /api/chat.

El backend envía ese mensaje a la API de OpenAI.

OpenAI devuelve una respuesta generada por IA.

El backend la reenvía al frontend, donde se muestra al usuario.

---

🧠 Tecnologías usadas
React

Spring Boot

OpenAI API

Java 17

Node.js

HTML + CSS

---

💬 Autor
Ander Rivera
📫 andersonrorivera@gmail.com
🔗 github.com/AnderCode19


