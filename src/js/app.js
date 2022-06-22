const email = document.getElementById('email');
const login = document.getElementById('username');
const fname = document.getElementById('name');
const surname = document.getElementById('surname');
const phone = document.getElementById('phone');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');

const regEmail = new RegExp('[a-zA-Z0-9!@#$%^&*]+@[a-z]+[.][a-z]{2,3}');
const regPas = new RegExp(
  '^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,30}$'
);
const regName = new RegExp('^[W+S+D+a-zA-Zа-яёА-ЯЁ-]+$');
const regUsername = new RegExp('(?=^[W+a-zA-Z0-9-_-]{3,15}$)(?=.[a-zA-Z].)');
const regPhone = new RegExp('^[0-9]{8,15}$');

function onbluremail() {
  if (!regEmail.test(document.getElementById('email').value)) {
    erroremail.classList.add('invalid');
    document.getElementById('erroremail').hidden = false;
  } else {
    document.getElementById('erroremail').hidden = true;
  }
}
function onblurlogin() {
  if (!regUsername.test(document.getElementById('username').value)) {
    error.classList.add('invalid');
    document.getElementById('error').hidden = false;
  } else {
    document.getElementById('error').hidden = true;
  }
}
function onblurname() {
  if (!regName.test(document.getElementById('name').value)) {
    errorname.classList.add('invalid');
    document.getElementById('errorname').hidden = false;
  } else {
    document.getElementById('errorname').hidden = true;
  }
}
function onblursurname() {
  if (!regName.test(document.getElementById('surname').value)) {
    errorsurname.classList.add('invalid');
    document.getElementById('errorsurname').hidden = false;
  } else {
    document.getElementById('errorsurname').hidden = true;
  }
}
function onblurphone() {
  if (!regPhone.test(document.getElementById('phone').value)) {
    errorphone.classList.add('invalid');
    document.getElementById('errorphone').hidden = false;
  } else {
    document.getElementById('errorphone').hidden = true;
  }
}
function onblurpass() {
  const regPas = new RegExp(
    '^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*~]{8,30}$'
  );
  if (!regPas.test(document.getElementById('password').value)) {
    errorpass.classList.add('invalid');
    document.getElementById('errorpass').hidden = false;
  } else {
    document.getElementById('errorpass').hidden = true;
  }
}
function onblurpass2() {
  const regPas = new RegExp(
    '^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*~]{8,30}$'
  );
  if (
    !regPas.test(
      document.getElementById('password2').value || password !== password2
    )
  ) {
    errorpass.classList.add('invalid');
    document.getElementById('errorpass2').hidden = false;
  } else {
    document.getElementById('errorpass2').hidden = true;
  }
}

window.addEventListener('submit', (e) => {
  e.preventDefault();

  const data = {
    email: email.value,
    login: login.value,
    name: fname.value,
    surname: surname.value,
    phone: phone.value,
    password: password.value,
    password2: password2.value,
  };
  console.log(data);
});
