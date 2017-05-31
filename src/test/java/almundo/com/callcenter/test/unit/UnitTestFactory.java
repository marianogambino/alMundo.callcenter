package almundo.com.callcenter.test.unit;

import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.factory.EmpleadoFry;
import almundo.com.callcenter.model.Empleable;
import almundo.com.callcenter.model.Operador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test
 */
public class UnitTestFactory {

    @Before
    public void setUp(){

    }

    @Test
    public void crearEmpleado(){
        Empleable empleable = EmpleadoFry.crearEmpleado(TipoEmpleadoEnum.OPERADOR, " Juan Perez");
        Assert.assertNotNull(empleable);
        Assert.assertEquals(((Operador)empleable).getNombre(), "Operador Juan Perez");
    }
}
