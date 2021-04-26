# pigeon-back
https://github.com/ZeusSOA/Messenger

# Запросы к серверу
Используемый протокол - HTTP.\
HTTP запросы, поддерживаемые Spring:\
* GET,
* HEAD,
* POST,
* PUT,
* PATCH,
* DELETE,
* OPTIONS,
* TRACE.

# Запросы для user:

# Получение всех пользователей\
GET server_url/user

Получение пользователя по id\
GET server_url/user/{id}

Получение пользователей по имени\
GET server_url/user/name/{name}

Получение чатов пользователя\
GET server_url/user/{userId}/chat

Добавление нового пользователя\
POST server_url/user

Удаление пользователя по id\
DELETE server_url/user/{id}

Удаление чата пользователя по chatId\
DELETE server_url/user/{userId}/chat/{chatId}

# Запросы для chat:

Получение всех чатов\
GET server_url/chat

Получение чата по id\
GET server_url/chat/{id}

Получене сообщений чата\
GET server_url/chat/{chatId}/message

Получение чатов пользователя\
GET server_url/chat/user/{userId}

Добавление нового чата\
POST server_url/chat

Добавление в чат пользователя\
POST server_url/chat/{chatId}/user

Удаление чата\
DELETE server_url/chat/{id}

# Запросы для message:

Получение всех сообщений\
GET server_url/message

Получение сообщения по id\
GET server_url/message/{id}

Получение всех сообщений пользователя\
GET server_url/message/user/{userId}

Получение всех сообщений чата\
GET server_url/message/chat/{chatId}

Добавление нового сообщения\
POST server_url/message

Удаление сообщения\
DELETE server_url/message/{id}
