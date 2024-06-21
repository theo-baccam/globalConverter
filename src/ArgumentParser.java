package src;


public class ArgumentParser {
    String[] arguments;
    int argumentCount;

    Base inputBase;
    Base outputBase;
    private int numberOfBases;

    String inputString;

    Enums.ArgumentError argumentError;
    String errorString;

    private int getArgumentCount() {
        int argumentCount = 0;

        for (String argument : this.arguments) {
            argumentCount += 1;
        }

        return argumentCount;
    }

    public void parseArguments() {
        this.argumentCount = getArgumentCount();
        if (this.argumentCount == 0) {
            this.argumentError = this.argumentError.NO_OPTIONS;
            return;
        };

        int i = 0;
        boolean skip = false;
        for (String str : this.arguments) {
            if (skip == true) {
                i++;
                skip = false;
                continue;
            };
            switch (str) {
                case "hexadecimal":
                case "-h":
                    if (this.inputBase == null) {
                        // this.inputBase = "hexadecimal";
                    } else if (this.outputBase == null) {
                        // this.outputBase = "hexadecimal";
                    };
                    this.numberOfBases += 1;
                    break;

                case "octal":
                case "-o":
                    if (this.inputBase == null) {
                        // this.inputBase = "octal";
                    } else if (this.outputBase == null) {
                        // this.outputBase = "octal";
                    };
                    this.numberOfBases += 1;
                    break;

                case "decimal":
                case "-d":
                    if (this.inputBase == null) {
                        this.inputBase = new Decimal();
                    } else if (this.outputBase == null) {
                        this.outputBase = new Decimal();
                    };
                    this.numberOfBases += 1;
                    break;

                case "binary":
                case "-b":
                    if (this.inputBase == null) {
                        this.inputBase = new Binary();
                    } else if (this.outputBase == null) {
                        this.outputBase = new Binary();
                    };
                    this.numberOfBases += 1;
                    break;

                case "text":
                case "-t":
                    if (this.inputBase == null) {
                        this.inputBase = new Text();
                    } else if (this.outputBase == null) {
                        this.outputBase = new Text();
                    };
                    this.numberOfBases += 1;
                    break;

                case "input":
                case "-i":
                    if (i + 1 < this.argumentCount) {
                        this.inputString = this.arguments[i + 1];
                        skip = true;
                    };
                    break;

                default:
                    this.argumentError = this.argumentError.INVALID_OPTION;
                    this.errorString = str;
                    return;
            };
            i++;
        };

        if (this.numberOfBases < 2) {
            this.argumentError= this.argumentError.MISSING_BASES;
        } else if (this.numberOfBases > 2) {
            this.argumentError = this.argumentError.TOO_MANY_BASES;
            return;
        } else if (this.inputString == null) {
            this.argumentError = this.argumentError.NO_INPUT;
        };
    }

    public ArgumentParser(String[] arguments) {
        this.arguments = arguments;
    }
}