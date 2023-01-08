package ch.unisg.ics.interactions.wiser.tests.units;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import java.util.Iterator;

/**
 * Created by Isai B. Cicourel
 */
public class SelectGraphDB {

    /**
     * Query an Endpoint using the given SPARQl query
     * @param szQuery
     * @param szEndpoint
     * @throws Exception
     */
    public void queryEndpoint(String szQuery, String szEndpoint)
            throws Exception
    {
        // Create a Query with the given String
        Query query = QueryFactory.create(szQuery);

        HttpClient hc = authHttpClient("nKesseli", "6V!s4NaV7");

        // Create the Execution Factory using the given Endpoint
        QueryExecution qexec = QueryExecutionFactory.sparqlService(szEndpoint, query, hc);

        // Set Timeout
        ((QueryEngineHTTP)qexec).addParam("timeout", "10000");


        // Execute Query
        int iCount = 0;
        ResultSet rs = qexec.execSelect();
        while (rs.hasNext()) {
            // Get Result
            QuerySolution qs = rs.next();

            // Get Variable Names
            Iterator<String> itVars = qs.varNames();

            // Count
            iCount++;
            System.out.println("Result " + iCount + ": ");

            // Display Result
            while (itVars.hasNext()) {
                String szVar = itVars.next().toString();
                String szVal = qs.get(szVar).toString();

                System.out.println("[" + szVar + "]: " + szVal);
            }
        }
    } // End of Method: queryEndpoint()

    /** Make an {@linkHttpClient} with users/password authentication. */
    static HttpClient authHttpClient(String user, String password) {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(user, password);
        credsProvider.setCredentials(AuthScope.ANY, credentials);
        HttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        return httpClient;
    }


    public static void main(String[] args) throws IOException {
        // SPARQL Query
        String szQuery = "select * where { \n" +
                "\t?s ?p ?o .\n" +
                "} limit 5";

        // DBPedia Endpoint
        String szEndpoint = "http://wiser-flagship.interactions.ics.unisg.ch/repositories/test";

        // Query DBPedia
        try {
            SelectGraphDB q = new SelectGraphDB();
            q.queryEndpoint(szQuery, szEndpoint);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
