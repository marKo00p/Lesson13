package HomeworkForLesson13;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

import java.nio.charset.Charset;

public class HandlerClass extends OptionHandler<Charset> {
    public HandlerClass(CmdLineParser parser, OptionDef option, Setter<? super Charset> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {

        String parameter = params.getParameter(1);
        try {

            Charset charset = Charset.forName(parameter);

            setter.addValue(charset);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public String getDefaultMetaVariable() {

        return null;
    }
}
