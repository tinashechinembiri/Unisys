import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.Unisys.Model.FairyLightarray;
import com.Unisys.Model.Fairylightmain;
import com.Unisys.Util.Constants;

public class FairylightmainTest {
	
	
	FairyLightarray fairyLights ;  
	
	@Before
	public void setUp()
	{
		fairyLights = new FairyLightarray(); 
	}
	
	@Test
	public void  createFairylights_Test()
	{
		 FairyLightarray fairyLength = Fairylightmain.createFairylightslist(fairyLights); 
		 
		 assertNotNull(fairyLength);
		 assertEquals(Constants.lights_Size, fairyLength.getLights().size()); 
		 
		 
	}
}
