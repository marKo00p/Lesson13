package HomeworkForLesson13;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.*;

import java.io.IOException;

public class SymbolHandler extends OptionHandler<Symbols> {


   public SymbolHandler(CmdLineParser parser, OptionDef option, Setter setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters parameters) throws CmdLineException {
       String first = parameters.getParameter(0);
        if(first.length() != 1){
            System.out.println("After -ch flag should be two single parameters");
       }
        char firstSymbol = first.toCharArray()[0];

        String second = parameters.getParameter(1);
        if(second.length() != 1){
            System.out.println("After -ch flag should be two single parameters");
        }
        char secondSymbol = second.toCharArray()[0];

        setter.addValue(new Symbols(firstSymbol, secondSymbol));
        return 2;
    }

    @Override
    public String getDefaultMetaVariable() {
        return null;
    }
}
