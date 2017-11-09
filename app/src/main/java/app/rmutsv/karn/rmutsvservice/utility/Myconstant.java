package app.rmutsv.karn.rmutsvservice.utility;

/**
 * Created by lenovo on 8/11/2560.
 */

public class Myconstant {

    private String urlPostData = "http://androidthai.in.th/rmuts/addDataMaster.php";

    private String urlGetAlluser = "http://androidthai.in.th/rmuts/getAllDataMaster.php";

    private String urldeleteData = "http://androidthai.in.th/rmuts/deleteDataMaster.php";

    public String getUrldeleteData () {
        return urldeleteData;
    }

    public String getUrlGetAlluser() {
        return urlGetAlluser;
    }

    public String getUrlPostData() {
        return urlPostData;
    }
}   // Main Class
