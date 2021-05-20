
import com.novatronic.api.eecc.bean.AccountStatementsResponse;
import com.novatronic.api.eecc.exception.StorageException;
import com.novatronic.api.eecc.services.implement.ImplementServicesEECC;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mrios
 */
public class Main {

    public static void main(String[] args) {

        ImplementServicesEECC service = new ImplementServicesEECC();

        String personId;
        String accountStatementId;
        List<AccountStatementsResponse> listadoEECCResponse = new ArrayList<>();
        byte[] pdfFile = null;

        personId = "12345678";
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("personId:                 " + personId);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        try {
            listadoEECCResponse = service.listadoEECC(personId);
            System.out.println("AccountStatementsResponse:     " + listadoEECCResponse.toString());
        } catch (StorageException ex) {
            System.out.println("errorCode:" + ex.getErrorCode());
            System.out.println("errorMessage:" + ex.getErrorMessage());
            System.out.println("statusCode:" + ex.getStatusCode());
            ex.printStackTrace();
        }

        personId = "87654321";
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("personId:                 " + personId);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        try {
            listadoEECCResponse = service.listadoEECC(personId);
            System.out.println("AccountStatementsResponse:     " + listadoEECCResponse.toString());
        } catch (StorageException ex) {
            System.out.println("errorCode:" + ex.getErrorCode());
            System.out.println("errorMessage:" + ex.getErrorMessage());
            System.out.println("statusCode:" + ex.getStatusCode());
            ex.printStackTrace();
        }

        accountStatementId = "12345678-202103";
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("accountStatementId:                 " + accountStatementId);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        try {
            pdfFile = service.recuperarEECC(accountStatementId);
            System.out.print("pdfFile:     ");
            System.out.println(pdfFile != null ? pdfFile : "nada");
        } catch (StorageException ex) {
            System.out.println("errorCode:" + ex.getErrorCode());
            System.out.println("errorMessage:" + ex.getErrorMessage());
            System.out.println("statusCode:" + ex.getStatusCode());
            ex.printStackTrace();
        }

        accountStatementId = "12345678-202104";
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("accountStatementId:                 " + accountStatementId);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        try {
            pdfFile = service.recuperarEECC(accountStatementId);
            System.out.print("pdfFile:     ");
            System.out.println(pdfFile != null ? pdfFile : "nada");
        } catch (StorageException ex) {
            System.out.println("errorCode:" + ex.getErrorCode());
            System.out.println("errorMessage:" + ex.getErrorMessage());
            System.out.println("statusCode:" + ex.getStatusCode());
            ex.printStackTrace();
        }

    }

}
