package main;

import java.io.File;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import io.ConocimientoInicial;
import io.Lector;

public class MainClass {
	public static  void main(String[] args) throws Exception {
		String escenarios = "escenarios";
        String soluciones = "soluciones";
        if (args.length >= 1) escenarios = args[0];
        if (args.length >= 2) soluciones = args[1];

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        
        for (int i = 1; i <= 8; i++) {
            File f = new File(escenarios, "Escenario.F2-" + i + ".txt");
            if (!f.exists()) {
            	continue;}
            System.out.println("Escenario " + i + " - hechos:");
            KieSession session = kc.newKieSession("ksession-mitos");
            
            ConocimientoInicial ci = new ConocimientoInicial();
            for (Object h : ci.getHechos()) session.insert(h);

            Lector lector = new Lector(ci.getSeres(), ci.getObjetos());
            for (Object h : lector.leer(f.getPath())) session.insert(h);

            session.getAgenda().getAgendaGroup("Condiciones iniciales").setFocus();
            session.fireAllRules();
            session.getAgenda().getAgendaGroup("Informacion Inicial").setFocus();
            session.fireAllRules();
            session.getAgenda().getAgendaGroup("Historias").setFocus();
            session.fireAllRules();

            session.dispose();
        }
        
        
	}
}
