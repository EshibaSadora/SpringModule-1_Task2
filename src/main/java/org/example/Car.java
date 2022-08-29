package org.example;

import java.util.UUID;

public class Car {

    //это уникальный номер автомобиля (добавил, потому что захотел)
    UUID Vin;

    public Boolean PartsDelivered;

    //Тип построенного автомобиля, что бы модели различать
    int Type;

    public Car(int type){
        //Изщем детали)
        PartsDelivered = Math.random() < 0.5;
        Vin = java.util.UUID.randomUUID();
        Type=type;
    }
}
