package com.company;

public enum Type_client{
    INDIVIDUAL {
        void create(String[] word) {
            System.out.println("Type as enum = Individual");
            Individual client = new Individual();       //создаём клиента

            int x;
            x = 0; //Ищем в массиве слов ключевое слово "name"
            while (!(word[x].equalsIgnoreCase("name")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.name = word[x+1]; //заполняем поле "name"
            System.out.printf("name = %s \n", client.name);

            x = 0; //Ищем в массиве слов ключевое слово "surname"
            while (!(word[x].equalsIgnoreCase("surname")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.surname = word[x+1]; //заполняем поле "surname"
            System.out.printf("surname = %s \n", client.surname);

            x = 0; //Ищем в массиве слов ключевое слово "age"
            while (!(word[x].equalsIgnoreCase("age")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.age = Integer.parseInt(word[x+1]); //заполняем поле "age"
            System.out.printf("age = %d \n", client.age);

        }
    },
    LEGAL_ENTITY {
        void create(String[] word) {
            System.out.println("Type as enum = Legal_entity");
            Legal_entity client = new Legal_entity();       //создаём клиента

            int x;
            x = 0; //Ищем в массиве слов ключевое слово "name"
            while (!(word[x].equalsIgnoreCase("name")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.name = word[x+1]; //заполняем поле "name"
            System.out.printf("name = %s \n", client.name);

            x = 0; //Ищем в массиве слов ключевое слово "country"
            while (!(word[x].equalsIgnoreCase("country")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.country = word[x+1]; //заполняем поле "country"
            System.out.printf("country = %s \n", client.country);

            x = 0; //Ищем в массиве слов ключевое слово "inn"
            while (!(word[x].equalsIgnoreCase("inn")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.inn = Integer.parseInt(word[x+1]); //заполняем поле "inn"
            System.out.printf("inn = %d \n", client.inn);

        }

    },
    HOLDING {
        void create(String[] word) {
            System.out.println("Type as enum = Holding");
            Holding client = new Holding();       //создаём клиента

            int x;
            x = 0; //Ищем в массиве слов ключевое слово "name"
            while (!(word[x].equalsIgnoreCase("name")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.name = word[x+1]; //заполняем поле "name"
            System.out.printf("name = %s \n", client.name);

            x = 0; //Ищем в массиве слов ключевое слово "inn"
            while (!(word[x].equalsIgnoreCase("inn")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.inn = Integer.parseInt(word[x+1]); //заполняем поле "inn"
            System.out.printf("inn = %s \n", client.inn);

            x = 0; //Ищем в массиве слов ключевое слово "price"
            while (!(word[x].equalsIgnoreCase("price")) && !(word[x+1] == null) && (x < 98)) {
                x += 1;
            }
            client.price = Integer.parseInt(word[x+1]); //заполняем поле "price"
            System.out.printf("price = %d \n", client.price);

        }
    };

    //создадим абстрактный метод create, который реализуем выше отдельно для каждого варианта
    //метод create создаёт нужный нам объект
    abstract void create (String[] word);


}


