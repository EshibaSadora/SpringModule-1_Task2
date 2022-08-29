package org.example;


import org.springframework.stereotype.Component;

@Component("HunterPL")
public class HunterProdLine implements ProductionLine{
    @Override
    public Car build() {
        //Смотрим наличие деталей в самом классе машины
        Car car = new Car(1);
        System.out.println("Уаз хантер в производстве");
        return car;

    }
}
