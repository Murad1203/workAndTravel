# Используем официальный образ OpenJDK как базовый образ
FROM openjdk:17-jdk-alpine3.14

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файл вашего приложения в контейнер
COPY target/workAndTravelIlwl-0.0.1-SNAPSHOT.jar /app/workAndTravelIlwl-0.0.1-SNAPSHOT.jar

# Если вам нужно передать какие-либо параметры при запуске приложения,
# вы можете определить их через переменные окружения, например:
# ENV YOUR_ENV_VARIABLE your_value
# Команда для запуска вашего Java приложения
CMD ["java", "-jar", "workAndTravelIlwl-0.0.1-SNAPSHOT.jar"]
