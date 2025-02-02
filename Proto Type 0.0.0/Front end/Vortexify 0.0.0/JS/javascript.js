function isValidGitHubRepo(url) {
    const regex = /^https:\/\/github\.com\/[a-zA-Z0-9-]+(\/[a-zA-Z0-9-_.]+)?(\/)?$/;
    return regex.test(url);
}



function getMessage() {
    document.getElementById("undefined-url").innerHTML = "<strong>New Message!</strong>";
}




function submitForm() {
    var url = document.getElementById("git-hub-text").value;
    if (isValidGitHubRepo(url)) {
        const apiUrl = '';   //backend url needed
        document.getElementById('loader').style.display = 'block';
        fetch(apiUrl)
            .then(response => {
                if (!response.ok) {
                    document.getElementById('loader').style.display = 'none';
                    throw new Error('Network response was not ok');
                }
                document.getElementById('loader').style.display = 'none';
                return response.json();

            })
            .then(data => {
                document.getElementById('loader').style.display = 'none';
                console.log(data);
            })
            .catch(error => {
                document.getElementById('loader').style.display = 'none';
                console.error('There was a problem with the fetch operation:', error);
            });
        
    } else {
        document.getElementById('undefined-url').style.display = 'block';
        setTimeout(() => {
            document.getElementById('undefined-url').style.display = 'none';
        }, 3000);
    }

}


