**1. Используя команду cat в терминале операционной системы Linux, создай два файла ("Домашние животные" и "Вьючные животные") и заполни их нужной информацией. После этого объедини их и просмотри содержимое созданного файла. Переименуй файл, дав ему новое имя "Друзья человека".**

* Создание файла "Домашние животные"

cat > "Домашние животные"

собаки

кошки

хомяки

Ctrl+D 

* Создание файла "Вьючные животные"
cat > "Вьючные животные"

Лошади

верблюды

ослы

Ctrl+D

* Объединение файлов

cat "Домашние животные" "Вьючные животные" > "Объединение"

* Просмотр содержимого файла

cat "Объединение"

* Переименование файла

mv "Объединение" "Друзья человека"

**2. Создать директорию, переместить файл туда.**

* Создание директории

mkdir new_direct

* Перемещение файла в новую директорию

mv "Друзья человека" new_direct

**3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.**

* Добавление репозитория MySQL

sudo add-apt-repository 'deb https://repo.mysql.com/apt/ubuntu/ bionic mysql-8.0'

* Обновление списка пакетов

sudo apt update

* Установка MySQL пакета

sudo apt install mysql-server

**4. Установить и удалить deb-пакет с помощью dpkg.**

sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb
sudo dpkg -r docker-ce-cli

**5. Выложить историю команд в терминале ubuntu**

history

**6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы.**

В UML-нотации:
  +---------------------+
  |   Animal            |      
  +---------------------+
  |                     |
  +---------------------+
          |
          |
          |
  +-------+-------+
  |               |
  |    Pet        |
  |               |
  +-------+-------+
          |
    +-----+-----+
    |           |
    |  Dog      |
    |           |
    +-----+-----+
          |
    +-----+-----+
    |           |
    |  Cat      |
    |           |
    +-----+-----+
          |
    +-----+-----+
    |           |
    | Hamster   |
    |           |
    +-----------+
  +-----------------+
  |    Working      |
  |  Animal         |
  +-----------------+
          |
    +-----+-----+
    |           |
    |  Horse    |
    |           |
    +-----+-----+
          |
    +-----+-----+
    |           |
    |  Camel    |
    |           |
    +-----+-----+
          |
    +-----+-----+
    |           |
    |  Donkey   |
    |           |
    +-----------+

**7. В подключенном MySQL репозитории создать базу данных “Друзья человека”**

CREATE DATABASE Друзья_человека;

**8. Создать таблицы с иерархией из диаграммы в БД**

-- Создание таблицы Animal (родительский класс)

CREATE TABLE Animal (

    animal_id INT PRIMARY KEY AUTO_INCREMENT,
    animal_type VARCHAR(50)
);

-- Создание таблицы Pet (дочерний класс, наследник Animal)

CREATE TABLE Pet (

    pet_id INT PRIMARY KEY AUTO_INCREMENT,
    pet_name VARCHAR(50),
    owner_id INT,
    FOREIGN KEY (owner_id) REFERENCES Animal(animal_id)
);

-- Создание таблицы WorkingAnimal (дочерний класс, наследник Animal)

CREATE TABLE WorkingAnimal (

    work_id INT PRIMARY KEY AUTO_INCREMENT,
    work_type VARCHAR(50)
);

-- Создание таблиц для дочерних классов Pet

CREATE TABLE Dog (

    dog_id INT PRIMARY KEY AUTO_INCREMENT,
    breed VARCHAR(50),
    FOREIGN KEY (dog_id) REFERENCES Pet(pet_id)
);

CREATE TABLE Cat (

    cat_id INT PRIMARY KEY AUTO_INCREMENT,
    breed VARCHAR(50),
    FOREIGN KEY (cat_id) REFERENCES Pet(pet_id)
);

CREATE TABLE Hamster (

    hamster_id INT PRIMARY KEY AUTO_INCREMENT,
    cage_number INT,
    FOREIGN KEY (hamster_id) REFERENCES Pet(pet_id)
);

-- Создание таблиц для дочерних классов WorkingAnimal

CREATE TABLE Horse (

    horse_id INT PRIMARY KEY AUTO_INCREMENT,
    horse_name VARCHAR(50),
    FOREIGN KEY (horse_id) REFERENCES WorkingAnimal(work_id)
);

CREATE TABLE Camel (

    camel_id INT PRIMARY KEY AUTO_INCREMENT,
    camel_name VARCHAR(50),
    FOREIGN KEY (camel_id) REFERENCES WorkingAnimal(work_id)
);

CREATE TABLE Donkey (

    donkey_id INT PRIMARY KEY AUTO_INCREMENT,
    donkey_name VARCHAR(50),
    FOREIGN KEY (donkey_id) REFERENCES WorkingAnimal(work_id)
);

**9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения**

-- Заполнение таблицы Animal

INSERT INTO Animal (animal_type) VALUES ('Dog');

INSERT INTO Animal (animal_type) VALUES ('Cat');

INSERT INTO Animal (animal_type) VALUES ('Hamster');

INSERT INTO Animal (animal_type) VALUES ('Horse');

INSERT INTO Animal (animal_type) VALUES ('Camel');

INSERT INTO Animal (animal_type) VALUES ('Donkey');


-- Заполнение таблицы Pet

INSERT INTO Pet (pet_name, owner_id) VALUES ('Buddy', 1);

INSERT INTO Pet (pet_name, owner_id) VALUES ('Whiskers', 2);

-- Заполнение таблиц для дочерних классов Pet

INSERT INTO Dog (breed) VALUES ('Labrador');

INSERT INTO Cat (breed) VALUES ('Persian');

INSERT INTO Hamster (cage_number) VALUES (101);

-- Заполнение таблиц для дочерних классов WorkingAnimal

INSERT INTO Horse (horse_name) VALUES ('Shadowfax');

INSERT INTO Camel (camel_name) VALUES ('Sahara');

INSERT INTO Donkey (donkey_name) VALUES ('Eeyore');

**10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.**

DELETE FROM Animal WHERE animal_type = 'Camel';

-- Создание новой таблицы для объединения лошадей и ослов

CREATE TABLE Equine AS

SELECT *

FROM Horse

UNION

SELECT *

FROM Donkey;

**11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице**

CREATE TABLE YoungAnimals AS

SELECT animal_id, 

       animal_type, 
       TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) AS age_years,
       TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) AS age_months
FROM Animals

WHERE birthdate <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)

  AND birthdate > DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

**12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.**

CREATE TABLE AllAnimals AS

(

    SELECT 'Pet' AS category, pet_id AS id, pet_name AS name FROM Pet
    UNION
    SELECT 'Dog' AS category, dog_id AS id, breed AS name FROM Dog
    UNION
    SELECT 'Cat' AS category, cat_id AS id, breed AS name FROM Cat
    UNION
    SELECT 'Hamster' AS category, hamster_id AS id, cage_number AS name FROM Hamster
    UNION
    SELECT 'WorkingAnimal' AS category, work_id AS id, work_type AS name FROM WorkingAnimal
    UNION
    SELECT 'Horse' AS category, horse_id AS id, horse_name AS name FROM Horse
    UNION
    SELECT 'Donkey' AS category, donkey_id AS id, donkey_name AS name FROM Donkey
    UNION
    SELECT 'YoungAnimal' AS category, animal_id AS id, animal_type AS name FROM YoungAnimals
);

