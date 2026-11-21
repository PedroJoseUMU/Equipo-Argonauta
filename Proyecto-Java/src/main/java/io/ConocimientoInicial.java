package io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.*;
import relaciones.*;

public class ConocimientoInicial {
	 	private final List<Object> hechos = new ArrayList<>();
	    private final Map<String, Ser> seres = new HashMap<>();
	    private final Map<String, Objeto> objetos = new HashMap<>();
	    private final Map<String, Lugar> lugares = new HashMap<>();


	    public ConocimientoInicial() {
		    	Dios zeus     = new Dios("Zeus", "Rey de los dioses");
		        Dios poseidon = new Dios("Poseidon", "Dios del mar");
		        Dios atenea   = new Dios("Atenea", "Diosa de la sabiduria");
		        Dios hermes   = new Dios("Hermes", "Mensajero de los dioses");
		        Dios hades    = new Dios("Hades", "Dios del inframundo");
		        Dios hefesto  = new Dios("Hefesto", "Dios de la forja");
	
		        Graya grayas = new Graya("Grayas");
		        Ninfa ninfas = new Ninfa("Ninfas");
	
		        Semidios perseo = new Semidios("Perseo");
		        perseo.setEsHeroe(true);
		        Semidios teseo = new Semidios("Teseo");
		        teseo.setEsHeroe(true);
		        Semidios heracles = new Semidios("Heracles");
		        heracles.setEsHeroe(true);
		        Humano andromeda = new Humano("Andromeda");
		        Humano casiopea  = new Humano("Casiopea");
		        Humano minos  = new Humano("Minos");
		        Humano dedalo  = new Humano("Dedalo");
		        Humano icaro  = new Humano("Icaro");
		        Humano ariadna  = new Humano("Ariadna");
		        ariadna.setEsHeroe(true);
		        
	
		        Gorgona medusa = new Gorgona("Medusa");
		        Minotauro minotaruo = new Minotauro("Minotauro");
		        CriaturaMarina ceto = new CriaturaMarina("Ceto");
		        ceto.setEstaLibre(false);   
		        
		        Lugar laberinto = new Lugar("Laberinto");
		        registrar(laberinto);
	
		        for (Ser s : new Ser[] { zeus, poseidon, atenea, hermes, hades, hefesto,
		                                 grayas, ninfas, perseo, andromeda, casiopea,
		                                 medusa, ceto, teseo, heracles, minos, dedalo,
		                                 icaro, ariadna, minotaruo}) {
		            registrar(s);
		        }
		        
	            Capacidad invisibilidad = new Capacidad("Invisibilidad");
	            Capacidad vuelo         = new Capacidad("Vuelo");
	            Capacidad espejo        = new Capacidad("Espejo");
	            Capacidad petrificar    = new Capacidad("Petrificar");
	            Capacidad cortar        = new Capacidad("Cortar");
	            Capacidad fuerza        = new Capacidad("Fuerza");
	            hechos.addAll(Arrays.asList(invisibilidad, vuelo, espejo, petrificar, cortar, fuerza ));

	            Objeto escudoBronce    = new Arma("Escudo de Bronce");
	            Objeto hoz             = new Arma("Hoz de Acero");
	            Objeto casco           = new ObjetoMagico("Casco de Hades");
	            Objeto brida           = new ObjetoMagico("Brida de Oro");
	            Objeto zurron          = new ObjetoMagico("Zurron Magico");
	            Objeto sandalias       = new ObjetoMagico("Sandalias Aladas");
	            Objeto ojo             = new ObjetoMagico("Ojo de las Grayas");
	            Objeto cabeza          = new ObjetoMagico("Cabeza de Medusa");
	            Objeto cabezaMinotauro = new ObjetoMagico("Cabeza del Minotauro");
	            Objeto cabezaCeto      = new ObjetoMagico("Cabeza de Ceto");
	            Objeto hiloAriadna     = new ObjetoMagico("Hilo de Ariadna");
	            Objeto espadaTeseo     = new Arma("Espada de Teseo");
	            Objeto cuernoMinotauro = new Arma("Cuerno del Minotauro");
	            Objeto alasIcaro       = new ObjetoMagico("Alas de Icaro");
	            Objeto alasDedalo = new ObjetoMagico("Alas de Dedalo");
	            Objeto cera      = new ObjetoMagico("Cera de Abejas");
	            Objeto plumas          = new ObjetoMagico("Plumas");
	            

	            Objeto escudoEspejo = new Arma("Escudo-Espejo");
	            Objeto anillo       = new ObjetoMagico("Anillo de Invisibilidad");
	            Objeto espejoMano   = new ObjetoMagico("Espejo de Mano");
	            Objeto conjuro      = new ObjetoMagico("Conjuro de Vuelo");

	            for (Objeto o : new Objeto[] { escudoBronce, hoz, casco, brida, zurron, sandalias,
	                                           ojo, cabeza, escudoEspejo, anillo, espejoMano, conjuro,cabezaMinotauro, cabezaCeto,
	                                           hiloAriadna, espadaTeseo, cuernoMinotauro, alasIcaro, cera, plumas, alasDedalo}) {
	                registrar(o);
	            }

	            posee(atenea, escudoBronce);
	            posee(hermes, hoz);
	            posee(hades, casco);
	            posee(hefesto, brida);
	            posee(ninfas, zurron);
	            posee(ninfas, sandalias);
	            posee(grayas, ojo);
	            posee(medusa, cabeza);
	            posee(minotaruo, cabezaMinotauro);
	            posee(ceto, cabezaCeto);
	            posee(ariadna, hiloAriadna);
	            posee(teseo, espadaTeseo);
	            posee(minotaruo, cuernoMinotauro);
	            posee(icaro, alasIcaro);
	            posee(dedalo, cera);
	            posee(dedalo, plumas);
	            
	            


	            concede(casco, invisibilidad);
	            concede(anillo, invisibilidad);
	            concede(sandalias, vuelo);
	            concede(conjuro, vuelo);
	            concede(escudoEspejo, espejo);
	            concede(espejoMano, espejo);
	            concede(cabeza, petrificar);
	            concede(hoz, cortar);
	            concede(espadaTeseo, cortar);
	            concede(cuernoMinotauro, cortar);
	            
		        hechos.add(new TieneCapacidad(heracles,fuerza));
	            hechos.add(new Apresa(poseidon, ceto));
	            hechos.add(new HijoDe(andromeda, casiopea));
	            hechos.add(new HijoDe(perseo, zeus));
	            hechos.add(new HijoDe(icaro, dedalo));
		        hechos.add(new EstaEn(minotaruo,laberinto));

	    }

        private void registrar(Ser s) {
            seres.put(s.getNombre().toLowerCase(), s);
            hechos.add(s);
        }

        private void registrar(Objeto o) {
            objetos.put(o.getNombre().toLowerCase(), o);
            hechos.add(o);
        }
        private void registrar(Lugar l) {
            lugares.put(l.getNombre().toLowerCase(), l);
            hechos.add(l);
        }
        

	    private void posee(Ser s, Objeto o)          { hechos.add(new PoseeObjeto(s, o)); }
	    private void concede(Objeto o, Capacidad c)  { hechos.add(new OtorgaCapacidad(o, c)); }
	    
	    public List<Object> getHechos() { return hechos; }
	    public Map<String, Ser> getSeres() { return seres; }
	    public Map<String, Objeto> getObjetos() { return objetos; }
}
