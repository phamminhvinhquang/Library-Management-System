const searchBtn = document.getElementById("searchBtn");
const refreshBtn = document.getElementById("refreshBtn");
const roleFilter = document.getElementById("roleFilter");
const searchInput = document.getElementById("searchInput");

const rows = document.querySelectorAll("#accountTableBody tr");

function filterAccounts() {

    const keyword = searchInput.value.toLowerCase().trim();
    const selectedRole = roleFilter.value.toLowerCase();

    rows.forEach(function (row) {

        const text = row.textContent.toLowerCase();
        const role = row.cells[2].innerText.toLowerCase();

        const matchKeyword = text.includes(keyword);
        const matchRole = (selectedRole === "" || role === selectedRole);

        if (matchKeyword && matchRole) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }

    });

}

refreshBtn.addEventListener("click", function () {

    searchInput.value = "";
    roleFilter.value = "";

    rows.forEach(function (row) {
        row.style.display = "";
    });

});

searchBtn.addEventListener("click", function () {
    filterAccounts();
});

roleFilter.addEventListener("change", function () {
    filterAccounts();
});

const viewButtons = document.querySelectorAll(".view-btn");

viewButtons.forEach(function (button) {

    button.addEventListener("click", function () {

        const row = button.closest("tr");

        const accountId = row.cells[0].innerText;
        const username = row.cells[1].innerText;
        const role = row.cells[2].innerText;
        const fullname = row.cells[3].innerText;
        const status = row.cells[4].innerText;

        alert(
            "Mã tài khoản: " + accountId +
            "\nTên đăng nhập: " + username +
            "\nVai trò: " + role +
            "\nHọ tên: " + fullname +
            "\nTrạng thái: " + status
        );

    });

});

const editButtons = document.querySelectorAll(".edit-btn");

editButtons.forEach(function (button) {

    button.addEventListener("click", function () {

        const row = button.closest("tr");

        let username = row.cells[1].innerText;

        const newUsername = prompt("Nhập tên đăng nhập mới:", username);

        if (newUsername !== null && newUsername.trim() !== "") {
            row.cells[1].innerText = newUsername;
            alert("Cập nhật thành công!");
        }

    });

});

const deleteButtons = document.querySelectorAll(".delete-btn");

deleteButtons.forEach(function (button) {

    button.addEventListener("click", function () {

        const row = button.closest("tr");

        const username = row.cells[1].innerText;

        const confirmDelete = confirm("Bạn có chắc muốn xóa tài khoản " + username + " ?");

        if (confirmDelete) {
            row.remove();
            alert("Đã xóa tài khoản thành công!");
        }

    });

});
