const registerForm = document.getElementById("registerForm");

registerForm.addEventListener("submit", function (event) {

    event.preventDefault();

    const fullName = document.getElementById("fullName").value.trim();
    const email = document.getElementById("email").value.trim();
    const phone = document.getElementById("phone").value.trim();
    const address = document.getElementById("address").value.trim();
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    if (
        fullName === "" ||
        email === "" ||
        phone === "" ||
        address === "" ||
        password === "" ||
        confirmPassword === ""
    ) {
        alert("Vui lòng nhập đầy đủ thông tin!");
        return;
    }

    // Kiểm tra email
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        alert("Email không hợp lệ!");
        return;
    }

    // Kiểm tra số điện thoại
    const phoneRegex = /^[0-9]{10}$/;

    if (!phoneRegex.test(phone)) {
        alert("Số điện thoại phải gồm 10 chữ số!");
        return;
    }

    // Kiểm tra mật khẩu
    if (password.length < 8) {
        alert("Mật khẩu phải có ít nhất 8 ký tự!");
        return;
    }

    // Kiểm tra xác nhận mật khẩu
    if (password !== confirmPassword) {
        alert("Mật khẩu xác nhận không khớp!");
        return;
    }

    alert("Đăng ký thành công!");
});

const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");

const togglePassword = document.getElementById("togglePassword");
const toggleConfirmPassword = document.getElementById("toggleConfirmPassword");

// Hiện / Ẩn mật khẩu
togglePassword.addEventListener("click", function () {

    if (password.type === "password") {

        password.type = "text";
        togglePassword.setAttribute("icon", "solar:eye-linear");

    } else {

        password.type = "password";
        togglePassword.setAttribute("icon", "solar:eye-closed-linear");

    }

});

// Hiện / Ẩn xác nhận mật khẩu
toggleConfirmPassword.addEventListener("click", function () {

    if (confirmPassword.type === "password") {

        confirmPassword.type = "text";
        toggleConfirmPassword.setAttribute("icon", "solar:eye-linear");

    } else {

        confirmPassword.type = "password";
        toggleConfirmPassword.setAttribute("icon", "solar:eye-closed-linear");

    }

});
