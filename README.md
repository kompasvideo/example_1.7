# otus_1.7
1. манифесты в папке manifest
2. установить БД postgresql по https://dev.to/dm8ry/how-to-deploy-postgresql-db-server-and-pgadmin-in-kubernetes-a-how-to-guide-5fm0
*   helm install dev-pg -f values.yaml bitnami/postgresql
*   миграций нет
*   kubectl apply -f congigMap.yaml
*   kubectl apply -f secret.yaml
*   kubectl apply -f service.yaml
*   kubectl apply -f ingress.yaml
*   minikube tunnel
*   файл hosts    127.0.0.1 arch.homework
*   kubectl apply -f dp_cm.yaml
3. в папке postman
4. ![](Screenshot%202023-10-03%20181552.png)

Простейший RESTful CRUD по созданию, удалению, просмотру и обновлению пользователей с манифестами для его разворачивания в kubernetes

Описание/Пошаговая инструкция выполнения домашнего задания:
Сделать простейший RESTful CRUD по созданию, удалению, просмотру и обновлению пользователей.
Пример API - https://app.swaggerhub.com/apis/otus55/users/1.0.0
Добавить базу данных для приложения.
Конфигурация приложения должна хранится в Configmaps.
Доступы к БД должны храниться в Secrets.
Первоначальные миграции должны быть оформлены в качестве Job-ы, если это требуется.
Ingress-ы должны также вести на url arch.homework/ (как и в прошлом задании)
На выходе должны быть предоставлена

ссылка на директорию в github, где находится директория с манифестами кубернетеса
инструкция по запуску приложения.
команда установки БД из helm, вместе с файлом values.yaml.
команда применения первоначальных миграций
команда kubectl apply -f, которая запускает в правильном порядке манифесты кубернетеса
Postman коллекция, в которой будут представлены примеры запросов к сервису на создание, получение, изменение и удаление пользователя. Важно: в postman коллекции использовать базовый url - arch.homework.
Проверить корректность работы приложения используя созданную коллекцию newman run коллекция_постман и приложить скриншот/вывод исполнения корректной работы

