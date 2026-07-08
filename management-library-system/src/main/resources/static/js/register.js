document.addEventListener("DOMContentLoaded", () => {
  // KIỂM TRA: Nếu đã đăng nhập thì không cho vào trang đăng ký
  if (localStorage.getItem("libraryToken")) {
    window.location.href = "index.html";
    return; // Dừng thực thi
  }
  const registerForm = document.getElementById("registerForm");

  registerForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const fullName = document.getElementById("fullName").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const phoneNumber = document.getElementById("phoneNumber").value;
    const address = document.getElementById("address").value;

    const accountData = {
      fullName,
      email,
      password,
      phoneNumber,
      address,
    };

    fetch("http://localhost:8086/api/auth/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(accountData),
    })
      .then((response) => {
        if (!response.ok) {
          return response.json().then((err) => {
            throw err;
          });
        }
        return response.json();
      })
      .then((data) => {
        alert(data.message);
        // Sau khi đăng ký hoàn tất, tự động chuyển người dùng sang trang đăng nhập
        window.location.href = "login.html";
      })
      .catch((error) => {
        console.error("Lỗi:", error);
        alert(error.message || "Đăng ký tài khoản không thành công.");
      });
  });
});
