const loginForm = document.getElementById("loginForm");

const password = document.getElementById("password");

const togglePassword = document.getElementById("togglePassword");

const loginMessage = document.getElementById("loginMessage");

togglePassword.addEventListener("click", function () {

    if (password.type === "password") {

        password.type = "text";

        togglePassword.textContent = "🙈";

    } else {

        password.type = "password";

        togglePassword.textContent = "👁";

    }

});

loginForm.addEventListener("submit", function (event) {

    event.preventDefault();

    const email = document.getElementById("email").value.trim();

    const passwordValue = password.value.trim();

    loginMessage.textContent = "";

    if (email === "" || passwordValue === "") {

        loginMessage.textContent = "Vui lòng nhập đầy đủ Email và Mật khẩu.";

        return;

    }

    loginMessage.style.color = "green";

    loginMessage.textContent = "Đăng nhập thành công!";
});
