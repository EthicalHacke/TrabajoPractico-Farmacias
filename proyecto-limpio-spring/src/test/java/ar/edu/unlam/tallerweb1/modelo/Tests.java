package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.SpringTest;


public class Tests extends SpringTest{

	
//PRIMER TEST	
@Test
@Transactional
@Rollback(true)
public void buscarTodasFarmaciasDeTurnoDiaMarteTest(){
		
		
Farmacia farmacity = new Farmacia("Farmacity");
Farmacia farmacil = new Farmacia("Farmacil");
Farmacia farmalock = new Farmacia("Farmalock");
Session session=getSession();
farmacity.setDiaDeTurno("lunes");
farmacil.setDiaDeTurno("martes");
farmalock.setDiaDeTurno("martes");
session.save(farmacity);
session.save(farmacil);
session.save(farmalock);
	
@SuppressWarnings("unchecked")
List<Farmacia>resultado=session.createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno", "martes"))
				.list();
		
		assertThat(resultado).hasSize(2);
		
		for (Farmacia obj : resultado) {
			  System.out.println(obj.getNombre());
			}
	}


//SEGUNDO TEST
@Test
@Transactional
@Rollback(true)
public void buscarTodasFarmaciasDeUnaCalleTest(){
	
Farmacia farmacity = new Farmacia("Farmacity");
Farmacia farmacil = new Farmacia("Farmacil");
Farmacia farmalock = new Farmacia("Farmalock");
Session session=getSession();
Direccion direccion1= new Direccion();
Direccion direccion2= new Direccion();
Direccion direccion3= new Direccion();
direccion1.setCalle("Muñoz");
direccion2.setCalle("Alianza");
direccion3.setCalle("Muñoz");
farmacity.setDireccion(direccion1);
farmacil.setDireccion(direccion2);
farmalock.setDireccion(direccion3);
session.save(direccion1);
session.save(direccion2);
session.save(direccion3);
session.save(farmacity);
session.save(farmacil);
session.save(farmalock);
	
@SuppressWarnings("unchecked")
List<Farmacia>resultado=session.createCriteria(Farmacia.class)
			.createAlias("direccion", "dir")
			.add(Restrictions.eq("dir.calle", "Muñoz"))
			.list();
	
	assertThat(resultado).hasSize(2);
	
	
	for (Farmacia obj : resultado) {
		  System.out.println(obj.getNombre());
		}

}


//TERCER TEST

@Test
@Transactional
@Rollback(true)

public void testBusqueTodasFarmaciasDeUnBarrio(){
	
	Farmacia farmacity = new Farmacia("Farmacity");
	Farmacia farmacil = new Farmacia("Farmacil");
	Farmacia farmalock = new Farmacia("Farmalock");
	Session session=getSession();
	Direccion direccion1= new Direccion();
	Direccion direccion2= new Direccion();
	Direccion direccion3= new Direccion();
	Barrio Ciudadela=new Barrio("Ciudadela");
	Barrio RamosMejia=new Barrio("RamosMejia");
	Barrio Ciudadela2=new Barrio("Ciudadela");
	direccion1.setBarrio(Ciudadela);
	direccion2.setBarrio(RamosMejia);	
	direccion3.setBarrio(Ciudadela2);	
	farmacity.setDireccion(direccion1);
	farmacil.setDireccion(direccion2);
	farmalock.setDireccion(direccion3);
	session.save(Ciudadela);
	session.save(RamosMejia);
	session.save(Ciudadela2);
	session.save(direccion1);
	session.save(direccion2);
	session.save(direccion3);
	session.save(farmacity);
	session.save(farmacil);
	session.save(farmalock);
			
	@SuppressWarnings("unchecked")
	List<Farmacia>resultado=session.createCriteria(Farmacia.class)
				.createAlias("direccion", "dir")
				.createAlias("dir.barrio", "bar")
				.add(Restrictions.eq("bar.nombre", "Ciudadela"))
					.list();
			
			assertThat(resultado).hasSize(2);
			
		
		for (Farmacia obj : resultado) {
					  System.out.println(obj.getNombre());
					}
				
			}
		}

