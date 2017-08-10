package almundo.com.callcenter.test.unit;

import almundo.com.callcenter.builder.EmpleadoBuilder;
import almundo.com.callcenter.enums.TipoEmpleadoEnum;
import almundo.com.callcenter.model.Empleable;
import almundo.com.callcenter.search.SearchAvailability;
import almundo.com.callcenter.search.SearchAvailabilityEmp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test
 */
public class UnitTestSearchAvailability {

    @Before
    public void setUp(){

    }

    @Test
    public void searchEmp(){
        SearchAvailability searchEmp = SearchAvailabilityEmp.getInstance();
        Empleable empleado = searchEmp.get();
        Assert.assertNotNull(empleado);
        Assert.assertTrue(EmpleadoBuilder.getListaEmpleado(TipoEmpleadoEnum.OPERADOR).size() == 7 );
    }
}
