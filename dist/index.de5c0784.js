const login = document.getElementById('username');
const password = document.getElementById('password');
const error = document.getElementById('error');
const errorpass = document.getElementById('errorpass');
function onblurlogin() {
    const regUsername = new RegExp('(?=^[W+a-zA-Z0-9-_-]{3,15}$)(?=.[a-zA-Z].)');
    if (!regUsername.test(document.getElementById('username').value)) {
        error.classList.add('invalid');
        document.getElementById('error').hidden = false;
    } else document.getElementById('error').hidden = true;
}
function onblurpass() {
    const regPas = new RegExp('^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*~]{8,30}$');
    if (!regPas.test(document.getElementById('password').value)) {
        errorpass.classList.add('invalid');
        document.getElementById('errorpass').hidden = false;
    } else document.getElementById('errorpass').hidden = true;
}
window.addEventListener('submit', (e)=>{
    e.preventDefault();
    const data = {
        login: login.value,
        password: password.value
    };
    console.log(data);
});

//# sourceMappingURL=index.de5c0784.js.map
