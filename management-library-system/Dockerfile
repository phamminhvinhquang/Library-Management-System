# Bước 1: Môi trường Maven để Build code từ mã nguồn
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Build bỏ qua test để chạy nhanh hơn
RUN mvn clean package -DskipTests

# Bước 2: Môi trường siêu nhẹ chỉ để chạy file .jar
FROM eclipse-temurin:21-jre
WORKDIR /app
# Copy file .jar từ bước 1 sang
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8086
# Khởi chạy Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
