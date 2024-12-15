// Funkcja do tworzenia śnieżynek
function createSnowflake() {
    const snowflake = document.createElement('div');
    snowflake.classList.add('snowflake');
    
    const size = Math.random() * 10 + 10;
    snowflake.style.fontSize = `${size}px`;  // Ustawiamy rozmiar czcionki (wielkość śnieżynki)
    
    // Ustawiamy losową pozycję początkową
    const startPosition = Math.random() * window.innerWidth;
    snowflake.style.left = `${startPosition}px`;

    // Ustawiamy emotkę śnieżynki
    snowflake.innerHTML = "\u2744"; // Symbol śnieżynki (możesz tu użyć innego znaku)

    // Dodajemy śnieżynkę do kontenera
    document.querySelector('.snowfall').appendChild(snowflake);

    // Animacja - spadający śnieg
    snowflake.style.animation = `snowfall ${Math.random() * 3 + 3}s linear infinite`;  // Losowy czas spadania (3-6s)

    // Po zakończeniu animacji usuwamy śnieżynkę z DOM
    snowflake.addEventListener('animationiteration', () => {
        snowflake.remove();
    });
}

// Tworzymy śnieżynki co 100ms
setInterval(createSnowflake, 100);
