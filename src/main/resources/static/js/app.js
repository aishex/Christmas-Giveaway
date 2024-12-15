document.getElementById('user-form').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const formData = new FormData(this);
    const data = {
        name: formData.get('name'),
        surname: formData.get('surname'),
        email: formData.get('email'),
        age: formData.get('age')
    };
    
    fetch('http://localhost:8080/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
        window.location.href = "/thankyou";
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
