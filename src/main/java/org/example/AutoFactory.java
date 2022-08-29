package org.example;

import org.example.events.CustomEvent;
import org.example.events.CustomPublisher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Scope("prototype")
public class AutoFactory
{
    int ProdSize = 0;
    public ProductionLine ProdLine;

    //Хранилище готовых машин
    private  ArrayList<Car> BuildCars;

    //Хранилище не построенных машин
    private  ArrayList<Car> NotBuildCars;

    CustomPublisher EventPublisher;


    public AutoFactory(@Qualifier("HunterPL")ProductionLine prodLine, CustomPublisher eventPublisher) {
        //ProdSize = prodSize;
        ProdLine = prodLine;
        BuildCars = new ArrayList<>();
        NotBuildCars = new ArrayList<>();
        EventPublisher = eventPublisher;
    }



    public void RunProd(){
        for(int CarsBuild =0; CarsBuild<ProdSize;CarsBuild++){
            Car car = ProdLine.build();
            if (car.PartsDelivered){
                //В вебинаре не сказано как использовать ивенты, выкрутился как  мог
                EventPublisher.publishCustomEvent("CAR VIN:" + car.Vin);
                BuildCars.add(car);}
            else
                NotBuildCars.add(car);


        }
    }

    public int GetBuildCnt(){
        return  BuildCars.size();
    }

    public int GetNotBuildCarsCnt(){
        return  NotBuildCars.size();
    }

}
