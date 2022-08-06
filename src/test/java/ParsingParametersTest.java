import HomeworkForLesson13.ParsingParameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParsingParametersTest {

    ParsingParameters pp = new ParsingParameters();
    @Test
    public void checkingReversMethod(){
        assertEquals("Wrong reversing","rood", pp.revers("door"));
    }
    @Test
    public void checkingChangeMethod(){
        assertEquals("Wrong replacing", "odor", pp.change("door"));
    }
    @Test
    public void emptyArgs(){
        assertNotNull(pp);
    }

}
