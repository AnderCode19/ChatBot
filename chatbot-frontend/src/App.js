import React, { useState } from 'react';
import './App.css';

function App() {
    const [input, setInput] = useState('');
    const [response, setResponse] = useState('');

    const handleSend = async () => {
        try {
            const res = await fetch('http://localhost:8080/api/chat', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ message: input }),
            });

            const text = await res.text(); // porque el backend devuelve texto plano
            setResponse(text);
        } catch (error) {
            setResponse('Error al conectarse con el backend');
            console.error(error);
        }
    };

    return (
        <div className="App">
            <h1>Chatbot</h1>
            <input
                type="text"
                value={input}
                onChange={(e) => setInput(e.target.value)}
                placeholder="Escribe tu mensaje"
            />
            <button onClick={handleSend}>Enviar</button>
            <p>Respuesta: {response}</p>
        </div>
    );
}
export default App;
