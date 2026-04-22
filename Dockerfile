# ─────────────────────────────────────────────
# Stage 1 – Build
# ─────────────────────────────────────────────
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copy all source files
COPY src/ ./src/

# Compile all Java source files into /app/out
RUN find src -name "*.java" > sources.txt \
    && mkdir -p out \
    && javac -d out @sources.txt

# Package compiled classes into a runnable JAR
RUN echo "Main-Class: app.SupermarketSystem" > manifest.txt \
    && jar cfm SupermarketSystem.jar manifest.txt -C out .

# ─────────────────────────────────────────────
# Stage 2 – Run  (smaller final image)
# ─────────────────────────────────────────────
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy only the JAR from the build stage
COPY --from=builder /app/SupermarketSystem.jar .

# Keep stdin open so the interactive console app can read input
ENTRYPOINT ["java", "-jar", "SupermarketSystem.jar"]
