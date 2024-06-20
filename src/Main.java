package src;


public class Main {
    public static void main(String[] arg) {
        ArgumentParser ap = new ArgumentParser(arg);
        ap.parseArguments();

        if (ap.argumentError != null) {
            switch (ap.argumentError) {
                case NO_OPTIONS:
                    System.out.printf("""
                        No options specified
                        Example: globconv -t -h -i 'input text'%n"""
                    );
                    break;

                case INVALID_OPTION:
                    System.out.printf("Invalid option: %s%n", ap.errorString);
                    break;

                case MISSING_BASES:
                    System.out.printf("""
                        Missing bases, there needs to be 2 bases for input 
                        and output bases in that order
                        Example: globconv -t -h -i 'input text'%n"""
                    );
                    break;

                case TOO_MANY_BASES:
                    System.out.printf("""
                        Too many bases, there needs to be only 2 bases
                        Example: globconv -t -h -i 'input text'%n"""
                    );
                    break;

                case NO_INPUT:
                    System.out.printf("""
                        No input text specified
                        Example: globconv -t -h -i 'input text'%n"""
                    );
                    break;
            };
        };

    };
}