document.addEventListener("DOMContentLoaded", () => {
  // KIỂM TRA: Nếu đã đăng nhập thì tự động đá về trang chủ sách
  if (localStorage.getItem("libraryToken")) {
    window.location.href = "index.html";
    return; // Dừng thực thi các code bên dưới
  }
  const loginForm = document.getElementById("loginForm");

  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch("http://3.235.63.103:8086/api/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, password }),
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
        // Lưu dữ liệu token JWT và thông tin người dùng vào LocalStorage bộ nhớ trình duyệt
        localStorage.setItem("libraryToken", data.token);
        localStorage.setItem("libraryUser", data.fullName);
        localStorage.setItem("libraryRole", data.role);

        // Điều hướng quay trở về Trang chủ sách sau khi xác thực thành công
        window.location.href = "index.html";
      })
      .catch((error) => {
        console.error("Lỗi:", error);
        alert(
          error.message ||
            "Đăng nhập thất bại, vui lòng kiểm tra lại thông tin!",
        );
      });
  });
});
