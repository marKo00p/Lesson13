import HomeworkForLesson13.ParsingParameters;
import HomeworkForLesson13.Symbols;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParsingParametersTest {

    ParsingParameters pp = new ParsingParameters();
    Symbols twoSymbols = new Symbols('d', 'o');
    @Test
    public void checkingReversMethod(){
        assertEquals("Wrong reversing","rood", pp.revers("door"));
    }
    @Test
    public void checkingChangeMethod(){
        assertEquals("Wrong replacing", "odor", pp.change("door", twoSymbols));
    }
    @Test
    public void emptyArgs(){
        assertNotNull(pp);
    }

}
