/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import fr.einfolearning.employee_crud.db.DBConnection;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marmotton
 */
public class TestDBConnection {

    private Connection db;
    
    @Before
    public void initConnection(){
        db = DBConnection.getInstance();
    }
    
    @Test
    public void testInitConnection() {
        assertNotNull("db ne doit pas être null. La connection doit être initialisée", db);
    }
    
    @Test
    public void testConnectionSingleton() {
        Connection db_connection = DBConnection.getInstance();
        assertEquals("La connection doit-être unique (Singleton)", this.db, db_connection);
    }
    
}
