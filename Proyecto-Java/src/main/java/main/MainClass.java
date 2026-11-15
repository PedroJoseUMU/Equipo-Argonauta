package main;

import java.nio.file.Paths;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import io.ConocimientoInicial;
import io.Lector;

public class MainClass {
	public static  void main(String[] args) {
		String escenarios = "escenarios";
        String soluciones = "soluciones";
        if (args.length >= 1) escenarios = args[0];
        if (args.length >= 2) soluciones = args[1];

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession session = kc.newKieSession("ksession-mitos");

        ConocimientoInicial ci = new ConocimientoInicial();
        for (Object h : ci.getHechos()) session.insert(h);

        //Lector lector = new Lector(ci.getSeres(), ci.getObjetos());
        //for (Object h : lector.leer(Paths.get(escenarios, "Escenario.F2-1.txt"))) session.insert(h);

        session.getAgenda().getAgendaGroup("Condiciones iniciales").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("Informacion Inicial").setFocus();
        session.fireAllRules();

        System.out.println("Hechos:");
        for (Object o : session.getObjects()) System.out.println(o);

        session.dispose();
	}
}
