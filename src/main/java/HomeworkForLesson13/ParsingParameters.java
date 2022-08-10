package HomeworkForLesson13;

import org.apache.logging.log4j.core.util.ArrayUtils;
import org.kohsuke.args4j.*;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ParsingParameters {
    @Option(name="-r",aliases = "--revers", usage = "Revers the input argument of option -s")
    private boolean recursive;

    @Option(name = "-s", aliases = "--string", usage = "Print original input. Mandatory option", required = true)
    private String str;

    @Option(name = "-ch", aliases = "--change", usage = "Swap input symbols", handler = SymbolHandler.class)
    private Symbols symbols;


    public static void main(String[] args)  throws IOException {
        new ParsingParameters().parseArgs(args);
    }


    //method to parse arguments
    public void parseArgs(String[] args) throws IOException{
        ParsingParameters t = new ParsingParameters();
        CmdLineParser clp = new CmdLineParser(t);


        try {

            clp.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java SampleMain -[options] arguments");
            // print the list of available options
            clp.printUsage(System.err);
            System.err.println();
            return;
        }
        //if(clp.getOptions().equals(symbols)){
        if(t.symbols.isEmpty()){
            System.out.println("-ch flag is set");
            System.out.println(t.change(t.str, t.symbols));
        }
        if(t.recursive){
            System.out.println("-r flag is set");
            System.out.println(t.revers(t.str));
        }
        System.out.println("-s flag is always set");
        System.out.println(t.str);

    }

    //method for -r option revers the string argument
    public String revers(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    //method for -ch option swap the first and the second elements of the string argument
    public String change(String s, Symbols sym){
        char[] arr = s.toCharArray();
        int f = s.indexOf(sym.getFrom());
        int t = s.indexOf(sym.getTo());
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(f, sym.getTo());
        sb.setCharAt(t,sym.getFrom());
        return sb.toString();
    }
}
