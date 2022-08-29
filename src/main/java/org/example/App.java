package org.example;

import org.example.events.CustomEvent;
import org.example.events.CustomPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);




        AutoFactory factory_hunter = context.getBean("autoFactory", AutoFactory.class);


        //Как явно указать какой компонент ProductionLine нужно внедрить?
        //При такой конструкции всегда используется компонент из @Qualifier
        //Хочу другую производственную линию!
        AutoFactory factory_patiot = context.getBean("autoFactory", AutoFactory.class);


        factory_hunter.ProdSize = 5;
        factory_patiot.ProdSize = 3;

        factory_hunter.RunProd();
        factory_patiot.RunProd();

        System.out.println("Всего машин готово:" + (factory_hunter.GetBuildCnt()+factory_patiot.GetBuildCnt()));
        System.out.println("Не хватило деталей для: " + (factory_hunter.GetNotBuildCarsCnt()+factory_patiot.GetNotBuildCarsCnt()));





        //Object factory = context.getBean("hunter_prodline", HunterProdLine.class);

    }
}
