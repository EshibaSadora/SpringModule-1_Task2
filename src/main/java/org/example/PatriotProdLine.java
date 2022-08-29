package org.example;


import org.springframework.stereotype.Component;

@Component("PatriotPL")
public class PatriotProdLine implements ProductionLine{
    @Override
    public Car build() {
        //Смотрим наличие деталей в самом классе машины
        Car car = new Car(2);
        System.out.println("Уаз патриот в производстве");
        return car;
    }
}
