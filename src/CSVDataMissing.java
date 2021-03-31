public class CSVDataMissing extends Exception{

    public CSVDataMissing(){
        super("In this row there is an information missing therefore we cannot parse it. ");

    }

    public CSVDataMissing(String s){
        super(s);
    }

}
