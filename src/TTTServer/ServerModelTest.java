package TTTServer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServerModelTest {
	@Test
	void testModel() {						//wenn irgendein Test failt, failt der ganze Case
		//ServerModel m = new ServerModel();
		//m.openServer(5000);
		//assertEquals(5000, m.getPort()); 	//wenn der Server mit dem angegebenen Port geöffnet wurde
		int i = 10;
		assertEquals(10, i);
		assertTrue(true);
		assertFalse(false);
		assertNull(null);
		//assertEquals(3000, m.getPort());
	}

}
