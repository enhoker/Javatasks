package com.company;
//import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        //переменные
        int x = 0;          // счётчик слов
        String[] word;      //массив слов файла
        word = new String[100];

        try(java.io.FileReader fin= new java.io.FileReader("C:\\Users\\Алияш\\Desktop\\y\\y.txt")) //открытие файла
        {
            int i;              //переменная, в которую считываем по одному символы из файла
            String j = "";      //переменная, в которую считываем по одному слова из файла
            while((i = fin.read()) != -1){ //считываем в i следующий символ из файла

                if( (i == 10) || (i == 13) || ((char)i == ' ') ) { //разделяем слова по пробелу или символу конца строки
                    if (!(j.equals(""))) {
                        word[x] = j;
                        x = x+1;
                    }
                    j = "";
                } else {
                    j = j + (char)i;
                    //  System.out.printf("j = %s i = %d \n", j, i);
                }

            }
            x = x+1;
            word[x] = j; //скидываем в word последнее слово
        }
        catch(java.io.IOException ex){ //обработка исключений
            System.out.println(ex.getMessage());
        }

        x = 0; //Ищем в массиве слов ключевое слово "type"
        while (!(word[x].equalsIgnoreCase("type")) & (x < 98)) {
            x += 1;
        }

        //   System.out.printf("word[%d] = %s\n", x+1, word[x+1]); //страдаем

        //выполним задачу первым способом, через три if'а
        System.out.println("First:");

        if(word[x+1].equalsIgnoreCase("INDIVIDUAL")) {              //определяем тип клиента по слову, следующему после "type"
            System.out.println("Type = Individual");
            Individual client = new Individual();       //создаём клиента

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

        if(word[x+1].equalsIgnoreCase("LEGAL_ENTITY")) {              //определяем тип клиента по слову, следующему после "type"
            System.out.println("Type = Legal_entity");
            Legal_entity client = new Legal_entity();       //создаём клиента

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

        if(word[x+1].equalsIgnoreCase("HOLDING")) {   //определяем тип клиента по слову, следующему после "type"
            System.out.println("Type = Holding");
            Holding client = new Holding();       //создаём клиента

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


        //теперь опробуем второй способ, через enum
        System.out.println("\nSecond:");

        x = 0; //Ищем в массиве слов ключевое слово "type"
        while (!(word[x].equalsIgnoreCase("type")) & (x < 98)) {
            x += 1;
        }

        Type_client c = Type_client.valueOf(word[x+1]); //создаём соответствующий элемент перечисления
        c.create(word); //выполняем метод create



    }
}


