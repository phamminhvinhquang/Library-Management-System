# --- Giai đoạn 1: Build mã nguồn bằng Maven ---
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copy file cấu hình pom.xml và tải trước các thư viện (dependencies) để cache chéo tăng tốc
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy toàn bộ thư mục mã nguồn vào bên trong container
COPY src ./src

# Tiến hành đóng gói ứng dụng ra file .jar (Bỏ qua chạy thử test để tránh lỗi kết nối DB khi build)
RUN mvn clean package -DskipTests

# --- Giai đoạn 2: Khởi chạy ứng dụng cực nhẹ với JRE ---
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Lấy file .jar đã được build từ giai đoạn 1 sang
COPY --from=build /app/target/*.jar app.jar

# Mở cổng 8086 giống cấu hình trong application.properties
EXPOSE 8086

# Lệnh chạy ứng dụng Java
ENTRYPOINT ["java", "-jar", "app.jar"]