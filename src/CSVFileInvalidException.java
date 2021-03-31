public class CSVFileInvalidException extends Exception{


    public CSVFileInvalidException(){
        super("Unfortuante error: Missing information in the list therefore row cannot be parsed ");

    }

    public CSVFileInvalidException(String e){
        super(e);
    }


}
