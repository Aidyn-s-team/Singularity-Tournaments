const login=document.getElementById("username"),password=document.getElementById("password"),error=document.getElementById("error"),errorpass=document.getElementById("errorpass");function onblurlogin(){new RegExp("(?=^[W+a-zA-Z0-9-_-]{3,15}$)(?=.[a-zA-Z].)").test(document.getElementById("username").value)?document.getElementById("error").hidden=!0:(error.classList.add("invalid"),document.getElementById("error").hidden=!1)}function onblurpass(){new RegExp("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*~]{8,30}$").test(document.getElementById("password").value)?document.getElementById("errorpass").hidden=!0:(errorpass.classList.add("invalid"),document.getElementById("errorpass").hidden=!1)}window.addEventListener("submit",(e=>{e.preventDefault();const n={login:login.value,password:password.value};console.log(n)}));
//# sourceMappingURL=index.cc6be09e.js.map
