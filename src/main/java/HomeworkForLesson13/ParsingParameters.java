package HomeworkForLesson13;

import org.kohsuke.args4j.*;
import org.kohsuke.args4j.CmdLineParser;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ParsingParameters {
    @Option(name="-r",aliases = "--revers", usage = "Revers the input argument of option -s")
    private boolean recursive;

    @Option(name = "-s", aliases = "--string", usage = "Print original input. Mandatory option", required = true)
    private String str;

    @Option(name = "-ch", aliases = "--change", usage = "Swaps the first and second symbols", handler = HandlerClass.class)
    private Charset change = StandardCharsets.US_ASCII;


    public static void main(String[] args) {
        new ParsingParameters().parseArgs(args);
    }


    //method to parse arguments
    public void parseArgs(String[] args) {
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
        if(clp.getOptions().equals(change)){
            System.out.println("-ch flag is set");
            System.out.println(t.change(t.str));
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
    public String change(String s){
        StringBuilder sb = new StringBuilder(s);
        char from = sb.charAt(1);
        char to = sb.charAt(0);
        sb.setCharAt(0, from);
        sb.setCharAt(1, to);
        return String.valueOf(sb);
    }
}
