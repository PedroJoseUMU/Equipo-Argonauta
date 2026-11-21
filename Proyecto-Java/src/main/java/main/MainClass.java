package main;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import io.ConocimientoInicial;
import io.Lector;
import io.Escritor;

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
            if (!f.isFile()) {
            	continue;
            	}
            // Por cada escenario se tiene su propio fichero de respuesta
            File respuesta = new File(soluciones, "Respuesta.F2-" + i + ".txt");
            
            // Se muestra el escenario completo antes de procesarlo
            System.out.println("\n========== ESCENARIO F2-" + i + " ==========\n");
            for (String linea : Files.readAllLines(f.toPath(), StandardCharsets.UTF_8)) {
                System.out.println(linea);
            }
            System.out.println("\n========== FIN DESCRIPCION ESCENARIO ==========\n");
            
            try (Escritor escritor = new Escritor(respuesta)) {
            	KieSession session = kc.newKieSession("ksession-mitos");
            	try {
            		// Para que se pueda utilizar el escritor en los ficheros de reglas
            		session.setGlobal("escritor", escritor);
            		
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
                    
                    // Comprueba el resultado cuando termina la historia.
                    session.getAgenda().getAgendaGroup("Resultados").setFocus();
                    session.fireAllRules();
                    
            	}
            	finally {
            		session.dispose();
            	}
               
            }
            
            // El fichero ya esta cerrado. Se imprime la resputa tal y como se guardo
            System.out.println("========== RESPUESTA F2-" + i + " ==========\n");
            for (String linea : Files.readAllLines(respuesta.toPath(), StandardCharsets.UTF_8)) {
                System.out.println(linea);
            }
            System.out.println("\n========== FIN ESCENARIO F2-" + i + " ==========\n");
            
        }
        
        
	}
}
